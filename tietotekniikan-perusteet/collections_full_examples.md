
# 🧠 Python Collections – Extended Reference Notes with Examples

---

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
