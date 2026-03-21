# Assignment 03

## Points Overview

| Exercise | Description | Points |
|----------|-------------|--------|
| 01 | Name Check | 2 |
| 02 | String Methods | 1 |
| 03 | Character Printing | 2 |
| 04 | Reverse Order | 2 |
| 05 | Reverse Order and Every Other Char | 2 |
| 06 | Appending Strings | 1 |
| 07 | Appending Strings - Part 2 | 2 |
| 08 | Palindrome | 3 |
| 09 | Palindrome - Part 2 | 3 |
| 10 | Loop | 3 |
| 11 | Calculator | 3 |
| 12 | Random Values | 2 |
| 13 | Random Integers | 2 |
| 14 | Password Check | 4 |
| 15 | Diagram | 3 |
| 16 | Shuffle | 2 |
| 17 | Hangman | 3 |
| 18 | Hangman: Text File | 2 |
| **Total** | | **42** |

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

Each exercise has a `Test.java` file that verifies your solution.
To run the tests:

1. Navigate to the exercise folder (e.g., `assignment03/01/`)
2. Make sure your `Main.java` is in the same folder
3. Run:

```bash
java Test.java
```

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
| | **Total** | **2** |

---

## 2. String Methods

Variables of class types are often called objects. `String` is a class type, and thus variables created from it are objects. An object can have operations (services, methods) that the programmer can use.

Implement an application in which you test (what do these do?) the following services:

- [`charAt(int)`](<https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/String.html#charAt(int)>)
- [`length()`](<https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/String.html#length()>)
- [`trim()`](<https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/String.html#trim()>)

Hint for the last one: _create a String that has spaces at the beginning and end._

### Test

- [Test.java](02/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Program compiles and produces output | 1 |
| | **Total** | **1** |

---

## 3. Character Printing

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

- [Test.java](03/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | "Otto" prints O, t, t, o on separate lines | 1 |
| 2 | "AB" prints A, B on separate lines | 1 |
| | **Total** | **2** |

---

## 4. Reverse Order

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

- [Test.java](04/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | "Otto" reversed prints o, t, t, O | 1 |
| 2 | "ABC" reversed prints C, B, A | 1 |
| | **Total** | **2** |

---

## 5. Reverse Order and Every Other Char

Previous task (i.e., task 4), but print every other character of the name.

### Example

```text
Enter your name: Otto
o
t
```

### Test

- [Test.java](05/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | "Otto" reversed every other prints o, t | 1 |
| 2 | "ABCDE" reversed every other prints E, C, A | 1 |
| | **Total** | **2** |

---

## 6. Appending Strings

What happens when you "add together" the following? Why?
Try it out and explain in comments.

```text
1 + 2
"string1" + "string2"
"string1" + 2
"string1" + 3.3
3.3 + "string" + 3.3
2 + "string2"
"string1" + 'a'
'a' + 'b'
```

### Test

- [Test.java](06/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Program compiles and produces output | 1 |
| | **Total** | **1** |

---

## 7. Appending Strings - Part 2

Implement an application that asks the user to enter names. Name input should stop when the user enters the string `lopeta`. On each round, the program prints all names entered so far on a single line:

### Example

```text
Enter name:
Tiina
Tiina
Enter name:
Heli
TiinaHeli
Enter name:
Kalle
TiinaHeliKalle
Enter name:
Pauli
TiinaHeliKallePauli
Enter name:
lopeta
```

### Test

- [Test.java](07/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Accumulates names correctly (Tiina, Heli) | 1 |
| 2 | No names printed when "lopeta" entered immediately | 1 |
| | **Total** | **2** |

---

## 8. Palindrome

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

- [Test.java](08/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | "saippuakauppias" is a palindrome | 1 |
| 2 | "hello" is not a palindrome | 1 |
| 3 | "abba" is a palindrome | 1 |
| | **Total** | **3** |

---

## 9. Palindrome - Part 2

Modify the previous task so that palindrome strings are checked in a way that spaces and punctuation marks (`,`, `.`) are ignored, and letter case does not matter. Use [`equalsIgnoreCase`](<https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/String.html#equalsIgnoreCase(java.lang.String)>) for comparison.

For example, the sentence `Nätin äänesi, sen äänitän` should be recognized as a palindrome.

**Do not use** the [`replaceAll`](<https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/String.html#replaceAll(java.lang.String,java.lang.String)>) method to remove spaces or punctuation marks.
Instead, build a cleaned version of the string using only [`charAt(int)`](<https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/String.html#charAt(int)>) and `+` (string concatenation).

The logic should manually filter characters and build a new string containing only letters.

### Example

```text
Enter a string: race car
Palindrome
```

```text
Enter a string: hello world
Not a palindrome
```

### Test

- [Test.java](09/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | "race car" is a palindrome (ignoring spaces) | 1 |
| 2 | "hello world" is not a palindrome | 1 |
| 3 | "Was it a car or a cat I saw" is a palindrome (ignoring case and spaces) | 1 |
| | **Total** | **3** |

---

## 10. Loop

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

- [Test.java](10/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Inputs 5 and 10 print all numbers from 5 to 10 | 1 |
| 2 | Inputs 2 and -3 print all numbers from -3 to 2 | 1 |
| 3 | Equal inputs print the number | 1 |
| | **Total** | **3** |

---

## 11. Calculator

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

- [Test.java](11/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Inputs 5 / 2 produce output 2.5 | 1 |
| 2 | Inputs 10 + 2 produce output 12 | 1 |
| 3 | Inputs 7 * 3 produce output 21 | 1 |
| | **Total** | **3** |

---

## 12. Random Values

In Java, you can generate a random double between `[0, 1[` like this:

```java
double random = Math.random();
```

Implement a Java application that prints 5 random numbers between `[0, 1[`.

### Example

```text
0.112312
0.332323
0.233223
0.323232
0.983233
```

### Test

- [Test.java](12/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Prints exactly 5 lines | 1 |
| 2 | All values are doubles in [0, 1[ | 1 |
| | **Total** | **2** |

---

## 13. Random Integers

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

- [Test.java](13/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Prints exactly 5 lines | 1 |
| 2 | All values are integers between 0 and 4 | 1 |
| | **Total** | **2** |

---

## 14. Password Check

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

- [Test.java](14/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | "Abcdefg1" is accepted | 1 |
| 2 | "short" is rejected (too short) | 1 |
| 3 | "abcdefgh" is rejected (no uppercase or digit) | 1 |
| 4 | "ABCDEFG1" is rejected (no lowercase) | 1 |
| | **Total** | **4** |

---

## 15. Diagram

Use the following code as a base. This program reads a text file called `"Main.java"` and prints each line to the console:

```java
import java.io.IOException;
import java.util.List;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.io.File;

void main() throws IOException {
    String textFileName = "Main.java";
    List<String> allLines = Files.readAllLines(
        new File(textFileName).toPath(),
        Charset.defaultCharset()
    );

    for (int i = 0; i < allLines.size(); i++) {
        String line = allLines.get(i);
        IO.println(line);
    }
}
```

Make sure the above code works.

Now create a separate text file named `input.txt` containing integers, for example:

```text
3
-3
-1
4
0
```

Implement an application that reads the file and prints the following pattern based on the input:

```text
   |+++
---|
  -|
   |++++
   |
```

Do not use the `String.repeat` method in your solution.

### Test

- [Test.java](15/Test.java)
- [input.txt](15/input.txt)

| # | Test | Points |
|---|------|--------|
| 1 | Positive values show + signs after \| | 1 |
| 2 | Negative values show - signs before \| | 1 |
| 3 | Zero shows only \| | 1 |
| | **Total** | **3** |

---

## 16. Shuffle

Implement an application that asks the user for a name:

```text
Enter name:
seppo
```

Then the program prints the name with its characters randomly shuffled, e.g.:

```text
oepps
```

Use only the concepts introduced in classroom sessions.

### Test

- [Test.java](16/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Output has same length as input | 1 |
| 2 | Shuffled output contains same characters as input | 1 |
| | **Total** | **2** |

---

## 17. Hangman

Implement a prototype for a hangman application.
The program contains the word to be guessed as a constant (`final` variable).
You can choose the word yourself.
The program starts and prints dashes (`-`) equal to the length of the word:

```text
Guess the word
-----
k
Guess the word
k----
i
Guess the word
ki---
s
Guess the word
kiss-
a
Guess the word
kissa
Correct!
```

The program ends when all letters are guessed.

### Test

- [Test.java](17/Test.java)

| # | Test | Points |
|---|------|--------|
| 1 | Game ends with "Correct!" when all letters guessed | 1 |
| 2 | Initial state shows dashes | 1 |
| 3 | After guessing "k", shows "k----" | 1 |
| | **Total** | **3** |

---

## 18. Hangman: Text File

Place words into a text file. In your program, read the words and randomly choose one to be guessed.

### Example

```text
Guess the word
----
k
Guess the word
k---
o
Guess the word
ko--
i
Guess the word
koi--
r
Guess the word
koir-
a
Guess the word
koira
Correct!
```

### Test

- [Test.java](18/Test.java)
- [words.txt](18/words.txt)

| # | Test | Points |
|---|------|--------|
| 1 | Game ends with "Correct!" | 1 |
| 2 | Displays "Guess the word" prompt | 1 |
| | **Total** | **2** |

---

## License

> This work is licensed under the
> **Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License (CC BY-NC-SA 4.0)**
>
> **Additional Restriction:**
> The material may **not** be used, in whole or in part, to **train, fine-tune, prompt, or otherwise feed into any generative artificial intelligence (AI) or machine learning (ML) system**, except for the author.

[Learn more about CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/)
