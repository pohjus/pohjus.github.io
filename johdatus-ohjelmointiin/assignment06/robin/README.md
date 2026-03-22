# Robin Edition

## Points Overview

| Exercise | Description | Points |
|----------|-------------|--------|
| 01 | Sum Check | 3 |
| 02 | Name Validation | 3 |
| 03 | Cumulative Sum | 3 |
| 04 | Print Stars | 2 |
| 05 | Print Rectangle | 3 |
| 06 | String Prefix | 2 |
| 07 | Reverse Command-Line Arguments | 2 |
| 08 | Array Shuffle | 3 |
| 09 | Row Sums | 3 |
| 10 | Place X on a Grid | 2 |
| **Total** | | **26** |

Create a separate directory for each exercise:

```text
robin/01/Main.java
robin/02/Main.java
...
robin/10/Main.java
```

---

## Basics

### 1. Sum Check

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

### 2. Name Validation

Implement a program that asks the user for a name.
The name must be at least two characters long.
If the user gives a name that is too short, ask again.
Finally, print the given name.

#### Example

```text
Enter name:
j
Enter name:
x
Enter name:
Li
You entered the name Li
```

---

### 3. Cumulative Sum

Implement a program that asks the user for a number `n`.
The program calculates the sum 1 + 2 + 3 + ... + n and prints the
result.

#### Example

```text
Enter number: 5
15
```

---

## Methods

### 4. Print Stars

Implement a method `printStars(int amount)` that prints `amount`
asterisks (`*`) on one line followed by a newline.

```java
void main() {
    printStars(5);
}

void printStars(int amount) {

}
```

#### Example output

```text
*****
```

---

### 5. Print Rectangle

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

## Strings

### 6. String Prefix

Implement a program that prints the beginning of a string based on
user input.

#### Example

```text
Enter word: example
Prefix length: 4
Result: exam
```

---

## Arrays

### 7. Reverse Command-Line Arguments

Implement a program that prints the given command-line arguments in
reverse order.

```java
void main(String[] args) {

}
```

#### Example

```bash
java Main.java a b c d
```

```text
d c b a
```

---

### 8. Array Shuffle

Implement a program with a method `shuffle(int[] array)` that randomly
shuffles the values in the given array.

```java
void main() {
    int[] numbers = {1, 2, 3, 4, 5};
    shuffle(numbers);
    for (int i = 0; i < numbers.length; i++) {
        IO.print(numbers[i] + " ");
    }
    IO.println("");
}

void shuffle(int[] array) {

}
```

#### Example output

```text
3 1 5 2 4
```

---

## 2D Arrays

### 9. Row Sums

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

### 10. Place X on a Grid

Implement a program that contains the following 2D `char` array:

```java
char[][] grid = {
    {'-', '-', '-', '-', '-', '-'},
    {'-', '-', '-', '-', '-', '-'},
    {'-', '-', '-', '-', '-', '-'},
    {'-', '-', '-', '-', '-', '-'}
};
```

Ask the user for a position and place an `X` character there, then
print the grid.

#### Example

```text
Enter xPos: 0
Enter yPos: 0
X-----
------
------
------
```
