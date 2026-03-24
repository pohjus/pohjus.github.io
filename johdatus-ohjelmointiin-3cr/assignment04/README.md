[< Back to course home](../README.md)

# Assignment 04

## Points Overview

| Exercise | Description | Points |
|----------|-------------|--------|
| 01 | Array Basics | 2 |
| 02 | Reverse Array Output | 2 |
| 03 | Every Other Name | 2 |
| 04 | Ten Integers and Sum | 4 |
| 05 | Longest Name | 4 |
| 06 | Command-Line Calculator | 7 |
| 07 | Count Occurrences | 5 |
| 08 | Multi-File ASCII Bars | 6 |
| 09 | Exception Handling | 5 |
| **Total** | | **37** |

## Required Video Notes

Submit the following handwritten video notes with this assignment:

- `notes/video01.pdf`
- `notes/video02.pdf`
- `notes/video03.pdf`
- `notes/video04.pdf`
- `notes/video05.pdf`

## Directory Structure

Create each exercise in its own folder:

```text
assignment04/01/Main.java
assignment04/02/Main.java
...
assignment04/nn/Main.java
```

Use the concepts we've covered in class: **don't use advanced
features**, even if you already know them.

See the [course README](../README.md) for tool setup, AI policy, and
installation instructions.

## Testing

See the shared testing instructions in the
[course README](../README.md#testing-assignments).

---

## Arrays

See:

- 📺 [Learn Java arrays in 9 minutes! (video)](https://www.youtube.com/watch?v=9dr2mHYYoug&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=31) (length: 9:09) - submit 📝 `notes/video01.pdf`
- [Java Arrays (W3Schools)](https://www.w3schools.com/java/java_arrays.asp)

Example of an array:

```java
void main() {
    // Create an array of size 3. It contains 3 zeros by default.
    // The size of an array cannot be changed afterwards.
    int[] array = new int[3];

    // Replace the zeros with values.
    array[0] = 101;
    array[1] = 200;
    array[2] = 999;

    // Print the values.
    IO.println(array[0]);
    IO.println(array[1]);
    IO.println(array[2]);

    // Create and initialize an array in one line.
    int[] another = {3, 4, 5, 6};

    // Array length.
    IO.println(another.length);  // 4
}
```

---

## Array Exercises

### 1. Array Basics

Implement a program where you store the numbers `12`, `99`, and `32` in
an array.

- Print the first number (`12`) and the last number (`32`).
- Print the length of the array.
- Print all values in the array using a `for` loop.

#### Example output

```text
12
32
3
12
99
32
```

---

### 2. Reverse Array Output

Implement a program that prints all values in the array from
exercise 1 in reverse order using a `for` loop.

Print one value per line.

#### Example output

```text
32
99
12
```

---

### 3. Every Other Name

Implement a program that contains a `String` array with the
following names: `"Matti"`, `"Liisa"`, `"Pekka"`, `"Anna"`.

Print every other name using a `for` loop. Start from index `0`, so
print names at indexes `0`, `2`, `4`, and so on.

#### Example output

```text
Matti
Pekka
```

---

### 4. Ten Integers and Sum

- 📺 [Enter USER INPUT into an ARRAY! (video)](https://www.youtube.com/watch?v=ah5bAnGpmKY&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=32) (length: 8:03) - submit 📝 `notes/video02.pdf`

Implement a program that asks the user for ten integers and stores them
in an array using a `for` loop. Finally, print the sum of the values in
the array. Use a second `for` loop to calculate the sum.

Ask for exactly 10 integers.

#### Example

```text
Enter ten numbers:
1
1
1
1
1
1
1
1
1
1
Sum of entered numbers: 10
```

---

### 5. Longest Name

Implement a program that asks the user how many names to enter, then
asks for each name and stores them in an array. The program prints the
longest name, meaning the one with the most characters.

If there are multiple longest names with the same length, print the
first one that was entered.

#### Example

```text
How many names: 4
Enter name: Ada
Enter name: Marianne
Enter name: Li
Enter name: Pekka
Marianne
```

---

## Command-Line Arguments

When you run a Java program, you can pass extra values after the
filename. These are called **command-line arguments** and are stored in a
`String` array called `args`.

```java
void main(String[] args) {
    IO.println(args[0]);
    IO.println(args[1]);
}
```

Run from the exercise folder:

```bash
java Main.java taikaviitta roopeankka
```

Here, `taikaviitta` and `roopeankka` are command-line arguments. These
values are automatically stored in the `args` array:

```java
String[] args = new String[2];
args[0] = "taikaviitta";
args[1] = "roopeankka";
```

You can convert a string to an integer like this:

```java
int number = Integer.parseInt("1");
```

---

## Command-Line Argument Exercises

### 6. Command-Line Calculator

Implement a program that accepts basic arithmetic operations via
command-line arguments, for example:

```bash
java Main.java 1 + 2
```

```text
result = 3
```

Support operations: `-`, `+`, `/`, and `x` for multiplication.

If the user gives the wrong number of arguments, print a short error
message.

If you use `*` as user input, it may fail because of shell behavior.
You can use:

**macOS:**

```bash
java Main.java 3 \* 3
java Main.java 3 '*' 3
java Main.java 3 "*" 3
```

**CMD:**

```cmd
java Main.java 3 "*" 3
```

**PowerShell (not tested):**

```powershell
java Main.java 3 --% * 3
```

---

### 7. Count Occurrences

- 📺 [How to SEARCH an ARRAY easy! (video)](https://www.youtube.com/watch?v=EB9-OOnCthg&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=33) (length: 7:29) - submit 📝 `notes/video03.pdf`

Implement a program that counts how many times a value appears in
an array.

#### Example

```bash
java Main.java 2 1 2 3 2 2
```

The first argument (`2`) is the number to search for in the array
`[1, 2, 3, 2, 2]`. The output should be `3`, because the number `2`
appears three times.

If the user gives too few arguments, print a short error message. You
can assume the user gives integers, so you do not need to handle
parsing exceptions.

#### Example output

```text
3
```

---

## File I/O

- 📺 [How to READ FILES with Java in 8 minutes! (video)](https://www.youtube.com/watch?v=eHjbvgw4hsI&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=59) (length: 6:54) - submit 📝 `notes/video04.pdf`

You can read a text file into an array using `Files.readAllLines`:

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

void main(String[] args) throws IOException {
    List<String> list = Files.readAllLines(Path.of("textfile.txt"));
    String[] allLines = list.toArray(new String[0]);
}
```

`Files.readAllLines` returns a `List<String>`. You can convert it to a
`String[]` array using `toArray`. The `throws IOException` tells Java
that this program may fail if the file is missing or unreadable.

---

## File I/O Exercise

### 8. Multi-File ASCII Bars

Implement a program that:

- Receives one or more filenames via command-line arguments.
- Each file contains integers, one number per line.
- For each number, prints a line of `*` characters whose length matches
  the number.
- After printing one file, prints an empty line and continues with the
  next file.
- Treats negative numbers as `0`.
- Ignores empty lines.

The output for each file should start with:

```text
=== filename ===
```

#### Example input file `numbers1.txt`

```text
3
1
4
0
```

#### Example input file `numbers2.txt`

```text
5
2
-3
7
```

When starting the app:

```bash
java Main.java numbers1.txt numbers2.txt
```

The output is:

```text
=== numbers1.txt ===
*** (3)
* (1)
**** (4)
(0)

=== numbers2.txt ===
***** (5)
** (2)
(0)
******* (7)
```

Use arrays in your solution (`allLines` and `args`).
Convert the file contents to a `String[]` before processing them.

---

## Exception Handling

- 📺 [Learn EXCEPTION HANDLING in 8 minutes! (video)](https://www.youtube.com/watch?v=u1PROb-aRUI&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=57) (length: 8:02) - submit 📝 `notes/video05.pdf`

Sometimes code can fail while running, for example because:

- a file is missing
- the user gave wrong input
- a number is not valid

If the program fails, it throws an **exception**. `try` / `catch` lets
you handle that problem instead of crashing.

Basic idea:

```java
try {
    // Code that might fail
} catch (Exception e) {
    // What to do if it fails
}
```

Example 1, dividing numbers:

```java
try {
    int result = 10 / 0;  // Could throw ArithmeticException.
    IO.println(result);
} catch (ArithmeticException e) {
    IO.println("You can't divide by zero!");
}
```

Output:

```text
You can't divide by zero!
```

Example 2, number format:

```java
try {
    int n = Integer.parseInt("abc");
    IO.println(n);
} catch (NumberFormatException e) {
    IO.println("That text is not a number.");
}
```

You can also chain catches:

```java
try {
    // ...
} catch (NumberFormatException e) {
    IO.println("That text is not a number.");
} catch (ArithmeticException e) {
    IO.println("You can't divide by zero!");
}
```

| Concept | Explanation |
|---------|-------------|
| `try` | Code that might cause an error |
| `catch` | What to do if the error happens |
| Program continues | The application does not crash immediately |
| Message to user | You can give a clear hint about what went wrong |

---

## Exception Handling Exercise

### 9. Exception Handling for Previous Exercise

Continue from exercise 8.

In the previous exercise, many things can go wrong:

| Area | Exception |
|------|-----------|
| `args` array | `ArrayIndexOutOfBoundsException` |
| Parsing path | `InvalidPathException` |
| File missing | `NoSuchFileException` |
| No read permission | `AccessDeniedException` |
| General I/O | `IOException` |
| String to int | `NumberFormatException` |
| Huge file | `OutOfMemoryError` |

Remove `throws IOException` from your program:

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

void main(String[] args) {
    List<String> list = Files.readAllLines(Path.of("textfile.txt"));
    String[] allLines = list.toArray(new String[0]);
}
```

Handle at least these cases:

- missing filename in `args`
- file does not exist
- a line is not a valid integer

Then:

1. Identify which lines might throw an exception, and add a comment next
   to each such line explaining which exception could occur.
2. Add exception handling.
3. If an exception occurs, print a short message explaining the cause,
   and stop the program immediately.

#### Example

```bash
java Main.java missing.txt
```

```text
File not found: missing.txt
```

You can stop the program after catching an error with `return`:

```java
try {
    IO.println(1 / 0);
} catch (ArithmeticException e) {
    IO.println("You can't divide by zero!");
    return;
}
```

`IO.println` is enough for this course. In more advanced Java programs,
you will also see `System.out.println` for normal output and
`System.err.println` for error messages.

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
