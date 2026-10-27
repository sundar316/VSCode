
import asyncio
import json
import queue
import sqlite3
import threading
import time
import tkinter as tk
from pathlib import Path
from tkinter import ttk, filedialog, messagebox

from telethon import TelegramClient
from telethon.errors import FloodWaitError
from telethon.tl.functions.messages import GetForumTopicsRequest
from telethon.tl.types import Channel


# =====================================================
# CONFIGURATION
# =====================================================

SESSION = "telegram_personal"
DB_FILE = "upload_history.db"
SETTINGS_FILE = "uploader_settings.json"

MAX_BATCH_GIB = 2
DEFAULT_BATCH_GIB = 2


class TelegramUploader:
    def __init__(self, root):
        self.root = root
        self.root.title("Telegram Bulk File Uploader")
        self.root.geometry("1100x760")
        self.root.minsize(780, 560)

        # Settings
        self.api_id = tk.StringVar()
        self.api_hash = tk.StringVar()
        self.folder = tk.StringVar()
        self.batch_limit = tk.StringVar(value="2")
        self.upload_mode = tk.StringVar(value="document")
        self.send_grouped = tk.BooleanVar(value=False)
        self.group_size = tk.StringVar(value="10")

        # UI status
        self.status = tk.StringVar(value="Select a folder and connect.")
        self.file_progress_text = tk.StringVar(
            value="No upload active"
        )
        self.overall_text = tk.StringVar(value="0 / 0 files completed")

        # Telegram groups and topics
        self.groups = {}
        self.topics = {}
        self.saved_group = ""
        self.saved_topic = ""

        # File data
        self.files = []
        self.batches = []

        # Worker coordination
        self.events = queue.Queue()
        self.stop_event = threading.Event()
        self.running = False
        self.fetching = False
        self.worker = None

        self.db_lock = threading.Lock()

        self.init_database()
        self.build_ui()
        self.load_settings()

        self.root.after(150, self.process_events)
        self.root.protocol("WM_DELETE_WINDOW", self.close)

    # =====================================================
    # DATABASE
    # =====================================================

    def init_database(self):
        with sqlite3.connect(DB_FILE) as db:
            db.execute("""
                CREATE TABLE IF NOT EXISTS uploaded (
                    path TEXT PRIMARY KEY,
                    size INTEGER NOT NULL,
                    mtime REAL NOT NULL,
                    uploaded_at REAL NOT NULL
                )
            """)

    def is_uploaded(self, path, size, mtime):
        with self.db_lock:
            with sqlite3.connect(DB_FILE) as db:
                row = db.execute(
                    "SELECT size, mtime FROM uploaded WHERE path=?",
                    (str(path),)
                ).fetchone()

        return (
            row is not None
            and row[0] == size
            and abs(row[1] - mtime) < 0.001
        )

    def mark_uploaded(self, path, size, mtime):
        with self.db_lock:
            with sqlite3.connect(DB_FILE) as db:
                db.execute("""
                    INSERT OR REPLACE INTO uploaded
                    (path, size, mtime, uploaded_at)
                    VALUES (?, ?, ?, ?)
                """, (str(path), size, mtime, time.time()))

    # =====================================================
    # SETTINGS
    # =====================================================

    def save_settings(self):
        data = {
            "api_id": self.api_id.get(),
            "api_hash": self.api_hash.get(),
            "folder": self.folder.get(),
            "batch_limit": self.batch_limit.get(),
            "upload_mode": self.upload_mode.get(),
            "send_grouped": self.send_grouped.get(),
            "group_size": self.group_size.get(),
            "group": self.group_combo.get(),
            "topic": self.topic_combo.get()
        }

        try:
            with open(SETTINGS_FILE, "w", encoding="utf-8") as f:
                json.dump(data, f, indent=2)
        except OSError as e:
            print("Settings save error:", e)

    def load_settings(self):
        try:
            with open(SETTINGS_FILE, "r", encoding="utf-8") as f:
                data = json.load(f)

            self.api_id.set(data.get("api_id", ""))
            self.api_hash.set(data.get("api_hash", ""))
            self.folder.set(data.get("folder", ""))
            self.batch_limit.set(
                data.get("batch_limit", str(DEFAULT_BATCH_GIB))
            )
            self.upload_mode.set(
                data.get("upload_mode", "document")
            )
            self.send_grouped.set(data.get("send_grouped", False))
            self.group_size.set(str(data.get("group_size", "10")))

            self.saved_group = data.get("group", "")
            self.saved_topic = data.get("topic", "")

        except (OSError, ValueError):
            pass

    # =====================================================
    # GUI
    # =====================================================

    def build_ui(self):
        main = ttk.Frame(self.root, padding=10)
        main.pack(fill="both", expand=True)

        # IMPORTANT:
        # Pack the bottom controls FIRST so the other sections
        # cannot push them outside the visible window.
        controls = ttk.Frame(main)
        controls.pack(side="bottom", fill="x", pady=(8, 0))

        self.start_btn = ttk.Button(
            controls,
            text="Start upload",
            command=self.start
        )
        self.start_btn.pack(side="left")

        self.stop_btn = ttk.Button(
            controls,
            text="Stop after current file",
            command=self.stop,
            state="disabled"
        )
        self.stop_btn.pack(side="left", padx=8)

        ttk.Button(
            controls,
            text="Clear preview",
            command=self.clear
        ).pack(side="right")

        # Progress section
        progress_frame = ttk.LabelFrame(
            main,
            text="Upload progress",
            padding=7
        )
        progress_frame.pack(side="bottom", fill="x", pady=5)

        ttk.Label(
            progress_frame,
            textvariable=self.status
        ).pack(anchor="w")

        ttk.Label(
            progress_frame,
            textvariable=self.file_progress_text
        ).pack(anchor="w", pady=(5, 0))

        self.file_bar = ttk.Progressbar(
            progress_frame,
            maximum=100
        )
        self.file_bar.pack(fill="x", pady=4)

        ttk.Label(
            progress_frame,
            textvariable=self.overall_text
        ).pack(anchor="w")

        self.overall_bar = ttk.Progressbar(
            progress_frame,
            maximum=100
        )
        self.overall_bar.pack(fill="x", pady=4)

        # Upload mode
        format_frame = ttk.LabelFrame(
            main,
            text="Upload format",
            padding=7
        )
        format_frame.pack(side="bottom", fill="x", pady=5)

        ttk.Radiobutton(
            format_frame,
            text="Send as Document (original file)",
            variable=self.upload_mode,
            value="document",
            command=self.save_settings
        ).pack(side="left", padx=8)

        ttk.Radiobutton(
            format_frame,
            text="Send as Compressed Media",
            variable=self.upload_mode,
            value="media",
            command=self.save_settings
        ).pack(side="left", padx=8)

        ttk.Checkbutton(
            format_frame,
            text="Group supported photos/videos into albums (media mode only)",
            variable=self.send_grouped,
            command=self.save_settings
        ).pack(side="left", padx=(14, 4))

        ttk.Label(format_frame, text="Items per album:").pack(side="left", padx=(8, 3))
        self.group_size_combo = ttk.Combobox(
            format_frame, textvariable=self.group_size,
            values=("2", "5", "10"), width=4, state="readonly"
        )
        self.group_size_combo.pack(side="left")
        self.group_size_combo.bind("<<ComboboxSelected>>", lambda event: self.save_settings())

        # Telegram account
        credentials = ttk.LabelFrame(
            main,
            text="Telegram account",
            padding=8
        )
        credentials.pack(side="top", fill="x", pady=(0, 6))

        credentials.columnconfigure(1, weight=1)
        credentials.columnconfigure(3, weight=1)

        ttk.Label(
            credentials,
            text="API ID"
        ).grid(row=0, column=0, sticky="w", padx=5, pady=4)

        ttk.Entry(
            credentials,
            textvariable=self.api_id
        ).grid(row=0, column=1, sticky="ew", padx=5, pady=4)

        ttk.Label(
            credentials,
            text="API Hash"
        ).grid(row=0, column=2, sticky="w", padx=5, pady=4)

        ttk.Entry(
            credentials,
            textvariable=self.api_hash,
            show="*"
        ).grid(row=0, column=3, sticky="ew", padx=5, pady=4)

        ttk.Label(
            credentials,
            text="Group"
        ).grid(row=1, column=0, sticky="w", padx=5, pady=4)

        self.group_combo = ttk.Combobox(
            credentials,
            state="readonly"
        )
        self.group_combo.grid(
            row=1, column=1, sticky="ew", padx=5, pady=4
        )
        self.group_combo.bind(
            "<<ComboboxSelected>>",
            self.on_group_selected
        )

        self.load_groups_btn = ttk.Button(
            credentials,
            text="Load Groups",
            command=self.load_groups
        )
        self.load_groups_btn.grid(
            row=1, column=2, columnspan=2,
            sticky="w", padx=5, pady=4
        )

        ttk.Label(
            credentials,
            text="Topic"
        ).grid(row=2, column=0, sticky="w", padx=5, pady=4)

        self.topic_combo = ttk.Combobox(
            credentials,
            state="disabled"
        )
        self.topic_combo.grid(
            row=2, column=1, sticky="ew", padx=5, pady=4
        )
        self.topic_combo.bind(
            "<<ComboboxSelected>>",
            lambda event: self.save_settings()
        )

        self.load_topics_btn = ttk.Button(
            credentials,
            text="Load Topics",
            command=self.load_topics,
            state="disabled"
        )
        self.load_topics_btn.grid(
            row=2, column=2, columnspan=2,
            sticky="w", padx=5, pady=4
        )

        # Source folder
        folder_frame = ttk.LabelFrame(
            main,
            text="Source folder",
            padding=7
        )
        folder_frame.pack(side="top", fill="x", pady=5)

        ttk.Entry(
            folder_frame,
            textvariable=self.folder
        ).pack(side="left", fill="x", expand=True, padx=(0, 8))

        ttk.Button(
            folder_frame,
            text="Browse",
            command=self.choose_folder
        ).pack(side="right")

        # Batch options
        options = ttk.Frame(main)
        options.pack(side="top", fill="x", pady=5)

        ttk.Label(
            options,
            text="Maximum batch size (GiB):"
        ).pack(side="left")

        ttk.Entry(
            options,
            textvariable=self.batch_limit,
            width=7
        ).pack(side="left", padx=6)

        ttk.Button(
            options,
            text="Scan and preview",
            command=self.scan
        ).pack(side="left", padx=5)

        # File table
        table_frame = ttk.LabelFrame(
            main,
            text="Files and batches",
            padding=5
        )
        table_frame.pack(
            side="top",
            fill="both",
            expand=True,
            pady=5
        )

        columns = ("name", "size", "batch", "state")

        self.tree = ttk.Treeview(
            table_frame,
            columns=columns,
            show="headings",
            height=8
        )

        self.tree.heading("name", text="File")
        self.tree.heading("size", text="Size")
        self.tree.heading("batch", text="Batch")
        self.tree.heading("state", text="Status")

        self.tree.column("name", width=520, anchor="w")
        self.tree.column("size", width=120, anchor="center")
        self.tree.column("batch", width=90, anchor="center")
        self.tree.column("state", width=150, anchor="center")

        scroll_y = ttk.Scrollbar(
            table_frame,
            orient="vertical",
            command=self.tree.yview
        )
        scroll_x = ttk.Scrollbar(
            table_frame,
            orient="horizontal",
            command=self.tree.xview
        )

        self.tree.configure(
            yscrollcommand=scroll_y.set,
            xscrollcommand=scroll_x.set
        )

        self.tree.grid(row=0, column=0, sticky="nsew")
        scroll_y.grid(row=0, column=1, sticky="ns")
        scroll_x.grid(row=1, column=0, sticky="ew")

        table_frame.rowconfigure(0, weight=1)
        table_frame.columnconfigure(0, weight=1)

    # =====================================================
    # TELEGRAM GROUPS AND TOPICS
    # =====================================================

    def get_credentials(self):
        api_id = int(self.api_id.get().strip())
        api_hash = self.api_hash.get().strip()

        if not api_hash:
            raise ValueError("API Hash is required")

        return api_id, api_hash

    def start_fetch(self, action, group_id=None):
        if self.running or self.fetching:
            return

        try:
            api_id, api_hash = self.get_credentials()
        except ValueError as e:
            messagebox.showerror("Credentials", str(e))
            return

        self.fetching = True
        self.load_groups_btn.config(state="disabled")
        self.load_topics_btn.config(state="disabled")
        self.status.set("Connecting to Telegram...")

        threading.Thread(
            target=self.fetch_worker,
            args=(action, api_id, api_hash, group_id),
            daemon=True
        ).start()

    def fetch_worker(self, action, api_id, api_hash, group_id):
        try:
            asyncio.run(
                self.fetch_data(
                    action, api_id, api_hash, group_id
                )
            )
        except Exception as e:
            self.events.put(("fetch_error", str(e)))
        finally:
            self.events.put(("fetch_finished", None))

    async def fetch_data(
        self, action, api_id, api_hash, group_id
    ):
        async with TelegramClient(
            SESSION, api_id, api_hash
        ) as client:

            if action == "groups":
                dialogs = await client.get_dialogs()
                groups = {}

                for dialog in dialogs:
                    entity = dialog.entity

                    if (
                        isinstance(entity, Channel)
                        and entity.megagroup
                    ):
                        label = f"{dialog.title} ({dialog.id})"
                        groups[label] = {
                            "id": dialog.id,
                            "entity": entity
                        }

                self.events.put(("groups", groups))

            elif action == "topics":
                entity = await client.get_entity(group_id)
                topics = {}
                offset_topic = 0

                while True:
                    result = await client(
                        GetForumTopicsRequest(
                            peer=entity,
                            q="",
                            offset_date=0,
                            offset_id=0,
                            offset_topic=offset_topic,
                            limit=100
                        )
                    )

                    page = result.topics

                    for topic in page:
                        label = f"{topic.title} (ID: {topic.id})"
                        topics[label] = topic.id

                    if len(page) < 100:
                        break

                    next_offset = max(t.id for t in page)
                    if next_offset <= offset_topic:
                        break

                    offset_topic = next_offset

                self.events.put(("topics", topics))

    def load_groups(self):
        self.start_fetch("groups")

    def on_group_selected(self, event=None):
        self.topics = {}
        self.topic_combo.set("")
        self.topic_combo["values"] = []
        self.topic_combo.config(state="disabled")
        self.load_topics_btn.config(state="normal")
        self.save_settings()

    def load_topics(self):
        selected = self.group_combo.get()

        if selected not in self.groups:
            messagebox.showwarning(
                "Select group",
                "Select a group first."
            )
            return

        group_id = self.groups[selected]["id"]
        self.start_fetch("topics", group_id)

    # =====================================================
    # FOLDER SCANNING AND BATCHES
    # =====================================================

    def choose_folder(self):
        selected = filedialog.askdirectory()

        if selected:
            self.folder.set(selected)
            self.save_settings()
            self.scan()

    def scan(self):
        if self.running or self.fetching:
            return

        folder = self.folder.get().strip()

        if not folder or not Path(folder).is_dir():
            messagebox.showerror(
                "Folder",
                "Select a valid folder."
            )
            return

        try:
            limit = float(self.batch_limit.get())

            if not 0 < limit <= MAX_BATCH_GIB:
                raise ValueError

        except ValueError:
            messagebox.showerror(
                "Batch size",
                "Enter a size greater than 0 and no more than 2 GiB."
            )
            return

        self.save_settings()
        self.files = []
        self.batches = []
        self.tree.delete(*self.tree.get_children())

        root_folder = Path(folder)

        for path in sorted(root_folder.rglob("*")):
            if not path.is_file():
                continue

            try:
                stat = path.stat()

                self.files.append({
                    "path": path,
                    "size": stat.st_size,
                    "mtime": stat.st_mtime,
                    "state": "Pending"
                })

            except OSError:
                continue

        max_size = int(limit * 1024**3)
        current_batch = []
        current_size = 0
        oversized = 0

        for item in self.files:
            if item["size"] > max_size:
                item["state"] = "Too large"
                oversized += 1
                continue

            if (
                current_batch
                and current_size + item["size"] > max_size
            ):
                self.batches.append(current_batch)
                current_batch = []
                current_size = 0

            current_batch.append(item)
            current_size += item["size"]

        if current_batch:
            self.batches.append(current_batch)

        batch_numbers = {}

        for number, batch in enumerate(
            self.batches, start=1
        ):
            for item in batch:
                batch_numbers[str(item["path"])] = number

        uploaded = 0
        total_bytes = 0

        for item in self.files:
            path = item["path"]
            total_bytes += item["size"]

            if item["state"] != "Too large":
                if self.is_uploaded(
                    path, item["size"], item["mtime"]
                ):
                    item["state"] = "Uploaded"
                    uploaded += 1

            self.tree.insert(
                "",
                "end",
                iid=str(path),
                values=(
                    str(path.relative_to(root_folder)),
                    f"{item['size'] / 1024**2:.2f} MB",
                    batch_numbers.get(str(path), "-"),
                    item["state"]
                )
            )

        eligible = len(self.files) - oversized

        self.status.set(
            f"{len(self.files)} files | "
            f"{total_bytes / 1024**3:.3f} GiB | "
            f"{len(self.batches)} batches | "
            f"{oversized} oversized"
        )

        self.overall_text.set(
            f"{uploaded} / {eligible} files completed"
        )

        self.overall_bar["value"] = (
            uploaded * 100 / eligible if eligible else 0
        )

        self.file_bar["value"] = 0
        self.file_progress_text.set("Waiting to upload")

    # =====================================================
    # UPLOAD CONTROL
    # =====================================================

    def start(self):
        if self.running or self.fetching:
            return

        if not self.files:
            messagebox.showwarning(
                "Scan first",
                "Scan a folder before uploading."
            )
            return

        group_label = self.group_combo.get()
        topic_label = self.topic_combo.get()

        if group_label not in self.groups:
            messagebox.showerror(
                "Group",
                "Load and select a group."
            )
            return

        if topic_label not in self.topics:
            messagebox.showerror(
                "Topic",
                "Load and select a topic."
            )
            return

        try:
            api_id, api_hash = self.get_credentials()
        except ValueError as e:
            messagebox.showerror("Credentials", str(e))
            return

        group_id = self.groups[group_label]["id"]
        topic_id = self.topics[topic_label]

        # Capture all GUI values before starting the worker.
        # Tkinter variables should not be read from worker threads.
        upload_mode = self.upload_mode.get()
        send_grouped = self.send_grouped.get() and upload_mode == "media"
        group_size = int(self.group_size.get())

        pending = [
            item for batch in self.batches for item in batch
            if item["state"] != "Too large"
            and not self.is_uploaded(
                item["path"], item["size"], item["mtime"]
            )
        ]

        if not pending:
            messagebox.showinfo(
                "Complete",
                "No pending files to upload."
            )
            return

        self.save_settings()
        self.running = True
        self.stop_event.clear()

        self.start_btn.config(state="disabled")
        self.stop_btn.config(state="normal")

        self.worker = threading.Thread(
            target=self.upload_worker,
            args=(
                api_id,
                api_hash,
                group_id,
                topic_id,
                upload_mode,
                send_grouped,
                group_size
            ),
            daemon=True
        )
        self.worker.start()

    def stop(self):
        self.stop_event.set()
        self.stop_btn.config(state="disabled")
        self.status.set("Stopping after the current file...")

    def upload_worker(
        self, api_id, api_hash, group_id, topic_id, upload_mode,
        send_grouped=False, group_size=10
    ):
        try:
            asyncio.run(
                self.upload_all(
                    api_id, api_hash, group_id, topic_id, upload_mode,
                    send_grouped, group_size
                )
            )
        except Exception as e:
            self.events.put(("fatal", str(e)))
        finally:
            self.events.put(("upload_finished", None))

    async def upload_all(
        self, api_id, api_hash, group_id, topic_id, upload_mode,
        send_grouped=False, group_size=10
    ):
        eligible = [
            item for batch in self.batches for item in batch
            if item["state"] != "Too large"
        ]
        completed = sum(
            1 for item in eligible
            if self.is_uploaded(item["path"], item["size"], item["mtime"])
        )
        self.events.put(("overall", (completed, len(eligible))))

        # Telegram albums support 2-10 photo/video items. Other files are
        # sent individually so they are not silently converted or rejected.
        media_exts = {".jpg", ".jpeg", ".png", ".webp", ".heic",
                      ".mp4", ".mov", ".m4v", ".avi", ".mkv"}

        async with TelegramClient(SESSION, api_id, api_hash) as client:
            entity = await client.get_entity(group_id)

            for batch_no, batch in enumerate(self.batches, start=1):
                pending = [
                    item for item in batch
                    if item["state"] != "Too large"
                    and not self.is_uploaded(item["path"], item["size"], item["mtime"])
                ]
                i = 0
                while i < len(pending):
                    if self.stop_event.is_set():
                        return

                    first = pending[i]
                    can_album = (
                        send_grouped and upload_mode == "media"
                        and first["path"].suffix.lower() in media_exts
                    )
                    group = [first]
                    if can_album:
                        j = i + 1
                        while j < len(pending) and len(group) < min(10, max(2, group_size)):
                            candidate = pending[j]
                            if candidate["path"].suffix.lower() not in media_exts:
                                break
                            group.append(candidate)
                            j += 1
                    # A one-item tail is simply sent as a regular media message.
                    paths = [str(item["path"]) for item in group]
                    total_bytes = sum(item["size"] for item in group)
                    label = (f"Album ({len(group)} files)" if len(group) > 1 else group[0]["path"].name)
                    self.events.put(("status", f"Batch {batch_no}/{len(self.batches)}"))
                    self.events.put(("file_text", f"Uploading: {label}"))
                    self.events.put(("file_progress", 0))

                    try:
                        for item in group:
                            stat = item["path"].stat()
                            if stat.st_size != item["size"] or abs(stat.st_mtime-item["mtime"]) >= 0.001:
                                raise RuntimeError(f"File changed since scan: {item['path']}")

                        def callback(sent, total):
                            self.events.put(("file_progress", sent * 100 / total if total else 0))

                        while True:
                            try:
                                await client.send_file(
                                    entity=entity,
                                    file=paths if len(paths) > 1 else paths[0],
                                    reply_to=topic_id,
                                    force_document=(upload_mode == "document"),
                                    supports_streaming=True,
                                    progress_callback=callback
                                )
                                break
                            except FloodWaitError as e:
                                self.events.put(("status", f"Telegram rate limit: waiting {e.seconds} seconds"))
                                await asyncio.sleep(e.seconds + 1)

                        for item in group:
                            self.mark_uploaded(item["path"], item["size"], item["mtime"])
                            self.events.put(("state", (item, "Uploaded")))
                        completed += len(group)
                    except Exception as e:
                        for item in group:
                            self.events.put(("state", (item, "Failed")))
                        self.events.put(("error", f"{label}: {e}"))

                    self.events.put(("overall", (completed, len(eligible))))
                    i += len(group)

    # =====================================================
    # GUI EVENT HANDLER
    # =====================================================

    def set_state(self, item, state):
        item["state"] = state
        key = str(item["path"])

        if self.tree.exists(key):
            values = list(self.tree.item(key, "values"))
            values[3] = state
            self.tree.item(key, values=values)

    def process_events(self):
        try:
            while True:
                kind, data = self.events.get_nowait()

                if kind == "status":
                    self.status.set(data)

                elif kind == "file_text":
                    self.file_progress_text.set(data)

                elif kind == "file_progress":
                    self.file_bar["value"] = data

                elif kind == "overall":
                    done, total = data

                    self.overall_text.set(
                        f"{done} / {total} files completed"
                    )

                    self.overall_bar["value"] = (
                        done * 100 / total if total else 0
                    )

                elif kind == "state":
                    item, state = data
                    self.set_state(item, state)

                elif kind == "groups":
                    self.groups = data
                    names = list(data.keys())

                    self.group_combo["values"] = names
                    self.group_combo.config(state="readonly")

                    if names:
                        if self.saved_group in self.groups:
                            self.group_combo.set(
                                self.saved_group
                            )
                        else:
                            self.group_combo.current(0)

                        self.on_group_selected()
                        self.status.set(
                            f"Loaded {len(names)} groups"
                        )
                    else:
                        self.status.set("No groups found")

                elif kind == "topics":
                    self.topics = data
                    names = list(data.keys())

                    self.topic_combo["values"] = names
                    self.topic_combo.config(
                        state="readonly" if names else "disabled"
                    )

                    if names:
                        if self.saved_topic in self.topics:
                            self.topic_combo.set(
                                self.saved_topic
                            )
                        else:
                            self.topic_combo.current(0)

                        self.status.set(
                            f"Loaded {len(names)} topics"
                        )
                    else:
                        self.status.set("No topics found")

                    self.save_settings()

                elif kind == "fetch_error":
                    messagebox.showerror(
                        "Telegram error",
                        data
                    )
                    self.status.set(
                        "Could not load Telegram data"
                    )

                elif kind == "fetch_finished":
                    self.fetching = False
                    self.load_groups_btn.config(
                        state="normal"
                    )

                    self.load_topics_btn.config(
                        state=(
                            "normal"
                            if self.group_combo.get() in self.groups
                            else "disabled"
                        )
                    )

                elif kind == "error":
                    print("Upload error:", data)

                elif kind == "fatal":
                    messagebox.showerror(
                        "Upload error",
                        data
                    )
                    self.status.set(
                        "Upload stopped due to an error"
                    )

                elif kind == "upload_finished":
                    self.running = False
                    self.start_btn.config(state="normal")
                    self.stop_btn.config(state="disabled")

                    if self.stop_event.is_set():
                        self.status.set("Upload stopped")
                    else:
                        self.status.set(
                            "Upload process completed"
                        )

        except queue.Empty:
            pass

        self.root.after(150, self.process_events)

    # =====================================================
    # OTHER CONTROLS
    # =====================================================

    def clear(self):
        if self.running or self.fetching:
            return

        self.files = []
        self.batches = []
        self.tree.delete(*self.tree.get_children())

        self.status.set("Select a folder and scan")
        self.file_progress_text.set("No upload active")
        self.overall_text.set("0 / 0 files completed")

        self.file_bar["value"] = 0
        self.overall_bar["value"] = 0

    def close(self):
        if self.running:
            if messagebox.askyesno(
                "Exit",
                "Stop after the current file and close?"
            ):
                self.stop_event.set()
                self.root.after(500, self.close)
            return

        if self.fetching:
            if not messagebox.askyesno(
                "Exit",
                "A Telegram request is running. Exit anyway?"
            ):
                return

        self.save_settings()
        self.root.destroy()


# =====================================================
# APPLICATION ENTRY POINT
# =====================================================

if __name__ == "__main__":
    root = tk.Tk()
    app = TelegramUploader(root)
    root.mainloop()
