# Introduction to Python Programming

---

<!-- TOC tocDepth:2..3 chapterDepth:2..6 -->

- [Welcome!](#welcome)
- [What is Python?](#what-is-python)
- [Your First Python Program](#your-first-python-program)
- [️ The `print()` Function](#️-the-print-function)
  - [Advanced print options:](#advanced-print-options)
- [Types](#types)
- [Variables and `type()`](#variables-and-type)
- [Strings in Python](#strings-in-python)
  - [String literals:](#string-literals)
  - [Access characters and length:](#access-characters-and-length)
  - [Formatted strings (f-strings):](#formatted-strings-f-strings)
- [User Input with `input()`](#user-input-with-input)
- [Type Casting](#type-casting)
- [Memory Address: `id()`](#memory-address-id)
- [Control Flow: `if`, `elif`, `else`](#control-flow-if-elif-else)
  - [Basic Structure](#basic-structure)
  - [Simple Example](#simple-example)
- [Comparison Operators](#comparison-operators)
- [Multiple Conditions with Logic Operators](#multiple-conditions-with-logic-operators)
- [Nested `if` Statements](#nested-if-statements)
- [Summary of control structures](#summary-of-control-structures)
- [Python Loops: `while` and `for`](#python-loops-while-and-for)
  - [`while` Loop – Repeat While Condition is True](#while-loop-–-repeat-while-condition-is-true)
  - [Using `continue` in `while`](#using-continue-in-while)
  - [`for` Loop – Iterate Over Items](#for-loop-–-iterate-over-items)
  - [Summary](#summary)
  - [`break` and `continue`](#break-and-continue)
- [Functions](#functions)
  - [What is a Function?](#what-is-a-function)
  - [Why Use Functions?](#why-use-functions)
- [Collections Overview](#collections-overview)
  - [Lists](#lists)
  - [Tuples](#tuples)
  - [Sets](#sets)
  - [Dictionaries](#dictionaries)
  - [Summary Table](#summary-table)

<!-- /TOC -->

---

## Welcome!

- No previous coding experience needed!
- Today you’ll learn:
  - What Python is
  - How to write simple programs
  - Key concepts: variables, data types, control flow, functions, input/output, and collections

---

## What is Python?

- Python is a **popular, easy-to-read** programming language.
- Used in:
  - Web development
  - Data science
  - AI & machine learning
  - Automation
- Python code looks like plain English.
- Current version: **Python 3.12**

---

## Your First Python Program

```python
print("Hello, world!")
```

- `print()` shows text on the screen
- Strings are inside quotes `"..."`
- Run your app
  - Open VS Code
  - Create new file `code.py`
  - Save file to some directory
  - Open command prompt and go the directory: `cd <path to your dir>`
  - Run your app `python code.py`

---

## ️ The `print()` Function

```python
print("Hello", "world")
print("Age:", 25)
print("Sum:", 2 + 3)
```

### Advanced print options:

```python
print("A", "B", "C", sep="-")  # A-B-C
print("No newline", end="...")
print("Continued")
```

---

## Types

| **Category**         | **Type**    | **Description**                              | **Example**                |
| -------------------- | ----------- | -------------------------------------------- | -------------------------- |
| **Basic Data Types** | `int`       | Integer numbers                              | `x = 42`                   |
|                      | `float`     | Floating-point numbers                       | `x = 3.14`                 |
|                      | `complex`   | Complex numbers                              | `x = 2 + 3j`               |
|                      | `bool`      | Boolean values                               | `x = True`                 |
|                      | `str`       | Text strings                                 | `x = "hello"`              |
| **Sequence Types**   | `list`      | Mutable ordered collection                   | `x = [1, 2, 3]`            |
|                      | `tuple`     | Immutable ordered collection                 | `x = (1, 2, 3)`            |
|                      | `range`     | Sequence of numbers                          | `x = range(5)`             |
| **Set Types**        | `set`       | Mutable unordered collection of unique items | `x = {1, 2, 3}`            |
|                      | `frozenset` | Immutable version of a set                   | `x = frozenset([1, 2, 3])` |
| **Mapping Type**     | `dict`      | Key-value mapping                            | `x = {"a": 1, "b": 2}`     |

---

## Variables and `type()`

```python
name = "Alice"
age = 30
is_admin = True

print(type(name))      # <class 'str'>
print(type(age))       # <class 'int'>
print(type(is_admin))  # <class 'bool'>
```

---

## Strings in Python

### String literals:

```python
a = 'single quotes'
b = "double quotes"
c = '''triple quotes for
          multi-line
       strings'''
```

### Access characters and length:

```python
text = "Python"
print(text[0])       # 'P'
print(len(text))     # 6
```

### Formatted strings (f-strings):

```python
name = "Alice"
age = 30
print(f"My name is {name} and I am {age} years old.")
```

---

## User Input with `input()`

- The `input()` function is used to read user input from the command line. It always returns the user input as a string, even if the input looks like a number.

```python
variable = input("Prompt message: ")
```

- The "Prompt message" is optional and will be shown before waiting for user input.
- Note: `input()` always returns a string:

```python
age = input("How old are you? ")
print(type(age))  # Always <class 'str'>, even if you type "25"
```

- Another example:

```python
name = input("Enter your name: ")
print(f"Hello, {name}!")
```

- Common error:

```python
# This will cause an error if input is not a number
number = int(input("Enter a number: "))
```

- To avoid errors, always validate user input if needed:

```python
user_input = input("Enter a number: ")

if user_input.isdigit():
    number = int(user_input)
    print("You entered:", number)
else:
    print("That's not a valid number.")
```

---

## Type Casting

```python
x = "5"
y = int(x) + 10
print(y)  # 15

a = float("3.14")
b = str(42)
c = bool("non-empty")
```

---

## Memory Address: `id()`

```python
x = 100
print(id(x))  # Shows memory address
```

---

## Control Flow: `if`, `elif`, `else`

Control flow allows your program to **make decisions**. In Python, you use `if`, `elif` (else if), and `else` to run different blocks of code based on conditions.

---

### Basic Structure

```python
if condition1:
    # Run this block if condition1 is True
elif condition2:
    # Run this block if condition1 is False AND condition2 is True
else:
    # Run this block if all above conditions are False
```

- Each condition must be an **expression that evaluates to True or False**.
- Use **indentation** (typically 4 spaces) instead of `{}`.
- You can have **zero or many `elif`**, but only **one `else`** at the end.

---

### Simple Example

```python
temperature = 25

if temperature > 30:
    print("It's hot!")
elif temperature > 20:
    print("Nice weather.")
else:
    print("It's a bit chilly.")
```

Output:

```
Nice weather.
```

- Note: `elif` and `else` are here optional!

---

## Comparison Operators

| Operator | Meaning          | Example  |
| -------- | ---------------- | -------- |
| `==`     | Equal to         | `x == 5` |
| `!=`     | Not equal to     | `x != 5` |
| `>`      | Greater than     | `x > 5`  |
| `<`      | Less than        | `x < 5`  |
| `>=`     | Greater or equal | `x >= 5` |
| `<=`     | Less or equal    | `x <= 5` |

---

## Multiple Conditions with Logic Operators

```python
x = 10

if x > 5 and x < 20:
    print("x is between 5 and 20")
```

```python
y = 15

if y < 10 or y > 12:
    print("y is outside 10-12 range")
```

```python
logged_in = True

if not logged_in:
    print("Please log in.")
```

### Python vs Java:

| Python Expression    | Java Equivalent                     | Meaning                                |
| -------------------- | ----------------------------------- | -------------------------------------- |
| `9 <= hour <= 17`    | `hour >= 9 && hour <= 17`           | `hour` is between 9 and 17 (inclusive) |
| `1 < x < 10`         | `x > 1 && x < 10`                   | `x` is greater than 1 and less than 10 |
| `a == b == c`        | `a == b && b == c`                  | All three variables are equal          |
| `x != y != z`        | `x != y && y != z`                  | `x`, `y`, and `z` are all different    |
| `not (x == y)`       | `!(x == y)`                         | `x` is not equal to `y`                |
| `x in [1, 2, 3]`     | `Arrays.asList(1,2,3).contains(x)`  | `x` is in the list                     |
| `x not in [1, 2, 3]` | `!Arrays.asList(1,2,3).contains(x)` | `x` is not in the list                 |
| `if x:`              | `if (x != 0)` or `if (x != null)`   | Truthy check                           |

---

## Nested `if` Statements

```python
age = 25
has_ticket = True

if age >= 18:
    if has_ticket:
        print("Entry allowed.")
    else:
        print("Ticket required.")
else:
    print("You must be 18 or older.")
```

---

## Summary of control structures

- Use `if` to check a condition.
- Use `elif` for extra conditions.
- Use `else` as a fallback.
- Combine with `and`, `or`, `not` for more complex logic.
- Indentation is critical!

---

## Python Loops: `while` and `for`

Loops allow you to **repeat blocks of code**. Python supports two main types:

- `while` loop: Repeats while a condition is `True`
- `for` loop: Iterates over items in a sequence like a list or range

---

### `while` Loop – Repeat While Condition is True

#### Syntax

```python
while condition:
    # code block
```

- The condition is checked **before** each iteration.
- If the condition becomes `False`, the loop stops.
- Make sure the loop has an **exit condition**, or it will run forever.

---

#### Example 1: Count to 4

```python
i = 1
while i <= 4:
    print(i)
    i += 1
```

Output:

```
1
2
3
4
```

---

#### Example 2: Infinite Loop (️)

```python
while True:
    print("This goes on forever!")
```

Press Ctrl+C to stop it in terminal.

---

#### Using `break` in `while`

```python
x = 0
while True:
    print(x)
    x += 1
    if x > 5:
        break
```

---

### Using `continue` in `while`

```python
i = 0
while i < 5:
    i += 1
    if i == 3:
        continue
    print(i)
```

Output:

```
1
2
4
5
```

---

### `for` Loop – Iterate Over Items

#### Syntax

```python
for item in iterable:
    # code block
```

- Loops over each item in a **sequence** (like a list, tuple, string, or range).
- You don't need an index unless you want one explicitly.

---

#### Example 1: Loop Over List

```python
fruits = ["apple", "banana", "cherry"]

for fruit in fruits:
    print(fruit)
```

---

#### Example 2: Loop Over String

```python
for char in "Python":
    print(char)
```

---

#### Example 3: Using `range()`

```python
for i in range(3):
    print(i)
```

Output:

```
0
1
2
```

```python
for i in range(1, 6):
    print(i)
```

Output:

```
1
2
3
4
5
```

---

#### Using `break` in `for`

```python
for i in range(10):
    if i == 4:
        break
    print(i)
```

---

#### Using `continue` in `for`

```python
for i in range(5):
    if i == 2:
        continue
    print(i)
```

Output:

```
0
1
3
4
```

---

### Summary

| Feature    | `while` Loop              | `for` Loop                       |
| ---------- | ------------------------- | -------------------------------- |
| Best for   | Unknown number of repeats | Known number or iterable         |
| Condition  | Checked before each loop  | Loops over sequence or range     |
| Common use | Waiting for user input    | Iterating lists, strings, ranges |

Both loop types support `break` (stop loop) and `continue` (skip current iteration).

---

### `break` and `continue`

```python
for i in range(5):
    if i == 3:
        break
    print(i)
```

```python
for i in range(5):
    if i == 2:
        continue
    print(i)
```

---

## Functions

### What is a Function?

- A **function** is a reusable block of code that performs a specific task.
- Functions help you avoid repeating code and make your programs easier to read and maintain.

---

### Why Use Functions?

- **Reusability**: Write once, use many times.
- **Organization**: Break large problems into smaller parts.
- **Readability**: Code becomes easier to understand.
- **Debugging**: Easier to test and fix issues in isolated blocks.

---

#### Defining a Function

- Use the `def` keyword followed by the function name and parentheses.
- Example:

```python
def greet():
    print("Hello, world!")
```

---

#### Calling a Function

- You run (or "call") a function by using its name followed by parentheses:

```python
greet()  # Output: Hello, world!
```

---

#### Function with Parameters

- Parameters allow you to pass information into a function:

```python
def greet(name):
    print(f"Hello, {name}!")
```

```python
greet("Alice")  # Output: Hello, Alice!
```

---

#### Function with Return Value

- Functions can **return** results using the `return` keyword:

```python
def add(a, b):
    return a + b
```

```python
result = add(2, 3)
print(result)  # Output: 5
```

---

#### Default Parameters

- You can give default values to parameters:

```python
def greet(name="stranger"):
    print(f"Hello, {name}!")
```

```python
greet()         # Output: Hello, stranger!
greet("Alice")  # Output: Hello, Alice!
```

---

#### Keyword Arguments

- You can name arguments when calling the function:

```python
def subtract(a, b):
    return a - b

print(subtract(b=5, a=10))  # Output: 5
```

---

#### Summary

- Functions = named blocks of code.
- Use `def` to define, `()` to call.
- Can have parameters and return values.
- Help make your code DRY (Don't Repeat Yourself).

---

## Collections Overview

### Lists

- A **list** is like a dynamic array – it can grow or shrink.
- Elements are ordered and mutable (can be changed).
- Indexing starts from `0`.

```python
fruits = ["apple", "banana", "cherry"]
fruits.append("orange")      # Add new item
print(fruits[0])             # Access first item
fruits[1] = "blueberry"      # Modify an item
print(fruits)                # ['apple', 'blueberry', 'cherry', 'orange']
```

#### Useful Methods with Examples:

```python
numbers = [3, 1, 4, 1, 5]

numbers.append(9)            # [3, 1, 4, 1, 5, 9]
numbers.remove(1)            # Removes first 1 → [3, 4, 1, 5, 9]
numbers.sort()               # [1, 3, 4, 5, 9]
total = sum(numbers)         # 22
length = len(numbers)        # 5
print(numbers[2])            # 4
print(3 in numbers)          # True
```

---

### Tuples

- A **tuple** is like a list, but **immutable** – cannot be changed after creation.
- Used for fixed data structures (e.g., coordinates, settings).
- Supports unpacking.

```python
point = (10, 20)
x, y = point
print(x, y)  # 10 20

# point[0] = 100  # ❌ Error: Tuples can't be changed
```

#### Operations with Examples:

```python
coords = (1, 2, 3)
print(coords[1])             # 2

a, b, c = coords             # unpacking
print(a, b, c)               # 1 2 3
```

---

### Sets

- A **set** is an unordered collection of unique items.
- Automatically removes duplicates.
- Fast membership testing.

```python
unique_numbers = {1, 2, 3, 2, 1}
print(unique_numbers)        # {1, 2, 3}
unique_numbers.add(4)
print(3 in unique_numbers)   # True
```

#### Operations with Examples:

```python
a = {1, 2, 3}
b = {3, 4, 5}

a.add(6)                     # {1, 2, 3, 6}
a.remove(2)                  # {1, 3, 6}
a.discard(10)                # Safe removal (no error)

union = a | b                # {1, 3, 4, 5, 6}
intersection = a & b         # {3}
difference = a - b           # {1, 6}
```

---

### Dictionaries

- A **dictionary** stores data as key-value pairs.
- Keys must be unique and immutable (usually strings or numbers).

```python
person = {"name": "Alice", "age": 30}
print(person["name"])        # Alice
person["age"] = 31           # Update value
person["job"] = "Engineer"   # Add new key-value pair
print(person)
```

#### Useful Methods and Syntax with Examples:

```python
person = {"name": "Bob", "city": "Paris"}

print(person["city"])        # Paris
print(person.get("age"))     # None

person["age"] = 45
print(person.items())        # dict_items([('name', 'Bob'), ('city', 'Paris'), ('age', 45)])
print(person.keys())         # dict_keys(['name', 'city', 'age'])
print(person.values())       # dict_values(['Bob', 'Paris', 45])
```

---

### Summary Table

| Type       | Ordered | Mutable | Duplicates | Syntax          | Example             |
| ---------- | ------- | ------- | ---------- | --------------- | ------------------- |
| List       | ✅      | ✅      | ✅         | `[]`            | `["a", "b", "c"]`   |
| Tuple      | ✅      | ❌      | ✅         | `()`            | `("x", "y")`        |
| Set        | ❌      | ✅      | ❌         | `{}` or `set()` | `{1, 2, 3}`         |
| Dictionary | ❌      | ✅      | Keys: ❌   | `{key: value}`  | `{"name": "Alice"}` |

---
