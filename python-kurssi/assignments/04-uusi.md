# 🧪 Assignment 04

## License

> This work is licensed under the
> **Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License (CC BY-NC-SA 4.0)**
>
> ⚠️ **Additional Restriction:**
> The material may **not** be used, in whole or in part, to **train, fine-tune, prompt, or otherwise feed into any generative artificial intelligence (AI) or machine learning (ML) system**, expect for the author.

🔗 [Learn more about CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/)

---

## ⚠️ For online lectures write and upload **handwritten** notes.

You can use your phone to capture photos from the notes and upload those as pdf.

Upload your notes:

```
lastname-firstname-lecture01.pdf
lastname-firstname-lecture02.pdf
lastname-firstname-lecture03.pdf
lastname-firstname-lecture04.pdf
```

Submit your notes to the teacher use [dropbox file upload](https://www.dropbox.com/request/WenoWd5sGzH4f8Fv0hIL).

**macOS**

- In Finder, select all the PNGs you want (hold ⌘ while clicking or drag to select).
- Right-click and choose Open With → Preview.
- In Preview’s sidebar (enable via View → Thumbnails if needed), drag the images to correct the order.
- Go to File → Print (or ⌘ + P), then in the Print dialog choose Save as PDF. That will produce one PDF containing all the images.

**Windows**

- Open the folder with your PNG images, select all you want (Ctrl + click or Ctrl + A).
- Right-click and choose Print. In the Print dialog, set the printer to Microsoft Print to PDF. This converts the selected images into a single PDF (one page per image).

## 📁 Directory Structure for Exercises

Create each exercise in its own folder:

```
lastname-firstname-assignment04/e01.py
lastname-firstname-assignment04/e02.py
...
lastname-firstname-assignment04/e23.py
```

So your directory structure could be (_change the name from `opiskelija-olli` to your name_):

```
opiskelija-olli-assignment04
├── e01.py
├── e02.py
├── e03.py
...
├── e23.py
```

⚠️ Use the concepts we've covered in class in your exercises - **don't use advanced features**, even if you already know them.

## 🚀 Submitting Your Work

1. Zip your `lastname-firstname-assignment03` directory to `lastname-firstname-assignment03.zip`. If you do not know how to zip, see [instructions](https://support.microsoft.com/en-us/windows/.zip-and-unzip-files-8d28fa72-f2f9-712f-67df-f80cf89fd4e5).
2. To submit your exercises to the teacher use [dropbox file upload](https://www.dropbox.com/request/WenoWd5sGzH4f8Fv0hIL).
3. Mark your exercises in Google Sheets (link in Moodle)
4. Be prepared to participate on code review where you may have to explain your solutions in the class.
5. Be on time on lectures, **latecomers do not get points**.
6. See general [guidelines](https://github.com/pohjus/common-course-assets/blob/main/exercise-points-guidelines.md) for the exercises.

## ✏️ Lectures

- [Overview of Collections](https://www.youtube.com/watch?v=0bpJqL1G70g&feature=youtu.be)
  - `lastname-firstname-lecture01.pdf`
- [Lists](https://www.youtube.com/watch?v=NFaSaPtzLCY&feature=youtu.be)
  - `lastname-firstname-lecture02.pdf`
- [Lists](https://www.youtube.com/watch?v=NFaSaPtzLCY&feature=youtu.be)
  - `lastname-firstname-lecture03.pdf`
- [Tuple and Set](https://www.youtube.com/watch?v=RKb5DBNMTcI)
  - `lastname-firstname-lecture04.pdf`
- [Recap: Lotto App](https://www.youtube.com/watch?v=6kA3l514jXY)
  - No need for notes.

## 🧩 Exercises

### Lists

Lists are ordered collections that can hold many values. They allow duplicates and support indexing, slicing, and modifications. Use them when you need a flexible sequence of items.

Example

```python
fruits = ["apple", "banana", "cherry"]
print(fruits[0])   # apple
```

> See [Python list tutorial](https://www.w3schools.com/python/python_lists.asp).

---

#### Assignment 01: Add Item to List

Start with this list: `["apple", "banana", "orange"]`.
Ask the user to input a fruit to add, and add it to the list.
Print the updated list.

Example

    Enter a fruit to add: mango
    ['apple', 'banana', 'orange', 'mango']

---

#### Assignment 02: Shopping List

Ask the user to enter 5 items using **for**-loop. Store them in a list and then print the full list.

```bash
Enter item 1:
milk
Enter item 2:
bread
...
['milk', 'bread', 'eggs', 'butter', 'coffee']
```

---

#### Assignment 03: Remove Item from List

Continue with previous assignment. Using the list given by the user, ask also from the user to input a fruit to remove.
If it exists, remove it and print the list. If not, print `"Not in list"`.

Example

    Enter a fruit to remove: banana
    ['apple', 'orange']

Example

    Enter a fruit to remove: kiwi
    Not in list

---

#### Assignment 04: Sort and Print List

Ask the user to enter 5 numbers, store them in a list, [sort](https://docs.python.org/3/howto/sorting.html) the list, and print it.

```
Enter number 1:
3
...
[1, 2, 3, 5, 9]
```

how

#### Assignment 05: Check Palindrome with List

Ask user for a word. Use a list to reverse the string and check if it's a palindrome. When reversing, use `for` - loop _(it can be done also for example using `reverse()` - function, but do not use that)_. So create a new list that has all characters from the original list but in reverse order.

To turn a `str` to List:

```python
# Convert str to list
letters = list("abc")
```

Examples:

```
Give string: saippuakauppias
It is a palindrome
```

```
Give string: kalle
It is not a palindrome
```

---

#### Assignment 06: List Average

Ask the user for 5 numbers, store in a list, then calculate and print the average.

Example

    Enter number 1: 5
    Enter number 2: 10
    Enter number 3: 15
    Enter number 4: 20
    Enter number 5: 25
    Average: 15.0

---

### Tuples

Tuples are ordered and immutable collections. Once created, they cannot be changed. They're useful for grouping related values that should stay constant, like coordinates or student records.

```python
point = (10, 20)
print(point[1])   # 20
```

> See [Python tuple tutorial](https://www.w3schools.com/python/python_tuples.asp).

#### Assignment 07: Tuple Packing

Create a tuple with 3 elements: name, age, and country:

```python
person = ("Anna", 25, "Finland")
```

Print each value like following:

    Name: Anna
    Age: 25
    Country: Finland

---

#### Assignment 08: Tuple with Mixed Data Types

Create a tuple that contains different data types: a `string`, an `integer`, a `list`, and a `boolean`.

Print the whole tuple to console.

Also print using indexing to access the list inside of the tuple.

Append a new value to the list and print the tuple again.

Example output:

```
Tuple: ('Alice', 30, [10, 20, 30], True)
List inside tuple: [10, 20, 30]
Updated tuple: ('Alice', 30, [10, 20, 30, 40], True)
```

---

#### Assignment 09: Tuple Slicing

Create a tuple of 10 numbers (1 - 10).

Print the first three elements, the last three elements, and the middle four elements using [slicing](https://www.w3schools.com/python/python_tuples_access.asp).

Example

    First three: (1, 2, 3)
    Last three: (8, 9, 10)
    Middle four: (4, 5, 6, 7)

---

#### Assignment 10: Nested Tuples

Create a tuple that contains two other tuples inside it.
Each inner tuple should represent a student: `(name, age, major)`.
Loop through the outer tuple and print each student's information nicely formatted.

Example output:

```
Name: Alice, Age: 21, Major: CS
Name: Bob, Age: 22, Major: Math
```

---

### Sets

Sets are unordered collections of unique items. They automatically remove duplicates and support operations like union, intersection, and difference, which are useful in tasks like finding common or distinct elements.

Example

```
numbers = {1, 2, 3, 3, 2}
print(numbers)   # {1, 2, 3}
```

> See [Python set tutorial](https://www.w3schools.com/python/python_sets.asp).

---

#### Assignment 11: Set Creation

Ask user for 5 words (using for-loop) and store them in a `set`.
Print the set - what do you notice about duplicates values user has given?

---

#### Assignment 12: Set Membership Test

Ask the user to input a name.
If it's in the set `{"Alice", "Bob", "Charlie"}`, print `"Name is allowed"`, else `"Name not allowed"`.

Example

    Enter name: Bob
    Name is allowed

Example

    Enter name: Max
    Name not allowed

---

#### Assignment 13: Set Operations

Ask user for two sets of numbers (comma-separated).
Print the union and intersection.

Example

    Enter first set: 1,2,3,4
    Enter second set: 3,4,5,6
    Union: {1, 2, 3, 4, 5, 6}
    Intersection: {3, 4}

To turn str into a list:

```python
s = "1,2,3,4"
lst = s.split(",")
print(lst)   # ['1', '2', '3', '4']
```

To turn a list into a set:

```python
my_set = set([1,2,3,4])
```

---

### Dictionaries

Dictionaries store data as key-value pairs. They are great when you need to look things up quickly, like a phonebook, a gradebook, or configuration settings.

```python
ages = {"John": 25, "Mary": 30}
print(ages["Mary"])   # 30
```

> See [Python dict tutorial](https://www.w3schools.com/python/python_dictionaries.asp).

---

#### Assignment 14: Dictionary Lookup

Create a dictionary:

```python
ages = {"John": 25, "Mary": 30, "Alex": 22}
```

Ask the user for a name. Print the person's age or `"Name not found"`.

Example

    Enter name: John
    25

Example

    Enter name: Mike
    Name not found

---

#### Assignment 15: Update Dictionary

Using the dictionary above, ask the user for a new person's name and age.
Add it to the dictionary. Print updated dictionary.

Example:

    Enter name: Lisa
    Enter age: 27
    {'John': 25, 'Mary': 30, 'Alex': 22, 'Lisa': 27}

---

#### Assignment 16: Dictionary from Input

Ask the user for three times names (use for-loop) and corresponding scores. Build a dict and print it.

Example input/output:

```
Enter name:
Anna
Enter score:
5
...
{'Anna': 5, 'Leo': 9, 'Mira': 8}
```

---

#### Assignment 17: Convert List to Dict

Ask user for 3 key-value pairs (e.g., `fruit:apple`).
Build a dictionary from them.

    Enter "key:value" pair: fruit:apple
    Enter "key:value" pair: drink:water
    Enter "key:value" pair: snack:chips
    {'fruit': 'apple', 'drink': 'water', 'snack': 'chips'}

---

#### Assignment 18: List of Dictionaries

Create a list like:

```python
products = [
    {"name": "milk", "price": 1.5},
    {"name": "bread", "price": 2.0}
]
```

Loop through and print: `"milk costs 1.5"` etc.

Example:

    milk costs 1.5
    bread costs 2.0

---

#### Assignment 19: Count Occurrences

Ask the user to enter some words (comma-separated).
Count how many times each word appears using a `dict`.
Example:

```
Enter words (comma separated):
cat,dog,cat,bird,dog
```

Output as dictionary:

```python
{'cat': 2, 'dog': 2, 'bird': 1}
```

---

#### 🤓 Extra Assignment 20: Nested Dictionary

Create a dictionary of students, where each student's name is the key and the value is another dictionary containing the student's details (`age` and `major`).

##### Requirements

1. Prepopulate the dictionary with at least two students.
2. Show the dictionary to the user.
3. Show a menu:
   - `[1] Add new student`
   - `[2] Exit`
4. If the user chooses `[1]`, ask for the student’s **name**, **age**, and **major**, and insert them into the dictionary.
5. Print the updated dictionary.
6. Repeat the menu until the user chooses `[2]`.

Example:

```
Students:
{
    "Alice": {"age": 21, "major": "CS"},
    "Bob": {"age": 22, "major": "Math"}
}
[1] Add new student
[2] Exit
1
Give name:
Jack
Give age:
20
Give major:
Physics
Students:
{
    "Alice": {"age": 21, "major": "CS"},
    "Bob": {"age": 22, "major": "Math"},
    "Jack": {"age": 20, "major": "Physics"}
}
[1] Add new student
[2] Exit
2
Bye!
```
