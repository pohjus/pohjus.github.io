# Assignment 02

## Points Overview

| Exercise | Description | Points |
|----------|-------------|--------|
| 01 | Christmas Eve Greeting | 4 |
| 02 | Dog's Exceptional Age | 4 |
| 03 | Working Hours | 5 |
| 04 | Division | 2 |
| 05 | For Loops | 4 |
| 06 | Input Validation | 2 |
| 07 | Weekday Switch-Case | 5 |
| 08 | Grade from Score | 7 |
| 09 | Rock-Paper-Scissors | 5 |
| **Total** | | **38** |

## Required Video Notes

Submit the following handwritten video notes with this assignment:

- `studentnumber-assignment02-video01.pdf`
- `studentnumber-assignment02-video02.pdf`
- `studentnumber-assignment02-video03.pdf`
- `studentnumber-assignment02-video04.pdf`
- `studentnumber-assignment02-video05.pdf`
- `studentnumber-assignment02-video06.pdf`
- `studentnumber-assignment02-video07.pdf`

## Directory Structure

Create each exercise in its own folder:

```text
assignment02/01/Main.java
assignment02/02/Main.java
...
assignment02/nn/Main.java
```

Use the concepts we've covered in class: **don't use advanced features**, even if you already know them.

See the [course README](../README.md) for tool setup, AI policy, and installation instructions.

## Testing

See the shared testing instructions in the
[course README](../README.md#testing-assignments).

---

## Theory: Boolean Algebra

**Boolean algebra** is a branch of algebra that deals with `true` or `false` values (binary: `1` and `0`). It is the foundation of logic in programming.

- **AND (`&&`)**: Result is true only if _both_ conditions are true.
- **OR (`||`)**: Result is true if _at least one_ condition is true.
- **NOT (`!`)**: Reverses the truth value.

**Truth Table:**

| A     | B     | A && B | A \|\| B | !A    |
|-------|-------|--------|----------|-------|
| true  | true  | true   | true     | false |
| true  | false | false  | true     | false |
| false | true  | false  | true     | true  |
| false | false | false  | false    | true  |

---

### Recap: User Input

In Java 25, you can use `IO.readln` to read user input and `IO.println` to print output. No class declaration or imports are needed.

```java
void main() {
    String name = IO.readln("Enter your name: ");
    IO.println("Hello, " + name + "!");
}
```

To read numbers, convert the `String` to an `int` using `Integer.parseInt`:

```java
void main() {
    int number = Integer.parseInt(IO.readln("Enter a number: "));
    IO.println("You entered: " + number);
}
```

---

## Boolean Algebra Exercises

### 1. Christmas Eve Greeting

- [Java LOGICAL OPERATORS are easy! (video)](https://www.youtube.com/watch?v=4ezfRdg6Z7E&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=20) - submit `studentnumber-assignment02-video01.pdf`

Create a Java program that prints _"Merry Christmas!"_ on Christmas Eve. The program uses two variables, `day` and `month`. You may ask the user for the day and month. If the date is not Christmas Eve, the program prints nothing.

#### Example

```text
Enter day:
24
Enter month:
12
Merry Christmas!
```

```text
Enter day:
3
Enter month:
3
```

#### Test

- [Test.java](01/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Prints "Merry Christmas!" for day 24, month 12 | 1 |
| 2 | Prints nothing for day 3, month 3 | 1 |
| 3 | Prints nothing for day 24, month 6 | 1 |
| 4 | Prints nothing for day 25, month 12 | 1 |
| | **Total** | **4** |

---

### 2. Dog's Exceptional Age

Write a program that asks the user's dog's age. If the dog is younger than 3 years or older than 10 years, the program prints `The dog is of exceptional age.`. Otherwise, the program prints nothing.

#### Example

```text
Enter dog's age:
2
The dog is of exceptional age.
```

```text
Enter dog's age:
5
```

#### Test

- [Test.java](02/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Age 2 prints "The dog is of exceptional age." | 1 |
| 2 | Age 5 prints nothing | 1 |
| 3 | Age 11 prints "The dog is of exceptional age." | 1 |
| 4 | Age 3 prints nothing | 1 |
| | **Total** | **4** |

---

### 3. Working Hours

Write a program that asks the user for the hour of the day. If the hour is between 9 and 17 (inclusive), the program prints `Working hours are in progress!`. Otherwise, it prints nothing.

#### Example

```text
Enter hour:
10
Working hours are in progress!
```

```text
Enter hour:
20
```

#### Test

- [Test.java](03/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Hour 10 prints "Working hours are in progress!" | 1 |
| 2 | Hour 20 prints nothing | 1 |
| 3 | Hour 9 prints "Working hours are in progress!" | 1 |
| 4 | Hour 17 prints "Working hours are in progress!" | 1 |
| 5 | Hour 8 prints nothing | 1 |
| | **Total** | **5** |

---

## Control Structures

### 4. Division

- [Java arithmetic is easy! (video)](https://www.youtube.com/watch?v=QAD5unRlCyo&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=5) - submit `studentnumber-assignment02-video02.pdf`

Converting **class types** to **primitive types** is not as straightforward as converting one primitive type to another. The most common class-to-primitive conversion is turning a string into a number:

```java
int x    = Integer.parseInt("55");
double y = Double.parseDouble("5.5");
```

Create an application that takes **two integers** from the user and outputs their division. Remember: if you divide two `int` variables, the result is also `int`. Cast from `int` to `double` to get a precise result. Verify that with inputs `5` and `2` the output is `2.5`.

Use `IO.readln` to read user input:

```java
int n = Integer.parseInt(IO.readln("Enter a number: "));
```

What type does `IO.readln` return? In other words, in what form (what data type) does the user's input arrive? Answer in your code comments.

#### Example

```text
Enter first number:
5
Enter second number:
2
2.5
```

#### Test

- [Test.java](04/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Inputs 5 and 2 produce output 2.5 | 1 |
| 2 | Inputs 7 and 2 produce output 3.5 | 1 |
| | **Total** | **2** |

---

### 5. For Loops

- [Java for loops are easy! (video)](https://www.youtube.com/watch?v=vOmZ4JFhRds&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=23) - submit `studentnumber-assignment02-video03.pdf`

Using a [**for**](https://www.w3schools.com/java/java_for_loop.asp) loop, write an application that prints the following integer ranges. Create four separate for loops (parts a-d).

```text
a) 1 -> 10
b) 5 -> 15
c) 10 -> 0
d) every second number from 10 -> 0
```

#### Expected Output

```text
1
2
3
4
5
6
7
8
9
10
5
6
7
8
9
10
11
12
13
14
15
10
9
8
7
6
5
4
3
2
1
0
10
8
6
4
2
0
```

#### Test

- [Test.java](05/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Part a: prints 1 to 10 | 1 |
| 2 | Part b: prints 5 to 15 | 1 |
| 3 | Part c: prints 10 to 0 | 1 |
| 4 | Part d: prints every second number from 10 to 0 | 1 |
| | **Total** | **4** |

---

### 6. Input Validation

Create an application that asks the user for a number between 1 and 7. If the user enters anything else, ask again (use a **do-while** loop).

A `do-while` loop always executes the body at least once, then checks the condition:

```java
do {
    // body
} while (condition);
```

#### Example

```text
Enter a number (1-7):
0
Enter a number (1-7):
9
Enter a number (1-7):
3
You entered: 3
```

#### Test

- [Test.java](06/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Accepts valid input 3 | 1 |
| 2 | Rejects 0 and 9, accepts 5 | 1 |
| | **Total** | **2** |

---

### 7. Weekday Switch-Case

Copy your exercise 6 code and extend it. Once the number is accepted, print the corresponding weekday (1 = Monday, 2 = Tuesday, ..., 7 = Sunday). Use [**switch-case**](https://www.w3schools.com/java/java_switch.asp).

- [Learn Java enhanced switches in 8 minutes! (video)](https://www.youtube.com/watch?v=6q2JKiynteM&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=18) - submit `studentnumber-assignment02-video04.pdf`

#### Example

```text
Enter a number (1-7):
1
Monday
```

```text
Enter a number (1-7):
5
Friday
```

#### Test

- [Test.java](07/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Input 1 prints "Monday" | 1 |
| 2 | Input 3 prints "Wednesday" | 1 |
| 3 | Input 5 prints "Friday" | 1 |
| 4 | Input 6 prints "Saturday" | 1 |
| 5 | Input 7 prints "Sunday" | 1 |
| | **Total** | **5** |

---

### 8. Grade from Score

- [Nested if statements are easy! (video)](https://www.youtube.com/watch?v=23VT2wh3BG4&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=12) - submit `studentnumber-assignment02-video05.pdf`

Write a program that asks for a score and outputs a grade according to the table:

| Grade (Latin) | Points |
|---------------|--------|
| _improbatur_  | 0-8    |
| _approbatur_  | 9-16   |
| _lubenter_    | 17-24  |
| _cum laude_   | 25-35  |
| _magna_       | 36-44  |
| _eximia_      | 45-52  |
| _laudatur_    | 53-60  |

**Tip:** _Do not_ use `switch-case` for this one.

#### Example

```text
Enter score:
55
laudatur
```

#### Test

- [Test.java](08/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Score 5 outputs "improbatur" | 1 |
| 2 | Score 8 outputs "improbatur" | 1 |
| 3 | Score 9 outputs "approbatur" | 1 |
| 4 | Score 20 outputs "lubenter" | 1 |
| 5 | Score 36 outputs "magna" | 1 |
| 6 | Score 45 outputs "eximia" | 1 |
| 7 | Score 55 outputs "laudatur" | 1 |
| | **Total** | **7** |

---

## Rock-Paper-Scissors

**Tip:** When comparing strings, use `equals`, not `==`:

**Correct way:**

```java
String mj1 = "hello";
String mj2 = "hello";
if (mj1.equals(mj2)) {
    ...
}
```

**Incorrect way:**

```java
String mj1 = "hello";
String mj2 = "hello";
if (mj1 == mj2) {
    ...
}
```

`String` is a class type and you must compare it with `equals`. For primitive types, use `==`.

### 9. Rock-Paper-Scissors

- [Useful string methods in Java! (video)](https://www.youtube.com/watch?v=Ntl3DxhyrQQ&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=13) - submit `studentnumber-assignment02-video06.pdf`
- [Code a rock paper scissors game with Java! (video)](https://www.youtube.com/watch?v=GsuEJ9QOPgk&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=37) - submit `studentnumber-assignment02-video07.pdf`

Implement the classic **Rock-Paper-Scissors** game in Java. The game is two-player: Player 1 chooses rock, paper, or scissors, then Player 2 does the same. The program announces the winner.

#### Example

```text
Player 1, enter your choice (rock/paper/scissors):
rock
Player 2, enter your choice (rock/paper/scissors):
scissors
Player 1 wins!
```

```text
Player 1, enter your choice (rock/paper/scissors):
paper
Player 2, enter your choice (rock/paper/scissors):
paper
It's a tie!
```

#### Test

- [Test.java](09/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Rock beats scissors | 1 |
| 2 | Paper beats rock | 1 |
| 3 | Scissors beats paper | 1 |
| 4 | Rock vs rock is a tie | 1 |
| 5 | Scissors vs rock, Player 2 wins | 1 |
| | **Total** | **5** |

---

## License

> This work is licensed under the
> **Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License (CC BY-NC-SA 4.0)**
>
> **Additional Restriction:**
> The material may **not** be used, in whole or in part, to **train, fine-tune, prompt, or otherwise feed into any generative artificial intelligence (AI) or machine learning (ML) system**, except for the author.

[Learn more about CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/)
