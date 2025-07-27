# JUnit Testing Framework with Java

JUnit is a widely used testing framework for Java that helps developers write and run repeatable automated tests. It is essential for Test-Driven Development (TDD) and ensures code correctness.

## Setting Up JUnit

### Prerequisites

- Java JDK (version 8+ recommended)
- Maven or Gradle build tool
- IDE such as IntelliJ IDEA or Eclipse

### Adding Dependencies (Maven Example)

Add the following dependency to your `pom.xml`:

```xml
<dependencies>
  <!-- JUnit 4 -->
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
  </dependency>

  <!-- For JUnit 5 (Jupiter) -->
  <!--
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.2</version>
    <scope>test</scope>
  </dependency>
  -->
</dependencies>
```
## Writing Test Cases

### JUnit 4 Example

Create test classes under `src/test/java/your/package/`

```java
package your.package;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(2, 3);
        assertEquals(5, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator calc = new Calculator();
        calc.divide(10, 0);
    }
}
```
## Writing Test Cases

### JUnit 5 Example

JUnit 5 offers more features and annotations for writing tests.

Create test classes under `src/test/java/your/package/`

Example test class:

```java
package your.package;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void testDivideByZero() {
        Calculator calc = new Calculator();
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
    }
}
```
## Common Annotations

| Annotation                            | Description                                  |
|-------------------------------------|----------------------------------------------|
| `@Test`                             | Marks a method as a test method               |
| `@Before` (JUnit 4) / `@BeforeEach` (JUnit 5) | Runs before each test method (setup)         |
| `@After` (JUnit 4) / `@AfterEach` (JUnit 5)   | Runs after each test method (cleanup)        |
| `@BeforeClass` (JUnit 4) / `@BeforeAll` (JUnit 5) | Runs once before all tests (static)          |
| `@AfterClass` (JUnit 4) / `@AfterAll` (JUnit 5)   | Runs once after all tests (static)           |
| `@Ignore` (JUnit 4) / `@Disabled` (JUnit 5) | Skips a test method                           |

## Assertions

JUnit provides various assertions to verify expected outcomes:

| Assertion                                | Description                      |
|-----------------------------------------|----------------------------------|
| `assertEquals(expected, actual)`         | Checks equality                  |
| `assertTrue(condition)`                   | Checks if condition is true      |
| `assertFalse(condition)`                  | Checks if condition is false     |
| `assertNull(object)`                       | Checks if object is null         |
| `assertNotNull(object)`                    | Checks if object is not null     |
| `assertThrows(Exception.class, executable)` | Checks if code throws an exception |

## Running Tests

- Run tests from your IDE’s built-in test runner.
- Use Maven: `mvn test`
- Use Gradle: `gradle test`
- Use JUnit Console Launcher for command line execution.

## Best Practices

- Write small, focused test methods testing one behavior at a time.
- Name tests clearly to reflect what they verify.
- Use setup/teardown methods to initialize and cleanup resources.
- Avoid dependencies between tests to keep them independent and reliable.
- Use parameterized tests for testing multiple input combinations.
- Keep business logic out of tests; tests should verify behavior only.

## Common Troubleshooting

| Issue                    | Solution                                                       |
|--------------------------|----------------------------------------------------------------|
| Tests not running         | Ensure correct dependencies are included and test classes are in `src/test/java`. |
| Assertions failing unexpectedly | Double-check expected vs actual values, test data correctness. |
| Tests order affects results | Make tests independent; do not rely on test execution order.    |
| Exception tests not working | Use correct syntax for expected exceptions (`@Test(expected=...)` or `assertThrows`). |

## Useful Resources

- [JUnit 4 Official Documentation](https://junit.org/junit4/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Baeldung JUnit Tutorials](https://www.baeldung.com/category/junit/)
- [JUnit GitHub Repository](https://github.com/junit-team/junit5)

## Summary

JUnit is a foundational testing tool for Java developers that supports writing and running automated tests with ease. By integrating JUnit into your development workflow, you ensure your code quality, reduce bugs, and facilitate maintainable software.

Mastering JUnit will boost your productivity and confidence in your Java projects.

— Hardik Chouhan
