# Assignment 03

How to return assignments? See instructions in the main [README.md](../README.md)!

## Upload the following Lecture Notes

- `studentnumber-assignment03-lecture01.pdf`
- `studentnumber-assignment03-lecture02.pdf`
- `studentnumber-assignment03-lecture03.pdf`
- `studentnumber-assignment03-lecture04.pdf`

## Points

| Exercise                                                | Points |
| ------------------------------------------------------- | ------ |
| 01: Basic Inheritance (Person/Student)                  | 4      |
| 02: Access Specifiers (Person/Student)                  | 7      |
| 03: Constructors and Base Init (Person/Student/Teacher) | 5      |
| 04: Virtual and Polymorphism (Person/Student/Teacher)   | 9      |
| 05: Abstract Base Class (Person/Student/Teacher)        | 7      |
| 06: Putting It All Together (Mammal/Dog/Cat)            | 7      |
| **Total**                                               | **39** |

## 01: Basic Inheritance (Person/Student)

---

- 📺 Lecture: Inheritance - Main Idea ✏️
  - `studentnumber-assignment03-lecture01.pdf`

- 📺 Lecture: Inheritance - Using const ✏️
  - `studentnumber-assignment03-lecture02.pdf`

---

Goal: Learn public inheritance and reuse base fields and methods.

Work in `01/Person.h`, `01/Person.cpp`, `01/Student.h`, `01/Student.cpp`, and `01/main.cpp`.

1. Create `Person` with `name` and `age` plus getters/setters and `toString()`.
2. Create `Student : public Person` with `studentId` plus getters/setters and `toString()`.
3. In `main`, create a `Person` and a `Student`, print both.

### Deliverable

Submit `01/Person.cpp`, `01/Person.h`, `01/Student.cpp`, `01/Student.h`, `01/main.cpp`.

### Test

Test your app:

```bash
clang++ -std=c++20 01/test.cpp 01/Person.cpp 01/Student.cpp -o 01/test && 01/test
```

| Test             | Points |
| ---------------- | ------ |
| Person toString  | 1      |
| Student toString | 1      |
| Student getters  | 1      |
| Student setters  | 1      |

## 02: Access Specifiers (Person/Student)

---

- 📺 Lecture: Access Specifiers ✏️
  - `studentnumber-assignment03-lecture03.pdf`

---

Goal: Understand how public/protected/private affect access from derived classes and outside code.

Work in `02/Person.h`, `02/Person.cpp`, `02/Student.h`, `02/Student.cpp`, and `02/main.cpp`.

1. Create `Person` with three members at different access levels: `age` (public, default `1`), `id` (protected, default `2`), `name` (private, default `"Alice"`).
2. Add getters for all three in `Person`.
3. Create `Student : public Person` with a method `sumAccessible()` that adds the members it can access directly (`age + id`).
4. In `main`, show which fields can be accessed directly and which require getters.
5. Add a short note in `02.txt` describing which members are accessible in `Student` and why.

### Deliverable

Submit `02/Person.cpp`, `02/Person.h`, `02/Student.cpp`, `02/Student.h`, `02/main.cpp`, and `02/02.txt`.

### Test

Test your app:

```bash
clang++ -std=c++20 02/test.cpp 02/Person.cpp 02/Student.cpp -o 02/test && 02/test
```

| Test                     | Points |
| ------------------------ | ------ |
| Person getter age        | 1      |
| Person getter id         | 1      |
| Person getter name       | 1      |
| Student sums age+id      | 1      |
| Student getter name      | 1      |
| Student uses updated age | 1      |
| 02.txt exists            | 1      |

## 03: Constructors and Base Init (Person/Student/Teacher)

## Member initializer list

Instead of assigning inside the constructor body, initialize members directly with `: member(value)`:

```cpp
// ❌ less preferred — members are default-constructed, then assigned
Shape(string color, int x) {
    this->color = color;
    this->x = x;
}

// ✅ preferred — members are initialized directly
Shape(string color, int x)
    : color(color), x(x)
{}
```

It is the **only way** to initialize `const` members and references.

---

## Inheritance & base constructor

The parent constructor is called in the initializer list, **before** the child's own members:

```cpp
class Circle : public Shape {
    int radius;
public:
    Circle(string color, int radius)
        : Shape(color),   // parent first
          radius(radius)  // then own members
    {}
};
```

### Is the base constructor call mandatory?

| Situation                                  | Required?                                          |
| ------------------------------------------ | -------------------------------------------------- |
| Parent has a default constructor           | No — compiler calls it automatically               |
| Parent has only parameterized constructors | Yes — mandatory                                    |
| Parent has both                            | No — compiler calls the default unless you specify |

```cpp
// Case 1 — not required
class Shape {
public:
    Shape() {}  // default exists
};
class Circle : public Shape {
public:
    Circle() {}  // compiler auto-calls Shape() ✅
};

// Case 2 — mandatory
class Shape {
public:
    Shape(string color) {}  // no default constructor!
};
class Circle : public Shape {
public:
    Circle() : Shape("red") {}  // must call explicitly ✅
    Circle() {}                 // ❌ compile error
};
```

### Exercise

Goal: Learn constructor chaining and base initialization.

Work in `03/Person.h`, `03/Person.cpp`, `03/Student.h`, `03/Student.cpp`, `03/Teacher.h`, `03/Teacher.cpp`, and `03/main.cpp`.

1. Create `Person` with a `name` field, a constructor `Person(const std::string& name)`, `getName()`, `toString()`, and `drink()` that returns `"Drinking water"`.
2. Create `Student : public Person` with `studentId` and a constructor that calls `Person(name)`. Add `getStudentId()`, `toString()`, and `drink()` that returns `"Drinking energy drink"`.
3. Create `Teacher : public Person` with `subject` and a constructor that calls `Person(name)`. Add `getSubject()`, `toString()`, and `drink()` that returns `"Drinking tea"`.
4. In `main`, create a person, student, and teacher, print their `toString()` and `drink()`.

### Deliverable

Submit `03/Person.cpp`, `03/Person.h`, `03/Student.cpp`, `03/Student.h`, `03/Teacher.cpp`, `03/Teacher.h`, `03/main.cpp`.

### Test

Test your app:

```bash
clang++ -std=c++20 03/test.cpp 03/Person.cpp 03/Student.cpp 03/Teacher.cpp -o 03/test && 03/test
```

| Test                       | Points |
| -------------------------- | ------ |
| Person toString and drink  | 1      |
| Student base constructor   | 1      |
| Student toString and drink | 1      |
| Teacher base constructor   | 1      |
| Teacher toString and drink | 1      |

## 04: Virtual and Polymorphism (Person/Student/Teacher)

---

- 📺 Lecture: Virtual Functions and Override ✏️
  - `studentnumber-assignment03-lecture04.pdf`

---

Goal: Learn constructor chaining, method overriding, and polymorphism via virtual functions.

Work in `04/Person.h`, `04/Person.cpp`, `04/Student.h`, `04/Student.cpp`, `04/Teacher.h`, `04/Teacher.cpp`, and `04/main.cpp`.

#### A) Constructors and Base Init

1. Create `Person` with a `name` field, a constructor `Person(const std::string& name)`, `getName()`, and `toString()`.
2. Create `Student : public Person` with `studentId` and a constructor that calls `Person(name)`. Add `getStudentId()` and `toString()`.
3. Create `Teacher : public Person` with `subject` and a constructor that calls `Person(name)`. Add `getSubject()` and `toString()`.

#### B) Override

4. Add a `drink()` method to `Person` returning `"Drinking water"`.
5. Override `drink()` in `Student` to return `"Drinking energy drink"`.
6. Override `drink()` in `Teacher` to return `"Drinking tea"`.
7. In `main`, create a `Student` and assign its address to a `Person*` pointer. Call `drink()` through the pointer. Write in `04b.txt` what happens and why.

#### C) Virtual with Polymorphism

8. Make `drink()` virtual in `Person` and use `override` in derived classes. Add a virtual destructor to `Person`.
9. Call `drink()` through `Person*` pointers again. Write in `04c.txt` what changed and why.

### Deliverable

Submit `04/Person.cpp`, `04/Person.h`, `04/Student.cpp`, `04/Student.h`, `04/Teacher.cpp`, `04/Teacher.h`, `04/main.cpp`, `04/04b.txt`, and `04/04c.txt`.

### Test

Test your app:

```bash
clang++ -std=c++20 04/test.cpp 04/Person.cpp 04/Student.cpp 04/Teacher.cpp -o 04/test && 04/test
```

| Test                      | Points |
| ------------------------- | ------ |
| Student base constructor  | 1      |
| Teacher base constructor  | 1      |
| Person drink              | 1      |
| Student drink             | 1      |
| Teacher drink             | 1      |
| 04b.txt exists            | 1      |
| Polymorphic student drink | 1      |
| Polymorphic teacher drink | 1      |
| 04c.txt exists            | 1      |

## 05: Abstract Base Class (Person/Student/Teacher)

Goal: Learn pure virtual functions and abstract classes.

Work in `05/Person.h`, `05/Person.cpp`, `05/Student.h`, `05/Student.cpp`, `05/Teacher.h`, `05/Teacher.cpp`, and `05/main.cpp`.

1. Create `Person` with a `name` field, `getName()`, a virtual `drink()` returning `"Drinking water"`, a pure virtual method `excuseForBeingLate()`, and a virtual destructor. Person cannot be instantiated.
2. Create `Student : public Person` with `studentId`. Override `drink()` to return `"Drinking energy drink"`. Implement `excuseForBeingLate()` to return `"My alarm didn't go off"`.
3. Create `Teacher : public Person` with `subject`. Override `drink()` to return `"Drinking tea"`. Implement `excuseForBeingLate()` to return `"I was looking for the classroom"`.
4. In `main`, create a `Student` and `Teacher`, assign their addresses to `Person*` pointers, and call `drink()` and `excuseForBeingLate()`.

### Deliverable

Submit `05/Person.cpp`, `05/Person.h`, `05/Student.cpp`, `05/Student.h`, `05/Teacher.cpp`, `05/Teacher.h`, `05/main.cpp`.

### Test

Test your app:

```bash
clang++ -std=c++20 05/test.cpp 05/Person.cpp 05/Student.cpp 05/Teacher.cpp -o 05/test && 05/test
```

| Test                      | Points |
| ------------------------- | ------ |
| Person is abstract        | 1      |
| Student drink             | 1      |
| Teacher drink             | 1      |
| Polymorphic student drink | 1      |
| Polymorphic teacher drink | 1      |
| Student excuse            | 1      |
| Teacher excuse            | 1      |

## 06: Putting It All Together (Mammal/Dog/Cat)

Goal: Combine inheritance, access specifiers, constructor chaining, abstract classes, and polymorphism.

Work in `06/Mammal.h`, `06/Mammal.cpp`, `06/Dog.h`, `06/Dog.cpp`, `06/Cat.h`, `06/Cat.cpp`, and `06/main.cpp`.

1. Create an abstract `Mammal` class with a private `name` field, `getName()`/`setName()`, a pure virtual `makeSound()`, and a virtual destructor.
2. Create `Dog : public Mammal`. The constructor takes `name` and calls `Mammal(name)`. Implement `makeSound()` returning `"Woof"`.
3. Create `Cat : public Mammal`. The constructor takes `name` and calls `Mammal(name)`. Implement `makeSound()` returning `"Meow"`.
4. In `main`, create a `Dog` and `Cat`, assign their addresses to `Mammal*` pointers, and call `makeSound()`.

### Deliverable

Submit `06/Mammal.cpp`, `06/Mammal.h`, `06/Dog.cpp`, `06/Dog.h`, `06/Cat.cpp`, `06/Cat.h`, `06/main.cpp`.

### Test

Test your app:

```bash
clang++ -std=c++20 06/test.cpp 06/Mammal.cpp 06/Dog.cpp 06/Cat.cpp -o 06/test && 06/test
```

| Test                  | Points |
| --------------------- | ------ |
| Mammal is abstract    | 1      |
| Dog makeSound         | 1      |
| Dog getName           | 1      |
| Cat makeSound         | 1      |
| Cat getName           | 1      |
| Polymorphic dog sound | 1      |
| Polymorphic cat sound | 1      |
