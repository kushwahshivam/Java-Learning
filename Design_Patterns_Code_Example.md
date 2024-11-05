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

### 2. Bridge Pattern
Definition: Decouples an abstraction from its implementation, allowing them to vary independently.
Use case: When you need to separate abstraction and implementation so that both can evolve independently.
Example: Separating the interface of a drawing shape (circle, rectangle) from the implementation (drawing in a window, console).

C++:
```cpp
class DrawingAPI {
public:
    virtual void drawCircle(int x, int y, int radius) = 0;
};

class OpenGLAPI : public DrawingAPI {
public:
    void drawCircle(int x, int y, int radius) override {
        std::cout << "OpenGL Circle at (" << x << ", " << y << ") with radius " << radius << std::endl;
    }
};

class DirectXAPI : public DrawingAPI {
public:
    void drawCircle(int x, int y, int radius) override {
        std::cout << "DirectX Circle at (" << x << ", " << y << ") with radius " << radius << std::endl;
    }
};

class Shape {
protected:
    DrawingAPI* api;

public:
    Shape(DrawingAPI* api) : api(api) {}

    virtual void draw() = 0;
    virtual void resize() = 0;
};

class Circle : public Shape {
private:
    int x, y, radius;

public:
    Circle(int x, int y, int radius, DrawingAPI* api) : Shape(api), x(x), y(y), radius(radius) {}

    void draw() override {
        api->drawCircle(x, y, radius);
    }

    void resize() override {
        radius += 5;
    }
};

int main() {
    OpenGLAPI* openGL = new OpenGLAPI();
    DirectXAPI* directX = new DirectXAPI();

    Shape* circle1 = new Circle(5, 5, 10, openGL);
    circle1->draw();  // OpenGL Circle at (5, 5) with radius 10

    Shape* circle2 = new Circle(10, 10, 15, directX);
    circle2->draw();  // DirectX Circle at (10, 10) with radius 15
}
```

Java:

```java
interface DrawingAPI {
    void drawCircle(int x, int y, int radius);
}

class OpenGLAPI implements DrawingAPI {
    public void drawCircle(int x, int y, int radius) {
        System.out.println("OpenGL Circle at (" + x + ", " + y + ") with radius " + radius);
    }
}

class DirectXAPI implements DrawingAPI {
    public void drawCircle(int x, int y, int radius) {
        System.out.println("DirectX Circle at (" + x + ", " + y + ") with radius " + radius);
    }
}

abstract class Shape {
    protected DrawingAPI api;

    public Shape(DrawingAPI api) {
        this.api = api;
    }

    public abstract void draw();
    public abstract void resize();
}

class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawingAPI api) {
        super(api);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        api.drawCircle(x, y, radius);
    }

    public void resize() {
        radius += 5;
    }

    public static void main(String[] args) {
        DrawingAPI openGL = new OpenGLAPI();
        DrawingAPI directX = new DirectXAPI();

        Shape circle1 = new Circle(5, 5, 10, openGL);
        circle1.draw();  // OpenGL Circle at (5, 5) with radius 10

        Shape circle2 = new Circle(10, 10, 15, directX);
        circle2.draw();  // DirectX Circle at (10, 10) with radius 15
    }
}
```

### 3. Composite Pattern
Definition: Composes objects into tree-like structures to represent part-whole hierarchies.
Use case: When you want to treat individual objects and compositions of objects uniformly.
Example: Filesystem where files and directories are both objects but directories contain multiple files (composite objects).

C++:
```cpp
#include <iostream>
#include <vector>
#include <string>

class Component {
public:
    virtual void display() = 0;
};

class Leaf : public Component {
private:
    std::string name;

public:
    Leaf(const std::string& name) : name(name) {}

    void display() override {
        std::cout << "Leaf: " << name << std::endl;
    }
};

class Composite : public Component {
private:
    std::vector<Component*> children;

public:
    void add(Component* component) {
        children.push_back(component);
    }

    void display() override {
        for (auto& child : children) {
            child->display();
        }
    }
};

int main() {
    Leaf* leaf1 = new Leaf("File1");
    Leaf* leaf2 = new Leaf("File2");

    Composite* directory = new Composite();
    directory->add(leaf1);
    directory->add(leaf2);

    directory->display();  // Displays both File1 and File2
}

Java:
```java
import java.util.ArrayList;
import java.util.List;

abstract class Component {
    public abstract void display();
}

class Leaf extends Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Leaf: " + name);
    }
}

class Composite extends Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void display() {
        for (Component child : children) {
            child.display();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Leaf leaf1 = new Leaf("File1");
        Leaf leaf2 = new Leaf("File2");

        Composite directory = new Composite();
        directory.add(leaf1);
        directory.add(leaf2);

        directory.display();  // Displays both File1 and File2
    }
}
```

### 4. Decorator Pattern
Definition: Adds behavior to an object dynamically without affecting the behavior of other objects from the same class.
Use case: When you want to extend the functionality of an object at runtime without modifying its structure.
Example: Adding responsibilities (like scrollbars or borders) to a graphical window object.

C++:
```cpp
#include <iostream>

class Window {
public:
    virtual void draw() = 0;
};

class SimpleWindow : public Window {
public:
    void draw() override {
        std::cout << "Drawing simple window" << std::endl;
    }
};

class WindowDecorator : public Window {
protected:
    Window* wrappedWindow;

public:
    WindowDecorator(Window* window) : wrappedWindow(window) {}

    void draw() override {
        wrappedWindow->draw();
    }
};

class ScrollWindowDecorator : public WindowDecorator {
public:
    ScrollWindowDecorator(Window* window) : WindowDecorator(window) {}

    void draw() override {
        WindowDecorator::draw();
        std::cout << "Adding scrollbars" << std::endl;
    }
};

int main() {
    Window* window = new SimpleWindow();
    Window* decoratedWindow = new ScrollWindowDecorator(window);
    decoratedWindow->draw();  // Drawing simple window, Adding scrollbars
}

Java:
```java
interface Window {
    void draw();
}

class SimpleWindow implements Window {
    public void draw() {
        System.out.println("Drawing simple window");
    }
}

class WindowDecorator implements Window {
    protected Window wrappedWindow;

    public WindowDecorator(Window window) {
        this.wrappedWindow = window;
    }

    public void draw() {
        wrappedWindow.draw();
    }
}

class ScrollWindowDecorator extends WindowDecorator {
    public ScrollWindowDecorator(Window window) {
        super(window);
    }

    public void draw() {
        super.draw();
        System.out.println("Adding scrollbars");
    }

    public static void main(String[] args) {
        Window window = new SimpleWindow();
        Window decoratedWindow = new ScrollWindowDecorator(window);
        decoratedWindow.draw();  // Drawing simple window, Adding scrollbars
    }
}
```

### 5. Facade Pattern
Definition: Provides a simplified interface to a complex subsystem, making it easier to interact with. It decouples clients from complex subsystem components, offering a higher-level interface.

Use case: When you want to provide a simplified interface to a larger body of code, such as when dealing with a complex system or set of APIs.

Example: A home theater system where you have subsystems like a DVD player, projector, lights, and sound system, and a facade class to simplify interactions.

C++:

```cpp
#include <iostream>

class DVDPlayer {
public:
    void play() {
        std::cout << "DVD player playing" << std::endl;
    }
};

class Projector {
public:
    void turnOn() {
        std::cout << "Projector turned on" << std::endl;
    }
};

class SoundSystem {
public:
    void activate() {
        std::cout << "Sound system activated" << std::endl;
    }
};

class HomeTheaterFacade {
private:
    DVDPlayer dvdPlayer;
    Projector projector;
    SoundSystem soundSystem;

public:
    void watchMovie() {
        projector.turnOn();
        soundSystem.activate();
        dvdPlayer.play();
    }
};

int main() {
    HomeTheaterFacade homeTheater;
    homeTheater.watchMovie();  // Simplified interface to start the movie
}
```

Java:

```java
class DVDPlayer {
    public void play() {
        System.out.println("DVD player playing");
    }
}

class Projector {
    public void turnOn() {
        System.out.println("Projector turned on");
    }
}

class SoundSystem {
    public void activate() {
        System.out.println("Sound system activated");
    }
}

class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, SoundSystem soundSystem) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.soundSystem = soundSystem;
    }

    public void watchMovie() {
        projector.turnOn();
        soundSystem.activate();
        dvdPlayer.play();
    }

    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, soundSystem);
        homeTheater.watchMovie();  // Simplified interface to start the movie
    }
}
```

### 6. Flyweight Pattern
Definition: Reduces memory usage by sharing common parts of an object. Rather than storing duplicate data, you store shared data once and reuse it wherever necessary. The idea is to minimize memory consumption by reusing as much data as possible.

Use case: When you need to manage large numbers of objects that share common data and only differ in a small, specific portion of their state. For instance, managing a large number of characters in a text editor where the character glyphs are shared, but each character has different positions.

Example: A text editor where common characters like "a", "b", "c" are shared across multiple places in the document to save space, while each occurrence only stores the specific position or formatting of the character.

C++:

```cpp
#include <iostream>
#include <unordered_map>
#include <string>

// Flyweight class
class Character {
public:
    virtual void display() = 0;
};

// Concrete Flyweight class
class ConcreteCharacter : public Character {
private:
    char value;

public:
    ConcreteCharacter(char value) : value(value) {}

    void display() override {
        std::cout << "Character: " << value << std::endl;
    }
};

// Flyweight Factory
class CharacterFactory {
private:
    std::unordered_map<char, Character*> characterPool;

public:
    Character* getCharacter(char value) {
        // Check if character already exists in the pool
        if (characterPool.find(value) == characterPool.end()) {
            characterPool[value] = new ConcreteCharacter(value);
        }
        return characterPool[value];
    }
};

int main() {
    CharacterFactory factory;

    // Create a document
    Character* charA = factory.getCharacter('a');
    Character* charB = factory.getCharacter('b');
    Character* charA2 = factory.getCharacter('a');  // Reuse the 'a' character object

    charA->display();  // Output: Character: a
    charB->display();  // Output: Character: b
    charA2->display(); // Output: Character: a (same as first 'a')

    return 0;
}
```

Java:

```java
import java.util.HashMap;
import java.util.Map;

// Flyweight class
interface Character {
    void display();
}

// Concrete Flyweight class
class ConcreteCharacter implements Character {
    private char value;

    public ConcreteCharacter(char value) {
        this.value = value;
    }

    @Override
    public void display() {
        System.out.println("Character: " + value);
    }
}

// Flyweight Factory
class CharacterFactory {
    private Map<Character, Character> characterPool = new HashMap<>();

    public Character getCharacter(char value) {
        // Check if character already exists in the pool
        if (!characterPool.containsKey(value)) {
            characterPool.put(value, new ConcreteCharacter(value));
        }
        return characterPool.get(value);
    }
}

public class Main {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        // Create a document
        Character charA = factory.getCharacter('a');
        Character charB = factory.getCharacter('b');
        Character charA2 = factory.getCharacter('a');  // Reuse the 'a' character object

        charA.display();  // Output: Character: a
        charB.display();  // Output: Character: b
        charA2.display(); // Output: Character: a (same as first 'a')
    }
}
```

### 7. Proxy Pattern
Definition: Provides a surrogate or placeholder for another object. The proxy controls access to the original object, allowing actions like lazy initialization, access control, logging, or monitoring.

Use case: When you need to control access to an object, such as lazy loading an object only when it’s needed, or adding access control or logging to an object.

Example: A virtual proxy pattern is often used to load large images only when they are needed, instead of loading them upfront, which can save memory and speed up application startup.

C++:

```cpp
#include <iostream>
#include <string>

// Subject Interface
class Image {
public:
    virtual void display() = 0;
};

// RealSubject class
class RealImage : public Image {
private:
    std::string filename;

public:
    RealImage(const std::string& filename) : filename(filename) {
        loadImage();
    }

    void loadImage() {
        std::cout << "Loading image: " << filename << std::endl;
    }

    void display() override {
        std::cout << "Displaying image: " << filename << std::endl;
    }
};

// Proxy class
class ProxyImage : public Image {
private:
    RealImage* realImage;
    std::string filename;

public:
    ProxyImage(const std::string& filename) : filename(filename), realImage(nullptr) {}

    void display() override {
        if (!realImage) {
            realImage = new RealImage(filename); // Lazy loading
        }
        realImage->display();
    }

    ~ProxyImage() {
        delete realImage;
    }
};

int main() {
    Image* image1 = new ProxyImage("image1.jpg");
    Image* image2 = new ProxyImage("image2.jpg");

    image1->display();  // Loads and displays image1.jpg
    image2->display();  // Loads and displays image2.jpg
    image1->display();  // Uses cached RealImage and just displays image1.jpg again

    delete image1;
    delete image2;
}
```

Java:

```java
// Subject Interface
interface Image {
    void display();
}

// RealSubject class
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImage();
    }

    public void loadImage() {
        System.out.println("Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy class
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); // Lazy loading
        }
        realImage.display();
    }
}

public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        image1.display();  // Loads and displays image1.jpg
        image2.display();  // Loads and displays image2.jpg
        image1.display();  // Uses cached RealImage and just displays image1.jpg again
    }
}
```

## Behavioral patterns

### 1. Chain of Responsibility Pattern
Definition: Passes a request along a chain of handlers. Each handler either processes the request or passes it to the next handler in the chain.

Use case: When multiple objects can handle a request, but the handler is not known a priori.

Example: Event handling systems or logging systems with multiple levels (info, debug, error).

C++ Example:
```cpp
#include <iostream>
#include <memory>

class Handler {
public:
    virtual void setNext(std::shared_ptr<Handler> nextHandler) = 0;
    virtual void handleRequest(int request) = 0;
};

class ConcreteHandlerA : public Handler {
private:
    std::shared_ptr<Handler> nextHandler;
public:
    void setNext(std::shared_ptr<Handler> nextHandler) override {
        this->nextHandler = nextHandler;
    }

    void handleRequest(int request) override {
        if (request == 1) {
            std::cout << "Handler A processed the request." << std::endl;
        } else if (nextHandler) {
            nextHandler->handleRequest(request);
        }
    }
};

class ConcreteHandlerB : public Handler {
private:
    std::shared_ptr<Handler> nextHandler;
public:
    void setNext(std::shared_ptr<Handler> nextHandler) override {
        this->nextHandler = nextHandler;
    }

    void handleRequest(int request) override {
        if (request == 2) {
            std::cout << "Handler B processed the request." << std::endl;
        } else if (nextHandler) {
            nextHandler->handleRequest(request);
        }
    }
};

int main() {
    std::shared_ptr<Handler> handlerA = std::make_shared<ConcreteHandlerA>();
    std::shared_ptr<Handler> handlerB = std::make_shared<ConcreteHandlerB>();

    handlerA->setNext(handlerB);

    handlerA->handleRequest(2); // Handler B processes the request
}
```

Java Example:

```java
abstract class Handler {
    protected Handler nextHandler;

    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(int request);
}

class ConcreteHandlerA extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request == 1) {
            System.out.println("Handler A processed the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class ConcreteHandlerB extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request == 2) {
            System.out.println("Handler B processed the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        
        handlerA.setNext(handlerB);
        
        handlerA.handleRequest(2); // Handler B processes the request
    }
}
```

### 2. Command Pattern
Definition: Encapsulates a request as an object, thereby allowing users to parameterize clients with different requests, queue or log requests, and support undoable operations.

Use case: When you want to decouple the sender of a request from the object that processes it.

Example: A remote control for a TV where pressing a button sends a request to turn on or off the TV.

C++ Example:
```cpp
#include <iostream>
#include <memory>

class Command {
public:
    virtual void execute() = 0;
};

class Light {
public:
    void turnOn() {
        std::cout << "Light is ON" << std::endl;
    }

    void turnOff() {
        std::cout << "Light is OFF" << std::endl;
    }
};

class LightOnCommand : public Command {
private:
    std::shared_ptr<Light> light;
public:
    LightOnCommand(std::shared_ptr<Light> light) : light(light) {}
    void execute() override {
        light->turnOn();
    }
};

class LightOffCommand : public Command {
private:
    std::shared_ptr<Light> light;
public:
    LightOffCommand(std::shared_ptr<Light> light) : light(light) {}
    void execute() override {
        light->turnOff();
    }
};

class RemoteControl {
private:
    std::shared_ptr<Command> command;
public:
    void setCommand(std::shared_ptr<Command> command) {
        this->command = command;
    }

    void pressButton() {
        command->execute();
    }
};

int main() {
    auto light = std::make_shared<Light>();
    auto lightOn = std::make_shared<LightOnCommand>(light);
    auto lightOff = std::make_shared<LightOffCommand>(light);

    RemoteControl remote;
    
    remote.setCommand(lightOn);
    remote.pressButton(); // Light is ON
    
    remote.setCommand(lightOff);
    remote.pressButton(); // Light is OFF
}
```

Java Example:

```java
interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();
        
        remote.setCommand(lightOn);
        remote.pressButton(); // Light is ON
        
        remote.setCommand(lightOff);
        remote.pressButton(); // Light is OFF
    }
}
```

### 3. Interpreter Pattern
Definition: Defines a grammar for interpreting sentences in a language. It allows you to interpret and evaluate language expressions.

Use case: When you have a small language or set of expressions that need to be interpreted.

Example: SQL query parsing or mathematical expression evaluation.

C++ Example:

```cpp
#include <iostream>
#include <string>
#include <map>

class Expression {
public:
    virtual int interpret() = 0;
};

class Number : public Expression {
private:
    int value;
public:
    Number(int value) : value(value) {}
    int interpret() override {
        return value;
    }
};

class Add : public Expression {
private:
    Expression* left;
    Expression* right;
public:
    Add(Expression* left, Expression* right) : left(left), right(right) {}
    int interpret() override {
        return left->interpret() + right->interpret();
    }
};

int main() {
    Expression* num1 = new Number(5);
    Expression* num2 = new Number(3);
    Expression* add = new Add(num1, num2);

    std::cout << "Result: " << add->interpret() << std::endl;  // Output: 8
}
```

Java Example:
```java
interface Expression {
    int interpret();
}

class Number implements Expression {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}

class Add implements Expression {
    private Expression left;
    private Expression right;

    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

public class Main {
    public static void main(String[] args) {
        Expression num1 = new Number(5);
        Expression num2 = new Number(3);
        Expression add = new Add(num1, num2);

        System.out.println("Result: " + add.interpret()); // Output: 8
    }
}
```

### 4. Iterator Pattern
Definition: Provides a way to sequentially access elements of a collection without exposing its underlying representation.

Use case: When you need to traverse a collection but don’t want to expose its internal structure.

Example: Iterating over elements in a list, tree, or map.

C++ Example:

```cpp
#include <iostream>
#include <vector>

class Iterator {
public:
    virtual bool hasNext() = 0;
    virtual int next() = 0;
};

class ConcreteIterator : public Iterator {
private:
    std::vector<int>& collection;
    size_t index = 0;
public:
    ConcreteIterator(std::vector<int>& collection) : collection(collection) {}

    bool hasNext() override {
        return index < collection.size();
    }

    int next() override {
        return collection[index++];
    }
};

int main() {
    std::vector<int> collection = {1, 2, 3, 4, 5};
    ConcreteIterator iterator(collection);

    while (iterator.hasNext()) {
        std::cout << iterator.next() << " ";
    }
    std::cout << std::endl;
}
```

Java Example:

```java
import java.util.ArrayList;
import java.util.List;

interface Iterator {
    boolean hasNext();
    int next();
}

class ConcreteIterator implements Iterator {
    private List<Integer> collection;
    private int index = 0;

    public ConcreteIterator(List<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return index < collection.size();
    }

    @Override
    public int next() {
        return collection.get(index++);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);

        Iterator iterator = new ConcreteIterator(collection);
        
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
```

### 5. Mediator Pattern
Definition: Defines an object that controls the communication between a set of objects, preventing direct communication between them.

Use case: When you have many objects interacting with each other, and you want to centralize control to reduce complexity.

Example: A chat application where the server mediates all communication between users.

C++ Example:

```cpp
#include <iostream>
#include <string>
#include <vector>

class Mediator {
public:
    virtual void sendMessage(const std::string& message, class Colleague* colleague) = 0;
};

class Colleague {
protected:
    Mediator* mediator;
public:
    Colleague(Mediator* mediator) : mediator(mediator) {}
    virtual void receiveMessage(const std::string& message) = 0;
};

class ChatRoom : public Mediator {
private:
    std::vector<Colleague*> colleagues;
public:
    void addColleague(Colleague* colleague) {
        colleagues.push_back(colleague);
    }

    void sendMessage(const std::string& message, Colleague* colleague) override {
        for (auto& col : colleagues) {
            if (col != colleague) {
                col->receiveMessage(message);
            }
        }
    }
};

class User : public Colleague {
private:
    std::string name;
public:
    User(Mediator* mediator, const std::string& name) : Colleague(mediator), name(name) {}

    void sendMessage(const std::string& message) {
        mediator->sendMessage(message, this);
    }

    void receiveMessage(const std::string& message) override {
        std::cout << name << " received: " << message << std::endl;
    }
};

int main() {
    ChatRoom chatRoom;

    User user1(&chatRoom, "Alice");
    User user2(&chatRoom, "Bob");

    chatRoom.addColleague(&user1);
    chatRoom.addColleague(&user2);

    user1.sendMessage("Hello, Bob!");
    user2.sendMessage("Hi, Alice!");
}
```

Java Example:

```java
import java.util.ArrayList;
import java.util.List;

interface Mediator {
    void sendMessage(String message, Colleague colleague);
}

abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receiveMessage(String message);
}

class ChatRoom implements Mediator {
    private List<Colleague> colleagues = new ArrayList<>();

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void sendMessage(String message, Colleague colleague) {
        for (Colleague col : colleagues) {
            if (col != colleague) {
                col.receiveMessage(message);
            }
        }
    }
}

class User extends Colleague {
    private String name;

    public User(Mediator mediator, String name) {
        super(mediator);
        this.name = name;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " received: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User user1 = new User(chatRoom, "Alice");
        User user2 = new User(chatRoom, "Bob");

        chatRoom.addColleague(user1);
        chatRoom.addColleague(user2);

        user1.sendMessage("Hello, Bob!");
        user2.sendMessage("Hi, Alice!");
    }
}
```

### 6. Memento Pattern
Definition: Captures the internal state of an object without exposing it, allowing the object to be restored to that state later.

Use case: When you want to store and restore the state of an object without exposing its internals.

Example: Undo/redo operations in text editors or game save points.

C++ Example:

```cpp
#include <iostream>
#include <string>

class Memento {
private:
    std::string state;
public:
    Memento(const std::string& state) : state(state) {}

    std::string getState() const {
        return state;
    }
};

class Originator {
private:
    std::string state;
public:
    void setState(const std::string& state) {
        this->state = state;
    }

    std::string getState() const {
        return state;
    }

    Memento saveStateToMemento() {
        return Memento(state);
    }

    void restoreStateFromMemento(const Memento& memento) {
        state = memento.getState();
    }
};

int main() {
    Originator originator;
    originator.setState("State1");

    // Save the state to memento
    Memento memento = originator.saveStateToMemento();
    std::cout << "Saved State: " << originator.getState() << std::endl;

    // Change state
    originator.setState("State2");
    std::cout << "Current State: " << originator.getState() << std::endl;

    // Restore state from memento
    originator.restoreStateFromMemento(memento);
    std::cout << "Restored State: " << originator.getState() << std::endl;

    return 0;
}
```

Java Example:

```java
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void restoreStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}

public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("State1");

        // Save the state to memento
        Memento memento = originator.saveStateToMemento();
        System.out.println("Saved State: " + originator.getState());

        // Change state
        originator.setState("State2");
        System.out.println("Current State: " + originator.getState());

        // Restore state from memento
        originator.restoreStateFromMemento(memento);
        System.out.println("Restored State: " + originator.getState());
    }
}
```

### 7. Observer Pattern
Definition: Defines a one-to-many dependency between objects, so that when one object changes state, all dependent objects are notified and updated automatically.

Use case: When multiple objects need to be notified about changes to another object, such as updating UI components.

Example: Event handling systems, like the observer pattern in GUI frameworks (e.g., buttons or form controls).

C++ Example:

```cpp
#include <iostream>
#include <vector>
#include <memory>

class Observer {
public:
    virtual void update(int state) = 0;
};

class Subject {
private:
    std::vector<std::shared_ptr<Observer>> observers;
    int state;
public:
    void attach(std::shared_ptr<Observer> observer) {
        observers.push_back(observer);
    }

    void setState(int state) {
        this->state = state;
        notify();
    }

    int getState() const {
        return state;
    }

    void notify() {
        for (auto& observer : observers) {
            observer->update(state);
        }
    }
};

class ConcreteObserver : public Observer {
private:
    std::string name;
public:
    ConcreteObserver(const std::string& name) : name(name) {}

    void update(int state) override {
        std::cout << "Observer " << name << " updated with state: " << state << std::endl;
    }
};

int main() {
    auto subject = std::make_shared<Subject>();

    auto observer1 = std::make_shared<ConcreteObserver>("A");
    auto observer2 = std::make_shared<ConcreteObserver>("B");

    subject->attach(observer1);
    subject->attach(observer2);

    subject->setState(1);  // Both observers are notified
    subject->setState(2);  // Both observers are notified again
}
```

Java Example:

```java
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(int state);
}

class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    public int getState() {
        return state;
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int state) {
        System.out.println("Observer " + name + " updated with state: " + state);
    }
}

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observer1 = new ConcreteObserver("A");
        Observer observer2 = new ConcreteObserver("B");

        subject.attach(observer1);
        subject.attach(observer2);

        subject.setState(1);  // Both observers are notified
        subject.setState(2);  // Both observers are notified again
    }
}
```

### 8. State Pattern
Definition: Allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

Use case: When an object needs to change its behavior based on its internal state, like a traffic light changing from red to green.

Example: A vending machine that behaves differently based on whether it's out of stock, has money inserted, or is dispensing an item.

C++ Example:

```cpp
#include <iostream>
#include <memory>

class State {
public:
    virtual void handleRequest() = 0;
};

class VendingMachine {
private:
    std::shared_ptr<State> currentState;
public:
    VendingMachine(std::shared_ptr<State> state) : currentState(state) {}

    void setState(std::shared_ptr<State> state) {
        currentState = state;
    }

    void request() {
        currentState->handleRequest();
    }
};

class NoMoneyState : public State {
public:
    void handleRequest() override {
        std::cout << "Insert money to proceed!" << std::endl;
    }
};

class HasMoneyState : public State {
public:
    void handleRequest() override {
        std::cout << "You can now select an item!" << std::endl;
    }
};

int main() {
    std::shared_ptr<State> noMoney = std::make_shared<NoMoneyState>();
    std::shared_ptr<State> hasMoney = std::make_shared<HasMoneyState>();

    VendingMachine vendingMachine(noMoney);
    vendingMachine.request();  // "Insert money to proceed!"

    vendingMachine.setState(hasMoney);
    vendingMachine.request();  // "You can now select an item!"
}
```

Java Example:

```java
interface State {
    void handleRequest();
}

class VendingMachine {
    private State currentState;

    public VendingMachine(State state) {
        this.currentState = state;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void request() {
        currentState.handleRequest();
    }
}

class NoMoneyState implements State {
    @Override
    public void handleRequest() {
        System.out.println("Insert money to proceed!");
    }
}

class HasMoneyState implements State {
    @Override
    public void handleRequest() {
        System.out.println("You can now select an item!");
    }
}

public class Main {
    public static void main(String[] args) {
        State noMoney = new NoMoneyState();
        State hasMoney = new HasMoneyState();

        VendingMachine vendingMachine = new VendingMachine(noMoney);
        vendingMachine.request();  // "Insert money to proceed!"

        vendingMachine.setState(hasMoney);
        vendingMachine.request();  // "You can now select an item!"
    }
}
```

### 9. Strategy Pattern
Definition: Defines a family of algorithms and allows the algorithm to be selected at runtime.

Use case: When you need to choose between different algorithms or behaviors based on context.

Example: A sorting strategy where you can choose between quicksort, mergesort, or bubblesort depending on the context.

C++ Example:

```cpp
#include <iostream>
#include <vector>
#include <algorithm>

class SortStrategy {
public:
    virtual void sort(std::vector<int>& data) = 0;
};

class QuickSort : public SortStrategy {
public:
    void sort(std::vector<int>& data) override {
        std::sort(data.begin(), data.end());  // Using built-in quicksort
        std::cout << "Sorted using QuickSort!" << std::endl;
    }
};

class MergeSort : public SortStrategy {
public:
    void sort(std::vector<int>& data) override {
        std::sort(data.begin(), data.end());  // Using built-in merge sort
        std::cout << "Sorted using MergeSort!" << std::endl;
    }
};

class SortContext {
private:
    SortStrategy* strategy;
public:
    SortContext(SortStrategy* strategy) : strategy(strategy) {}

    void setStrategy(SortStrategy* strategy) {
        this->strategy = strategy;
    }

    void sort(std::vector<int>& data) {
        strategy->sort(data);
    }
};

int main() {
    std::vector<int> data = {5, 3, 8, 6, 2};
    SortContext context(new QuickSort());
    context.sort(data);  // "Sorted using QuickSort!"

    context.setStrategy(new MergeSort());
    context.sort(data);  // "Sorted using MergeSort!"
}
```

Java Example:

```java
import java.util.ArrayList;
import java.util.List;

interface SortStrategy {
    void sort(List<Integer> data);
}

class QuickSort implements SortStrategy {
    @Override
    public void sort(List<Integer> data) {
        data.sort(Integer::compareTo);  // Using built-in quicksort
        System.out.println("Sorted using QuickSort!");
    }
}

class MergeSort implements SortStrategy {
    @Override
    public void sort(List<Integer> data) {
        data.sort(Integer::compareTo);  // Using built-in merge sort
        System.out.println("Sorted using MergeSort!");
    }
}

class SortContext {
    private SortStrategy strategy;

    public SortContext(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(List<Integer> data) {
        strategy.sort(data);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        data.add(5);
        data.add(3);
        data.add(8);
        data.add(6);
        data.add(2);

        SortContext context = new SortContext(new QuickSort());
        context.sort(data);  // "Sorted using QuickSort!"

        context.setStrategy(new MergeSort());
        context.sort(data);  // "Sorted using MergeSort!"
    }
}
```

### 10. Template Method Pattern
Definition: Defines the structure of an algorithm, deferring some steps to subclasses.

Use case: When you want to define a fixed sequence of steps and allow subclasses to provide their own implementation for certain steps.

Example: A base class that defines the skeleton of an algorithm, and subclasses implement specific steps like data reading or processing.

C++ Example:

```cpp
#include <iostream>

class AbstractClass {
public:
    void templateMethod() {
        step1();
        step2();
        step3();
    }

    virtual void step1() = 0;
    virtual void step2() = 0;
    void step3() {
        std::cout << "Step 3: Common behavior" << std::endl;
    }
};

class ConcreteClass : public AbstractClass {
public:
    void step1() override {
        std::cout << "Step 1: Specific behavior" << std::endl;
    }

    void step2() override {
        std::cout << "Step 2: Specific behavior" << std::endl;
    }
};

int main() {
    ConcreteClass obj;
    obj.templateMethod();
}
```

Java Example:

```java
abstract class AbstractClass {
    public void templateMethod() {
        step1();
        step2();
        step3();
    }

    abstract void step1();
    abstract void step2();
    
    void step3() {
        System.out.println("Step 3: Common behavior");
    }
}

class ConcreteClass extends AbstractClass {
    @Override
    void step1() {
        System.out.println("Step 1: Specific behavior");
    }

    @Override
    void step2() {
        System.out.println("Step 2: Specific behavior");
    }
}

public class Main {
    public static void main(String[] args) {
        ConcreteClass obj = new ConcreteClass();
        obj.templateMethod();
    }
}
```

### 11. Visitor Pattern
Definition: Allows you to define new operations on an object structure without changing the classes of the elements on which it operates.

Use case: When you need to perform operations on objects of various classes in a structure (like an abstract syntax tree).

Example: A visitor that adds up all values in a tree structure or performs some type of transformation on elements of a hierarchy.

C++ Example:

```cpp
#include <iostream>
#include <memory>

class Visitor;

class Element {
public:
    virtual void accept(Visitor& visitor) = 0;
};

class ConcreteElementA : public Element {
public:
    void accept(Visitor& visitor) override;
    void operationA() {
        std::cout << "ConcreteElementA operation" << std::endl;
    }
};

class ConcreteElementB : public Element {
public:
    void accept(Visitor& visitor) override;
    void operationB() {
        std::cout << "ConcreteElementB operation" << std::endl;
    }
};

class Visitor {
public:
    virtual void visit(ConcreteElementA& element) = 0;
    virtual void visit(ConcreteElementB& element) = 0;
};

class ConcreteVisitor : public Visitor {
public:
    void visit(ConcreteElementA& element) override {
        std::cout << "Visiting ConcreteElementA" << std::endl;
        element.operationA();
    }

    void visit(ConcreteElementB& element) override {
        std::cout << "Visiting ConcreteElementB" << std::endl;
        element.operationB();
    }
};

void ConcreteElementA::accept(Visitor& visitor) {
    visitor.visit(*this);
}

void ConcreteElementB::accept(Visitor& visitor) {
    visitor.visit(*this);
}

int main() {
    ConcreteElementA elementA;
    ConcreteElementB elementB;

    ConcreteVisitor visitor;

    elementA.accept(visitor);
    elementB.accept(visitor);
}
```

Java Example:

```java
interface Element {
    void accept(Visitor visitor);
}

class ConcreteElementA implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public void operationA() {
        System.out.println("ConcreteElementA operation");
    }
}

class ConcreteElementB implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public void operationB() {
        System.out.println("ConcreteElementB operation");
    }
}

interface Visitor {
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}

class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("Visiting ConcreteElementA");
        element.operationA();
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("Visiting ConcreteElementB");
        element.operationB();
    }
}

public class Main {
    public static void main(String[] args) {
        ConcreteElementA elementA = new ConcreteElementA();
        ConcreteElementB elementB = new ConcreteElementB();
        
        ConcreteVisitor visitor = new ConcreteVisitor();
        
        elementA.accept(visitor);
        elementB.accept(visitor);
    }
}


This is just a start for both **C++** and **Java** code examples for **Creational** design patterns. There are many other patterns, like **Structural** (*Adapter, Composite, Decorator*) and **Behavioral** patterns (**Observer, Strategy**), that follow similar structures.