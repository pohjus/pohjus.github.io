# Assignment 07

## Points Overview

| Exercise | Description | Points |
|----------|-------------|--------|
| 01 | Class Rectangle and Object Creation | 5 |
| 02 | Reference Behavior and Printing Objects | 4 |
| 03 | Instance Method printMe() | 3 |
| 04 | Method countSurfaceArea() | 4 |
| 05 | Encapsulation: Getters and Setters | 6 |
| 06 | IllegalArgumentException in Setters | 5 |
| 07 | Constructor | 4 |
| 08 | toString() Override | 2 |
| 09 | equals Method | 3 |
| 10 | Array of Rectangles + User Input | 4 |
| **Total** | | **40** |

## Required Video Notes

Submit the following handwritten video notes with this assignment:

- `notes/video01.pdf`
- `notes/video02.pdf`
- `notes/video03.pdf`
- `notes/video04.pdf`
- `notes/video05.pdf`

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

See the shared testing instructions in the
[course README](../README.md#testing-assignments).

---

## From `void main()` to Classes

In earlier assignments, you used the simpler Java 25 beginner syntax:

```java
void main() {
    IO.println("Hello");
}
```

That syntax hides some of the usual Java structure. In traditional
Java, the same idea is written like this:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
```

So when you wrote `void main() { ... }`, Java was hiding the surrounding
`public class Main { ... }` structure for you.

In this assignment, that hidden structure becomes visible because you
are now learning **classes** and **objects**. From this point on, you
will often write your own classes such as `Rectangle`, and you may have
more than one `.java` file in the same exercise.

Short version:

- earlier assignments used simplified beginner syntax
- this assignment uses the full class-based Java syntax
- `Main` is the class that contains the starting point of the program
- other classes such as `Rectangle` define your own objects

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

- 📺 [Learn Java Object Oriented Programming in 10 minutes! (video)](https://www.youtube.com/watch?v=DYbi93vuSaU&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=39) (length: 9:51) - submit 📝 `notes/video01.pdf`

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

### 4. Method countSurfaceArea()

Copy your previous exercise to a new folder `04/`.

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

### 5. Encapsulation: Getters and Setters

- 📺 [Learn Java getters and setters in 10 minutes! (video)](https://www.youtube.com/watch?v=OjrR_C_UPjc&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=52) (length: 10:06) - submit 📝 `notes/video02.pdf`

Copy your previous exercise to a new folder `05/`.

Make `width` and `height` **private**. Add getters and setters ensuring values are always positive.

Example:

```java
r.setWidth(30);  // valid
r.setWidth(-30); // ignored, value stays 30
```

---

### 6. IllegalArgumentException in Setters

Copy your previous exercise to a new folder `06/`.

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

### 7. Constructor

- 📺 [Learn CONSTRUCTORS in 10 minutes! (video)](https://www.youtube.com/watch?v=ZD7CB6wKg8A&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=40) (length: 10:07) - submit 📝 `notes/video03.pdf`

Copy your previous exercise to a new folder `07/`.

Add a constructor:

```java
public Rectangle(int width, int height)
```

Validate parameters (must be > 0). If an invalid value is given, throw `IllegalArgumentException`.

---

### 8. toString() Override

- 📺 [Learn the toString() method in 5 minutes! (video)](https://www.youtube.com/watch?v=u3BGdOunOTI&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=47) (length: 5:52) - submit 📝 `notes/video04.pdf`

Copy your previous exercise to a new folder `08/`.

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

### 9. equals Method

Copy your previous exercise to a new folder `09/`.

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

### 10. Array of Rectangles + User Input

- 📺 [Learn Java ARRAY OF OBJECTS in 5 minutes! (video)](https://www.youtube.com/watch?v=cMJeCs0n6BY&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=42) (length: 5:46) - submit 📝 `notes/video05.pdf`

Copy your previous exercise to a new folder `10/`.

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

## License

> This work is licensed under the
> **Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License (CC BY-NC-SA 4.0)**
>
> **Additional Restriction:**
> The material may **not** be used, in whole or in part, to **train, fine-tune, prompt, or otherwise feed into any generative artificial intelligence (AI) or machine learning (ML) system**, except for the author.

[Learn more about CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/)
