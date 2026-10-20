[< Back to course home](README.md)

# Check Your Grade with Grade.java

`Grade.java` checks your assignment zips on your own computer before you submit them.
It runs the same tests that are used for grading, counts your video notes and shows an estimated grade.

## What You Need

* Java 25 or newer, check it with `java -version`
* An internet connection
* Your assignment zip files

## Step 1: Download Grade.java

Download [Grade.java](Grade.java) and save it in a folder of your choice, for example `java-course`.
If your browser opens the file as text, right click the link and choose "Save link as".

You can also download it in the terminal.

**macOS / Linux (Terminal):**

```bash
curl -O https://pohjus.github.io/johdatus-ohjelmointiin-3cr/Grade.java
```

**Windows (Command Prompt or PowerShell):**

```bash
curl.exe -O https://pohjus.github.io/johdatus-ohjelmointiin-3cr/Grade.java
```

You only need to download it once.
Every time you run it, it fetches the latest checker from the course site, so you always get the newest fixes.

## Step 2: Collect Your Zips

Create a folder named `my-zips` next to `Grade.java`.
Copy your assignment zips into it, named exactly as you submit them:

```text
java-course/
  Grade.java
  my-zips/
    12345-assignment01.zip
    12345-assignment02.zip
    ...
    12345-assignment08.zip
```

* Replace `12345` with your own student number in every file name.
* Add zips as you finish assignments; missing ones count as 0 points.
* Each zip must contain one root folder named after the assignment, as described in [Assignment Submission](README.md#assignment-submission).

## Step 3: Run It

Open a terminal in the `java-course` folder and run:

```bash
java Grade.java my-zips
```

Checking all eight assignments can take a few minutes.
For a short reminder of the instructions, run:

```bash
java Grade.java --help
```

## Reading the Output

Each assignment gets its own section:

```text
=== assignment01 ===
  Zip: 12345-assignment01.zip
  01: 1/1
  02: 1/1
  03: 1/2
        FAIL: output contains 'Hello Jack'
  ...
  Note missing or not a PDF: notes/video06.pdf
  Notes: 5/6
```

* `03: 1/2` means exercise 03 got 1 of its 2 points.
* `FAIL` lines below an exercise tell you which checks failed.
* `Notes: 5/6` means 5 of the 6 required video note PDFs were found.

At the end you see a summary of all assignments:

```text
  Total points: 250/282 (88.7%), minimum 50%
  Total notes:  35/35 (100.0%), minimum 70%
  Estimated grade: 4
```

To pass the course you need at least 50% of the points and at least 70% of the video notes.
See [Grading](README.md#grading) for how the percentage maps to a grade.

## Warnings and Errors

| Message | What to do |
| ------- | ---------- |
| `Student number in zip names: 12345` | Make sure this is your own student number. |
| `WARNING: your zip names use different student numbers` | Use your own student number in every zip name. |
| `WARNING: unexpected zip name` | Rename the zip to `studentnumber-assignment0X.zip`; until then it gets 0 points. |
| `ERROR: wrong zip name, 0 points` | Rename the zip to `studentnumber-assignment0X.zip` and run `Grade.java` again. |
| `No zip found` | That assignment has no zip in the folder yet; it counts as 0 points. |
| `WARNING: remove 01/Test.java from your zip` | Remove all `Test.java` and `.class` files and create the zip again. |
| `ERROR: root folder assignment01/ not found in zip` | Zip the `assignment01` folder itself, not the files inside it. |
| `01: 0/1 missing` | The exercise folder is missing from your zip. |
| `a file name has special characters` | Rename files that contain letters such as ä or ö and create the zip again. |
| `FAIL: test timed out` | Your program waits for input forever or never stops; check your loops. |
| `could not download the checker` | Check your internet connection and try again. |

## Good to Know

* Your files are not sent anywhere; everything runs on your own computer.
* The grade is an unofficial estimate; the official results are on the [results page](results.md).
* Late submissions get an automatic grade 1, which the estimate does not include.
* `Grade.java` only checks that your video notes exist and are PDFs; the teacher still checks that they are handwritten.
* Having problems with Java itself? See the [FAQ](FAQ.md).
