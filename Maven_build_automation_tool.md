# 📘 Maven Essentials: A Developer's Guide

## 🚀 What is Maven?

Apache Maven is a **build automation and project management tool** primarily used for Java projects. It simplifies:
- Building projects
- Managing dependencies
- Running tests
- Generating reports
- Deploying artifacts

Maven uses an XML file called `pom.xml` (Project Object Model) to configure the build process and dependencies.

## 🛠️ Installation

1. Install Java JDK (8+ recommended)
2. Download Maven from [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
3. Add Maven `bin/` folder to your system's `PATH`
4. Verify installation:

    ```bash
     mvn -version
   ```
   
## 📁 Basic Project Structure

```css
my-app/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/
    │   └── resources/
    └── test/
        ├── java/
        └── resources/
```

## ⚙️ The `pom.xml` Breakdown

```xml
<project>
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.example</groupId>
  <artifactId>demo-project</artifactId>
  <version>1.0-SNAPSHOT</version>
  <dependencies>
    <!-- Add your dependencies here -->
  </dependencies>
</project>
```

# 🔁 Maven Build Lifecycle

Maven has three built-in lifecycles:

| Lifecycle | Description                      |
|-----------|----------------------------------|
| **clean**   | Cleans the `target/` directory       |
| **default** | Handles compilation, testing, packaging |
| **site**    | Generates documentation and reports |

Each lifecycle has phases:

## Default Lifecycle (Common Phases):

| Phase     | Description                        |
|-----------|----------------------------------|
| **validate** | Check project structure          |
| **compile**  | Compile source code              |
| **test**     | Run unit tests                  |
| **package**  | Bundle into JAR/WAR             |
| **verify**   | Run checks on results           |
| **install**  | Install artifact to local repository |
| **deploy**   | Copy to remote repository (e.g., Nexus) |

> 📝 **Note**: Each phase builds upon the previous. Running `mvn install` will automatically trigger all prior phases (`validate → compile → test → package → install`).

### 📌 Examples

Run common Maven lifecycle phases:

```bash
mvn compile         # Just compile
mvn test            # Compile + test
mvn package         # Compile + test + package
mvn clean install   # Clean + full build + local install
mvn site            # Generate project site
```

## 📦 Dependency Management

Add dependencies inside the `<dependencies>` tag:

```xml
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-lang3</artifactId>
  <version>3.12.0</version>
</dependency>
```
Maven automatically downloads them from Maven Central.


## 🔌 Commonly Used Plugins

Plugins extend Maven’s functionality.

| Plugin                  | Purpose                        |
|-------------------------|--------------------------------|
| maven-compiler-plugin   | Set Java version               |
| maven-surefire-plugin   | Run unit tests                |
| maven-jar-plugin        | Create JAR files              |
| maven-site-plugin       | Generate HTML documentation   |
| maven-clean-plugin      | Delete compiled files         |

### Example: Compiler Plugin

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.10.1</version>
      <configuration>
        <source>17</source>
        <target>17</target>
      </configuration>
    </plugin>
  </plugins>
</build>
```
## 🧪 Running Maven Commands

| Command               | Description                      |
|-----------------------|----------------------------------|
| `mvn compile`         | Compile source code              |
| `mvn test`            | Run tests                      |
| `mvn clean`           | Remove compiled output (`target/`) |
| `mvn package`         | Create JAR/WAR                 |
| `mvn install`         | Install locally                |
| `mvn site`            | Generate HTML reports          |
| `mvn dependency:tree` | Show full dependency hierarchy |


## 🗂️ Maven Repositories

| Type    | Location                             |
|---------|-------------------------------------|
| Local   | `~/.m2/repository`                  |
| Central | [https://repo.maven.apache.org/maven2](https://repo.maven.apache.org/maven2) |
| Remote  | Hosted (e.g., Nexus, Artifactory)  |


## 🏷️ Useful Concepts

| Concept              | Meaning                                         |
|----------------------|------------------------------------------------|
| SNAPSHOT             | Development version (non-final, changes frequently) |
| Transitive Dependency| A dependency’s own dependencies are also included |
| Scope                | Controls visibility: compile, test, provided, etc. |


## 🧩 Maven Profiles

Use profiles to customize builds for different environments (e.g., dev/staging/prod):

```xml
<profiles>
  <profile>
    <id>dev</id>
    <properties>
      <env>development</env>
    </properties>
  </profile>
</profiles>
```

Run with:

```bash
  mvn clean install -P dev
```

### 🔄 Best Practices

- ✅ **Always run** `mvn clean` before a fresh build to avoid stale artifacts.
- 🧪 **Use** `mvn verify` in CI pipelines to ensure post-package validations (tests, quality checks, etc.) are executed.
- 🚫 **Avoid running** `mvn deploy` locally unless you're intentionally pushing to a remote artifact repository.
- 🧠 **Use** `mvn dependency:tree` to inspect and debug transitive dependencies and resolve version conflicts.
- 🧩 **Split configurations** using Maven profiles (`<profiles>`) for different environments like `dev`, `test`, and `prod`.


## 📚 Recommended Learning Resources

- [Maven Official Documentation](https://maven.apache.org/)
- [Baeldung Maven Tutorials](https://www.baeldung.com/category/maven/)
- [Maven Repository Search](https://search.maven.org/)
- [Build Lifecycle Guide](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)


## ✅ Summary

Maven streamlines Java development by handling:

- Build automation  
- Dependency management  
- Project standardization  
- Team collaboration  

It’s a must-learn for Java developers working in team settings or enterprise systems.


*Author: Hardik Chouhan*
