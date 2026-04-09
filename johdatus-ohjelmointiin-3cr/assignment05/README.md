[< Back to course home](../README.md)

# Assignment 05

## Points Overview

| Exercise | Description | Points |
|----------|-------------|--------|
| 01 | Print Your Name | 5 |
| 02 | Print Greeting and Name | 5 |
| 03 | Print Given Name | 5 |
| 04 | Return Date | 4 |
| 05 | Calculator Method | 7 |
| 06 | Print Character Many Times | 6 |
| 07 | Return Character Many Times | 6 |
| 08 | Method Overloading | 3 |
| 09 | Even or Odd | 3 |
| 10 | Min, Max, and Range | 4 |
| **Total** | | **48** |

## Required Video Notes

Submit the following handwritten video notes with this assignment:

- `notes/video01.pdf`
- `notes/video02.pdf`
- `notes/video03.pdf`

## Directory Structure

Create each exercise in its own folder:

```text
assignment05/01/Main.java
assignment05/02/Main.java
...
assignment05/10/Main.java
```

Use the concepts we've covered in class: **don't use advanced
features**, even if you already know them.

See the [course README](../README.md) for tool setup, AI policy, and
installation instructions.

## Testing

See the shared testing instructions in the
[course README](../README.md#testing-assignments).

---

## Methods

| Video | Length | Notes |
|-------|--------|-------|
| [METHODS in Java are easy!](https://www.youtube.com/watch?v=JKecvKiNX2I&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=26) | 15:24 | `notes/video01.pdf` |
| [Learn Java overloaded methods in 6 minutes!](https://www.youtube.com/watch?v=nhnAx79gxCM&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=27) | 6:08 | `notes/video02.pdf` |
| [Learn VARIABLE SCOPE in 4 minutes!](https://www.youtube.com/watch?v=eVCK1jlopmY&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=28) | 4:58 | `notes/video03.pdf` |

See also:

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

#### Test

- [Test.java](01/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Source contains `printName()` method | 1 |
| 2 | `main` calls `printName()` | 1 |
| 3 | Program produces non-empty output | 1 |
| 4 | Output has exactly one non-empty line | 1 |
| 5 | Output contains at least 2 characters | 1 |
| | **Total** | **5** |

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

#### Test

- [Test.java](02/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Source contains `printGreeting()` method | 1 |
| 2 | Source contains `printName()` method | 1 |
| 3 | Output contains "Hello" | 1 |
| 4 | Output contains "Hello" followed by a name | 1 |
| 5 | Greeting and name appear on a single line | 1 |
| | **Total** | **5** |

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
Jeppe
```

#### Test

- [Test.java](03/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Source contains `printGivenName(String)` method | 1 |
| 2 | Input "Jeppe" appears in output | 1 |
| 3 | Input "Anna" appears in output | 1 |
| 4 | Output contains a prompt for the name | 1 |
| 5 | Different names produce different output | 1 |
| | **Total** | **5** |

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

#### Test

- [Test.java](04/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Source contains `returnDate()` method | 1 |
| 2 | Output contains "21.3.2026" | 1 |
| 3 | Output has exactly one non-empty line | 1 |
| 4 | Output line matches "21.3.2026" exactly | 1 |
| | **Total** | **4** |

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

#### Test

- [Test.java](05/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Source contains `calculate(int, int)` method | 1 |
| 2 | Output prompts for first number | 1 |
| 3 | Output prompts for second number | 1 |
| 4 | Inputs 4 and 6 produce "10" | 1 |
| 5 | Inputs 100 and 200 produce "300" | 1 |
| 6 | Inputs -5 and 3 produce "-2" | 1 |
| 7 | Inputs 7 and 7 produce "14" | 1 |
| | **Total** | **7** |

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

#### Test

- [Test.java](06/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Source contains `printManyTimes(char, int)` method | 1 |
| 2 | Source contains a for loop | 1 |
| 3 | Output contains "XXX" | 1 |
| 4 | Output contains "OOOOO" | 1 |
| 5 | "XXX" appears on its own line | 1 |
| 6 | "OOOOO" appears on its own line | 1 |
| | **Total** | **6** |

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

#### Test

- [Test.java](07/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Source contains `returnManyTimes(char, int)` method | 1 |
| 2 | Source contains a for loop | 1 |
| 3 | Output contains "XXX" | 1 |
| 4 | Output contains "OOOOO" | 1 |
| 5 | "XXX" appears on its own line | 1 |
| 6 | "OOOOO" appears on its own line | 1 |
| | **Total** | **6** |

---

### 8. Method Overloading

Create three overloaded `greet` methods:

- `void greet()` prints `"Hello!"`
- `void greet(String name)` prints `"Hello, <name>!"`
- `void greet(String name, int times)` prints `"Hello, <name>!"` the given number of times

Use the following as a base:

```java
void main() {

}

void greet() {

}

void greet(String name) {

}

void greet(String name, int times) {

}
```

Call all three from `main`:

- `greet()`
- `greet("Matti")`
- `greet("Anna", 3)`

#### Example output

```text
Hello!
Hello, Matti!
Hello, Anna!
Hello, Anna!
Hello, Anna!
```

#### Test

- [Test.java](08/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Output contains "Hello!" on its own line | 1 |
| 2 | Output contains "Hello, Matti!" | 1 |
| 3 | "Hello, Anna!" appears at least 3 times | 1 |
| | **Total** | **3** |

---

### 9. Even or Odd

Implement a method `boolean isEven(int n)` that returns `true` if the number is even, `false` otherwise.

Ask the user for a number in `main`. Use the method to check whether the number is even or odd. Print `"even"` or `"odd"`.

**Tip:** The **modulo operator** (`%`) returns the remainder of a division. For example, `7 % 2` is `1` and `4 % 2` is `0`. A number is even when dividing it by 2 leaves no remainder:

```java
if (n % 2 == 0) {
    // n is even
}
```

Use the following as a base:

```java
void main() {

}

boolean isEven(int n) {

}
```

#### Example

```text
Enter a number:
4
even
```

```text
Enter a number:
7
odd
```

#### Test

- [Test.java](09/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Source contains isEven(int) method | 1 |
| 2 | Input 4 outputs "even" | 1 |
| 3 | Input 7 outputs "odd" | 1 |
| | **Total** | **3** |

---

### 10. Min, Max, and Range

Implement three methods:

- `int min(int a, int b)` returns the smaller of the two numbers
- `int max(int a, int b)` returns the larger of the two numbers
- `int range(int a, int b)` returns `max(a, b) - min(a, b)` by calling the other two methods

Ask the user for two numbers. Print the minimum, maximum, and range.

Use the following as a base:

```java
void main() {

}

int min(int a, int b) {

}

int max(int a, int b) {

}

int range(int a, int b) {

}
```

#### Example

```text
Enter first number:
3
Enter second number:
7
min: 3
max: 7
range: 4
```

```text
Enter first number:
10
Enter second number:
2
min: 2
max: 10
range: 8
```

#### Test

- [Test.java](10/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Inputs 3, 7 produce "min: 3" | 1 |
| 2 | Inputs 3, 7 produce "max: 7" | 1 |
| 3 | Inputs 3, 7 produce "range: 4" | 1 |
| 4 | Inputs 10, 2 produce min: 2, max: 10, range: 8 | 1 |
| | **Total** | **4** |

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
