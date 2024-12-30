## Default Methods in Java 8
In Java 8, the default keyword was introduced to allow developers to add new methods to interfaces without breaking the existing implementations of those interfaces.

### Example
Interface with Default Method:

```java
public interface Animal {
    // Abstract method
    void sound();

    // Default method
    default void eat() {
        System.out.println("This animal is eating.");
    }
}
```

### Class Implementing the Interface:

```java
public class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Woof");
    }
}
```

### Class with its Own Implementation of the Default Method:

```java
public class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Meow");
    }

    @Override
    public void eat() {
        System.out.println("This cat is eating gracefully.");
    }
}
```

### Using the Interface and Classes:

```java
public class DefaultMethodExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound(); // Output: Woof
        dog.eat();   // Output: This animal is eating.

        Cat cat = new Cat();
        cat.sound(); // Output: Meow
        cat.eat();   // Output: This cat is eating gracefully.
    }
}
```


### Benefits of Default Methods

- **Backward Compatibility:** Before Java 8, any change in an interface would require all implementing classes to be updated. The default keyword lets you add methods to interfaces without forcing existing classes to implement them, ensuring backward compatibility.

- **Interface Evolution**: It allows the evolution of interfaces. You can add new functionality to interfaces and provide a default implementation so that existing codebases remain functional and do not break.

- **Optional Methods**: Sometimes, an interface might have methods that are optional to implement. The default keyword allows you to provide a standard implementation for such methods, and individual classes can override these methods if they want a different behavior.

In essence, the default keyword enhances flexibility without violating the core principles of abstraction and interface contracts. This means you can evolve your interfaces while maintaining the simplicity and consistency of abstraction.
