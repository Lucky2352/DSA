import os
import re

ROOT = "."
IGNORE = {".git", ".github", "scripts", "node_modules"}
START = "<!-- PROBLEMS_TABLE_START -->"
END = "<!-- PROBLEMS_TABLE_END -->"

# Matches folders like "1-two-sum", "25-reverse-nodes-in-k-group"
FOLDER_PATTERN = re.compile(r"^(\d+)-(.+)$")

def slug_to_title(slug: str) -> str:
    return " ".join(word.capitalize() for word in slug.split("-"))

def find_problems():
    problems = []
    for name in os.listdir(ROOT):
        if name in IGNORE or name.startswith("."):
            continue
        if not os.path.isdir(os.path.join(ROOT, name)):
            continue
        match = FOLDER_PATTERN.match(name)
        if match:
            number = int(match.group(1))
            slug = match.group(2)
            title = slug_to_title(slug)
            problems.append((number, title, name))
    problems.sort(key=lambda p: p[0])
    return problems

def build_table():
    problems = find_problems()
    lines = ["| # | Problem | Folder |", "|---|---------|--------|"]
    for number, title, folder in problems:
        lines.append(f"| {number} | {title} | [`{folder}`](./{folder}) |")
    return "\n".join(lines)

def update_readme():
    with open("README.md", "r", encoding="utf-8") as f:
        content = f.read()

    if START not in content or END not in content:
        raise SystemExit("Markers not found in README.md")

    before = content.split(START)[0]
    after = content.split(END)[1]
    new_section = f"{START}\n{build_table()}\n{END}"

    new_content = before + new_section + after

    if new_content != content:
        with open("README.md", "w", encoding="utf-8") as f:
            f.write(new_content)
        print("README updated.")
    else:
        print("No changes needed.")

if __name__ == "__main__":
    update_readme()
