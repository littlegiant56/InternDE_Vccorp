# HashMap, HashSet, ArrayList in Java

## 1. **HashMap**

`HashMap` is a data structure that stores key-value pairs. It uses hashing to store and retrieve these pairs with an average time complexity of O(1) for operations like adding, retrieving, or removing elements.

### Key Methods:

- **put(K key, V value)**: Adds a key-value pair to the map.
- **get(Object key)**: Returns the value associated with the specified key, or `null` if not found.
- **remove(Object key)**: Removes the element with the specified key.
- **containsKey(Object key)**: Checks if the map contains the specified key.
- **size()**: Returns the number of key-value pairs in the map.
- **clear()**: Removes all elements.

## 2. **HashSet**

`HashSet` is a collection that does not allow duplicate elements and uses hashing for storage. It does not guarantee the order of elements.

### Key Methods:

- **add(E e)**: Adds an element to the set (if it already exists, it is not added).
- **remove(Object o)**: Removes the specified element.
- **contains(Object o)**: Checks if the set contains the specified element.
- **size()**: Returns the number of elements in the set.
- **clear()**: Removes all elements from the set.

## 3. **ArrayList**

`ArrayList` is a dynamic array that can change size. Elements are stored in the order of insertion, and it allows access by index.

### Key Methods:

- **add(E e)**: Adds an element to the list.
- **get(int index)**: Retrieves the element at the specified index.
- **remove(int index)**: Removes the element at the specified index.
- **size()**: Returns the number of elements in the list.
- **clear()**: Removes all elements.

## Comparison:

| **Characteristic**  | **HashMap**                     | **HashSet**                          | **ArrayList**                        |
| ------------------- | ------------------------------- | ------------------------------------ | ------------------------------------ |
| **Data Structure**  | Stores key-value pairs          | A set that does not allow duplicates | A list of elements                   |
| **Unique Elements** | Only keys are unique            | Does not allow duplicate elements    | Allows duplicate elements            |
| **Element Order**   | No order guarantee              | No order guarantee                   | Maintains insertion order            |
| **Element Access**  | Access by key (O(1) average)    | Check for element existence (O(1))   | Access by index (O(1))               |
| **When to Use**     | When key-value pairs are needed | When unique elements are required    | When ordered, indexed list is needed |

---

## `hashCode()` and `equals()` Concepts:

- **`hashCode()`**: Returns a hash code representing the object. This hash code is used in hash-based data structures like `HashMap`, `HashSet` to determine where to store the element.

  - **Rule**: If two objects are equal (compared via `equals()`), they must have the same `hashCode()` value.

- **`equals()`**: Checks if two objects are equal based on their content (not memory addresses).

In the above example, if `hashCode()` and `equals()` are not overridden, `HashSet` will treat two objects with the same content as different objects.

# Design Patterns: Abstract Factory, Composite, Template Method

## 1. **Abstract Factory Pattern**

### Intent:

The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. It allows you to create objects from various classes that belong to a common family or theme, abstracting the creation process to be flexible and scalable.

### Structure:

- **AbstractFactory**: Declares the interface for creating abstract product objects.
- **ConcreteFactory**: Implements the operations to create concrete product objects.
- **AbstractProduct**: Declares an interface for a type of product object.
- **ConcreteProduct**: Implements the abstract product interface.
- **Client**: Uses only interfaces declared by AbstractFactory and AbstractProduct classes.

## 2. **Composite Pattern**

### Intent:

The Composite pattern allows you to compose objects into tree-like structures to represent part-whole hierarchies. It treats individual objects and compositions of objects uniformly, meaning the same operations can be applied to both.

### Structure:

- **Component**: Declares the interface for all objects in the composition.
- **Leaf**: Represents leaf objects in the composition (no children).
- **Composite**: Represents composite objects that can have children (implements add, remove, and operation methods).
- **Client**: Interacts with the objects in the composition through the Component interface.

## 3. **Template Method Pattern**

### Intent:

The Template Method pattern defines the skeleton of an algorithm in a method, allowing subclasses to redefine specific steps of the algorithm without changing its structure. It provides a way for subclasses to hook into the algorithm, ensuring some steps are fixed while others are customizable.

### Structure:

- **AbstractClass**: Defines the template method that contains the algorithm's structure. Some steps are implemented in the base class, while others are left abstract or with default implementations for subclasses to override.
- **ConcreteClass**: Implements the abstract methods and provides specific behavior.

## Conclusion:

- **Abstract Factory** is useful when you need to create related objects without specifying the exact class.
- **Composite** is great for dealing with tree structures and treating individual objects and compositions uniformly.
- **Template Method** allows you to define an algorithm's structure while letting subclasses alter certain steps without changing the algorithm itself.
