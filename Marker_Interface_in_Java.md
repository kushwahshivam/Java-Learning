## Marker Interfaces in Java
A marker interface in Java is an interface with no methods or constants inside it. It's used to "mark" or tag certain classes to indicate that they have a specific property or should be treated in a certain way by the JVM or other code.

### Common Marker Interfaces
- **Serializable**: Indicates that a class can be serialized (converted into a byte stream).

- **Cloneable**: Indicates that a class allows cloning (creating a copy of an object).

- **Remote**: Marks a class as available to be called remotely using RMI (Remote Method Invocation).

### Example
Marker Interface Definition:

```java
// Marker interface
public interface SpecialFeature {
    // No methods or fields
}
```


### Class Implementing Marker Interface:

```java
public class MyClass implements SpecialFeature {
    private String name;

    public MyClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```


### Utilizing the Marker Interface:

```java
public class MarkerInterfaceExample {

    public static void main(String[] args) {
        MyClass myObject = new MyClass("Example");

        if (myObject instanceof SpecialFeature) {
            System.out.println(myObject.getName() + " has the special feature!");
        } else {
            System.out.println(myObject.getName() + " does not have the special feature.");
        }
    }
}
```

### Uses of Marker Interfaces

- **Type Identification**: They allow the developer to indicate that a class belongs to a specific type. This is useful for type-checking at runtime using the instanceof operator.

- **Metadata Tagging**: Marker interfaces provide metadata about a class. This metadata can be used by tools and libraries to process objects differently based on whether they implement the marker interface.

- **Enforcing Contracts**: They can be used to enforce that certain classes adhere to specific contracts. For instance, only classes that implement Serializable can be passed to certain I/O streams that require objects to be serialized.
