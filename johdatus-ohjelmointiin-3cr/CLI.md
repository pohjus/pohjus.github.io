[< Back to course home](README.md)

# Command Line Basics

This guide covers the command line skills you need for this course.
No prior experience is assumed.

## What is the command line?

The command line (also called **terminal**, **shell**, or **CLI**) is a text-based way to interact with your computer.
Instead of clicking on icons and menus, you type commands and press Enter.

In this course, you use the command line to navigate to your exercise folders, compile Java programs, and run them.

## Opening the command line

### Windows

1. Press `Win + R`, type `cmd`, and press Enter.
2. A black window opens. This is **Command Prompt**.

You can also search for "Command Prompt" in the Start menu.

### macOS

1. Press `Cmd + Space` to open Spotlight.
2. Type `Terminal` and press Enter.
3. A white window opens. This is **Terminal**.

## Understanding the prompt

When you open the command line, you see a line of text ending with a cursor.
This is the **prompt**. It tells you where you are on the computer.

**Windows:**

```text
C:\Users\YourName>
```

This means you are in the folder `C:\Users\YourName`.

**macOS:**

```text
yourname@mac ~ %
```

The `~` symbol means your home folder (e.g., `/Users/yourname`).

## Your first command

Type the following and press Enter:

**Windows:**

```bash
echo Hello
```

**macOS:**

```bash
echo Hello
```

The computer prints `Hello` back to you. That is how all commands work: you type a command, press Enter, and the computer responds.

## Navigating folders

Your files are organized in folders (also called directories).
The command line always has a **current folder**, which is where you are right now.

### See where you are

**Windows:**

```bash
cd
```

**macOS:**

```bash
pwd
```

This prints the full path of your current folder.

### List files in the current folder

**Windows:**

```bash
dir
```

**macOS:**

```bash
ls
```

This shows all files and folders in your current location.

### Change folder

The `cd` command moves you into a different folder.

**Windows:**

```bash
cd Desktop
```

**macOS:**

```bash
cd Desktop
```

Now you are inside the `Desktop` folder.

### Go up one level

**Windows:**

```bash
cd ..
```

**macOS:**

```bash
cd ..
```

The `..` means "parent folder": the folder that contains the current one.

### Go to a specific folder

You can type the full path to jump directly to any folder.

**Windows:**

```bash
cd C:\Users\YourName\Desktop\assignment01\02
```

**macOS:**

```bash
cd /Users/yourname/Desktop/assignment01/02
```

### Tips for navigating

- **Windows tip:** In File Explorer, navigate to a folder and type `cmd` in the address bar. Press Enter to open Command Prompt directly in that folder.
- **macOS tip:** Type `cd ` (with a space after it), then drag a folder from Finder into the Terminal window. The path is pasted automatically. Press Enter.

## Path separators

Windows and macOS use different characters to separate folders in a path:

- **Windows:** backslash `\` (e.g., `C:\Users\YourName\Desktop`)
- **macOS:** forward slash `/` (e.g., `/Users/yourname/Desktop`)

## Creating folders

**Windows:**

```bash
mkdir assignment01
```

**macOS:**

```bash
mkdir assignment01
```

This creates a new folder called `assignment01` inside your current folder.

## Common mistakes

### Spaces in folder names

If a folder name contains spaces, wrap the path in double quotes:

```bash
cd "My Documents"
```

Without quotes, the command line thinks `My` and `Documents` are two separate things.

### Wrong direction

If you see an error like "The system cannot find the path specified" or "No such file or directory", you are trying to go to a folder that does not exist from your current location.
Use `dir` (Windows) or `ls` (macOS) to see what folders are available, then `cd` into the correct one.

## Compiling and running Java

This is the main reason you need the command line in this course.

### Step 1: Navigate to the exercise folder

First, move to the folder that contains your `Main.java` file:

**Windows:**

```bash
cd C:\Users\YourName\Desktop\assignment01\02
```

**macOS:**

```bash
cd /Users/yourname/Desktop/assignment01/02
```

### Step 2: Verify your file is there

**Windows:**

```bash
dir
```

**macOS:**

```bash
ls
```

You should see `Main.java` in the output.

### Step 3: Run the program

For most exercises in this course (single-file programs):

```bash
java Main.java
```

This compiles and runs your program in one step.

### Step 4: Run the test

Each exercise has a `Test.java` file. Run it the same way:

```bash
java Test.java
```

### Multi-file programs

In later assignments (e.g., assignment 07), you have multiple `.java` files.
For those, compile all files first, then run:

```bash
javac *.java
java Main
```

Or to run the test:

```bash
javac *.java
java Test
```

Note: when using `javac`, you run with `java Main` (no `.java` extension).

## Checking your Java installation

To verify that Java is installed and available:

```bash
java --version
javac --version
```

Both should show version 25. If you get "command not found" or a different version, see the [FAQ](FAQ.md).

## Quick reference

| Action | Windows | macOS |
|--------|---------|-------|
| Open terminal | `Win + R`, type `cmd` | `Cmd + Space`, type `Terminal` |
| See current folder | `cd` | `pwd` |
| List files | `dir` | `ls` |
| Change folder | `cd foldername` | `cd foldername` |
| Go up one level | `cd ..` | `cd ..` |
| Create folder | `mkdir foldername` | `mkdir foldername` |
| Run Java program | `java Main.java` | `java Main.java` |
| Compile multiple files | `javac *.java` | `javac *.java` |
| Check Java version | `java --version` | `java --version` |

---

## License

> Copyright (c) 2026. All rights reserved.
>
> Permission is granted to use, copy, and share this material for non-commercial educational purposes, provided that:
>
> 1. Attribution is given to the original author.
> 2. Modified versions are shared under the same terms.
> 3. The material is **not** used, in whole or in part, to **train, fine-tune, or otherwise feed into any generative AI or machine learning system**.
>
> Commercial use requires written permission from the author.
