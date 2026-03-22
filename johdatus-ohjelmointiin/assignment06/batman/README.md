# Batman Edition

## Points Overview

| Exercise | Description | Points |
|----------|-------------|--------|
| 01 | Packages and compilation | 1 |
| 02 | Documentation | - |
| 03 | Arrays.toIntArray | 2 |
| 04 | Arrays.contains | 3 |
| 05 | Arrays.containsSameValues | 4 |
| 06 | MyConsole.readInt | - |
| 07 | Bounded readInt | - |
| 08 | Ask lotto numbers | - |
| 09 | Unique lotto numbers | - |
| 10 | Generate random lotto (Math.getRandom, removeIndex, calculateLotto) | 10 |
| 11 | Compare lotto results | - |
| 12 | Lotto simulation | 1 |
| 13 | Selection sort | 5 |
| 14 | Sorted output | - |
| 15 | Lifetime check | - |
| 16 | README | - |
| **Total** | | **26** |

Exercises marked with `-` are interactive or structural and are
tested manually.

In this exercise you will build a **lottery simulation** that estimates
how many years it would take to win the jackpot.

You will learn how to structure your code using **packages** and how to
write proper **documentation**.

All code must be written in **English** and follow **clean code
principles**.

### Important note

This is a **rudimentary implementation** of a lottery application.
We will **not** use any of Java's built-in convenience classes such as
`ArrayList` or `Set`, even though they would make the task easier.

We will intentionally use **plain arrays** so that you can practise
array handling.
The same applies to some utility methods (for example sorting): they
already exist in the standard library, but we will re-implement them
for learning purposes.

You can implement your whole app in one directory (`batman/`).

---

## 1. Packages

Packages are used to organise code, avoid name collisions, and divide
larger applications into logical parts.
For example, if the same project contains two classes named `Math`,
they must live in different packages to avoid conflicts.

### Step 1: Create a Math class

Create a file `Math.java` with the following content:

```java
public class Math {
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}
```

Notice we use `java.lang.Math.random()` instead of just
`Math.random()`, because our class is also named `Math`.

### Step 2: Place the class into a package

Add a package declaration:

```java
package fi.tuni.tamk.tiko.yourname.util;

public class Math {
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}
```

This means the file must be saved in the directory:

```text
fi/tuni/tamk/tiko/yourname/util/Math.java
```

Change `yourname` to your own name, for example `virtanentiina`.

Compile:

```bash
javac fi/tuni/tamk/tiko/yourname/util/Math.java
```

### Step 3: Create a Main class in another package

Create a Main class that uses your Math class:

```java
package fi.tuni.tamk.tiko.yourname;

import fi.tuni.tamk.tiko.yourname.util.Math;

public class Main {
    public static void main(String[] args) {
        System.out.println(Math.getRandom(1, 10));
    }
}
```

Save this in:

```text
fi/tuni/tamk/tiko/yourname/Main.java
```

Your directory structure should look like:

```text
fi/
  tuni/
    tamk/
      tiko/
        yourname/
          Main.java
          util/
            Math.java
```

Compile and run:

```bash
javac fi/tuni/tamk/tiko/yourname/Main.java
java fi/tuni/tamk/tiko/yourname/Main
```

---

## 2. Documentation

Javadoc is a documentation system built into Java.
It allows you to write documentation directly above your classes and
methods.
From these comments, Java can automatically generate HTML documentation
pages.

Javadoc comments start with `/**` and end with `*/`.
They describe **what** a class or method does, not how it is
implemented.

Example:

```java
/**
 * A utility class for common math-related helper methods.
 *
 * <p>This class is not meant to be instantiated.
 * All methods inside it are static.</p>
 */
public class Math {
    /**
     * Returns a random integer between min and max (inclusive).
     *
     * @param min the minimum value
     * @param max the maximum value
     * @return a random integer between min and max
     */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}
```

Document your `Math.java` class and your `Main.java` class.

Generate documentation:

```bash
javadoc -author -d doc -subpackages fi
```

This generates HTML documentation for all classes under the `fi`
package.
Open `doc/index.html` in your browser to see the result.

---

## 3. Util Class: Arrays

Create a new class `fi.tuni.tamk.tiko.yourname.util.Arrays`:

```java
package fi.tuni.tamk.tiko.yourname.util;

public class Arrays {

}
```

Add a method that converts a `String` array to an `int` array:

```java
public static int[] toIntArray(String[] array) {

}
```

Document the class and the method using Javadoc.
Test in your `main` method that it works correctly.

#### Example usage

```java
String[] input = {"1", "2", "3"};
int[] result = Arrays.toIntArray(input);
// result is now {1, 2, 3}
```

---

## 4. Contains Method

Add a method to your `Arrays` class:

```java
public static boolean contains(int value, int[] array) {

}
```

It returns `true` if `value` is found in `array`, `false` otherwise.
Document and test.

#### Example usage

```java
int[] numbers = {1, 2, 3, 4, 5};
System.out.println(Arrays.contains(3, numbers)); // true
System.out.println(Arrays.contains(9, numbers)); // false
```

---

## 5. Count Same Values

Add a method to your `Arrays` class:

```java
public static int containsSameValues(int[] array1, int[] array2) {

}
```

Given `{1, 2, 3, 4, 5, 6, 20}` and `{1, 20, 21, 22, 23, 24, 25}`,
it returns `2` because both arrays contain two same values (`1` and
`20`).
You can assume both arrays contain unique values.
Document and test.

#### Example usage

```java
int[] a = {1, 2, 3, 4, 5, 6, 20};
int[] b = {1, 20, 21, 22, 23, 24, 25};
System.out.println(Arrays.containsSameValues(a, b)); // 2
```

---

## 6. Util Class: MyConsole

Create a new class `fi.tuni.tamk.tiko.yourname.util.MyConsole`:

```java
package fi.tuni.tamk.tiko.yourname.util;

public class MyConsole {
    public static int readInt(String errorMessage) {

    }
}
```

Implement `readInt` so that it reads an integer from the user.
If the input is not a valid integer, print `errorMessage` and ask
again until a valid integer is given.

You can use `System.console()` to read input:

```java
java.io.Console c = System.console();
try {
    int input = Integer.parseInt(c.readLine());
} catch (NumberFormatException e) {
    System.out.println("Not a valid number");
}
```

Document and test.

#### Example

```text
Enter a number: abc
Not a valid number
Enter a number: 42
You entered 42
```

---

## 7. Bounded ReadInt

Add an overloaded method to `MyConsole`:

```java
public static int readInt(int min, int max,
        String errorMessageNonNumeric,
        String errorMessageOutOfRange) {

}
```

Ask the user for an integer between `min` and `max`.
If the input is not numeric, display `errorMessageNonNumeric`.
If the input is outside the range, display `errorMessageOutOfRange`.
Keep asking until valid input is given.
Document and test.

#### Example

```text
Enter a number between 1 and 10: abc
Please give a number.
Enter a number between 1 and 10: 50
Number must be between 1 and 10.
Enter a number between 1 and 10: 5
You entered 5
```

---

## 8. Ask Lotto Numbers

Implement a program that asks seven (7) lotto numbers from the user.
Each number must be between 1 and 40.

#### Example

```text
Please give a unique number between [1, 40]
1
Please give a unique number between [1, 40]
2
...
Please give a unique number between [1, 40]
7
```

If the input is not a number:

```text
Please give a number.
```

If the input is out of range:

```text
Please give a unique number between [1, 40]
```

Use your `MyConsole` class if possible.

---

## 9. Unique Lotto Numbers

Extend the previous exercise.
Store all user lotto numbers in an array.
Validate that each number is unique.
If a duplicate is entered, print an error and ask again.

#### Example

```text
Please give a unique number between [1, 40]
1
Please give a unique number between [1, 40]
1
Not unique!
Please give a unique number between [1, 40]
2
```

You can use `Arrays.contains` to check for duplicates.

---

## 10. Generate Random Lotto

Create a method in your main class:

```java
public static int[] calculateLotto() {

}
```

This returns an array of size 7 with unique random values between
1 and 40.
Use your `Math.getRandom` method.

#### Example return value

```text
[1, 5, 12, 20, 23, 31, 38]
```

**Easy approach:** Generate a random value between 1 and 40.
If it already exists in the array, generate again.

**Better approach:** Create an array containing values 1 to 40.
Pick a random index, take the value, remove it from the array, and
repeat 7 times.
For this approach, implement a helper method in your `Arrays` class:

```java
public static int[] removeIndex(int[] original, int index) {

}
```

This returns a new array with the element at `index` removed.

---

## 11. Compare Lotto Results

Compare the user's lotto numbers with the generated lotto.
Print how many numbers the user got right.

You can use the `Arrays.containsSameValues` method.

#### Example

```text
User lotto: 1, 2, 3, 4, 5, 6, 7
Random lotto: 1, 2, 20, 21, 22, 23, 24
You got 2 right!
```

---

## 12. Lotto Simulation

Implement the program so that it generates random lotto numbers
repeatedly until the user wins (all 7 correct).
Each iteration represents one week.
Calculate how many years it takes.

Print a "best of" summary:

```text
Got 1 right! Took 0 years
Got 2 right! Took 0 years
Got 3 right! Took 0 years
Got 4 right! Took 2 years
Got 5 right! Took 61 years
Got 6 right! Took 1232 years
Got 7 right! Took 1222536 years
You won!
```

---

## 13. Selection Sort

Implement a method in your `Arrays` class:

```java
public static int[] sort(int[] array) {

}
```

Sort the given array using
[selection sort](https://www.geeksforgeeks.org/selection-sort/).
Document and test.

#### Example usage

```java
int[] numbers = {5, 2, 8, 1, 4};
int[] sorted = Arrays.sort(numbers);
// sorted is now {1, 2, 4, 5, 8}
```

---

## 14. Sorted Output

Sort both the user lotto and the random lotto before printing them.
Format numbers with a leading zero for single digits:

```text
User lotto: [01, 02, 03, 05, 06, 30]
Random lotto: [01, 02, 20, 22, 23, 30]
Got 2 right! Took 0 years
```

Ask the user at the start whether they want detailed output for each
iteration or only the summary.

---

## 15. Lifetime Check

Run the simulation repeatedly until the user wins within a lifetime
(less than 120 years):

```text
Got 7 right! Took 137737 years
You won!
Although it took more than a lifetime, let's try again.
...
Got 7 right! Took 85 years
You won within a lifetime!
```

Also implement the option to give lotto numbers as command-line
arguments instead of entering them one by one:

```bash
java fi/tuni/tamk/tiko/yourname/Main 1 2 3 4 5 6 7
```

---

## 16. README

Document your main class.
Generate Javadoc from all classes.

Create a `MYREADME.md` file for your project.
Include a description of what the application does, how to compile
and run it, and example output.
