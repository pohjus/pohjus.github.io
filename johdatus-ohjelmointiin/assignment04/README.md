# Assignment 04

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

This assignment does not currently include `Test.java` files in the
repository.

Test your programs manually by compiling and running them from the
correct exercise folder.

---

## Arrays

See:

- [Java Arrays (W3Schools)](https://www.w3schools.com/java/java_arrays.asp)
- [Java Arrays Tutorial (YouTube)](https://www.youtube.com/watch?v=B10TjOAyBnw)

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

Implement an application that prints all values in the array from
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

Implement an application that contains a `String` array with `n` names.
You can decide the value of `n` yourself, and you do not need to ask it
from the user.

Add some names to the array. Print every other name using a `for` loop.
Start from index `0`, so print names at indexes `0`, `2`, `4`, and so
on.

#### Example

If the array contains:

```text
Matti
Liisa
Pekka
Anna
```

the output is:

```text
Matti
Pekka
```

---

### 4. Ten Integers and Sum

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

Modify exercise 3 so that the value `n` is asked from the user. Also ask
the names from the user and store them in an array. The program prints
the longest name, meaning the one with the most characters.

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

### 6. Random Integer and Rock-Paper-Scissors

The following stores a random floating-point number in the range
`[0,1[` into a variable:

```java
double random = Math.random();
```

Part 1: implement an application that prints a random integer between
`0` and `9`. Use type casting.

Part 2: implement an application that randomly prints `"rock"`,
`"paper"`, or `"scissors"`.

You are not allowed to use `if` or `switch` statements.

Hint: an array is a good fit for part 2.

#### Example output

Part 1:

```text
7
```

Part 2:

```text
paper
```

---

### 7. Command-Line Calculator

Study the following program:

```java
void main(String[] args) {
    IO.println(args[0]);
    IO.println(args[1]);
}
```

Run from the exercise folder.

With Java 25 simple programs, you can run:

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

Now implement an application that accepts basic arithmetic operations,
for example:

```bash
java Calculator.java 1 + 2
```

```text
result = 3
```

Use command-line arguments.
The arguments are written after the file name in the command.

Support operations: `-`, `+`, `/`, and `x` for multiplication.

If the user gives the wrong number of arguments, print a short error
message.

You can convert a string to an integer like this:

```java
int number = Integer.parseInt("1");
```

If you use `*` as user input, it may fail because of shell behavior.
You can use:

**macOS:**

```bash
java Calculator.java 3 \* 3
java Calculator.java 3 '*' 3
java Calculator.java 3 "*" 3
```

**CMD:**

```cmd
java Calculator.java 3 "*" 3
```

**PowerShell (not tested):**

```powershell
java Calculator.java 3 --% * 3
```

---

### 8. Linear Search

Implement a Java application that contains an array of 10 random
integers between `1` and `100`. Use `Math.random()` to generate the
numbers.

The application checks if the array contains a number provided by the
user. Accept the number as a command-line argument.

#### Example

```bash
java App.java 50
```

```text
Found!
```

If the number is not found, print:

```text
Not found!
```

Use
[linear search](https://www.w3schools.com/dsa/dsa_algo_linearsearch.php).

---

### 9. Count Occurrences

Implement an application that counts how many times a value appears in
an array.

#### Example

```bash
java CountOccurrences.java 2 1 2 3 2 2
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

### 10. Reverse Array

Implement an application that reverses an array and then outputs it.

```bash
java ReverseArray.java 1 2 3
```

```text
3, 2, 1
```

If the user gives too few arguments, print a short error message. You
can assume the user gives integers, so you do not need to handle
parsing exceptions.

---

### 11. Sum Until Negative

Implement an application that adds numbers until a negative value is
found in the command-line arguments.

```bash
java SumUntilNegative.java 3 4 5 -1 10
```

```text
12
```

If there is no negative number, sum all given values.

#### Another example

```bash
java SumUntilNegative.java 3 4 5
```

```text
12
```

---

### 12. Multi-File ASCII Bars

Create a Java program that:

- Receives one or more filenames via command-line arguments.
- Each file contains integers, one number per line.
- For each number, prints a line of ASCII characters (`*`) whose length
  matches the number.
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
java MultiAsciiBars.java numbers1.txt numbers2.txt
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

To read a text file into an array:

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

Use arrays in your solution (`allLines` and `args`).
Convert the file contents to a `String[]` before processing them.

---

### 13. Exception Handling for Previous Exercise

Continue from exercise 12.

#### Background

What is `try` / `catch`?

Sometimes code can fail while running, for example because:

- a file is missing
- the user gave wrong input
- a number is not valid

If the program fails, it throws an exception. `try` / `catch` lets you
handle that problem instead of crashing.

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

Now remove `throws IOException` from your app:

```java
import java.nio.file.*;
import java.io.IOException;
import java.util.List;

void main(String[] args) {
    List<String> list = Files.readAllLines(Path.of("textfile.txt"));
    String[] allLines = list.toArray(new String[0]);
}
```

#### Task

In this exercise, handle at least these cases:

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
java MultiAsciiBars.java missing.txt
```

```text
File not found: missing.txt
```

Example:

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

## Methods

See:

- [Java Methods Tutorial 1 (YouTube)](https://www.youtube.com/watch?v=cCgOESMQe44)
- [Java Methods Tutorial 2 (YouTube)](https://www.youtube.com/watch?v=L1htVG3xP5Y)
- [Java Methods (W3Schools)](https://www.w3schools.com/java/java_methods.asp)
- [Methods (MOOC.fi)](https://ohjelmointi-20.mooc.fi/osa-2/4-metodit)

Examples of different kinds of methods:

```java
void main() {
    doIt1();
    doIt2(2);
    IO.println(doIt3());
    IO.println(doIt4(5));
    IO.println(doIt5(2, 3));
}

void doIt1() {
    IO.println(1);
}

void doIt2(int x) {
    IO.println(x);
}

int doIt3() {
    return 3;
}

int doIt4(int x) {
    x--;
    return x;
}

int doIt5(int a, int b) {
    return a + b;
}
```

`IO.println` prints a line and moves to the next line.
`IO.print` prints without adding a newline.

---

## Method Exercises

### 14. Print Your Name

Use the following as a base:

```java
void main() {

}

void printName() {

}
```

Modify the `printName` method so that it prints your own name. Call the
method from `main`.

#### Example output

```text
Matti
```

---

### 15. Print Greeting and Name

Use the following as a base:

```java
void main() {

}

void printGreeting() {

}

void printName() {

}
```

Modify the code so that `printName` prints your name and
`printGreeting` prints the text `"Hello "`. Call both methods from
`main`. The output should be for example `"Hello Matti"`.

Use `IO.print` in `printGreeting` and `IO.println` in `printName` so the
text appears on one line.

#### Example output

```text
Hello Matti
```

---

### 16. Print Given Name

Use the following as a base:

```java
void main() {

}

void printGivenName(String x) {

}
```

Ask the user for a name in `main`. Pass the entered name to
`printGivenName`, which then prints it.

#### Example

```text
Enter name:
Jeppe
Jeppe
```

---

### 17. Return Date

Use the following as a base:

```java
void main() {

}

String returnDate() {

}
```

Modify the `returnDate` method so that it returns the string
`"14.9.2025"`. Print the returned text in `main`.

#### Example output

```text
14.9.2025
```

---

### 18. Calculator Method

Implement a calculator program that adds two numbers together.

You can ask the numbers from the user in `main`. The program includes a
method `calculate` that performs the addition. The method receives two
integers as parameters and returns their sum. Print the result in
`main`.

Use the following as a base:

```java
void main() {

}

int calculate(int a, int b) {

}
```

#### Example

```text
Enter first number: 4
Enter second number: 6
10
```

---

### 19. Print Character Many Times

Implement a method that receives a character (`char`) and an amount
(`int`) as parameters. The method prints the character the specified
number of times.

If you call the method with `'X'` and `3`, it should print `XXX`.

Test it. Use a `for` loop in your solution.
Print the characters on one line, followed by a newline at the end.

#### Example output

```text
XXX
```

---

### 20. Return Character Many Times

Implement the same idea as in exercise 19, but this time the method
returns a `String` that contains the character repeated the specified
number of times.

Test it. Use a `for` loop in your solution.

For example, if the arguments are `'X'` and `3`, the method returns
`"XXX"`.

#### Example output

```text
XXX
```
