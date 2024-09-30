# Setting Up Your Java Project with MySQL Connector/J

Setup Java project with MySQL Connector/J in both Visual Studio Code (VSCode) and IntelliJ IDEA on Ubuntu.

## Prerequisites
- Ensure you have Java Development Kit (JDK) installed. You can check by running `java -version` in the terminal.

## 1. Download MySQL Connector/J

### For Ubuntu 22.04
1. Open a terminal.
2. Download the MySQL Connector/J .deb package:

   ```bash
   wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java_9.0.0-1ubuntu22.04_all.deb
    ```
- Or you can download it from the official website  [here](https://dev.mysql.com/downloads/connector/j/).


3. Install the package using `dpkg`:

    ```bash
    sudo dpkg -i mysql-connector-java-9.0.0.deb
    ```

4. Locate the JAR file (usually installed in `/usr/share/java/`):

    ```bash
    ls /usr/share/java/mysql-connector-java-9.0.0.jar
    ```

## 2. Setting Up in Visual Studio Code (VSCode)

1. **Install Java Extension Pack**

    - Open VSCode.
    - Go to the Extensions view by clicking on the Extensions icon in the Activity Bar or by pressing `Ctrl + Shift + X`.
    - Search for **Java Extension Pack** and install it.

2. **Create a New Java Project**

    - Open the Command Palette by pressing `Ctrl + Shift + P`.
    - Type and select Java: Create Java Project.
    - Choose a location to create your project and select a project type (e.g., No Build Tools).

3. **Add MySQL Connector/J JAR to Your Project**
    - Copy the JAR file to your project directory. For example:

    ```bash
    cp /usr/share/java/mysql-connector-java-9.0.0.jar /path/to/your_project/lib/
    ```

4. **Configure Classpath**
    - Create a folder named `lib` inside your project directory (if not already done).

    - In your project, create a new file named `launch.json` inside the `.vscode` folder (you may need to create this folder).

    - Add the following configuration in `launch.json`:

    ```json
    {
        "version": "0.2.0",
        "configurations": [
            {
                "type": "java",
                "name": "Launch Java Program",
                "request": "launch",
                "mainClass": "jdbctest",
                "classpath": [
                    "lib/mysql-connector-java-9.0.0.jar"
                ]
            }
        ]
    }
    ```
    Adjust the `mainClass` to your class name.
    
## 3. Setting Up in IntelliJ IDEA

1. **Create a New Java Project**

    - Open IntelliJ IDEA.
    - Click on New Project.
    - Select Java from the left panel, choose your JDK, and click Next.
    - Name your project and select a location. Click Finish.

2. **Add MySQL Connector/J as a Dependency**

    - Right-click on your project in the Project view and select **Open Module Settings** (or press `F4`).
    - Go to the Libraries section.
    - Click the `+` button, select Java, and then navigate to the JAR file located at `/usr/share/java/mysql-connector-java-9.0.0.jar`.
    - Click **OK** to add the library.

## 4. Steps to Add the code

1. **Open Your Project:**

    - If you’re using VSCode, open your Java project folder.
    - If you’re using IntelliJ IDEA, open the project you created.

2. **Navigate to the src Directory:**

    - In the project explorer, find the src folder.

3. **Create a New Java Class:**

- VSCode:
    - Right-click on the src folder, select New File, and name it jdbctest.java.
- IntelliJ IDEA:
    - Right-click on the src folder, select New > Java Class, and name it jdbctest.

4. **Add the Code:**

- Open jdbctest.java and copy the sample code provided earlier:

    ```java
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class jdbctest {
        // Database URL, username, and password
        private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
        private static final String USER = "your_username";
        private static final String PASSWORD = "your_password";

        public static void main(String[] args) {
            // Establishing the connection
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                if (connection != null) {
                    System.out.println("Connected to the database successfully!");
                }
            } catch (SQLException e) {
                System.err.println("Connection failed: " + e.getMessage());
            }
        }
    }
    ```

5. **Update Database Credentials:**

    - Replace `your_database_name`, `your_username`, and `your_password` with your actual MySQL credentials.

6. **Run Your Program:**

    - In **VSCode**, press `F5` or select "Run" from the top menu.
    In **IntelliJ IDEA**, right-click on the file in the project explorer and select Run **'jdbctest.main()'**.

*After running the program, check the console output for the success message.*

## Summary
- In **VSCode**, download and install the MySQL Connector/J, set up a project, add the MySQL JAR, configure the classpath, and run your code.
- In **IntelliJ IDEA**, create a project, add the MySQL JAR as a library, write your code, and run it directly.
