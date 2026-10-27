import requests
import re
import json
import time
from concurrent.futures import ThreadPoolExecutor, as_completed
import urllib3
urllib3.disable_warnings(urllib3.exceptions.InsecureRequestWarning)

BASE_URL = "https://tamilradios.org/livetv/"

CHANNELS = [
    ("Colors Tamil HD", "colors-tamil-hd"),
    ("Z Tamil HD", "z-tamil-hd"),
    ("Discovery Kids Tamil", "discovery-kids-tamil"),
    ("CN Tamil", "cn-tamil"),
    ("History TV18 HD Tamil", "history-tv18-hd-tamil"),
    ("Jaya Max", "jaya-max"),
    ("Jaya Movie", "jaya-movie"),
    ("Discovery Tamil", "discovery-tamil-2"),
    ("Animal Planet HD", "animal-planet-hd"),
    ("Jaya TV", "jaya-tv"),
    ("Sony YAY Tamil", "sony-yay-tamil"),
    ("Surya TV", "surya-tv"),
    ("Polimer TV", "polimer-tv"),
    ("Vasanth TV", "vasanth-tv"),
    ("Makkal TV", "makkal-tv"),
    ("Vendhar TV", "vendhar-tv"),
    ("DD Tamil", "dd-tamil"),
    ("Isai Aruvi TV", "isai-aruvi-tv"),
    ("Chithiram TV", "chithiram-tv"),
    ("Kalaignar TV", "kalaignar-tv"),
    ("Raj Musix", "raj-musix"),
    ("Raj Digital Plus", "raj-digital-plus"),
    ("Sathiyam TV", "sathiyam-tv"),
    ("Raj TV", "raj-tv"),
    ("Puthiya Thalaimurai", "928"),
    ("News Tamil 24x7", "news-tamil-24x7"),
    ("Malai Murasu TV", "malai-murasu-tv"),
    ("Chanakyaa TV", "chanakyaa-tv"),
    ("Tamil Janam TV", "tamil-janam-tv"),
    ("News J", "news-j"),
    ("IBC Bakthi", "ibc-bakthi"),
    ("IBC Tamil", "ibc-tamil"),
    ("Angel TV", "angel-tv"),
    ("Sri Sankara Tamil", "sri-sankara-tamil"),
    ("SVBC TTD", "svbc-ttd"),
    ("Madha TV", "madha-tv"),
    ("Kalaignar Seithigal TV", "kalaignar-seithigal-tv"),
    ("Sana TV", "sana-tv"),
    ("Tamilan TV", "tamilan-tv"),
    ("Thanthi TV", "thanthi-tv"),
    ("Polimer News", "polimer-news"),
    ("Peppers TV", "peppers-tv"),
    ("Murasu TV", "murasu-tv"),
    ("Moon TV", "moon-tv"),
    ("Sirippoli TV", "sirippoli-tv"),
    ("Sun News", "sun-news"),
    ("7 Star TV", "7-star-tv"),
    ("Vaanavil TV", "vaanavil-tv"),
    ("Aus Tamil TV", "aus-tamil-tv"),
    ("Royal TV", "royal-tv"),
    ("Athavan TV", "athavan-tv"),
    ("Thalaa TV", "thalaa-tv"),
    ("MN Music", "mn-music"),
    ("Vasantham TV", "vasantham-tv"),
    ("Udhayam TV", "udhayam-tv"),
    ("Thendral TV", "thendral-tv"),
    ("U TV Tamil", "u-tv-tamil"),
    ("Kavin TV", "kavin-tv"),
    ("Anandham TV", "anandham-tv"),
    ("Subin TV", "subin-tv"),
    ("Marutham Nelli TV", "mn-tv"),
    ("No 1 TV", "no-1-tv"),
    ("D TV", "d-tv"),
    ("Aasirvadham TV", "aasirvadham-tv"),
    ("Nambikkai TV", "nambikkai-tv"),
    ("Deva TV", "deva-tv"),
    ("D Bhakti TV", "d-bhakti-tv"),
    ("TVI TV", "tvi-tv"),
    ("Tamil 3 TV", "tamil-3-tv"),
    ("Tamil Star TV", "tamil-star-tv"),
    ("Eye Tamil TV", "eye-tamil-tv"),
    ("SLS TV", "sls-tv"),
    ("Mullai TV", "mullai-tv"),
    ("Jupiter Tamil TV", "jupiter-tamil-tv"),
    ("Shalini TV", "shalini-tv"),
    ("Malar TV", "malar-tv"),
    ("Bharathi TV", "bharathi-tv"),
    ("SJ Surya TV", "sj-surya-tv"),
    ("Rasi Music", "rasi-music"),
    ("Bright Simrose TV", "bright-simrose-tv"),
    ("Thillai TV", "thillai-tv"),
    ("Maniway TV", "maniway-tv"),
    ("Enthiran TV", "enthiran-tv"),
    ("STN TV", "stn-tv"),
    ("Boss TV", "boss-tv"),
    ("MCN HD", "mcn-hd"),
    ("Jayam TV", "jayam-tv"),
    ("Kovai TV", "kovai-tv"),
    ("Sana Plus HD", "sana-tv-hd"),
    ("Velan TV", "velan-tv"),
    ("MS Mathan TV", "ms-mathan-tv"),
    ("Irattaipaathai TV", "irattaipaathai-tv"),
    ("CTN", "ctn"),
    ("Senthur TV", "senthur-tv"),
    ("Velavan TV", "velavan-tv"),
    ("Vani TV HD", "vani-tv-hd"),
    ("Max Movies HD", "max-movies-hd"),
    ("Max Music HD", "max-music-hd"),
    ("Roja TV", "roja-tv"),
    ("Roja Movies", "roja-movies"),
    ("Tharun Movies HD", "tharun-movies-hd"),
    ("Thaai TV", "thaai-tv"),
    ("MN TV", "mn-tv-2"),
    ("BTV HD", "btv-hd"),
    ("SK TV", "sk-tv"),
    ("Suriyan TV", "suriyan-tv"),
    ("NTV HD", "ntv-hd"),
    ("Gem TV", "gem-tv"),
    ("Eason TV", "eason-tv"),
    ("Tamil Oli TV", "tamil-oli-tv"),
    ("Tamil TV HD", "tamil-tv-hd"),
    ("KCTV", "kctv"),
    ("Jith TV", "jith-tv"),
    ("JR Malar TV", "jr-malar-tv"),
    ("JCV Musix", "jcv-musix"),
    ("Raga TV", "raga-tv"),
    ("Oli TV HD", "oli-tv-hd"),
    ("Kumari TV", "kumari-tv"),
    ("Prime TV", "prime-tv"),
    ("MP TV", "mp-tv"),
    ("G Music", "g-music"),
    ("Tamil Television Network", "tamil-television-network"),
    ("TDN HD", "tdn-hd"),
    ("Surya TV Tamil", "surya-tv-tamil"),
    ("Yet TV", "yet-tv"),
    ("Dark TV", "dark-tv"),
    ("A2A TV", "a2a-tv"),
    ("Succes TV Tamil", "succes-tv-tamil"),
    ("Manasu TV", "manasu-tv"),
    ("Om Sakthi TV", "om-sakthi-tv"),
    ("Sakthi TV HD", "sakthi-tv-hd"),
    ("Deiva Oli", "deiva-oli"),
    ("Asoka TV", "asoka-tv"),
    ("NTN TV", "ntn-tv"),
    ("PR TV", "pr-tv"),
    ("DTV", "dtv"),
    ("Thalapathy TV", "thalapathy-tv"),
    ("Riya TV", "riya-tv"),
    ("Nila TV Nellai", "nila-tv-nellai"),
    ("Harin TV", "harin-tv"),
    ("Time TV", "time-tv"),
    ("Phoenix TV Tamil", "phoenix-tv-tamil"),
    ("Imai TV", "imai-tv"),
    ("Nila TV", "nila-tv"),
    ("WE Baduga TV", "we-baduga-tv"),
    ("Sky Plus TV", "sky-plus-tv"),
    ("Vasantham", "vasantham"),
    ("Devathai TV", "devathai-tv"),
    ("Jeyam Television", "jeyam-television"),
    ("SMCV HD", "smcv-hd"),
    ("Yogaa TV", "yogaa-tv"),
    ("Roja TV 2", "roja-tv-2"),
    ("Sasi TV", "sasi-tv"),
    ("Jose TV", "jose-tv"),
    ("TOP TV", "top-tv"),
    ("RK TV", "rk-tv"),
    ("Maran TV", "maran-tv"),
    ("Surya HD Digital", "surya-hd-digital"),
    ("Aaryaa TV", "aarya-tv"),
    ("Isai TV", "isai-tv"),
    ("Dharshan TV", "dharshan-tv"),
    ("Britain Tamil Bhakthi TV", "britain-tamil-bhakthi-tv"),
    ("Sha TV", "sha-tv"),
    ("Sachin TV", "sachin-tv"),
    ("Sachin TV Music", "sachin-tv-music"),
    ("Dhoni TV HD", "dhoni-tv-hd"),
    ("EET TV", "eet-tv"),
    ("Thendral TV Madurai", "thendral-tv-madurai"),
    ("Namma Gopi TV", "namma-gopi-tv"),
    ("Jeyam TV", "jeyam-tv"),
    ("M Television", "m-television"),
    ("Aadvik TV", "aadvik-tv"),
    ("Thirumagal TV", "thirumagal-tv"),
    ("Maruthi TV", "maruthi-tv"),
    ("Aadhavan TV", "aadhavan-tv"),
    ("3 Star TV", "3-star-tv"),
    ("JCV", "jcv"),
    ("Velicham TV", "velicham-tv"),
    ("Minnal HD", "minnal-hd"),
    ("Hai TV", "hai-tv"),
    ("KCTN TV", "kctn-tv"),
    ("JJ News Tamil", "jj-news-tamil"),
    ("Anandam TV", "anandam-tv"),
    ("Urchagam TV", "urchagam-tv"),
    ("Thendral TV 2", "thendral-tv-2"),
    ("Eagle TV", "eagle-tv"),
    ("Rainbow TV", "rainbow-tv"),
    ("Ashoka TV", "ashoka-tv"),
    ("Sai TV", "sai-tv"),
    ("Anbu TV", "anbu-tv"),
    ("Apple TV", "apple-tv"),
    ("Nellai TV", "nellai-tv"),
    ("Params TV", "params-tv"),
    ("Rock TV", "rock-tv"),
    ("RJ Tamil TV", "rj-tamil-tv"),
    ("King 24x7", "king-24x7"),
    ("Karthick TV", "karthick-tv"),
    ("Akilam TV", "akilam-tv"),
    ("Rio TV", "rio-tv"),
    ("Saami TV", "saami-tv"),
    ("7 Green 4K", "7-green-4k"),
    ("Queens TV", "queens-tv"),
    ("Jayam TV 2", "jayam-tv-2"),
    ("Smiley TV", "smiley-tv"),
    ("Vanavil TV Kallakurichi", "vanavil-tv-kallakurichi"),
    ("Visil Max", "visil-max"),
    ("VCTN TV", "vctn-tv"),
    ("Jothibala TV", "jothibala-tv"),
    ("Akash TV", "akash-tv"),
    ("Vikatan TV", "vikatan-tv"),
    ("Vedha TV", "vedha-tv"),
    ("NTC TV", "ntc-tv"),
    ("Ultimate TV", "ultimate-tv"),
    ("Anandham TV 2", "anandham-tv-2"),
    ("Strawberry TV", "aaryaa-tv"),
    ("Thulir TV", "thulir-tv"),
    ("MSN TV", "msn-tv"),
    ("King TV", "king-tv"),
    ("Kumaran TV", "kumaran-tv"),
    ("Ganesh TV", "ganesh-tv"),
    ("Mathi TV", "mathi-tv"),
    ("Visil TV", "visil-tv"),
    ("Durai TV", "durai-tv"),
    ("Apple TV Nagercoil", "apple-tv-nagercoil"),
    ("Jeyson TV", "jeyson-tv"),
    ("Kumari Kathir TV", "kumari-kathir-tv"),
    ("JC TV", "jc-tv"),
    ("Digital TV", "digital-tv"),
    ("Veera TV", "veera-tv"),
    ("Subash TV", "subash-tv"),
    ("NTV Trichy", "ntv-trichy"),
    ("Arunai TV", "arunai-tv"),
    ("RR TV", "rr-tv"),
    ("SS TV", "ss-tv"),
    ("UTV Mayuram", "utv-mayuram"),
    ("Thirumalai TV", "thirumalai-tv"),
    ("Subi TV", "subi-tv"),
    ("Hitech TV", "hitech-tv"),
    ("Orange TV", "orange-tv"),
    ("Leo TV", "leo-tv"),
    ("S TV", "s-tv"),
    ("Aasai TV", "aasai-tv"),
    ("Aalaya Magimai TV", "aalaya-magimai-tv"),
    ("Dheiveegam TV", "dheiveegam-tv"),
    ("Amman TV", "amman-tv"),
    ("Oscar TV", "oscar-tv"),
    ("Temble TV", "temble-tv"),
    ("Palkar TV", "palkar-tv"),
    ("Thamil TV", "thamil-tv"),
]

HEADERS = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/124.0 Safari/537.36",
    "Accept-Language": "en-US,en;q=0.9",
}

# URL fragments to skip (not actual stream sources)
SKIP_DOMAINS = (
    "wp-content", "googletagmanager", "flagcounter",
    "google-analytics", "googleapis", "gstatic",
    "facebook", "twitter", "w.org", "youtube.com",
)

# Ordered patterns — most specific first
PATTERNS = [
    # YuppTV embed iframe
    (re.compile(r'(https?://(?:www\.)?yupptv\.com/yupptvnew/channels/[^\s"\'<>]+/live/embed)', re.I), "yupptv"),
    # tamilradios MPD player wrapper  →  extract inner URL
    (re.compile(r'playermpd\.html\?mpd=(https?://[^\s"\'<>&]+)', re.I), "mpd"),
    # tamilradios HLS player wrapper  →  extract inner URL
    (re.compile(r'player\.html\?url=(https?://[^\s"\'<>&]+)', re.I), "m3u8"),
    # Direct .m3u8
    (re.compile(r'(https?://[^\s"\'<>]+\.m3u8[^\s"\'<>]*)', re.I), "m3u8"),
    # Direct .mpd
    (re.compile(r'(https?://[^\s"\'<>]+\.mpd[^\s"\'<>]*)', re.I), "mpd"),
    # Any other external iframe src
    (re.compile(r'src=["\']( https?://(?!(?:www\.)?tamilradios\.org)[^\s"\'<>]+)["\']', re.I), "iframe"),
]


def extract_source(html: str):
    for pattern, src_type in PATTERNS:
        match = pattern.search(html)
        if match:
            url = requests.utils.unquote(match.group(1)).strip()
            if any(skip in url for skip in SKIP_DOMAINS):
                continue
            return {"url": url, "type": src_type}
    return None


def fetch_channel(name: str, slug: str):
    page_url = BASE_URL + slug
    try:
        resp = requests.get(page_url, headers=HEADERS, timeout=15, verify=False)
        resp.raise_for_status()
        result = extract_source(resp.text)
        if result:
            print(f"  ✓  {name:<40}  [{result['type']:<8}]  {result['url']}")
            return {"name": name, "slug": slug, "page_url": page_url, **result}
        else:
            print(f"  ✗  {name:<40}  (no source found)")
            return {"name": name, "slug": slug, "page_url": page_url, "url": None, "type": None}
    except Exception as e:
        print(f"  !  {name:<40}  ERROR: {e}")
        return {"name": name, "slug": slug, "page_url": page_url, "url": None, "type": f"error: {e}"}


def save_json(results, filename="tamil_tv_sources.json"):
    with open(filename, "w", encoding="utf-8") as f:
        json.dump(results, f, indent=2, ensure_ascii=False)
    print(f"\n  Saved → {filename}")


def save_m3u(results, filename="tamil_tv.m3u"):
    lines = ["#EXTM3U"]
    for r in results:
        if r.get("url"):
            lines.append(f'#EXTINF:-1 tvg-name="{r["name"]}" group-title="Tamil Live TV",{r["name"]}')
            lines.append(r["url"])
    with open(filename, "w", encoding="utf-8") as f:
        f.write("\n".join(lines))
    found = sum(1 for r in results if r.get("url"))
    print(f"  Saved → {filename}  ({found} channels with streams)")


def main():
    print(f"\nFetching stream sources for {len(CHANNELS)} Tamil TV channels ...\n")
    all_results = []

    with ThreadPoolExecutor(max_workers=5) as executor:
        future_map = {
            executor.submit(fetch_channel, name, slug): (name, slug)
            for name, slug in CHANNELS
        }
        for future in as_completed(future_map):
            all_results.append(future.result())
            time.sleep(0.1)   # small polite delay

    # Restore original channel order
    order = {slug: i for i, (_, slug) in enumerate(CHANNELS)}
    all_results.sort(key=lambda r: order.get(r["slug"], 9999))

    found   = [r for r in all_results if r.get("url")]
    missing = [r for r in all_results if not r.get("url")]

    print(f"\n{'='*60}")
    print(f"  Total channels  : {len(CHANNELS)}")
    print(f"  Sources found   : {len(found)}")
    print(f"  Not found       : {len(missing)}")
    print(f"{'='*60}\n")

    save_json(all_results)
    save_m3u(found)

    if missing:
        print("\n  --- Channels with no source found ---")
        for r in missing:
            print(f"    {r['name']}")


if __name__ == "__main__":
    main()
