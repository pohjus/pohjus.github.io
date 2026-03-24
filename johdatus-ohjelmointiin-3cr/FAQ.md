[< Back to course home](README.md)

# FAQ: Java Installation and Setup

If you run into problems installing or running Java, check this page first.
For installation instructions, see the [course README](README.md#installing-java).

---

## 1. `java: command not found`

### Error message

**Windows:**

```text
'java' is not recognized as an internal or external command
```

**macOS / Linux:**

```text
java: command not found
```

### Why it happens

The `java` executable is not in your system's PATH.
This usually means the installer's "Add to PATH" option was not enabled, or you installed from a `.tar.gz` archive without updating PATH manually.
It can also happen if the terminal was open during installation and has not been restarted.

### Fix: Windows

1. Close all Command Prompt windows.
2. Re-run the Temurin 25 `.msi` installer. On the "Custom Setup" screen, enable **"Add to PATH"**.
3. Open a new Command Prompt and run `java --version`.

If you prefer to set PATH manually:

1. Open **Settings > System > About > Advanced system settings > Environment Variables**.
2. Under **System variables**, find `Path` and click **Edit**.
3. Add a new entry: `C:\Program Files\Eclipse Adoptium\jdk-25+XX\bin` (replace `XX` with your build number).
4. Click OK, close all dialogs, and open a new Command Prompt.

### Fix: macOS

1. Close Terminal.
2. Re-run the Temurin 25 `.pkg` installer. It sets PATH automatically.
3. Open a new Terminal and run `java --version`.

### Fix: Linux

Add the Temurin `bin/` directory to your PATH. If you extracted Temurin to `/opt/jdk-25`:

```bash
echo 'export PATH="/opt/jdk-25/bin:$PATH"' >> ~/.bashrc
source ~/.bashrc
```

If you use zsh, replace `~/.bashrc` with `~/.zshrc`.

---

## 2. `javac: command not found` but `java` works

### Error message

**Windows:**

```text
'javac' is not recognized as an internal or external command
```

**macOS / Linux:**

```text
javac: command not found
```

### Why it happens

A JRE (Java Runtime Environment) is installed instead of a JDK (Java Development Kit).
The JRE includes `java` but not `javac`.
Some systems ship a built-in JRE. For example, macOS command-line tools provide `java` but not `javac`.

### Fix (all OS)

1. Run `java --version`. If the output does **not** mention "Temurin", you are using a different Java.
2. Go to [adoptium.net](https://adoptium.net/) and download the **JDK** (not JRE) for Temurin 25.
3. Install it, making sure PATH is set.
4. Open a new terminal and verify both commands work:

```bash
java --version
javac --version
```

---

## 3. `UnsupportedClassVersionError`: `java` and `javac` point to different versions

### Error message

You compile with `javac Main.java` and run with `java Main`, but get:

```text
Error: LinkageError occurred while loading main class Main
	java.lang.UnsupportedClassVersionError: Main has been compiled by a more
	recent version of the Java Runtime (class file version 69.0), this version
	of the Java Runtime only recognizes class file versions up to 61.0
```

Or the other way around, `javac` is older and does not recognize Java 25 syntax:

```text
Main.java:1: error: class, interface, enum, or record expected
void main() {
^
```

You can confirm the mismatch by checking both versions:

```bash
java --version
javac --version
```

If they show different version numbers (e.g., 25 vs 17), this is the problem.

### Why it happens

Multiple Java installations exist on the system.
The PATH order puts different versions first for `java` and `javac`.

### Fix: Windows

1. Open **Settings > System > About > Advanced system settings > Environment Variables**.
2. Under **System variables**, find `Path` and click **Edit**.
3. Look for entries pointing to old Java installations (e.g., `C:\Program Files\Java\jdk-17\bin`).
4. Remove old entries or move the Temurin 25 entry above them.
5. Open a new Command Prompt and verify both commands show version 25.

### Fix: macOS

1. List installed JDKs:

```bash
/usr/libexec/java_home -V
```

2. Remove old JDKs you no longer need:

```bash
sudo rm -rf /Library/Java/JavaVirtualMachines/temurin-17.jdk
```

3. Open a new Terminal and verify both `java --version` and `javac --version` show 25.

### Fix: Linux

1. Check which binaries are being used:

```bash
which java
which javac
```

2. On Debian/Ubuntu, use `update-alternatives`:

```bash
sudo update-alternatives --config java
sudo update-alternatives --config javac
```

Select the Temurin 25 entry for both.

---

## 4. Wrong Java version (e.g., Java 17 instead of 25)

### Error message

When using the Java 25 `void main()` syntax:

```text
Main.java:1: error: class, interface, enum, or record expected
void main() {
^
```

Or `java --version` shows a version other than 25.

### Why it happens

- The wrong version was downloaded from adoptium.net.
- A package manager installed the latest LTS (e.g., 21) instead of 25.
- An older Java was already installed and takes priority in PATH.

### Fix (all OS)

1. Run `java --version` to confirm the current version.
2. Go to [adoptium.net](https://adoptium.net/) and explicitly select **Temurin 25**.
3. Install it. On Windows, make sure "Add to PATH" is enabled.
4. If the old version still shows up, see section 3 above to fix PATH order.

---

## 5. `void main()` does not compile

### Error message

```text
Main.java:1: error: class, interface, enum, or record expected
void main() {
^
```

### Why it happens

You are running a Java version older than 25.
The simplified `void main()` syntax is only available in Java 25.

### Fix

1. Run `java --version`. If it does not show 25, install Temurin 25 (see section 4).
2. If the version is 25 but you used `javac Main.java` followed by `java Main`, try using the source launcher instead:

```bash
java Main.java
```

For single-file exercises, `java Main.java` is the recommended way to run your code.

---

## 6. `IO` class not found

### Error message

```text
error: cannot find symbol
  symbol:   variable IO
```

### Why it happens

The `IO` class was introduced in Java 25.
If you see this error, you are most likely using an older Java version.

### Fix

1. Run `java --version` and `javac --version`. Both should show 25.
2. If not, install Temurin 25 (see section 4).
3. If you have multiple Java versions installed, make sure Temurin 25 comes first in PATH (see section 3).

---

## 7. File saved as `Main.java.txt` (Windows)

### Error message

```text
error: file not found: Main.java
```

The file appears as `Main.java` in File Explorer but is actually `Main.java.txt`.

### Why it happens

Windows hides known file extensions by default.
When saving from Notepad or another editor, a `.txt` extension is silently appended.

### Fix

1. Open File Explorer.
2. Click **View > Show > File name extensions** (enable it).
3. If the file is named `Main.java.txt`, rename it to `Main.java`.

---

## 8. Running `java` from the wrong directory

### Error message

```text
error: file not found: Main.java
```

Or:

```text
Error: Could not find or load main class Main
```

### Why it happens

You did not navigate to the exercise folder before running the command.

### Fix

1. Use `cd` to navigate to the folder containing `Main.java`:

**Windows:**

```bash
cd C:\Users\YourName\path\to\assignment01\02
```

**macOS / Linux:**

```bash
cd /Users/YourName/path/to/assignment01/02
```

2. Verify the file is there:

**Windows:**

```bash
dir
```

**macOS / Linux:**

```bash
ls
```

3. Run the program:

```bash
java Main.java
```

---

## 9. `Error: Could not find or load main class`

### Error message

```text
Error: Could not find or load main class Main
```

### Why it happens

This can happen when:

- You compiled with `javac Main.java` but then ran `java Main.java` (with the `.java` extension). When `.class` files exist, this can cause confusion.
- The filename does not match the class name.
- You are in the wrong directory.

### Fix

- If using source launcher (recommended for single-file exercises): `java Main.java`
- If you compiled with `javac` first: `java Main` (without `.java`)
- Make sure you are in the correct directory (see section 8).
- If confused, delete all `.class` files and start fresh:

**Windows:**

```bash
del *.class
java Main.java
```

**macOS / Linux:**

```bash
rm *.class
java Main.java
```

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
