# Zed vs VS Code — Getting Started (Student Version)

## VS Code vs Zed (High-Level Comparison)

[**Zed**](https://zed.dev)

- Starts as a **plain text editor** and can gradually be configured into an IDE.
- **For learning, starting from a text editor and adding tools gradually matches** how programming skills develop.
- Starting from an IDE exposes students to automation before they understand what it replaces.
- Very fast!

**Zed is not better than VS Code in general**; it is better suited for learning purposes and is therefore recommended for these courses.

[**VS Code**](https://code.visualstudio.com)

- The most popular code editor.
- Extremely powerful and extensible, and it is built around automation and extensions.
- By default, VS Code suggests code while typing, highlights errors immediately, and strongly encourages the use of automated tooling such as formatting and code assistance.
- Is a Web application, much slower than Zed.

In the end, the choice of editor does not matter. For learning purposes, it is wise to start with a clean editor that minimizes automation.

## Installing Zed

Official download page: https://zed.dev/download

| Step | macOS                              | Windows                        |
| ---- | ---------------------------------- | ------------------------------ |
| 1    | Open your browser                  | Open your browser              |
| 2    | Go to https://zed.dev              | Go to https://zed.dev          |
| 3    | Download the macOS version         | Download the Windows installer |
| 4    | Open the `.dmg` file               | Run the installer              |
| 5    | Drag **Zed** into **Applications** | Accept default options         |

---

## Changing Zed Settings (Course Configuration)

With these configurations, Zed does not provide:

- AI or code suggestions
- Automatic formatting
- Code completion
- Automatic error fixing

This is by design, not a limitation.

---

### Open the Settings File

1. Open Zed
2. Open the Command Palette
   - macOS: `Cmd + Shift + P`
   - Windows: `Ctrl + Shift + P`
3. Type **Settings**
4. Select **Open Settings (JSON)**

A file named `settings.json` will open.

---

### Replace the Settings

1. Select all content in `settings.json`
2. Delete it completely
3. Paste the configuration below
4. Save the file

Changes apply immediately.

---

### Course `settings.json`

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

### Optional Features

**Displaying All Whitespace Characters**

Whitespace characters include:

- spaces
- tabs
- line breaks

Displaying them helps you:

- see indentation clearly
- distinguish tabs from spaces
- avoid hidden formatting mistakes

This is useful for learning and for writing clean, consistent code.

---

**Showing Whitespace in Zed**

In Zed, whitespace display is controlled by the `show_whitespaces` setting.

To display **all** whitespace characters, add or modify this setting in `settings.json`:

```json
"show_whitespaces": "all"
```

---

**Indent Guides**

Indent guides are **vertical lines** shown in the editor that visualize code indentation levels.

They help you:

- see code structure
- understand nesting (blocks, loops, conditionals)
- spot incorrect indentation quickly

Indent guides do **not** change the code; they are purely visual.

You can add following to `settings.json`:

```json
"indent_guides": {
  "enabled": true,
  "coloring": "indent_aware"
}
```

---

**Font Ligatures**

Font ligatures are a visual feature where multiple characters are displayed as a single symbol.

Examples:

- `!=` may appear as `≠`
- `=>` may appear as `⇒`

Ligatures do not change the code itself, only how it is displayed.

For learning, ligatures are usually disabled so students can see every character exactly as typed, which makes understanding syntax clearer.

---

**Ligatures in Zed**

Ligatures in Zed are controlled through font feature settings:

```json
"buffer_font_features": {
  "calt": false,
  "liga": false
}
```

Enabling ligatures:

```json
"buffer_font_features": {
  "calt": true,
  "liga": true
}
```

You must also use a font that supports ligatures, for example:

```json
"buffer_font_family": "JetBrains Mono"
```
