[< Back to course home](../README.md)

# Assignment 03

## Points Overview

| Exercise | Description | Points |
|----------|-------------|--------|
| 01 | Name Check | 3 |
| 02 | Character Printing | 2 |
| 03 | Reverse Order | 2 |
| 04 | Palindrome | 3 |
| 05 | Loop | 3 |
| 06 | Calculator | 4 |
| 07 | Random Integers | 3 |
| 08 | Password Check | 6 |
| **Total** | | **26** |

## Required Video Notes

Submit the following handwritten video notes with this assignment:

- `notes/video01.pdf`
- `notes/video02.pdf`
- `notes/video03.pdf`

## Directory Structure

Create each exercise in its own folder:

```text
assignment03/01/Main.java
assignment03/02/Main.java
...
assignment03/nn/Main.java
```

Use the concepts we've covered in class: **don't use advanced features**, even if you already know them.

See the [course README](../README.md) for tool setup, AI policy, and installation instructions.

## Testing

See the shared testing instructions in the
[course README](../README.md#testing-assignments).

---

## 1. Name Check

Implement an application that asks the user for their name.

If the name is `"Matti"` print `"Hello Matti!"`. If the name is anything else, print nothing.

### Example

```text
Enter your name: Matti
Hello Matti!
```

```text
Enter your name: Ville
```

### Test

- [Test.java](01/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Prints "Hello Matti!" for input "Matti" | 1 |
| 2 | Prints nothing for input "Ville" | 1 |
| 3 | Prints nothing for input "matti" (case sensitive) | 1 |
| | **Total** | **3** |

---

## 2. Character Printing

| Video | Length | Notes |
|-------|--------|-------|
| [Java substrings are easy!](https://www.youtube.com/watch?v=44iQGNUcik0&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=14) | 8:05 | `notes/video01.pdf` |

Implement an application that asks the user for their name and prints each character on its own line.

### Example

```text
Enter your name: Otto
O
t
t
o
```

### Test

- [Test.java](02/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | "Otto" single-char lines are exactly [O, t, t, o] in order | 1 |
| 2 | "AB" single-char lines are exactly [A, B] in order | 1 |
| | **Total** | **2** |

---

## 3. Reverse Order

Previous task, but print the characters in reverse order.

### Example

```text
Enter your name: Otto
o
t
t
O
```

### Test

- [Test.java](03/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | "Otto" single-char lines are exactly [o, t, t, O] in order | 1 |
| 2 | "ABC" single-char lines are exactly [C, B, A] in order | 1 |
| | **Total** | **2** |

---

## 4. Palindrome

Implement an application that asks the user for a string. The application reports whether the string is a palindrome or not. Use the String class and a for loop in your solution.

### Example

```text
Enter a string: abba
Palindrome
```

```text
Enter a string: hello
Not a palindrome
```

### Test

- [Test.java](04/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | "saippuakauppias" contains "palindrome" but not "not a palindrome" | 1 |
| 2 | "hello" contains "not a palindrome" | 1 |
| 3 | "abba" contains "palindrome" but not "not a palindrome" | 1 |
| | **Total** | **3** |

---

## 5. Loop

Implement an application that asks the user for two integers. The program prints all the numbers between the two values, from smallest to largest.

### Example

```text
Enter number 1: 5
Enter number 2: 10
5
6
7
8
9
10
```

```text
Enter number 1: 2
Enter number 2: -3
-3
-2
-1
0
1
2
```

### Test

- [Test.java](05/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Inputs 5 and 10 produce exactly [5, 6, 7, 8, 9, 10] | 1 |
| 2 | Inputs 2 and -3 produce exactly [-3, -2, -1, 0, 1, 2] | 1 |
| 3 | Inputs 3 and 3 produce exactly [3] | 1 |
| | **Total** | **3** |

---

## 6. Calculator

| Video | Length | Notes |
|-------|--------|-------|
| [Let's code a simple calculator with Java!](https://www.youtube.com/watch?v=1An1DH79e5Y&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=19) | 12:16 | `notes/video02.pdf` |

Implement a calculator application. The program asks for two integers and an operator. It prints the result of the calculation.

### Example

```text
Enter number 1:
5
Enter operator:
/
Enter number 2:
2
5 / 2 = 2.5
```

```text
Enter number 1:
10
Enter operator:
+
Enter number 2:
2
10 + 2 = 12
```

### Test

- [Test.java](06/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Inputs 5 / 2 produce output 2.5 | 1 |
| 2 | Inputs 10 + 2 produce output 12 | 1 |
| 3 | Inputs 7 * 3 produce output 21 | 1 |
| 4 | Inputs 10 - 3 produce output 7 | 1 |
| | **Total** | **4** |

---

## 7. Random Integers

| Video | Length | Notes |
|-------|--------|-------|
| [Generate random numbers using Java!](https://www.youtube.com/watch?v=-tt98ICTHtQ&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=8) | 5:00 | `notes/video03.pdf` |

You can generate a random double between `[0, 1[` like this:

```java
double random = Math.random();
```

You can convert a floating point number (double) into an integer (int) via type casting:

```java
double a = 5.89;
int b = (int) a;
IO.println(b); // 5
```

In type casting, the decimal part is discarded, i.e., rounding happens downwards.
Now implement an application that prints five random integers between 0 and 4.
Use `Math.random()` and type casting.

### Example

```text
0
4
4
2
1
```

### Test

- [Test.java](07/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Prints exactly 5 lines | 1 |
| 2 | All values are integers between 0 and 4 | 1 |
| 3 | Two runs produce different output (not hardcoded) | 1 |
| | **Total** | **3** |

---

## 8. Password Check

Implement an application that asks the user for a password.

Check that the password is at least 8 characters long, contains at least one digit, one uppercase letter, and one lowercase letter.
If valid, print "Password accepted", otherwise print the reason why it's not accepted.

Tips:

- You can check uppercase and lowercase using:
  - `Character.isLowerCase('k')`
  - `Character.isUpperCase('K')`
- To check for digits:
  - `Character.isDigit('1')`
- Methods with names like `isXXXX()` usually return a boolean value (`true` or `false`)

### Example

```text
Enter password: Abcdefg1
Password accepted
```

```text
Enter password: short
Password must be at least 8 characters long
```

### Test

- [Test.java](08/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | "Abcdefg1" is accepted | 1 |
| 2 | "short" is rejected (too short) | 1 |
| 3 | "abcdefgh" is rejected (no uppercase or digit) | 1 |
| 4 | "ABCDEFG1" is rejected (no lowercase) | 1 |
| 5 | "Abcdefgh" is rejected (no digit) | 1 |
| 6 | "12345678A" is rejected (no lowercase) | 1 |
| | **Total** | **6** |

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
