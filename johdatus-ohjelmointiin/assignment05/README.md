# Assignment 05

## Points Overview

| Exercise | Description | Points |
|----------|-------------|--------|
| 01 | Print Your Name | 2 |
| 02 | Print Greeting and Name | 2 |
| 03 | Print Given Name | 2 |
| 04 | Return Date | 2 |
| 05 | Calculator Method | 3 |
| 06 | Print Character Many Times | 2 |
| 07 | Return Character Many Times | 2 |
| **Total** | | **15** |

## Directory Structure

Create each exercise in its own folder:

```text
assignment05/01/Main.java
assignment05/02/Main.java
...
assignment05/07/Main.java
```

Use the concepts we've covered in class: **don't use advanced
features**, even if you already know them.

See the [course README](../README.md) for tool setup, AI policy, and
installation instructions.

## Testing

Each exercise has a `Test.java` file that automatically checks your
solution.
The test file runs your `Main.java` as a separate process and verifies
its output.

### Step-by-step

1. Write your solution in `Main.java` and place it in the correct
   exercise folder (e.g., `assignment05/01/Main.java`).
2. Download the `Test.java` file from the repository and place it in the
   **same folder** as your `Main.java`.
3. Open a terminal and navigate to the exercise folder:

**Windows (Command Prompt):**

```text
cd C:\Users\YourName\path\to\assignment05\01
```

**macOS / Linux (Terminal):**

```bash
cd /Users/YourName/path/to/assignment05/01
```

4. Verify that both files are in the folder:

**Windows:**

```text
dir
```

**macOS / Linux:**

```bash
ls
```

You should see both `Main.java` and `Test.java` listed.

5. Run the test:

```bash
java Test.java
```

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

### 1. Print Your Name

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

### 2. Print Greeting and Name

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

### 3. Print Given Name

Use the following as a base:

```java
void main() {

}

void printGivenName(String name) {

}
```

Ask the user for a name in `main`. Pass the entered name to
`printGivenName`, which then prints it.

#### Example

When the user enters `Jeppe`:

```text
Enter name:
Jeppe
```

---

### 4. Return Date

Use the following as a base:

```java
void main() {

}

String returnDate() {

}
```

Modify the `returnDate` method so that it returns the string
`"21.3.2026"`. Print the returned text in `main`.

#### Example output

```text
21.3.2026
```

---

### 5. Calculator Method

Implement a calculator program that adds two numbers together.

Ask the user for two numbers in `main`. The program includes a
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

When the user enters `4` and `6`:

```text
Enter first number:
Enter second number:
10
```

---

### 6. Print Character Many Times

Implement a method that receives a character (`char`) and an amount
(`int`) as parameters. The method prints the character the specified
number of times.

Use the following as a base:

```java
void main() {

}

void printManyTimes(char c, int amount) {

}
```

If you call the method with `'X'` and `3`, it should print `XXX`.

Call the method from `main` with at least these two calls:
`printManyTimes('X', 3)` and `printManyTimes('O', 5)`.

Use a `for` loop in your solution.
Print the characters on one line, followed by a newline at the end.

#### Example output

```text
XXX
OOOOO
```

---

### 7. Return Character Many Times

Implement the same idea as in exercise 6, but this time the method
returns a `String` that contains the character repeated the specified
number of times.

Use the following as a base:

```java
void main() {

}

String returnManyTimes(char c, int amount) {

}
```

Call the method from `main` with at least these two calls:
`returnManyTimes('X', 3)` and `returnManyTimes('O', 5)`.
Print the returned values.

Use a `for` loop in your solution.

For example, if the arguments are `'X'` and `3`, the method returns
`"XXX"`.

#### Example output

```text
XXX
OOOOO
```
