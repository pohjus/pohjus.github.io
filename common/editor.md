# Zed vs VS Code — Getting Started (Student Version)

## Table of Contents

1. [VS Code vs Zed (High-Level Comparison)](#1-vs-code-vs-zed-high-level-comparison)
2. [Why Zed Is Better for Learning](#2-why-zed-is-better-for-learning)
3. [Popularity vs Similarity](#3-popularity-vs-similarity)
4. [What Is Intentionally Disabled](#4-what-is-intentionally-disabled)
5. [Installing Zed](#5-installing-zed)
6. [Using Zed in This Course](#6-using-zed-in-this-course)
7. [Later Transition](#7-later-transition)
8. [Changing Zed Settings (Course Configuration)](#8-changing-zed-settings-course-configuration)

---

## 1. VS Code vs Zed (High-Level Comparison)

### Zed

Website: https://zed.dev

Zed is:

- Modern and fast
- Minimal by design
- Less extension-driven

With the course configuration, Zed:

- Behaves like a plain text editor
- Does not suggest code
- Does not auto-format
- Does not fix mistakes

Zed is not better than VS Code in general — it is better for learning and it is highly recommend for these courses.

---

### Visual Studio Code (VS Code)

Website: https://code.visualstudio.com

VS Code is:

- The most popular code editor
- Extremely powerful and extensible
- Built around automation and extensions

By default, VS Code:

- Suggests code while typing
- Formats code automatically
- Highlights errors immediately
- Encourages reliance on tooling

This is excellent for professionals, but not ideal for learning fundamentals.

---

## 2. Why Zed Is Better for Learning

When learning programming, the goal is to:

- Remember syntax
- Understand structure
- Notice mistakes
- Build discipline

VS Code removes friction.

Zed (in this course) keeps friction intentionally.

This helps you:

- See every character you type
- Understand indentation and spacing
- Learn from mistakes instead of hiding them

---

## 4. What Is Intentionally Disabled

In this course configuration, Zed does not provide:

- AI or code suggestions  
  (for example GitHub Copilot: https://github.com/features/copilot)
- Automatic formatting  
  (for example Prettier: https://prettier.io)
- Code completion
- Automatic error fixing

This is by design, not a limitation.

---

## 5. Installing Zed

Official download page: https://zed.dev/download

### macOS

1. Open your browser
2. Go to https://zed.dev
3. Download the macOS version
4. Open the `.dmg` file
5. Drag **Zed** into **Applications**

---

### Windows

1. Open your browser
2. Go to https://zed.dev
3. Download the Windows installer
4. Run the installer
5. Accept default options

---

## 8. Changing Zed Settings (Course Configuration)

Zed documentation: https://zed.dev/docs

Zed uses a JSON configuration file.

---

### 8.1 Open the Settings File

1. Open Zed
2. Open the Command Palette
   - macOS: `Cmd + Shift + P`
   - Windows: `Ctrl + Shift + P`
3. Type **Settings**
4. Select **Open Settings (JSON)**

A file named `settings.json` will open.

---

### 8.2 Replace the Settings

1. Select all content in `settings.json`
2. Delete it completely
3. Paste the configuration below
4. Save the file

Changes apply immediately.

---

### 8.3 Course `settings.json`

Copy **everything** below:

```json
{
  "assistant": {
    "enabled": false
  },

  "features": {
    "edit_prediction_provider": "none",
    "copilot": false
  },

  "disable_ai": true,

  "format_on_save": "off",

  "formatter": {
    "default_formatter": null
  },

  "languages": {
    "*": {
      "format_on_save": "off",
      "formatter": null,
      "enable_language_server": false
    }
  },

  "prettier": {
    "allowed": false
  },

  "auto_install_extensions": false,

  "buffer_font_family": "monospace",
  "buffer_font_size": 14,

  "buffer_font_features": {
    "calt": false,
    "liga": false
  }
}
```
