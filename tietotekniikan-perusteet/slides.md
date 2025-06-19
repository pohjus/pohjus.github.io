# 🐍 Introduction to Python Programming

---

## 👋 Welcome!

- No previous coding experience needed!
- Today you’ll learn:
  - What Python is
  - How to write simple programs
  - Key concepts: variables, data types, control flow, functions, input/output, and collections

---

## 🔧 What is Python?

- Python is a **popular, easy-to-read** programming language.
- Used in:
  - Web development
  - Data science
  - AI & machine learning
  - Automation
- Python code looks like plain English.
- Current version: **Python 3.12**

---

## 🚀 Your First Python Program

```python
print("Hello, world!")
```

- `print()` shows text on the screen
- Strings are inside quotes `"..."`

---

## 🖨️ The `print()` Function

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

## 🧠 Variables and `type()`

```python
name = "Alice"
age = 30
is_admin = True

print(type(name))      # <class 'str'>
print(type(age))       # <class 'int'>
print(type(is_admin))  # <class 'bool'>
```

---

## 🔤 Strings in Python

### String literals:

```python
a = 'single quotes'
b = "double quotes"
c = '''triple quotes for multi-line strings'''
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

## ⌨️ User Input with `input()`

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

## 🔁 Type Casting

```python
x = "5"
y = int(x) + 10
print(y)  # 15

a = float("3.14")
b = str(42)
c = bool("non-empty")
```

---

## 🆔 Memory Address: `id()`

```python
x = 100
print(id(x))  # Shows memory address
```

---

## 🔂 Control Flow: `if`, `elif`, `else`

Control flow allows your program to **make decisions**. In Python, you use `if`, `elif` (else if), and `else` to run different blocks of code based on conditions.

---

### ✅ Basic Structure

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

### 🔍 Simple Example

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

---

## 🧠 Comparison Operators

| Operator | Meaning          | Example  |
| -------- | ---------------- | -------- |
| `==`     | Equal to         | `x == 5` |
| `!=`     | Not equal to     | `x != 5` |
| `>`      | Greater than     | `x > 5`  |
| `<`      | Less than        | `x < 5`  |
| `>=`     | Greater or equal | `x >= 5` |
| `<=`     | Less or equal    | `x <= 5` |

---

## 🧩 Multiple Conditions with Logic Operators

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

---

## 🧪 Nested `if` Statements

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

## 🎯 Recap

- Use `if` to check a condition.
- Use `elif` for extra conditions.
- Use `else` as a fallback.
- Combine with `and`, `or`, `not` for more complex logic.
- Indentation is critical!

---

---

## 🔁 Python Loops: `while` and `for`

Loops allow you to **repeat blocks of code**. Python supports two main types:

- `while` loop: Repeats while a condition is `True`
- `for` loop: Iterates over items in a sequence like a list or range

---

### 🔄 `while` Loop – Repeat While Condition is True

#### ✅ Syntax

```python
while condition:
    # code block
```

- The condition is checked **before** each iteration.
- If the condition becomes `False`, the loop stops.
- Make sure the loop has an **exit condition**, or it will run forever.

---

#### 🔍 Example 1: Count to 4

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

#### 🔍 Example 2: Infinite Loop (⚠️)

```python
while True:
    print("This goes on forever!")
```

Press Ctrl+C to stop it in terminal.

---

#### 🔄 Using `break` in `while`

```python
x = 0
while True:
    print(x)
    x += 1
    if x > 5:
        break
```

---

### 🔄 Using `continue` in `while`

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

### 🔁 `for` Loop – Iterate Over Items

#### ✅ Syntax

```python
for item in iterable:
    # code block
```

- Loops over each item in a **sequence** (like a list, tuple, string, or range).
- You don't need an index unless you want one explicitly.

---

#### 🔍 Example 1: Loop Over List

```python
fruits = ["apple", "banana", "cherry"]

for fruit in fruits:
    print(fruit)
```

---

#### 🔍 Example 2: Loop Over String

```python
for char in "Python":
    print(char)
```

---

#### 🔍 Example 3: Using `range()`

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

#### 🔄 Using `break` in `for`

```python
for i in range(10):
    if i == 4:
        break
    print(i)
```

---

#### 🔄 Using `continue` in `for`

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

### 🎯 Summary

| Feature    | `while` Loop              | `for` Loop                       |
| ---------- | ------------------------- | -------------------------------- |
| Best for   | Unknown number of repeats | Known number or iterable         |
| Condition  | Checked before each loop  | Loops over sequence or range     |
| Common use | Waiting for user input    | Iterating lists, strings, ranges |

Both loop types support `break` (stop loop) and `continue` (skip current iteration).

---

### 🔁 `break` and `continue`

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

## 🧰 Functions

```python
def greet(name):
    print(f"Hello, {name}")

greet("Alice")
```

### Return values:

```python
def add(a, b):
    return a + b

result = add(3, 4)
print(result)
```

---

## 📦 Collections Overview

| Type       | Example            |
| ---------- | ------------------ |
| List       | `[1, 2, 3]`        |
| Tuple      | `(1, 2, 3)`        |
| Set        | `{1, 2, 3}`        |
| Dictionary | `{"a": 1, "b": 2}` |

---

## 📋 Lists

```python
fruits = ["apple", "banana", "cherry"]
fruits.append("orange")
print(fruits[0])
```

---

## 📚 Tuples

```python
point = (10, 20)
x, y = point
print(x, y)
```

---

## 🔢 Sets

```python
unique_numbers = {1, 2, 3, 2}
print(unique_numbers)  # {1, 2, 3}
```

---

## 📖 Dictionaries

```python
person = {"name": "Alice", "age": 30}
print(person["name"])
```

---

## 🎉 Recap

- Python is readable and beginner-friendly
- You’ve learned:
  - Syntax, print, input, variables
  - Strings, types, id
  - Control flow and loops
  - Functions and collections

Keep practicing and experimenting!

---
