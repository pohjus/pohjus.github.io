# Assignment 08

## Points Overview

| Exercise | Description | Points |
|----------|-------------|--------|
| 01 | Human class with basic methods | 3 |
| 02 | Programmer extends Human | 3 |
| 03 | Name field with getters and setters | 3 |
| 04 | Constructors and `super` | 3 |
| 05 | Programmer salary validation | 3 |
| 06 | Programmer constructor with salary | 2 |
| 07 | `printInfo()` in Human and Programmer | 2 |
| 08 | Abstract class `Mammal` | 2 |
| 09 | Human and Dog inherit from Mammal | 2 |
| 10 | Abstract method `makeSound()` | 2 |
| 11 | Interface `Sellable` | 2 |
| 12 | Method parameter typed as `Sellable` | 2 |
| **Total** | | **29** |

This assignment focuses on inheritance, constructors, overriding,
abstract classes, and interfaces.

## Required Video Notes

Submit the following handwritten video notes with this assignment:

- `studentnumber-assignment08-video01.pdf`
- `studentnumber-assignment08-video02.pdf`
- `studentnumber-assignment08-video03.pdf`
- `studentnumber-assignment08-video04.pdf`
- `studentnumber-assignment08-video05.pdf`

## Directory Structure

Create each exercise in its own folder:

```text
assignment08/01/Main.java
assignment08/01/Human.java
assignment08/02/Main.java
assignment08/02/Human.java
assignment08/02/Programmer.java
...
assignment08/nn/Main.java
```

Use the concepts we've covered in class: **don't use advanced
features**, even if you already know them.

See the [course README](../README.md) for tool setup, AI policy, and
installation instructions.

## Testing

Each exercise has a `Test.java` file that automatically checks your
solution.
The test file runs your program as a separate process and verifies
its behavior.

### Step-by-step

1. Write your solution and place it in the correct exercise folder
   (for example `assignment08/01/`).
2. Keep the `Test.java` file in the same folder as the source files.
3. Open a terminal and navigate to the exercise folder.
4. Run the test:

```bash
java Test.java
```

---

## Inheritance

- [Learn Java inheritance in 9 minutes! (video)](https://www.youtube.com/watch?v=23HFxAPyJ9U&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=44) - submit `studentnumber-assignment08-video01.pdf`

### Example

```java
class Shape {
    public int xPos;
    public int yPos;
}

// Circle now has xPos, yPos and radius
class Circle extends Shape {
    public int radius;
}
```

### 1. Human Class with Basic Methods

Implement a class `Human`. The `Human` class has the methods:

```java
public void sleep();
public void eat();
public void drink();
public void reproduce();
```

The methods print to the screen:
`Human drinks`, `Human eats`, `Human sleeps`, and
`Human reproduces`.

Create another class `Main`, whose `main` method creates a couple of
`Human` objects and calls these methods.

Submit `Human.java` and `Main.java`.

---

### 2. Programmer Extends Human

Create a class `Programmer` that extends `Human`.
Add the methods:

```java
public void attendCyberGothDanceParty();
public void code();
```

The methods print simple text such as `Programmer codes`.

Now create a `Programmer` object in `Main` and call its methods:
`sleep`, `eat`, `drink`, `reproduce`, `code`, and
`attendCyberGothDanceParty`.

Submit `Human.java`, `Programmer.java`, and `Main.java`.

---

### 3. Name Field with Getters and Setters

Add the attribute `private String name` to the `Human` class.
Implement setter and getter methods:

```java
public void setName(String n);
public String getName();
```

Set names for humans and programmers.

Modify the `Human` class so that its methods always print the person's
name.

Example:

```text
Human drinks
```

becomes:

```text
Tapani drinks
```

Submit updated `Human.java`, `Programmer.java`, and `Main.java`.

---

## Constructors

### 4. Constructors and `super`

- [Learn the Java super keyword in 10 minutes! (video)](https://www.youtube.com/watch?v=23HFxAPyJ9U&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=45) - submit `studentnumber-assignment08-video02.pdf`

Add a constructor to `Human`:

```java
public Human(String n)
```

The constructor receives the person's name and initializes the
`name` attribute.

Think about:

- Why does the `Programmer` class not compile now?

Note that Java adds a default constructor to a class if you do not
create one yourself.

Add a constructor to `Programmer`:

```java
public Programmer(String n)
```

Pass `n` to the superclass constructor using `super`.

Test now by creating `Human` and `Programmer` objects while giving names
directly to the constructor:

```java
Human tiina = new Human("Tiina");
Programmer hanna = new Programmer("Hanna");
```

Submit updated `Human.java`, `Programmer.java`, and `Main.java`.

---

### 5. Programmer Salary Validation

Add the attribute `int salary` to the `Programmer` class.
Implement getter and setter:

```java
public void setSalary(int s);
public int getSalary();
```

Ensure the salary must be between `1000` and `10000`.
Otherwise throw `IllegalArgumentException`.

Test the method.

Submit updated `Programmer.java` and `Main.java`.

---

### 6. Programmer Constructor with Salary

Modify the `Programmer` constructor so that it takes name and salary:

```java
public Programmer(String n, int s)
```

Pass `n` to the superclass and initialize the `salary` attribute with
`s`.

Example:

```java
Programmer hanna = new Programmer("Tapani", 3000);
System.out.println(hanna.getSalary());
```

Submit updated `Human.java`, `Programmer.java`, and `Main.java`.

---

## Overriding

### 7. `printInfo()` in Human and Programmer

- [Learn Java METHOD OVERRIDING in 4 minutes! (video)](https://www.youtube.com/watch?v=23HFxAPyJ9U&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=46) - submit `studentnumber-assignment08-video03.pdf`

Add the method `printInfo()` to the `Human` class.
The method prints the person's name.

Add the same method to `Programmer`.
The method prints the programmer's name and salary.
Use superclass functionality with `super.printInfo()`.

Example:

```java
hanna.printInfo();  // name + salary, hanna is a programmer
tiina.printInfo();  // name, tiina is a human
```

Submit updated `Human.java`, `Programmer.java`, and `Main.java`.

---

## Abstract Classes

### 8. Abstract Class `Mammal`

- [Learn Java abstraction in 9 minutes! (video)](https://www.youtube.com/watch?v=23HFxAPyJ9U&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=48) - submit `studentnumber-assignment08-video04.pdf`

Implement the abstract class `Mammal`:

```java
abstract class Mammal {

}
```

Try to create an object from this class.

Think about:

- Why does it not compile?

Add the method `giveBirth()` to the class.
The method prints:

```text
gives birth to a child.
```

Create class `Dog`, which extends `Mammal`.
Create a `Dog` object and call its `giveBirth()` method.

Submit `Mammal.java`, `Dog.java`, and `Main.java`.

---

### 9. Human and Dog Inherit from Mammal

Implement class `Human` so that it extends `Mammal`.
`Human` has method `createArt()` that prints:

```text
creates art
```

Implement for `Dog` method `sniffButt()` that prints:

```text
sniffs another dog's butt
```

Test by creating `Human` and `Dog` objects and calling their methods.

Submit updated `Mammal.java`, `Human.java`, `Dog.java`, and `Main.java`.

---

### 10. Abstract Method `makeSound()`

Add the abstract method `makeSound()` to `Mammal`:

```java
abstract class Mammal {
    abstract void makeSound();
}
```

Think about:

- Why does it no longer compile?

Implement the abstract method in subclasses.

Test.

Submit updated `Mammal.java`, `Human.java`, `Dog.java`, and `Main.java`.

---

## Interfaces

### Template

```java
interface Flyable {
    public void fly();
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("bird flies");
    }
}
```

### 11. Interface `Sellable`

- [Learn INTERFACES in 6 minutes! (video)](https://www.youtube.com/watch?v=23HFxAPyJ9U&list=PLZPZq0r_RZOOj_NOZYq_R2PECIMglLemc&index=49) - submit `studentnumber-assignment08-video05.pdf`

Implement the interface `Sellable`, which has one method `sell()`.
Create class `EnergyDrink` that implements `Sellable`.
Print `energy drink sold` in the method.

Example:

```java
EnergyDrink ed = new EnergyDrink();
ed.sell(); // energy drink sold
```

Also make `Dog` implement `Sellable` and print `dog sold`.

Submit `Sellable.java`, `EnergyDrink.java`, updated `Dog.java`, and
`Main.java`.

---

### 12. Method Parameter Typed as `Sellable`

Use the following structure:

```java
class Main {
    public static void main(String[] args) {

    }

    public static void method(Sellable a) {

    }
}
```

Which objects can you pass?
Test.

Submit a `Main.java` that demonstrates the allowed calls.

---

## License

> This work is licensed under the
> **Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License (CC BY-NC-SA 4.0)**
>
> **Additional Restriction:**
> The material may **not** be used, in whole or in part, to **train, fine-tune, prompt, or otherwise feed into any generative artificial intelligence (AI) or machine learning (ML) system**, except for the author.

[Learn more about CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/)
