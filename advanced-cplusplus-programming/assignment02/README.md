# Assignment 02

How to return assignments? See instructions in the main [README.md](../README.md)!

## Upload the following Lecture Notes

- `studentnumber-assignment02-lecture01.pdf`
- `studentnumber-assignment02-lecture02.pdf`
- `studentnumber-assignment02-lecture03.pdf`
- `studentnumber-assignment02-lecture04.pdf`
- `studentnumber-assignment02-lecture05.pdf`
- `studentnumber-assignment02-lecture06.pdf`
- `studentnumber-assignment02-lecture07.pdf`

## Points

| Exercise                           | Points |
| ---------------------------------- | ------ |
| 01: Composition Basics (Line)      | 6      |
| 02: Aggregation vs Composition     | 5      |
| 03: Heap Ownership (Phone/Battery) | 6      |
| 04: Combined exercise              | 13     |
| **Total**                          | **30** |

## 01: Composition Basics (Line)

---

- 📺 Lecture: Aggregation and Composition ✏️
  - `studentnumber-assignment02-lecture01.pdf`
- 📺 Lecture: Implementing Composition: Book and (Cover) ✏️
  - `studentnumber-assignment02-lecture02.pdf`
- 📺 Lecture: Implementing Composition: Cover and App ready ✏️
  - `studentnumber-assignment02-lecture03.pdf`

---

Goal: Learn composition by building a class that owns other objects by value and delegates behavior.

Work in `01/Point.h`, `01/Point.cpp`, `01/Line.h`, `01/Line.cpp`, and `01/main.cpp`.

1. Reuse or re-create a `Point` class with `x`, `y`, getters, setters, and `toString()`.
2. Create a `Line` class that _contains_ two `Point` members: `start` and `end`.
3. Add a constructor that takes two `Point`s and stores them by value.
4. Add `length()` that returns the distance between `start` and `end`.
5. Add `moveBy(int dx, int dy)` that moves both points.
6. Add `toString()` and `operator<<` for `Line`.
7. In `main`, create a few lines, print them, and show that `moveBy` updates both points.

Use the following `main.cpp` template:

```cpp
#include <iostream>
#include "Line.h"

int main() {
    Point a(0, 0);
    Point b(3, 4);

    Line line(a, b); // notice, will copy a and b, so Line has its own points.
    std::cout << line << std::endl;
    std::cout << "Length: " << line.length() << std::endl;

    line.moveBy(1, 2);
    std::cout << "After move: " << line << std::endl;
    return 0;
}
```

### Deliverable

Submit `01/Point.cpp`, `01/Point.h`, `01/Line.cpp`, `01/Line.h`, `01/main.cpp`.

### Test

See [test.cpp](01/test.cpp). Test your app:

```bash
clang++ -std=c++20 01/test.cpp 01/Point.cpp 01/Line.cpp -o 01/test && 01/test
```

| Test                        | Points |
| --------------------------- | ------ |
| Point toString format       | 1      |
| Line toString format        | 1      |
| Line length                 | 1      |
| Line moveBy updates start   | 1      |
| Line moveBy updates end     | 1      |
| operator<< matches toString | 1      |

## 02: Aggregation vs Composition (Human/Heart/Car)

---

- 📺 Lecture: Aggregation ✏️
  - `studentnumber-assignment02-lecture04.pdf`
- 📺 Lecture: Implementing School - class ✏️
  - `studentnumber-assignment02-lecture05.pdf`
- 📺 Lecture: Implementing Student - class and test the App ✏️
  - `studentnumber-assignment02-lecture06.pdf`

---

Goal: Understand non-owning relationships and lifetime responsibility.

Think of composition vs aggregation like this:

- Composition: A Human has a Heart. If the Human is destroyed, the Heart goes too. (Owning relationship.)
- Aggregation: A Human uses a Car. If the Human is destroyed, the Car can still exist. (Non-owning relationship.)

Work in `02/Human.h`, `02/Human.cpp`, `02/Heart.h`, `02/Heart.cpp`, `02/Car.h`, `02/Car.cpp`, and `02/main.cpp`.

1. Create a `Heart` class with a `beatsPerMinute` field and a `toString()` method.
2. Create a `Car` class with `brand` and `model` plus a `toString()` method.
3. Create a `Human` class that _owns_ a `Heart` by value and _aggregates_ a `Car` via a non-owning pointer.
   - Constructor should take a name and beats-per-minute and create the heart.
   - Provide `setCar(const Car* car)` to attach a car without owning it.
   - `Human::toString()` should include heart info and either the car info or "no car".
4. In `main`, create one or more `Car` objects, create `Human` objects, attach cars, and print them.
5. Briefly explain in `02/02.txt` why `Human` should not delete the `Car*` value.

Use the following `main.cpp` template:

```cpp
#include <iostream>
#include "Car.h"
#include "Human.h"

int main() {
    Car volvo("Volvo", "240");
    Car bmw("BMW", "M3");

    Human timo("Timo", 60);
    Human teemu("Teemu", 62);

    timo.setCar(&volvo);
    teemu.setCar(&bmw);

    std::cout << timo << std::endl;
    std::cout << teemu << std::endl;
    return 0;
}
```

### Deliverable

Submit `02/Human.cpp`, `02/Human.h`, `02/Heart.cpp`, `02/Heart.h`, `02/Car.cpp`, `02/Car.h`, `02/main.cpp`, and `02/02.txt`.

### Test

See [test.cpp](02/test.cpp). Test your app:

```bash
clang++ -std=c++20 02/test.cpp 02/Human.cpp 02/Heart.cpp 02/Car.cpp -o 02/test && 02/test
```

| Test                        | Points |
| --------------------------- | ------ |
| Heart toString              | 1      |
| Car toString                | 1      |
| Human toString without car  | 1      |
| Human toString with car     | 1      |
| operator<< matches toString | 1      |

## 03: Heap Ownership (Phone/Battery)

---

- 📺 Lecture: Heap Ownership ✏️
  - `studentnumber-assignment02-lecture07.pdf`
- 📺 Lecture: Implementation of Book class
- 📺 Lecture: Running the App

---

Goal: Learn raw-pointer ownership, deep copy, and why the Rule of Three exists.

In exercise 02, `Human` owned a `Heart` by value. The compiler handled copying and destruction automatically. Here, `Phone` owns a `Battery*` on the heap, so you must define how copying and destruction work. Otherwise, you risk double deletes or leaks.

Work in `03/Phone.h`, `03/Phone.cpp`, `03/Battery.h`, `03/Battery.cpp`, and `03/main.cpp`.

1. Create a `Battery` class with `capacityMah` and a `toString()` method.
2. Create a `Phone` class that owns a `Battery*`.
3. In `Phone`, implement:
   - Constructor that allocates a `Battery` on the heap.
   - Destructor that deletes the `Battery`.
   - Copy constructor that performs a deep copy and prints a message when called.
   - Copy assignment operator that performs a deep copy, handles self-assignment, and prints a message.
4. Add getters and setters: `getModel()`, `getBatteryCapacity()`, `setBatteryCapacity(int)`.
5. Add `toString()` for `Phone` that includes battery info.
6. In `main`, create phones, copy them, assign them, and print them.
7. Add a short note in `03/03.txt` explaining why the Rule of Three is needed here.

Use the following `main.cpp` template:

```cpp
#include <iostream>
#include "Phone.h"

int main() {
    Phone* a = new Phone("Nokia", 3000);
    std::cout << *a << std::endl;

    Phone* b = new Phone(*a); // copy constructor
    std::cout << *b << std::endl;

    Phone* c = new Phone("Samsung", 5000);
    *c = *a; // copy assignment
    std::cout << *c << std::endl;

    delete a;
    delete b;
    delete c;
    return 0;
}
```

### Deliverable

Submit `03/Phone.cpp`, `03/Phone.h`, `03/Battery.cpp`, `03/Battery.h`, `03/main.cpp`, and `03/03.txt`.

### Test

See [test.cpp](03/test.cpp). Test your app:

```bash
clang++ -std=c++20 03/test.cpp 03/Phone.cpp 03/Battery.cpp -o 03/test && 03/test
```

| Test                             | Points |
| -------------------------------- | ------ |
| Battery toString                 | 1      |
| Phone toString                   | 1      |
| Copy constructor copies data     | 1      |
| Copy assignment copies data      | 1      |
| Deep copy keeps copies unchanged | 1      |
| operator<< matches toString      | 1      |

## 04: Combined exercise

Goal: Combine composition, aggregation, and heap ownership (Rule of Three) into a single class.

A `Musician` uses three relationship patterns:

- `Name` by value (composition): the musician owns its name.
- `Instrument*` on the heap (ownership): the musician allocates and deletes it, requiring the Rule of Three.
- `const Studio*` as a non-owning pointer (aggregation): the studio exists independently.

Work in `04/Name.h`, `04/Name.cpp`, `04/Instrument.h`, `04/Instrument.cpp`, `04/Studio.h`, `04/Studio.cpp`, `04/Musician.h`, `04/Musician.cpp`, and `04/main.cpp`.

1. Create a `Name` class with `first` and `last` fields and a `toString()` that returns `"Name(first, last)"`.
2. Create an `Instrument` class with `type` and `brand`, getters, and a `toString()` that returns `"Instrument(type, brand)"`. Add a destructor that prints a message.
3. Create a `Studio` class with `name` and `city`, getters, and a `toString()` that returns `"Studio(name, city)"`.
4. Create a `Musician` class that:
   - Stores `Name` by value, `Instrument*` on the heap, and `const Studio*` as a non-owning pointer.
   - Constructor takes first name, last name, instrument type, and instrument brand. Sets studio to `nullptr`.
   - Implements the Rule of Three: destructor deletes the instrument, copy constructor and copy assignment operator deep copy it.
   - Provides `setStudio(const Studio* s)` and `toString()`.
   - Overloads `operator<<`.
5. In `main`, create musicians, attach a studio, copy and assign them, and print them.

Use the following `main.cpp` template:

```cpp
#include <iostream>
#include "Musician.h"
#include "Studio.h"

int main() {
    Studio abbey("Abbey Road", "London");

    Musician james("James", "Hetfield", "Guitar", "ESP");
    james.setStudio(&abbey);
    std::cout << james << std::endl;

    // Copy constructor
    Musician copy(james);
    std::cout << copy << std::endl;

    // Copy assignment
    Musician lars("Lars", "Ulrich", "Drums", "Tama");
    lars = james;
    std::cout << lars << std::endl;

    return 0;
}
```

### Deliverable

Submit `04/Name.cpp`, `04/Name.h`, `04/Instrument.cpp`, `04/Instrument.h`, `04/Studio.cpp`, `04/Studio.h`, `04/Musician.cpp`, `04/Musician.h`, `04/main.cpp`.

### Test

See [test.cpp](04/test.cpp). Test your app:

```bash
clang++ -std=c++20 04/test.cpp 04/Name.cpp 04/Instrument.cpp 04/Studio.cpp 04/Musician.cpp -o 04/test && 04/test
```

| Test                                                     | Points |
| -------------------------------------------------------- | ------ |
| Name toString                                            | 1      |
| Instrument toString                                      | 1      |
| Instrument getType                                       | 1      |
| Instrument getBrand                                      | 1      |
| Studio toString                                          | 1      |
| Studio getName                                           | 1      |
| Studio getCity                                           | 1      |
| Musician toString without studio                         | 1      |
| Musician toString with studio                            | 1      |
| operator<< matches toString                              | 1      |
| Copy constructor copies data                             | 1      |
| Copy assignment copies data                              | 1      |
| Deep copy: changing original studio does not affect copy | 1      |
