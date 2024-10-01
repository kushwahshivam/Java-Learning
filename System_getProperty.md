# Java System.getProperty

`System.getProperty` is a method in Java that allows you to retrieve system properties and configuration settings. These properties provide information about the operating system, Java runtime environment, and other system-related details.

## Common System Properties

Below are some commonly used system properties you can retrieve using `System.getProperty`:

| Property Name             | Description                                     |
|---------------------------|-------------------------------------------------|
| `os.version`              | OS Version                                     |
| `os.name`                 | OS Name                                        |
| `os.arch`                 | OS Architecture                                |
| `java.compiler`           | Name of the compiler you are using             |
| `java.ext.dirs`          | Extension directory path                        |
| `java.library.path`       | Paths to search for libraries when loading     |
| `path.separator`          | Path separator                                  |
| `file.separator`          | File separator                                  |
| `user.dir`                | Current working directory of User               |
| `user.name`               | Account name of User                           |
| `java.vm.version`         | JVM implementation version                      |
| `java.vm.name`            | JVM implementation name                         |
| `java.home`               | Java installation directory                     |
| `java.runtime.version`    | JVM version                                    |

## Example Usage

Here’s a simple example of how to retrieve and print these system properties in Java:

```java
public class SystemPropertiesExample {
    public static void main(String[] args) {
        System.out.println("OS Name: " + System.getProperty("os.name"));
        System.out.println("OS Version: " + System.getProperty("os.version"));
        System.out.println("OS Architecture: " + System.getProperty("os.arch"));
        System.out.println("Java Compiler: " + System.getProperty("java.compiler"));
        System.out.println("Java Home: " + System.getProperty("java.home"));
        System.out.println("User Name: " + System.getProperty("user.name"));
        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
        System.out.println("JVM Version: " + System.getProperty("java.runtime.version"));
        System.out.println("JVM Name: " + System.getProperty("java.vm.name"));
    }
}
```

## Output
When you run the above code, you will see output similar to this:

```yaml
OS Name: Windows 10
OS Version: 10.0
OS Architecture: amd64
Java Compiler: javac
Java Home: C:\Program Files\Java\jdk-17
User Name: YourUsername
Current Working Directory: C:\Users\YourUsername\Projects
JVM Version: 17.0.1
JVM Name: OpenJDK 64-Bit Server VM
```

## Conclusion
Using `System.getProperty`, you can easily access various system-related properties in Java applications, which can be particularly useful for configuration, debugging, and ensuring compatibility across different environments.


