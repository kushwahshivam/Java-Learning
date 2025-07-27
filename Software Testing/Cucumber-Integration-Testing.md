# Cucumber Testing Guide

## What is Cucumber?

Cucumber is a **Behavior-Driven Development (BDD)** framework for writing automated acceptance tests in a natural language style, specifically using the **Gherkin** syntax. It enables collaboration between developers, testers, and business stakeholders by creating executable specifications.

## Why Use Cucumber?

- Bridges communication gaps between technical and non-technical team members.
- Defines clear acceptance criteria before implementation.
- Produces living documentation that evolves with the application.
- Facilitates automated regression testing in an understandable format.
- Integrates well with Java tools and testing frameworks like JUnit or TestNG.

## Key Concepts

| Term             | Description                                                                                   |
|------------------|-----------------------------------------------------------------------------------------------|
| **Feature**      | A high-level description of a software feature or behavior, written in plain English.         |
| **Scenario**     | A specific example or test case under a feature that describes a particular behavior.         |
| **Steps**        | Actions or assertions in a scenario, expressed as `Given`, `When`, `Then`, `And`, or `But`.   |
| **Step Definitions** | Java methods that map to Gherkin steps and contain test automation logic.                    |
| **Hooks**        | Code blocks to run before or after scenarios, useful for setup and teardown.                   |
| **Tags**         | Labels to organize and selectively run scenarios or features.                                 |

## Basic Gherkin Syntax

- **Feature:** Starts the feature file, describing what’s being tested.
- **Scenario:** Defines a test case.
- **Given:** Initial context or state of the system.
- **When:** An action or event.
- **Then:** Expected outcome or assertion.
- **And/But:** Additional steps.

Example:

```gherkin
Feature: User Login

  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters valid username and password
    Then User is redirected to the dashboard
```

# Setting Up Cucumber with Java

## Prerequisites

- Java JDK (version 8+ recommended)
- Maven or Gradle build tool
- IDE such as IntelliJ IDEA or Eclipse

## Adding Dependencies (Maven Example)

Add the following dependencies to your `pom.xml`:

```xml
<dependencies>
  <!-- Cucumber Java -->
  <dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.11.0</version>
    <scope>test</scope>
  </dependency>

  <!-- Cucumber JUnit -->
  <dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>7.11.0</version>
    <scope>test</scope>
  </dependency>

  <!-- JUnit -->
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
  </dependency>

  <!-- Selenium WebDriver (optional, if UI testing) -->
  <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.4.0</version>
  </dependency>
</dependencies>
```

# Writing Feature Files

- Stored under `src/test/resources/features/`
- File extension: `.feature`
- Write features and scenarios in plain English using Gherkin syntax.

## Example: login.feature

```gherkin
Feature: User Login

  Scenario: Successful login with valid credentials
    Given User navigates to the login page
    When User enters username "testuser" and password "password123"
    Then User should see the homepage
```

# Creating Step Definitions

Stored under `src/test/java/your/package/steps/`

Java methods annotated with `@Given`, `@When`, `@Then`, matching the feature steps.

### Example:

```java
package your.package.steps;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class LoginSteps {

    @Given("User navigates to the login page")
    public void userNavigatesToLoginPage() {
        // Navigate to login page, e.g., Selenium WebDriver code
    }

    @When("User enters username {string} and password {string}")
    public void userEntersCredentials(String username, String password) {
        // Code to input username and password
    }

    @Then("User should see the homepage")
    public void userSeesHomepage() {
        // Assert user is redirected to homepage
        assertTrue(true); // replace with real check
    }
}
```

# Running Cucumber Tests

Create a test runner class with JUnit:

```java
package your.package.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/resources/features",
  glue = "your.package.steps",
  plugin = {"pretty", "html:target/cucumber-reports.html"},
  monochrome = true,
  tags = "@smoke" // optional: run scenarios with @smoke tag only
)
public class TestRunner {}
```
# Best Practices

- Write clear, concise feature files focusing on behavior, not implementation.
- Reuse step definitions to avoid duplication.
- Use hooks (`@Before`, `@After`) for setup/teardown.
- Tag scenarios for easy selective test execution.
- Keep business logic out of step definitions; delegate to helper classes or page objects.
- Regularly update feature files to keep documentation current.

# Common Troubleshooting

| Issue                      | Solution                                                                                  |
|----------------------------|-------------------------------------------------------------------------------------------|
| Steps not matched to definitions | Check for exact match of step text and regex patterns.                                   |
| Tests running but no output | Use `plugin = {"pretty", "html:target/cucumber-reports.html"}` in `@CucumberOptions`.    |
| Missing dependencies        | Ensure Cucumber and JUnit dependencies are added with correct versions.                   |
| Windows path issues         | Use forward slashes `/` in feature file paths and step definitions.                       |

# Useful Resources

- [Official Cucumber Website](https://cucumber.io/)
- [Cucumber JVM GitHub Repository](https://github.com/cucumber/cucumber-jvm)
- [Gherkin Reference](https://cucumber.io/docs/gherkin/reference/)
- [Cucumber with Selenium Tutorial](https://www.toolsqa.com/cucumber/cucumber-with-selenium/)

# Summary

Cucumber helps teams write executable specifications in plain English, automating acceptance tests that everyone can understand. It enhances communication and reduces misunderstandings between developers, testers, and business teams.

By mastering Cucumber, you bring clarity, automation, and collaboration into your testing and development process.

— Hardik Chouhan
