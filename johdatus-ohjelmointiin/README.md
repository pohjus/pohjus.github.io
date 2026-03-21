# Introduction to Java

## Preliminary Agenda and Assignments

| Topics | Assignment | Points |
|--------|------------|--------|
| Variables, input/output, if statements, while loops | [Assignment 01](assignment01/) | 36 |
| Boolean algebra, control structures, ASCII graphics | [Assignment 02](assignment02/) | 63 |
| Strings, palindromes, file I/O, randomness, hangman | [Assignment 03](assignment03/) | 59 |
| **Total** | | **158** |

## Course Requirements

1. Watch lectures and submit handwritten notes for every lecture.
2. Complete assignments (minimum 50%).

### Handwritten Notes

- Handwritten notes must be on pen and paper (not digital).
- Must include main topics.
- Submit as PDFs with images of handwritten notes.
- File format: `studentnumber-lectureYY.pdf` (e.g., `12345-lecture01.pdf`)
- Language: Finnish or English.
- Incorrect filenames result in automatic rejection.

### Assignment Submission

- Zip format: `studentnumber-assignment0X.zip` (e.g., `12345-assignment01.zip`)
- Structure:

```text
assignment0X/
  01/..
  02/..
  03/..
```

- Each test equals 1 point. **Minimum 50%** of total points required.
- Course period: `2026-05-01` to `2026-08-31`
- **Deadline:** `2026-08-15`
- Late penalties:
  - `2026-08-16` to `2026-08-31`: automatic grade 1
  - After `2026-08-31`: **course failed, no exceptions**

## Grading

The grade is determined by the assignment score. There is no exam.

| Grade | Percentage |
|-------|------------|
| 1     | 50%        |
| 2     | 60%        |
| 3     | 70%        |
| 4     | 80%        |
| 5     | 90%        |

## Tools

### Installing Java

Install **Eclipse Temurin 25** from the [Adoptium website](https://adoptium.net/).

#### Windows

1. Go to [https://adoptium.net/](https://adoptium.net/).
2. Download the **Windows x64** `.msi` installer for **Temurin 25**.
3. Run the installer. During installation, make sure the option **"Add to PATH"** is enabled.
4. Open **Command Prompt**: press `Win + R`, type `cmd`, and press Enter.
5. Verify the installation by running:

```bash
java --version
javac --version
```

#### macOS

1. Go to [https://adoptium.net/](https://adoptium.net/).
2. Download the **macOS** installer (`.pkg`) for **Temurin 25**. Choose **aarch64** if you have an Apple Silicon Mac (M1/M2/M3/M4), or **x64** for an older Intel Mac.
3. Run the installer.
4. Open **Terminal**: press `Cmd + Space`, type `Terminal`, and press Enter.
5. Verify the installation by running:

```bash
java --version
javac --version
```

#### Linux

1. Go to [https://adoptium.net/](https://adoptium.net/).
2. Download the **Linux x64** `.tar.gz` archive for **Temurin 25**.
3. Extract and add to your PATH, or use your distribution's package manager. See the [Adoptium installation guide](https://adoptium.net/installation/linux/) for details.
4. Verify the installation by running:

```bash
java --version
javac --version
```

### Text Editors

You need a text editor to write Java code. Here are some options:

- **[VS Code](https://code.visualstudio.com/)**: Popular, free editor with Java support via extensions.
- **[Notepad++](https://notepad-plus-plus.org/)**: Lightweight editor for Windows. Simple and easy to use.
- **[Zed](https://zed.dev/)**: Fast, modern editor available for macOS, Windows, and Linux.
- **[micro](https://micro-editor.github.io/)**: Simple terminal-based editor. Easy to use, works on all platforms.
- **[IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/)**: Full-featured Java IDE, free community version available. **Not recommended for beginners:** it hides the compile/run process, its autocomplete does too much of the thinking for you, and its project structure adds unnecessary complexity for simple single-file exercises.

Any plain text editor will work. Do **not** use a word processor like Microsoft Word.

### Disabling AI Features

Many modern editors include built-in AI assistants or autocomplete powered by AI (e.g., GitHub Copilot in VS Code, AI Assistant in IntelliJ, Zed's AI features). **You must disable all AI-powered code suggestions and completions** before working on exercises.

- **VS Code**: Uninstall or disable the GitHub Copilot extension. Go to Extensions (`Ctrl+Shift+X` / `Cmd+Shift+X`), search for "Copilot", and disable it.
- **IntelliJ IDEA**: Go to `Settings` > `Plugins`, search for "AI Assistant", and disable it.
- **Zed**: Go to `Settings` and disable AI-related features (Assistant, inline completions).

## AI Policy

It is strictly **forbidden** to use AI tools to complete exercises directly.

### Allowed Uses

- Explaining concepts.
- Requesting simple study examples.
- Clarifying theory and terminology.

### Prohibited Uses

- Asking AI to complete or solve assignment tasks.
- Copying AI-generated code into submissions.

If you want to use AI as a learning aid, use [ChatGPT Study Mode](https://chatgpt.com/), which is designed to guide you through problems without giving you the answer directly.

### Why This Matters

In the future, much of programming work will involve reading, reviewing, and validating code generated by AI. However, if you do not understand the basics, you cannot effectively validate whether AI-generated code is correct, handles edge cases, or solves the right problem. The only reliable way to build that foundation is by writing code manually.

All submitted assignments are run through a plagiarism detection tool that also checks for AI-generated code.

### Privacy Notice

Never share your student ID, email, credentials, or confidential information on external AI platforms (ChatGPT, Claude, etc.).

### Course Guideline

Follow [Arene AI Traffic Light Model](https://sites.tuni.fi/vinkkipankki/tekoaly/liikennevalomalli-nain-ohjeistat-opiskelijoita-tekoalyn-kaytossa/) "Yellow Rule": "The use of AI is allowed, but it must be disclosed."

## License

> This work is licensed under the
> **Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License (CC BY-NC-SA 4.0)**
>
> **Additional Restriction:**
> The material may **not** be used, in whole or in part, to **train, fine-tune, prompt, or otherwise feed into any generative artificial intelligence (AI) or machine learning (ML) system**, except for the author.

[Learn more about CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/)
