
# 📦 JUnit Demo Project

This is a simple Maven-based Java project to demonstrate **JUnit 4** and **JUnit 5** testing frameworks. It includes basic, exception, and parameterized tests.

## 📁 Project Structure

```markdown
src/
├── main/java/com/example/calculator/Calculator.java
└── test/java/com/example/calculator/
├── CalculatorJUnit4Test.java
├── CalculatorJUnit5Test.java
└── CalculatorParameterizedTest.java
```


## 🧪 Test Coverage

| Feature                         | JUnit 4        | JUnit 5        |
|--------------------------------|----------------|----------------|
| Basic tests                    | ✅             | ✅             |
| Exception testing              | ✅             | ✅             |
| Lifecycle annotations          | ✅             | ✅             |
| Parameterized tests            | ❌             | ✅             |
| Assertions                     | ✅             | ✅             |
| IDE + CLI test execution       | ✅             | ✅             |

## 🚀 How to Run

### 1. Prerequisites

- Java 8+
- Maven
- Any IDE (IntelliJ / Eclipse / VS Code)

### 2. Run via IDE

Right-click any test class → **Run Tests**

### 3. Run via Command Line

```bash
# Run all tests
mvn test
```
## ✅ JUnit Reference Guide

This document provides a quick reference to commonly used **JUnit assertions**, **annotations**, and **learning resources** to support your Java testing practices.

---

### ✅ Assertions Used (with Descriptions)

| Assertion                                | Description                                              |
|-----------------------------------------|----------------------------------------------------------|
| `assertEquals(expected, actual)`        | Verifies that two values are equal                      |
| `assertNotEquals(unexpected, actual)`   | Verifies that two values are *not* equal               |
| `assertTrue(condition)`                 | Verifies that the condition is true                     |
| `assertFalse(condition)`                | Verifies that the condition is false                    |
| `assertNull(object)`                    | Verifies that the object is null                        |
| `assertNotNull(object)`                 | Verifies that the object is not null                    |
| `assertThrows(Exception.class, executable)` | Verifies that the code under test throws an exception |
| `assertAll(...)` (JUnit 5 only)         | Groups multiple assertions to run together              |

---

### 🔖 Key Annotations in JUnit

| Annotation                          | JUnit Version | Purpose                                                  |
|-------------------------------------|---------------|----------------------------------------------------------|
| `@Test`                             | Both          | Marks a method as a test case                            |
| `@Before` / `@BeforeEach`           | JUnit 4 / 5   | Runs setup code before each test                         |
| `@After` / `@AfterEach`             | JUnit 4 / 5   | Runs cleanup code after each test                        |
| `@BeforeClass` / `@BeforeAll`       | JUnit 4 / 5   | Runs once before all test methods (must be `static`)     |
| `@AfterClass` / `@AfterAll`         | JUnit 4 / 5   | Runs once after all test methods (must be `static`)      |
| `@Ignore` / `@Disabled`             | JUnit 4 / 5   | Temporarily disables a test                              |
| `@ParameterizedTest`               | JUnit 5       | Runs the same test method multiple times with different inputs |
| `@CsvSource` / `@ValueSource`       | JUnit 5       | Supplies test data for parameterized tests               |
| `@DisplayName("name")`              | JUnit 5       | Assigns a custom display name to a test case             |

---

## 📚 Learn More

Here are some trusted resources to deepen your understanding of JUnit:

- 📘 [**JUnit 5 User Guide**](https://junit.org/junit5/docs/current/user-guide/)
- 📗 [**JUnit 4 Documentation**](https://junit.org/junit4/)
- 🧪 [**Baeldung JUnit Tutorials**](https://www.baeldung.com/category/junit/)
- 🛠 [**JUnit GitHub Repository**](https://github.com/junit-team/junit5)


## ✨ Tips

- Use JUnit 5 for new projects—it offers more power and flexibility.
- Keep tests isolated, readable, and meaningful.
- Combine `assertAll()` to validate multiple outcomes without halting on the first failure.
- Use `@DisplayName` to describe test intent clearly in reports or IDE output.

---

Happy Testing! 🎯


