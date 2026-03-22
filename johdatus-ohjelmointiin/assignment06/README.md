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
| | [**Robin track**](robin/README.md) | 26 |
| | [**Batman track**](batman/README.md) | 26 |
| **Total** | | **47** |

This assignment has two parts: shared 2D array exercises (1-6) and a
choice between two tracks.

After completing exercises 1-6, choose one:

- [**Robin exercises**](robin/README.md): A review of the basics
  covering methods, strings, arrays, and 2D arrays.
- [**Batman exercises**](batman/README.md): A full lottery simulation
  application with packages and documentation.

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

Each exercise has a `Test.java` file that automatically checks your
solution.
The test file runs your `Main.java` as a separate process and verifies
its output.

### Step-by-step

1. Write your solution in `Main.java` and place it in the correct
   exercise folder (e.g., `assignment06/01/Main.java`).
2. Download the `Test.java` file from the repository and place it in the
   **same folder** as your `Main.java`.
3. Open a terminal and navigate to the exercise folder:

**Windows (Command Prompt):**

```bash
cd C:\Users\YourName\path\to\assignment06\01
```

**macOS / Linux (Terminal):**

```bash
cd /Users/YourName/path/to/assignment06/01
```

4. Verify that both files are in the folder:

**Windows:**

```bash
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

## 2D Arrays

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

A 2D `char` array can be used to draw shapes:

```java
void main() {
    char[][] grid = {
        {'x', 'x', 'x', 'x', 'x'},
        {'x', '-', '-', '-', 'x'},
        {'x', '-', '-', '-', 'x'},
        {'x', 'x', 'x', 'x', 'x'}
    };

    for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[row].length; col++) {
            IO.print(grid[row][col]);
        }
        IO.println("");
    }
}
```

Output:

```text
xxxxx
x---x
x---x
xxxxx
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
