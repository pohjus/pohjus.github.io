# Assignment 07

## Points Overview

| Exercise | Description | Points |
|----------|-------------|--------|
| 01 | Class Rectangle and Object Creation | 5 |
| 02 | Reference Behavior and Printing Objects | 4 |
| 03 | Instance Method printMe() | 3 |
| 04 | this Reference | 3 |
| 05 | Garbage Collection Experiment | 4 |
| 06 | Method countSurfaceArea() | 4 |
| 07 | Encapsulation: Getters and Setters | 6 |
| 08 | IllegalArgumentException in Setters | 5 |
| 09 | Constructor | 4 |
| 10 | Identity vs Equality | 3 |
| 11 | equals Method | 3 |
| 12 | toString() Override | 2 |
| 13 | countDiagonal() | 3 |
| 14 | cloneMe() | 3 |
| 15 | Array of Rectangles + User Input | 4 |
| 16 | GUI Basics: Swing | 5 |
| 17 | Composite Rectangle Task | 5 |
| **Total** | | **66** |

## Directory Structure

Create each exercise in its own folder:

```text
assignment07/01/Rectangle.java
assignment07/01/Main.java
assignment07/02/Rectangle.java
assignment07/02/Main.java
...
assignment07/nn/Rectangle.java
```

Use the concepts we've covered in class: **don't use advanced features**, even if you already know them.

See the [course README](../README.md) for tool setup, AI policy, and
installation instructions.

## Testing

Each exercise has a `Test.java` file that automatically checks your
solution.
The test file runs your program as a separate process and verifies
its output.

### Step-by-step

1. Write your solution and place it in the correct
   exercise folder (e.g., `assignment07/01/`).
2. Download the `Test.java` file from the repository and place it in the
   **same folder** as your source files.
3. Open a terminal and navigate to the exercise folder:

**Windows (Command Prompt):**

```bash
cd C:\Users\YourName\path\to\assignment07\01
```

**macOS / Linux (Terminal):**

```bash
cd /Users/YourName/path/to/assignment07/01
```

4. Verify that all files are in the folder:

**Windows:**

```bash
dir
```

**macOS / Linux:**

```bash
ls
```

You should see `Rectangle.java`, `Main.java`, and `Test.java` listed.

5. Compile and run the test:

```bash
javac *.java
java Test
```

---

## Object-Oriented Basics

In Java, a **class** defines a blueprint for objects. An **object** is an instance of a class, created with `new`. Each object has its own copy of the fields defined in the class.

```java
class Rectangle {
    public int width;
    public int height;
}

class Main {
    public static void main(String[] args) {
        Rectangle a = new Rectangle();
        System.out.println(a.width);
    }
}
```

---

### 1. Class Rectangle and Object Creation

Create a class `Rectangle` with two **public** fields: `int width` and `int height`.

Create a second class `Main` with a `main` method where you instantiate a `Rectangle` object named `a`.

Compile and run:

```bash
javac *.java
java Main
```

Immediately print the `width` and `height` of `a`.
Add a comment in your code explaining what values you see and why.

---

### 2. Reference Behavior and Printing Objects

Copy your previous exercise to a new folder `02/`.

Print the rectangle via:

```java
System.out.println(a);
```

Add a comment in your code describing the output and why Java prints that format.

Then create a new variable referring to the same object:

```java
Rectangle b = a;
```

Print `b`. Modify `a.width` and `a.height`, then print `b.width` and `b.height`.
Add a comment in your code explaining what happened and why (object reference behavior).

---

### 3. Instance Method printMe()

Copy your previous exercise to a new folder `03/`.

Add a method:

```java
public void printMe()
```

It prints the rectangle's width and height.
Call it from `main` using `a.printMe()`.

#### Example

```java
a.width = 10;
a.height = 5;
a.printMe();
```

```text
width: 10, height: 5
```

---

### 4. this Reference

Copy your previous exercise to a new folder `04/`.

Add method:

```java
public void whoAmI() {
    System.out.println(this);
}
```

Call it and add a comment in your code explaining what `this` refers to.

---

### 5. Garbage Collection Experiment (Legacy Topic)

Copy your previous exercise to a new folder `05/`.

Create:

```java
Rectangle p = new Rectangle();
System.out.println(p);
p = null;
```

Add a finalizer method:

```java
@Override
protected void finalize() {
    System.out.println("Deleting: " + this);
}
```

Add a helper method in `Main` to trigger GC:

```java
static void runGC() {
    System.gc();
    try { Thread.sleep(1000); } catch(Exception e) {}
}
```

Call `runGC()`. Does `finalize` execute?
Now try:

```java
Rectangle p1 = new Rectangle();
Rectangle p2 = p1;
System.out.println(p1);
p1 = null;
runGC();
```

Add a comment in your code explaining whether the object is destroyed and why.

> Note: `finalize()` is deprecated in modern Java. The purpose of this exercise is to understand that garbage collection exists, not to use `finalize()` in real applications.

---

### 6. Method countSurfaceArea()

Copy your previous exercise to a new folder `06/`.

Add:

```java
public int countSurfaceArea()
```

Return `width * height`. Call the method from `main` and print the result.

#### Example

```java
Rectangle r = new Rectangle();
r.width = 10;
r.height = 5;
System.out.println(r.countSurfaceArea());
```

```text
50
```

---

### 7. Encapsulation: Getters and Setters

Copy your previous exercise to a new folder `07/`.

Make `width` and `height` **private**. Add getters and setters ensuring values are always positive.

Example:

```java
r.setWidth(30);  // valid
r.setWidth(-30); // ignored, value stays 30
```

---

### 8. IllegalArgumentException in Setters

Copy your previous exercise to a new folder `08/`.

Modify setters to throw:

```java
throw new IllegalArgumentException("Width must be positive");
```

Test and also catch exceptions in `main`.

#### What is try-catch?

A try-catch block lets you run code that might fail and handle problems without stopping the entire program.
Inside try, you place the risky code.
Inside catch, you react when an exception occurs, such as logging, adjusting input, or giving feedback to the user.

`IllegalArgumentException` is thrown when a method receives an argument that makes no sense in its expected rules.
Example: passing a negative number to a method that requires a positive one.

Example of catching an exception:

```java
try {
    int result = square(-5);
    System.out.println("Result: " + result);
} catch (IllegalArgumentException e) {
    System.out.println("problem...");
}
```

---

### 9. Constructor

Copy your previous exercise to a new folder `09/`.

Add a constructor:

```java
public Rectangle(int width, int height)
```

Validate parameters (must be > 0). If an invalid value is given, throw `IllegalArgumentException`.

---

### 10. Identity vs Equality

Copy your previous exercise to a new folder `10/`.

Create:

```java
Rectangle r1 = new Rectangle(50, 50);
Rectangle r2 = new Rectangle(50, 50);
```

Compare using `==`. Does it enter the if-block? Add a comment in your code explaining why or why not.

---

### 11. equals Method

Copy your previous exercise to a new folder `11/`.

Implement:

```java
public boolean equals(Rectangle r)
```

Compare width and height. Return `true` if both are equal, `false` otherwise.

#### Example

```java
Rectangle r1 = new Rectangle(50, 50);
Rectangle r2 = new Rectangle(50, 50);
System.out.println(r1.equals(r2));
```

```text
true
```

---

### 12. toString() Override

Copy your previous exercise to a new folder `12/`.

Override `toString()` so that it returns a string with the actual field values.
Test with `System.out.println(r1);`.

#### Example

```java
Rectangle r1 = new Rectangle(50, 50);
System.out.println(r1);
```

```text
width = 50, height = 50
```

---

### 13. countDiagonal()

Copy your previous exercise to a new folder `13/`.

Add a method that computes and returns the diagonal length. Use `Math.sqrt`.

#### Example

```java
Rectangle r = new Rectangle(3, 4);
System.out.println(r.countDiagonal());
```

```text
5.0
```

---

### 14. cloneMe()

Copy your previous exercise to a new folder `14/`.

Create a method that returns a **new instance** with the same width and height values.

#### Example

```java
Rectangle r1 = new Rectangle(50, 50);
Rectangle r2 = r1.cloneMe();
System.out.println(r1 == r2);
System.out.println(r1.equals(r2));
```

```text
false
true
```

---

### 15. Array of Rectangles + User Input

Copy your previous exercise to a new folder `15/`.

Create an array of 10 rectangles.
Ask the user for width and height for each.
Validate input: if the user gives an invalid value (e.g., negative), ask again using a loop.
Calculate and print the total area of all rectangles.

#### Example

```text
Rectangle 1 - Enter width: 10
Rectangle 1 - Enter height: 5
Rectangle 2 - Enter width: 3
Rectangle 2 - Enter height: 4
...
Total area: 62
```

---

### 16. GUI Basics: Swing

Swing is a legacy GUI library. Normally you would use JavaFX for GUI apps, but Swing is better for now for learning purposes of OO.

Create a window with the following:

- Set title in constructor
- Set size
- Make visible
- Add a `JButton`
- Add a text area in center
- Add menu bar: File -> Exit (no functionality required)
- Use a layout (try `BorderLayout`)

Goal: a window with a large text area in the center, a `Clear` button at the top, and a File menu with Exit.

#### Deliverable

Submit the source code files in folder `16/`. Take a **screenshot** of your running application and save it as `screenshot.png` (or `.jpg`) in the same folder.

---

### 17. Composite Rectangle Task

Copy your exercise 14 to a new folder `17/`.

Create a new class that manages several Rectangle objects using an array.

Key ideas for the task:

- The maximum number of rectangles is given when creating the object
- Store rectangles inside an array (not `ArrayList`)
- Provide a way to add rectangles until the array is full
- Compute the total surface area of all stored rectangles
- Find the rectangle with the largest surface area
- Print meaningful information about the stored rectangles if developer wants

Write a demo in main that creates a few rectangles, places them into your structure, and prints:

- Total surface area
- The rectangle with the largest area
- A readable presentation of all stored rectangles

Do not modify the `Rectangle` class. Build a new class that works alongside it.
The goal is to design the structure and logic yourself. Think about the edge cases: when should exceptions be thrown in the class you created?

---

## License

> This work is licensed under the
> **Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License (CC BY-NC-SA 4.0)**
>
> **Additional Restriction:**
> The material may **not** be used, in whole or in part, to **train, fine-tune, prompt, or otherwise feed into any generative artificial intelligence (AI) or machine learning (ML) system**, except for the author.

[Learn more about CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/)
