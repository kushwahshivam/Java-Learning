# Understanding `private`, `final`, and `static` in Java

In Java, the keywords `private`, `final`, and `static` each serve distinct purposes when applied to a variable, method, or inner class within a class. Here's what they mean when used together:

1. **private**: This access modifier means that the member (variable or method) is only accessible within the class it is declared in. It cannot be accessed from outside this class, ensuring encapsulation.

2. **final**: When a variable is declared as `final`, it means that its value cannot be changed once it has been assigned. For methods, `final` indicates that the method cannot be overridden by subclasses. For classes, it means the class cannot be subclassed.

3. **static**: A static member belongs to the class itself rather than to any specific instance of the class. This means that you can access it without creating an instance of the class. Static members are shared among all instances of the class.

## Example Usage

Combining these three keywords might look like this:

```java
public class FileManager {
    private static final String FILE_NAME = "data.txt";

    public static void printFileName() {
        System.out.println(FILE_NAME);
    }
}
```

#### In this example:
- `FILE_NAME` is a constant that is private to `FileManager` and cannot be changed (`final`).
- It is `static`, so it can be accessed via the class name (`FileManager.FILE_NAME`) without needing an instance.


## 1. Private Variable

```java
public class Example {
    private static final int MAX_VALUE = 100; // Private static final variable

    public int getMaxValue() {
        return MAX_VALUE; // Accessing the private variable
    }
}
```

#### Explanation:

- `MAX_VALUE` is a private static final variable, meaning it can only be accessed within the `Example` class, and its value cannot be changed.

## 2. Private Method

```java
public class Example {
    private static final String SECRET = "This is a secret!"; // Private static final variable

    private static void displaySecret() { // Private static method
        System.out.println(SECRET);
    }

    public void revealSecret() {
        displaySecret(); // Accessing the private method
    }
}
```

#### Explanation:

- `displaySecret` is a private static method that can only be called within the `Example` class. It accesses the private variable `SECRET`.


## 3. Private Inner Class

```java
public class OuterClass {
    private static final String OUTER_CONSTANT = "Outer Constant";

    private static class InnerClass { // Private static inner class
        public void display() {
            System.out.println(OUTER_CONSTANT); // Accessing the outer class's constant
        }
    }

    public void createInnerInstance() {
        InnerClass inner = new InnerClass(); // Creating an instance of the private inner class
        inner.display(); // Calling the display method
    }
}
```

#### Explanation:

- `InnerClass` is a private static inner class that can only be accessed within `OuterClass`. It can access the private static constant `OUTER_CONSTANT`.


## 4. Private Final Variable

```java
public class Example {
    private final int instanceValue; // Private final variable

    public Example(int value) {
        this.instanceValue = value; // Value can be set only once
    }

    public int getInstanceValue() {
        return instanceValue; // Accessing the private final variable
    }
}
```

#### Explanation:

- `instanceValue` is a private final variable, meaning it can be assigned only once (in the constructor) and cannot be changed afterward.

## 5. Private Static Method

```java
public class Example {
    private static void displayMessage() { // Private static method
        System.out.println("This is a private static method.");
    }

    public void callDisplay() {
        displayMessage(); // Accessing the private static method
    }
}
```

#### Explanation:
- `displayMessage` is a private static method that can only be called within the `Example` class.

## 6. Private Final Method

```java
public class Example {
    private final void displayMessage() { // Private final method
        System.out.println("This is a private final method.");
    }

    public void showMessage() {
        displayMessage(); // Accessing the private final method
    }
}
```
#### Explanation:

- `displayMessage` is a private final method, meaning it cannot be overridden in subclasses and can only be called within the `Example` class.

## 7. Private Static Final Method

```java
public class Example {
    private static final void displayMessage() { // Private static final method
        System.out.println("This is a private static final method.");
    }

    public void callDisplay() {
        displayMessage(); // Accessing the private static final method
    }
}
```

#### Explanation:
- `displayMessage` is a private static final method. While the `final` modifier does not have an effect on static methods in this context (static methods cannot be overridden), it still emphasizes that this method cannot be hidden in subclasses.

## 6. Private Static Inner Class

```java
public class OuterClass {
    private static class InnerClass { // Private static inner class
        public void display() {
            System.out.println("This is a private static inner class.");
        }
    }

    public void createInnerInstance() {
        InnerClass inner = new InnerClass(); // Creating an instance of the private inner class
        inner.display(); // Calling the display method
    }
}
```
#### Explanation:

- `InnerClass` is a private static inner class that can only be accessed within `OuterClass`.

## 7. Private Final Class

```java
public class Outer {
    private final class FinalClass { // Private final inner class
        public void display() {
            System.out.println("This is a private final class.");
        }
    }

    public void createFinalClassInstance() {
        FinalClass finalClass = new FinalClass(); // Creating an instance of the private final class
        finalClass.display(); // Calling the display method
    }
}
```
#### Explanation:
- `FinalClass` is a private final class, meaning it cannot be subclassed and can only be accessed within the `Outer` class.

## Summary

These examples illustrate how `private`, `final`, and `static` can be used together in various combinations with:

- **Variables**: To restrict access and control mutability.
- **Methods**: To restrict access, prevent overriding, or indicate that the method is associated with the class rather than instances.
- **Classes**: To encapsulate functionality and control access and inheritance.

Understanding these combinations is essential for writing clean, maintainable Java code.