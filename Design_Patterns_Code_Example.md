# Common Design Patterns with Code Examples (C++ and Java)

Design patterns are general reusable solutions to commonly occurring problems in software design. They can be classified into **Creational**, **Structural**, and **Behavioral** patterns. Below are some of the most common design patterns with code examples in both **C++** and **Java**.


## **Creational Design Patterns**

These patterns deal with object creation mechanisms, trying to create objects in a way that is suitable for the situation.

### 1. **Singleton Pattern**
Ensures that a class has only one instance and provides a global point of access to that instance.

**Use Case**: When you need to control access to shared resources, like a database or a configuration file.

#### **C++:**
```cpp
class Singleton {
private:
    static Singleton* instance;

    // Private constructor to prevent instantiation
    Singleton() {}

public:
    static Singleton* getInstance() {
        if (!instance) {
            instance = new Singleton();
        }
        return instance;
    }
};

Singleton* Singleton::instance = nullptr;

int main() {
    Singleton* s1 = Singleton::getInstance();
    Singleton* s2 = Singleton::getInstance();
    // s1 and s2 will be the same instance
}
```
#### **Java:**
```java
public class Singleton {
    private static Singleton instance;

    // Private constructor to prevent instantiation
    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        // s1 and s2 will be the same instance
    }
}
```

### 2. Factory Method Pattern
Defines an interface for creating objects, but lets subclasses alter the type of objects that will be created.

**Use Case**: When you have a superclass and want to allow different subclasses to create different objects.

#### **C++:**
```cpp
class Product {
public:
    virtual void doSomething() = 0;
};

class ConcreteProductA : public Product {
public:
    void doSomething() override {
        std::cout << "Product A" << std::endl;
    }
};

class ConcreteProductB : public Product {
public:
    void doSomething() override {
        std::cout << "Product B" << std::endl;
    }
};

class Creator {
public:
    virtual Product* createProduct() = 0;
};

class ConcreteCreatorA : public Creator {
public:
    Product* createProduct() override {
        return new ConcreteProductA();
    }
};

class ConcreteCreatorB : public Creator {
public:
    Product* createProduct() override {
        return new ConcreteProductB();
    }
};

int main() {
    Creator* creator = new ConcreteCreatorA();
    Product* product = creator->createProduct();
    product->doSomething();  // Product A
}
```

#### **Java:**
```java
abstract class Product {
    public abstract void doSomething();
}

class ConcreteProductA extends Product {
    @Override
    public void doSomething() {
        System.out.println("Product A");
    }
}

class ConcreteProductB extends Product {
    @Override
    public void doSomething() {
        System.out.println("Product B");
    }
}

abstract class Creator {
    public abstract Product createProduct();
}

class ConcreteCreatorA extends Creator {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}

public class Main {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreatorA();
        Product product = creator.createProduct();
        product.doSomething();  // Product A
    }
}
```

### 3. Abstract Factory Pattern
Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

**Use Case**: When you need to create multiple objects, each of which belongs to a certain family.

#### **C++:**
```cpp
class Button {
public:
    virtual void render() = 0;
};

class MacButton : public Button {
public:
    void render() override {
        std::cout << "Rendering Mac button" << std::endl;
    }
};

class WinButton : public Button {
public:
    void render() override {
        std::cout << "Rendering Windows button" << std::endl;
    }
};

class GUIFactory {
public:
    virtual Button* createButton() = 0;
};

class MacFactory : public GUIFactory {
public:
    Button* createButton() override {
        return new MacButton();
    }
};

class WinFactory : public GUIFactory {
public:
    Button* createButton() override {
        return new WinButton();
    }
};

int main() {
    GUIFactory* factory = new WinFactory();
    Button* button = factory->createButton();
    button->render();  // Rendering Windows button
}
```

#### **Java:**
```java
interface Button {
    void render();
}

class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Mac button");
    }
}

class WinButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows button");
    }
}

interface GUIFactory {
    Button createButton();
}

class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }
}

class WinFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }
}

public class Main {
    public static void main(String[] args) {
        GUIFactory factory = new WinFactory();
        Button button = factory.createButton();
        button.render();  // Rendering Windows button
    }
}
```

### 4. Builder Pattern
Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

**Use Case**: When you need to create complex objects with multiple parts or options.

#### **C++:**
```cpp
class Meal {
private:
    std::vector<std::string> items;

public:
    void addItem(const std::string& item) {
        items.push_back(item);
    }

    void showItems() {
        for (const auto& item : items) {
            std::cout << item << std::endl;
        }
    }
};

class MealBuilder {
public:
    Meal buildMeal() {
        Meal meal;
        meal.addItem("Burger");
        meal.addItem("Soda");
        return meal;
    }
};

int main() {
    MealBuilder builder;
    Meal meal = builder.buildMeal();
    meal.showItems();  // Burger, Soda
}
```

#### **Java:**
```java
import java.util.ArrayList;
import java.util.List;

class Meal {
    private List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    public void showItems() {
        for (String item : items) {
            System.out.println(item);
        }
    }
}

class MealBuilder {
    public Meal buildMeal() {
        Meal meal = new Meal();
        meal.addItem("Burger");
        meal.addItem("Soda");
        return meal;
    }
}

public class Main {
    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();
        Meal meal = builder.buildMeal();
        meal.showItems();  // Burger, Soda
    }
}
```

### 5. Prototype Pattern
Specifies the kinds of objects to create using a prototype instance and creates new objects by copying this prototype.

**Use Case**: When object creation is expensive or complex, and you want to clone an existing object.

#### **C++:**
```cpp
class Prototype {
public:
    virtual Prototype* clone() = 0;
};

class ConcretePrototype : public Prototype {
private:
    int data;

public:
    ConcretePrototype(int data) : data(data) {}

    Prototype* clone() override {
        return new ConcretePrototype(data);
    }

    void showData() {
        std::cout << "Data: " << data << std::endl;
    }
};

int main() {
    ConcretePrototype prototype(42);
    ConcretePrototype* clone = static_cast<ConcretePrototype*>(prototype.clone());
    clone->showData();  // Data: 42
}

#### **Java:**
```java
abstract class Prototype {
    public abstract Prototype clone();
}

class ConcretePrototype extends Prototype {
    private int data;

    public ConcretePrototype(int data) {
        this.data = data;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(this.data);
    }

    public void showData() {
        System.out.println("Data: " + data);
    }
}

public class Main {
    public static void main(String[] args) {
        ConcretePrototype prototype = new ConcretePrototype(42);
        ConcretePrototype clone = (ConcretePrototype) prototype.clone();
        clone.showData();  // Data: 42
    }
}
```
## Structural Design Patterns
These patterns focus on how to compose classes or objects to form larger structures while keeping them flexible and efficient.

### 1. Adapter Pattern
Allows incompatible interfaces to work together by providing a wrapper that "adapts" one interface to another.

**Use Case**: When you have a system that expects one interface but you need to integrate an incompatible class or interface.

#### **C++:**
```cpp
class OldSystem {
public:
    void oldRequest() {
        std::cout << "Old system request" << std::endl;
    }
};

class NewSystem {
public:
    virtual void newRequest() = 0;
};

class Adapter : public NewSystem {
private:
    OldSystem* oldSystem;

public:
    Adapter(OldSystem* os) : oldSystem(os) {}

    void newRequest() override {
        oldSystem->oldRequest();
    }
};

int main() {
    OldSystem* oldSystem = new OldSystem();
    Adapter* adapter = new Adapter(oldSystem);
    adapter->newRequest();  // Old system request
}
```

#### **Java:**
```java
class OldSystem {
    public void oldRequest() {
        System.out.println("Old system request");
    }
}

interface NewSystem {
    void newRequest();
}

class Adapter implements NewSystem {
    private OldSystem oldSystem;

    public Adapter(OldSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    @Override
    public void newRequest() {
        oldSystem.oldRequest();
    }

    public static void main(String[] args) {
        OldSystem oldSystem = new OldSystem();
        Adapter adapter = new Adapter(oldSystem);
        adapter.newRequest();  // Old system request
    }
}
```

This is just a start for both **C++** and **Java** code examples for **Creational** design patterns. There are many other patterns, like **Structural** (*Adapter, Composite, Decorator*) and **Behavioral** patterns (**Observer, Strategy**), that follow similar structures.