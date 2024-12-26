# SOLID Principles of Object-Oriented Design (OOD) in Java

The SOLID principles are a set of five design principles that help improve the maintainability, readability, and flexibility of object-oriented software systems. They are:

- **S** - Single Responsibility Principle (SRP)
- **O** - Open/Closed Principle (OCP)
- **L** - Liskov Substitution Principle (LSP)
- **I** - Interface Segregation Principle (ISP)
- **D** - Dependency Inversion Principle (DIP)

## 1. Single Responsibility Principle (SRP)

**Definition:**  
A class should have only one reason to change, meaning it should have only one job or responsibility.

### Explanation:
Each class should handle only one responsibility or concern. This makes the class easier to maintain and modify over time. If a class has more than one responsibility, changes in one part of the system may affect the other parts of the class, leading to difficulties in testing and maintenance.

### Java Example:

```java
// Incorrect: Employee class is doing more than one responsibility
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Responsibility: Salary Calculation
    public double calculateSalary() {
        return salary * 1.1; // Adding a 10% bonus
    }

    // Responsibility: Saving Employee to Database
    public void saveToDatabase() {
        // Logic to save employee to database
        System.out.println("Employee saved to database");
    }
}

// Correct: Divided responsibilities into separate classes
class SalaryCalculator {
    public double calculateSalary(Employee employee) {
        return employee.getSalary() * 1.1; // Adding a 10% bonus
    }
}

class EmployeeDatabase {
    public void save(Employee employee) {
        // Logic to save employee to database
        System.out.println("Employee saved to database");
    }
}
```

## 2. Open/Closed Principle (OCP)
**Definition:**
Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.

### Explanation:
The Open/Closed Principle encourages developers to design systems where new functionality can be added through extensions without changing existing code. This can be achieved using inheritance, interfaces, or abstract classes.

### Java Example:

```java
// Incorrect: We modify the class to add new report types
class ReportGenerator {
    public void generateReport(String reportType) {
        if (reportType.equals("PDF")) {
            System.out.println("Generating PDF report...");
        } else if (reportType.equals("HTML")) {
            System.out.println("Generating HTML report...");
        }
    }
}

// Correct: Open for extension, closed for modification
interface Report {
    void generate();
}

class PDFReport implements Report {
    public void generate() {
        System.out.println("Generating PDF report...");
    }
}

class HTMLReport implements Report {
    public void generate() {
        System.out.println("Generating HTML report...");
    }
}

class ReportGenerator {
    public void generateReport(Report report) {
        report.generate();
    }
}
```

## 3. Liskov Substitution Principle (LSP)

**Definition:**
Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.

### Explanation:
The Liskov Substitution Principle ensures that subclasses can be substituted for their base classes without introducing errors. A subclass should be able to extend the functionality of the parent class without changing its expected behavior.

### Java Example:
```java
// Incorrect: Violating LSP with inconsistent behavior
class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly!");
    }
}

// Correct: Maintaining consistent behavior in subclass
class Bird {
    public void move() {
        System.out.println("Moving...");
    }
}

class Sparrow extends Bird {
    @Override
    public void move() {
        System.out.println("Flying...");
    }
}

class Penguin extends Bird {
    @Override
    public void move() {
        System.out.println("Swimming...");
    }
}
```

## 4. Interface Segregation Principle (ISP)
**Definition:**
Clients should not be forced to depend on interfaces they do not use.

### Explanation:
Instead of creating large, monolithic interfaces, it is better to create smaller, more specific interfaces. Clients should only be required to implement the methods they actually need.

### Java Example:

```java
// Incorrect: A large interface with methods that not all implementers need
interface Worker {
    void work();
    void eat();
}

class Human implements Worker {
    public void work() {
        System.out.println("Working...");
    }

    public void eat() {
        System.out.println("Eating...");
    }
}

class Robot implements Worker {
    public void work() {
        System.out.println("Working...");
    }

    public void eat() {
        throw new UnsupportedOperationException("Robots don't eat!");
    }
}

// Correct: Split into smaller, more specific interfaces
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    public void work() {
        System.out.println("Working...");
    }

    public void eat() {
        System.out.println("Eating...");
    }
}

class Robot implements Workable {
    public void work() {
        System.out.println("Working...");
    }
}
```

## 5. Dependency Inversion Principle (DIP)
**Definition:**
High-level modules should not depend on low-level modules. Both should depend on abstractions.
Abstractions should not depend on details. Details should depend on abstractions.

### Explanation:
The Dependency Inversion Principle promotes decoupling high-level modules from low-level modules by introducing abstractions. High-level modules should depend on interfaces or abstract classes rather than concrete implementations.

### Java Example:
```java
// Incorrect: High-level module depending on low-level module
class LightBulb {
    public void turnOn() {
        System.out.println("LightBulb turned on");
    }

    public void turnOff() {
        System.out.println("LightBulb turned off");
    }
}

class Switch {
    private LightBulb bulb;

    public Switch(LightBulb bulb) {
        this.bulb = bulb;
    }

    public void operate() {
        bulb.turnOn();
    }
}

// Correct: Dependency on abstraction
interface Switchable {
    void turnOn();
    void turnOff();
}

class LightBulb implements Switchable {
    public void turnOn() {
        System.out.println("LightBulb turned on");
    }

    public void turnOff() {
        System.out.println("LightBulb turned off");
    }
}

class Fan implements Switchable {
    public void turnOn() {
        System.out.println("Fan turned on");
    }

    public void turnOff() {
        System.out.println("Fan turned off");
    }
}

class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void operate() {
        device.turnOn();
    }
}
```

### Summary
By following the SOLID principles, you can create object-oriented software that is:

- **SRP**: Focused on a single responsibility.
- **OCP**: Easy to extend without modifying existing code.
- **LSP**: Safe to substitute base class objects with subclass objects.
- **ISP**: Focused on client-specific interfaces.
- **DIP**: Decoupled from concrete implementations.

These principles help improve the maintainability, flexibility, and scalability of your software design.
