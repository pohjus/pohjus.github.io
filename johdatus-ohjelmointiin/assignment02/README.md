# Assignment 02

## Points Overview

| Exercise | Description | Points |
|----------|-------------|--------|
| 01 | Christmas Eve Greeting | 2 |
| 02 | Dog's Exceptional Age | 2 |
| 03 | Working Hours | 2 |
| 04 | Variables | 1 |
| 05 | Casting | 1 |
| 06 | Division | 2 |
| 07 | While Loops | 4 |
| 08 | For Loops | 4 |
| 09 | Do-While Loops | 5 |
| 10 | Multiplication by Addition | 2 |
| 11 | Input Validation | 2 |
| 12 | Weekday Switch-Case | 2 |
| 13 | Grade from Score | 3 |
| 14 | Pattern Width | 2 |
| 15 | Square Pattern | 2 |
| 16 | Diagonal Left to Right | 2 |
| 17 | Diagonal Right to Left | 2 |
| 18 | Rock-Paper-Scissors | 3 |
| 19 | RPS vs Computer | 2 |
| 20 | Best of Three | 2 |
| **Total** | | **47** |

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

Each exercise has a `Test.java` file that verifies your solution.
To run the tests:

1. Navigate to the exercise folder (e.g., `assignment02/01/`)
2. Make sure your `Main.java` is in the same folder
3. Run:

```bash
java Test.java
```

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
| | **Total** | **2** |

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
| | **Total** | **2** |

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
| | **Total** | **2** |

---

## Variables

### 4. Uninitialized Variables

Write a Java program that **declares** three variables: `int age`, `double number`, `char someChar`. Try to print their values without initializing them. What compiler error do you get? Fix it by initializing the variables. Answer the question in your code comments.

#### Test

- [Test.java](04/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Program compiles and runs with initialized variables | 1 |
| | **Total** | **1** |

---

### 5. Casting

Declare an `int` variable (give it any value) and assign it to a `byte` variable. Use an explicit cast:

```java
byte x = (byte) someInt;
```

When converting from a larger range (e.g., `int`) to a smaller range (`byte`), an explicit cast is required.

Then create a `byte` variable and assign it to an `int` variable. Is a cast required in this direction? Answer in your code comments.

#### Test

- [Test.java](05/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Program compiles and runs with correct casts | 1 |
| | **Total** | **1** |

---

### 6. Division

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

- [Test.java](06/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Inputs 5 and 2 produce output 2.5 | 1 |
| 2 | Inputs 10 and 4 produce output 2.5 | 1 |
| | **Total** | **2** |

---

## Control Structures

### 7. While Loops

Using a [**while**](https://www.w3schools.com/java/java_while_loop.asp) loop, write an application that prints the following integer ranges. Create four separate while loops (parts a-d).

```text
a) 1 → 10
b) 5 → 15
c) 10 → 0
d) every second number from 10 → 0
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

- [Test.java](07/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Part a: prints 1 to 10 | 1 |
| 2 | Part b: prints 5 to 15 | 1 |
| 3 | Part c: prints 10 to 0 | 1 |
| 4 | Part d: prints every second number from 10 to 0 | 1 |
| | **Total** | **4** |

---

### 8. For Loops

Implement the previous loops with a [**for**](https://www.w3schools.com/java/java_for_loop.asp) loop. Expected output is the same as exercise 7.

#### Test

- [Test.java](08/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Part a: prints 1 to 10 | 1 |
| 2 | Part b: prints 5 to 15 | 1 |
| 3 | Part c: prints 10 to 0 | 1 |
| 4 | Part d: prints every second number from 10 to 0 | 1 |
| | **Total** | **4** |

---

### 9. Do-While Loops

Implement the previous loops with a [**do-while**](https://www.javatpoint.com/java-do-while-loop) loop. Expected output is the same as exercise 7.

What is the principal difference between `while` and `do-while`? Try a loop whose condition is false from the start; how do the two differ?

```java
int x = 20;
while (x < 1) {
    IO.println("A");
}

do {
    IO.println("B");
} while (x < 1);
```

Answer in a text file `while-vs-dowhile.txt` in folder `assignment02/09/`.

#### Test

- [Test.java](09/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Part a: prints 1 to 10 | 1 |
| 2 | Part b: prints 5 to 15 | 1 |
| 3 | Part c: prints 10 to 0 | 1 |
| 4 | Part d: prints every second number from 10 to 0 | 1 |
| 5 | File while-vs-dowhile.txt exists | 1 |
| | **Total** | **5** |

---

### 10. Multiplication by Addition

Multiplication is familiar to everyone:

```text
2 * 4 = 8
```

You can also compute the product using repeated addition:

```text
2 * 4 => 2 + 2 + 2 + 2 = 8
```

In general:

```text
n * m = n + n + n ... (m times)
```

Write a Java application that asks the user for two numbers and calculates their product using repeated addition. If the user enters `2` and `4`, compute `2 + 2 + 2 + 2` and print the result.

#### Example

```text
Enter number1:
2
Enter number2:
3
Product:
6
```

**Hint:**

```java
// calculate 5 x 5
int product = 0;
product = product + 5;    // 0 + 5
product = product + 5;    // 5 + 5
product = product + 5;    // 10 + 5
product = product + 5;    // 15 + 5
product = product + 5;    // 20 + 5
IO.println(product);      // 25
```

Use a loop in your solution.

#### Test

- [Test.java](10/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Inputs 2 and 3 produce "6" | 1 |
| 2 | Inputs 5 and 5 produce "25" | 1 |
| | **Total** | **2** |

---

### 11. Input Validation

Create an application that asks the user for a number between 1 and 7. If the user enters anything else, ask again (use a **do-while** loop).

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

- [Test.java](11/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Accepts valid input 3 | 1 |
| 2 | Rejects 0 and 9, accepts 5 | 1 |
| | **Total** | **2** |

---

### 12. Weekday Switch-Case

Copy your exercise 11 code and extend it. Once the number is accepted, print the corresponding weekday (1 = Monday, 2 = Tuesday, ..., 7 = Sunday). Use [**switch-case**](https://www.w3schools.com/java/java_switch.asp).

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

- [Test.java](12/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Input 1 prints "Monday" | 1 |
| 2 | Input 5 prints "Friday" | 1 |
| | **Total** | **2** |

---

### 13. Grade from Score

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

- [Test.java](13/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Score 5 outputs "improbatur" | 1 |
| 2 | Score 20 outputs "lubenter" | 1 |
| 3 | Score 55 outputs "laudatur" | 1 |
| | **Total** | **3** |

---

## ASCII Graphics using Control Structures

The following pattern-drawing tasks **must not** use `String.repeat()`. Implement them using loops.

### 14. Pattern Width

Write a program that prints a row of `X` characters. Ask the user for the number of `X`'s. Use a loop to output the characters.

```text
Enter pattern width:
4
XXXX
```

**Tip:** `IO.print("X")` outputs `X` without a trailing newline. `IO.println("X")` outputs `X` with a trailing newline.

#### Test

- [Test.java](14/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Width 4 prints "XXXX" | 1 |
| 2 | Width 6 prints "XXXXXX" | 1 |
| | **Total** | **2** |

---

### 15. Square Pattern

Write a program that prints a square of `X` characters. Ask the user for the square's height. The width equals the height. Use a loop.

```text
Enter square height:
4
XXXX
XXXX
XXXX
XXXX
```

#### Test

- [Test.java](15/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Height 4 prints a 4x4 square | 1 |
| 2 | Height 3 prints a 3x3 square | 1 |
| | **Total** | **2** |

---

### 16. Diagonal Left to Right

Write a program that prints a diagonal pattern going left to right. Ask the user for the height. Use a loop.

```text
Enter height:
5
X
 X
  X
   X
    X
```

#### Test

- [Test.java](16/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Height 5 prints correct diagonal | 1 |
| 2 | Height 3 prints correct diagonal | 1 |
| | **Total** | **2** |

---

### 17. Diagonal Right to Left

Write a program that prints a diagonal pattern going right to left. Ask the user for the height. Use a loop.

```text
Enter height:
5
    X
   X
  X
 X
X
```

#### Test

- [Test.java](17/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Height 5 prints correct diagonal | 1 |
| 2 | Height 3 prints correct diagonal | 1 |
| | **Total** | **2** |

---

## Rock-Paper-Scissors using Control Structures

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

### 18. Rock-Paper-Scissors

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

- [Test.java](18/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Rock beats scissors | 1 |
| 2 | Paper beats rock | 1 |
| 3 | Scissors beats paper | 1 |
| | **Total** | **3** |

---

### 19. RPS vs Computer

Modify the application so the player competes against the computer. The computer randomly chooses rock, paper, or scissors. Use `Math.random`:

```java
// random number in [0, 1[
double x = Math.random();
```

#### Example

```text
Enter your choice (rock/paper/scissors):
rock
Computer chose: scissors
You win!
```

```text
Enter your choice (rock/paper/scissors):
paper
Computer chose: paper
It's a tie!
```

#### Test

- [Test.java](19/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Program runs and accepts user input | 1 |
| 2 | Program announces winner correctly | 1 |
| | **Total** | **2** |

---

### 20. Best of Three

Extend the game to _best-of-three_. At the end, announce whether the human or the computer won.

#### Example

```text
Round 1:
Enter your choice (rock/paper/scissors):
rock
Computer chose: scissors
You win this round!
Round 2:
Enter your choice (rock/paper/scissors):
paper
Computer chose: rock
You win this round!
Round 3:
Enter your choice (rock/paper/scissors):
scissors
Computer chose: scissors
Tie!
Final score - You: 2, Computer: 0
You win the game!
```

#### Test

- [Test.java](20/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Game plays three rounds | 1 |
| 2 | Final winner is announced | 1 |
| | **Total** | **2** |

---

## License

> This work is licensed under the
> **Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License (CC BY-NC-SA 4.0)**
>
> **Additional Restriction:**
> The material may **not** be used, in whole or in part, to **train, fine-tune, prompt, or otherwise feed into any generative artificial intelligence (AI) or machine learning (ML) system**, except for the author.

[Learn more about CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/)
