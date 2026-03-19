# Assignment 04: Recap - Vehicle Fleet

How to return assignments? See instructions in the main [README.md](../README.md)!

## Points

| Exercise                                    | Points |
| ------------------------------------------- | ------ |
| 01: Core Class (Engine)                      | 6      |
| 02: Composition (Vehicle owns Engine)        | 6      |
| 03: Inheritance and Polymorphism (Car/Truck) | 10     |
| 04: Heap Ownership and Aggregation (Fleet)   | 10     |
| **Total**                                    | **32** |

## 01: Core Class (Engine)

Goal: Recap encapsulation, constructors, const, validation, and operator overloading.

Work in `01/Engine.h`, `01/Engine.cpp`, and `01/main.cpp`.

1. Create an `Engine` class with two private fields: `int horsepower` and `std::string fuelType`.
2. Add a parameterized constructor that takes `int horsepower` and `const std::string& fuelType`. Use a member initializer list. Throw an exception if `horsepower` is less than 0.
3. Add a default constructor that sets `horsepower` to `0` and `fuelType` to `"Unknown"`.
4. Add const getters: `getHorsepower()`, `getFuelType()`.
5. Add setters: `setHorsepower(int hp)` (throw if hp < 0), `setFuelType(const std::string& type)`.
6. Add `toString()` that returns `Engine(horsepower, fuelType)`, for example `Engine(150, Diesel)`.
7. Overload `operator<<` to print the same as `toString()`.

Use the following `main.cpp` template:

```cpp
#include <iostream>
#include "Engine.h"

int main() {
    Engine e1(150, "Diesel");
    std::cout << e1 << std::endl;

    Engine e2;
    std::cout << e2 << std::endl;

    e2.setHorsepower(200);
    e2.setFuelType("Petrol");
    std::cout << e2 << std::endl;

    try {
        Engine e3(-10, "Electric");
    } catch (const std::exception& e) {
        std::cout << "Exception: " << e.what() << std::endl;
    }

    return 0;
}
```

### Deliverable

Submit `01/Engine.cpp`, `01/Engine.h`, `01/main.cpp`.

### Test

See [test.cpp](01/test.cpp) and test your app:

```bash
clang++ -std=c++20 01/test.cpp 01/Engine.cpp -o 01/test && 01/test
```

| Test                              | Points |
| --------------------------------- | ------ |
| Parameterized constructor values  | 1      |
| Default constructor values        | 1      |
| toString format                   | 1      |
| operator<< matches toString       | 1      |
| Constructor throws on negative hp | 1      |
| Setter throws on negative hp      | 1      |

## 02: Composition (Vehicle owns Engine)

Goal: Recap composition where one class owns another by value.

Work in `02/Engine.h`, `02/Engine.cpp`, `02/Vehicle.h`, `02/Vehicle.cpp`, and `02/main.cpp`.

1. Reuse or copy your `Engine` class from exercise 01.
2. Create a `Vehicle` class with private fields: `std::string brand`, `std::string model`, `int year`, and `Engine engine` (owned by value).
3. Add a constructor that takes `const std::string& brand`, `const std::string& model`, `int year`, and `const Engine& engine`. Use a member initializer list.
4. Add const getters: `getBrand()`, `getModel()`, `getYear()`, `getEngine()`.
5. Add `toString()` that returns `Vehicle(brand, model, year, Engine(hp, fuel))`, for example `Vehicle(Volvo, XC90, 2024, Engine(250, Diesel))`.
6. Overload `operator<<` to print the same as `toString()`.
7. Overload `operator==` to compare two vehicles by `brand`, `model`, and `year`.

Use the following `main.cpp` template:

```cpp
#include <iostream>
#include "Vehicle.h"
#include "Engine.h"

int main() {
    Engine e1(250, "Diesel");
    Engine e2(150, "Petrol");

    Vehicle v1("Volvo", "XC90", 2024, e1);
    Vehicle v2("Toyota", "Corolla", 2023, e2);
    Vehicle v3("Volvo", "XC90", 2024, e1);

    std::cout << v1 << std::endl;
    std::cout << v2 << std::endl;

    std::cout << "v1 == v3? " << (v1 == v3) << std::endl;
    std::cout << "v1 == v2? " << (v1 == v2) << std::endl;

    return 0;
}
```

### Deliverable

Submit `02/Engine.cpp`, `02/Engine.h`, `02/Vehicle.cpp`, `02/Vehicle.h`, `02/main.cpp`.

### Test

See [test.cpp](02/test.cpp) and test your app:

```bash
clang++ -std=c++20 02/test.cpp 02/Engine.cpp 02/Vehicle.cpp -o 02/test && 02/test
```

| Test                        | Points |
| --------------------------- | ------ |
| Vehicle constructor values  | 1      |
| Vehicle toString format     | 1      |
| Engine toString format      | 1      |
| operator<< matches toString | 1      |
| operator== same vehicles    | 1      |
| operator== different vehicles | 1      |

## 03: Inheritance and Polymorphism (Car/Truck)

Goal: Recap inheritance, virtual functions, abstract classes, and polymorphism.

Work in `03/Engine.h`, `03/Engine.cpp`, `03/Vehicle.h`, `03/Vehicle.cpp`, `03/Car.h`, `03/Car.cpp`, `03/Truck.h`, `03/Truck.cpp`, and `03/main.cpp`.

1. Reuse or copy your `Engine` class.
2. Create an abstract `Vehicle` class with private fields: `std::string brand`, `std::string model`, `int year`, and `Engine engine`.
   - Constructor takes brand, model, year, and engine.
   - Add const getters: `getBrand()`, `getModel()`, `getYear()`, `getEngine()`.
   - Add a pure virtual method `std::string purpose() const = 0`.
   - Add a pure virtual method `Vehicle* clone() const = 0` that returns a heap-allocated copy of the object.
   - Add a virtual `toString()` that returns `Vehicle(brand, model, year, Engine(hp, fuel))`.
   - Add a virtual destructor.
3. Create `Car : public Vehicle` with a private field `int passengerCount`.
   - Constructor takes brand, model, year, engine, and passengerCount. Calls `Vehicle(...)`.
   - Add `getPassengerCount()`.
   - Override `purpose()` to return `"Personal transport"`.
   - Override `clone()` to return `new Car(*this)`.
   - Override `toString()` to return `Car(brand, model, year, Engine(hp, fuel), passengerCount)`.
4. Create `Truck : public Vehicle` with a private field `int cargoCapacity`.
   - Constructor takes brand, model, year, engine, and cargoCapacity. Calls `Vehicle(...)`.
   - Add `getCargoCapacity()`.
   - Override `purpose()` to return `"Cargo transport"`.
   - Override `clone()` to return `new Truck(*this)`.
   - Override `toString()` to return `Truck(brand, model, year, Engine(hp, fuel), cargoCapacity)`.
5. In `main`, create `Car` and `Truck` objects, store their addresses in `Vehicle*` pointers, and call `purpose()` and `toString()` polymorphically.

Use the following `main.cpp` template:

```cpp
#include <iostream>
#include "Car.h"
#include "Truck.h"
#include "Engine.h"

int main() {
    Car car("Volvo", "XC90", 2024, Engine(250, "Diesel"), 5);
    Truck truck("Scania", "R500", 2023, Engine(500, "Diesel"), 25);

    Vehicle* vehicles[] = {&car, &truck};

    for (Vehicle* v : vehicles) {
        std::cout << v->toString() << std::endl;
        std::cout << "Purpose: " << v->purpose() << std::endl;
    }

    return 0;
}
```

### Deliverable

Submit `03/Engine.cpp`, `03/Engine.h`, `03/Vehicle.cpp`, `03/Vehicle.h`, `03/Car.cpp`, `03/Car.h`, `03/Truck.cpp`, `03/Truck.h`, `03/main.cpp`.

### Test

See [test.cpp](03/test.cpp) and test your app:

```bash
clang++ -std=c++20 03/test.cpp 03/Engine.cpp 03/Vehicle.cpp 03/Car.cpp 03/Truck.cpp -o 03/test && 03/test
```

| Test                       | Points |
| -------------------------- | ------ |
| Vehicle is abstract        | 1      |
| Car toString format        | 1      |
| Car purpose                | 1      |
| Car getPassengerCount      | 1      |
| Truck toString format      | 1      |
| Truck purpose              | 1      |
| Car clone                  | 1      |
| Truck clone                | 1      |
| Polymorphic car purpose    | 1      |
| Polymorphic truck purpose  | 1      |

## 04: Heap Ownership and Aggregation (Fleet)

Goal: Recap heap ownership (Rule of Three) and aggregation (non-owning pointer).

Work in `04/` directory. Copy your `Engine`, `Vehicle`, `Car`, and `Truck` classes from exercise 03.

Additionally create `04/Driver.h`, `04/Driver.cpp`, `04/Fleet.h`, `04/Fleet.cpp`, and `04/main.cpp`.

1. Create a `Driver` class with `std::string name` and `int licenseYear`. Add const getters and `toString()` returning `Driver(name, licenseYear)`.
2. Create a `Fleet` class that:
   - Owns a dynamically allocated array of `Vehicle*` pointers on the heap.
   - Aggregates a `const Driver*` (non-owning pointer, the driver exists independently).
   - Has a `maxSize` field (set in constructor) and a `count` field (starts at 0).
3. `Fleet` constructor takes `int maxSize` and allocates the array. Sets driver to `nullptr`.
4. Implement the Rule of Three:
   - Destructor: deletes all vehicles in the array and the array itself.
   - Copy constructor: deep copies all vehicles using `clone()`. Copies the driver pointer (not the driver itself, it is non-owning).
   - Copy assignment operator: handles self-assignment, cleans up old data, deep copies.
5. Add `setDriver(const Driver* d)` to attach a driver.
6. Add `addVehicle(Vehicle* v)` that takes ownership of a heap-allocated vehicle. Returns `bool` (false if full).
7. Add `getCount()`, `getMaxSize()`.
8. Add `toString()` that returns a multi-line string in this format:
   ```
   Fleet(Driver(Timo, 2015), 2 vehicles)
   - Car(Volvo, XC90, 2024, Engine(250, Diesel), 5)
   - Truck(Scania, R500, 2023, Engine(500, Diesel), 25)
   ```
   If no driver is set, use `"no driver"` instead: `Fleet(no driver, 0 vehicles)`.
9. Overload `operator<<`.

Use the following `main.cpp` template:

```cpp
#include <iostream>
#include "Fleet.h"
#include "Car.h"
#include "Truck.h"
#include "Engine.h"
#include "Driver.h"

int main() {
    Driver driver("Timo", 2015);

    Fleet fleet(3);
    fleet.setDriver(&driver);
    fleet.addVehicle(new Car("Volvo", "XC90", 2024, Engine(250, "Diesel"), 5));
    fleet.addVehicle(new Truck("Scania", "R500", 2023, Engine(500, "Diesel"), 25));

    std::cout << fleet << std::endl;

    // Copy constructor
    Fleet copy(fleet);
    std::cout << "Copy:" << std::endl;
    std::cout << copy << std::endl;

    // Copy assignment
    Fleet assigned(1);
    assigned = fleet;
    std::cout << "Assigned:" << std::endl;
    std::cout << assigned << std::endl;

    return 0;
}
```

### Deliverable

Submit all `.cpp` and `.h` files in `04/`, plus `04/main.cpp`.

### Test

See [test.cpp](04/test.cpp) and test your app:

```bash
clang++ -std=c++20 04/test.cpp 04/Engine.cpp 04/Vehicle.cpp 04/Car.cpp 04/Truck.cpp 04/Driver.cpp 04/Fleet.cpp -o 04/test && 04/test
```

| Test                              | Points |
| --------------------------------- | ------ |
| Driver toString                   | 1      |
| Fleet addVehicle                  | 1      |
| Fleet toString with driver        | 1      |
| Fleet toString without driver     | 1      |
| Fleet full returns false          | 1      |
| Copy constructor copies data      | 1      |
| Copy assignment copies data       | 1      |
| Deep copy keeps copies unchanged  | 1      |
| Destructor frees memory           | 1      |
| operator<< matches toString       | 1      |
