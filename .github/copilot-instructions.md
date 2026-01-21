<!-- Auto-generated and editable: guidance for AI coding agents working in this workspace -->
# Copilot / AI Agent Instructions

Purpose: quick, practical guidance so an AI coding assistant can be immediately productive in this multi-language learning repository.

- **Repository shape:** top-level language folders (e.g. `C/`, `JAVA/`, `Python/`, `HTML_&_CSS_&_JS/`, `GO/`, `C#/`) containing many standalone examples and small projects. There is no single monolithic application—this is a collection of examples and exercises.

- **Big picture:** treat this repo as a learn-by-example archive. Tasks most likely include adding or improving small, self-contained examples, creating README/docs per folder, or adding language-specific build/run helpers. Avoid large-scale cross-language refactors unless instructed.

- **Key directories to inspect:**
  - [C](C) — many standalone C programs (e.g. [C/Sorting/BubbleSorting.c](C/Sorting/BubbleSorting.c)).
  - [JAVA](JAVA) — collections, algorithms and samples (e.g. [JAVA/Arrays/Array.java](JAVA/Arrays/Array.java)).
  - [HTML_&_CSS_&_JS](HTML_&_CSS_&_JS) — static pages and JS examples (see [HTML_&_CSS_&_JS/HTML/Calculator.html](HTML_&_CSS_&_JS/HTML/Calculator.html)).
  - [GO](GO) — contains `go.mod` and `main.go` (module-based Go project).

- **Common patterns found in code:**
  - Files are grouped by language then by topic (e.g., `JAVA/Algorithms`, `C/Sorting`).
  - Many files are single-file examples (compile/run per-file). Expect no shared build system across languages.
  - Naming uses capitalized folder names and mixed-case filenames; when adding files follow existing folder naming.

- **Developer workflows (how to run / test):**
  - C: compile single files with `gcc` or use the provided `build/Debug` artifacts. Example: `gcc -o out C/Sorting/BubbleSorting.c && ./out`.
  - Java: compile with `javac` inside the relevant folder and run with `java` using the package/classpath rooted at the folder. Example: `javac JAVA/Arrays/Array.java && java -cp JAVA Arrays.Array`.
  - Go: run `go run GO/main.go` or `go build` inside the `GO` folder (module present).
  - HTML/JS: open files in browser; no server by default.

- **If you need to change code:**
  - Keep edits minimal and local to the example being improved.
  - Preserve demonstrative/educational intent: don't replace simple implementations with heavy framework code.
  - When adding helpers or CI, place them in a small top-level `tools/` or `.github/` area and document usage.

- **Files to reference when modeling changes:**
  - `C/Sorting/BubbleSorting.c` — typical single-file C example.
  - `JAVA/Arrays/Array.java` — canonical Java example structure.
  - `GO/main.go` and `go.mod` — module-based Go example.

- **What not to do:**
  - Don't assume a unified build/test system (there isn't one).
  - Don't rename or reorganize large sets of files without an explicit plan—this repository is an index of examples and renames break users' expectations.

- **Suggested agent actions (practical, high-value):**
  - Add brief README files inside major folders (e.g., `C/README.md`) explaining how to run representative examples.
  - Create small language-specific run scripts (e.g., `run_c_examples.sh` or PowerShell equivalents) and document them in the top-level `README.md`.
  - Improve a single example per PR with tests or run instructions where appropriate.

If anything here is unclear or you want the agent to adopt stricter conventions (naming, testing, CI), tell me which folders to target and I will update these instructions and make an initial PR.
