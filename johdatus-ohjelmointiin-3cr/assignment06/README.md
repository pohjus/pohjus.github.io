# Assignment 06

## Points Overview

| Exercise | Description | Points |
|----------|-------------|--------|
| 01 | Access a 2D Array Element | 2 |
| 02 | Print First Row | 2 |
| 03 | Print Entire 2D Array | 4 |
| 04 | User-Filled 2D Array | 4 |
| 05 | Print Method for 2D Array | 3 |
| 06 | Dynamic 2D Array | 6 |
| 07 | Sum Check | 3 |
| 08 | Cumulative Sum | 3 |
| 09 | Print Rectangle | 3 |
| 10 | Row Sums | 3 |
| **Total** | | **33** |

## Required Video Notes

Submit the following handwritten video notes with this assignment:

- `notes/video01.pdf`

## Directory Structure

Create each exercise in its own folder:

```text
assignment06/01/Main.java
assignment06/02/Main.java
...
assignment06/nn/Main.java
```

Use the concepts we've covered in class: **don't use advanced
features**, even if you already know them.

See the [course README](../README.md) for tool setup, AI policy, and
installation instructions.

## Testing

See the shared testing instructions in the
[course README](../README.md#testing-assignments).

---

## 2D Arrays

- 📺 [Learn Java 2D arrays in 9 minutes! (video)](https://www.youtube.com/watch?v=Qf3Nczxm2AY&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=35) (length: 9:38) - submit 📝 `notes/video01.pdf`

A **2D array** is an array of arrays. You can think of it as a table
with rows and columns.

{% raw %}
```java
void main() {
    // Create a 2x3 array (2 rows, 3 columns).
    int[][] table = new int[2][3];
    table[0][0] = 1;
    table[0][1] = 2;
    table[0][2] = 3;
    table[1][0] = 4;
    table[1][1] = 5;
    table[1][2] = 6;

    // Create and initialize in one line.
    int[][] another = {{1, 2, 3}, {4, 5, 6}};

    // Print all values using nested for loops.
    for (int row = 0; row < another.length; row++) {
        for (int col = 0; col < another[row].length; col++) {
            IO.print(another[row][col] + " ");
        }
        IO.println("");
    }
}
```
{% endraw %}

Output:

```text
1 2 3
4 5 6
```

---

## 2D Array Exercises

### 1. Access a 2D Array Element

Implement a program that contains the following 2D array:

{% raw %}
```java
int[][] array = {{1, 3, 9}, {2, 7, 3}};
```
{% endraw %}

Print the second row's second element (`7`).

#### Example output

```text
7
```

---

### 2. Print First Row

Use a `for` loop to print the first row of the array from exercise 1.

#### Example output

```text
1 3 9
```

---

### 3. Print Entire 2D Array

Print the entire 2D array from exercise 1 using two nested `for`
loops.

#### Example output

```text
1 3 9
2 7 3
```

---

### 4. User-Filled 2D Array

Modify the previous exercise so that the values are entered by the
user instead of being hardcoded. The array has 2 rows and 3 columns.
After reading the values, print the array.

#### Example

```text
Enter values:
1
4
5
1
2
3
2D array is:
1 4 5
1 2 3
```

---

### 5. Print Method for 2D Array

Extend the previous solution by creating a separate method for
printing:

```java
void printArray(int[][] array) {

}
```

Pass the array to this method, which prints all rows line by line.

#### Example output

```text
Enter values:
1
4
5
1
2
3
2D array is:
1 4 5
1 2 3
```

---

### 6. Dynamic 2D Array

Extend the previous solution by first asking the user for the number
of rows and columns. Then ask for the element values, store them in
the array, and print using the method from exercise 5.

#### Example

```text
Number of rows: 2
Number of columns: 3
Enter values:
1
2
3
4
5
6
2D array is:
1 2 3
4 5 6
```

---

## Review Exercises

The following exercises review earlier topics: conditionals, loops,
methods, and 2D arrays.

### 7. Sum Check

Implement a program that asks the user for two numbers.
If their sum is 10, print `"it was ten"`.
Otherwise, print `"it was not ten"`.

#### Example

```text
Enter first number: 3
Enter second number: 7
it was ten
```

---

### 8. Cumulative Sum

Implement a program that asks the user for a number `n`.
The program calculates the sum 1 + 2 + 3 + ... + n and prints the
result.

#### Example

```text
Enter number: 5
15
```

---

### 9. Print Rectangle

Implement a method `printRectangle(int width, int height)` that prints
a rectangle of asterisks with the given dimensions.

```java
void main() {
    printRectangle(7, 3);
}

void printRectangle(int width, int height) {

}
```

#### Example output

```text
*******
*******
*******
```

---

### 10. Row Sums

Implement a program that contains the following 2D array:

{% raw %}
```java
int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}};
```
{% endraw %}

Print all values of the array and the sum of each row.

#### Example output

```text
1 2 3 4 sum = 10
5 6 7 8 sum = 26
```

---

## License

> This work is licensed under the
> **Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License (CC BY-NC-SA 4.0)**
>
> **Additional Restriction:**
> The material may **not** be used, in whole or in part, to **train, fine-tune, prompt, or otherwise feed into any generative artificial intelligence (AI) or machine learning (ML) system**, except for the author.

[Learn more about CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/)
