# Image Storage in MySQL Database using JDBC

This project demonstrates how to store and retrieve images in a MySQL database using Java and JDBC.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Setup Instructions](#setup-instructions)
- [Inserting an Image](#inserting-an-image)
- [Retrieving an Image](#retrieving-an-image)
- [Running the Code](#running-the-code)

## Prerequisites

- Java Development Kit (JDK) installed (version 8 or above).
- MySQL Server installed and running.
- MySQL Connector/J (JDBC Driver) for MySQL.
- An image file (e.g., `Book_001.jpg`) to insert into the database.

## Setup Instructions

1. **Create a MySQL Database and Table:**
   Execute the following SQL commands in your MySQL environment to create a database and a table for storing images:

   ```sql
   CREATE DATABASE test_db_02;

   USE test_db_02;

   CREATE TABLE books (
       isbn VARCHAR(13) PRIMARY KEY,
       image BLOB
   );
   ```

2. **Download MySQL Connector/J:**

- Download the MySQL Connector/J from the official website: MySQL Connector/J.
- Place the downloaded `.jar` file (e.g., `mysql-connector-j-9.0.0.jar`) in the same directory as your Java programs.

## Inserting an Image

To insert an image into the database, use the `InsertImgInDB.java` file.

### Modifications Needed

1. **Update Database Credentials:** In the `database.properties` file, modify the following lines with your MySQL username and password:

    ```properties
    db.url=jdbc:mysql://localhost:3306/[database_name]
    db.username=[user_name]
    db.password=[password]
    ```
2. **Update ISBN and Image Path:**

- Change the ISBN number if necessary:

    ```java
    pstmt.setString(1, "978-3-16-148410-1");
    ```
- Ensure the path to the image file is correct. Update the following line to point to your image file:

    ```java
    File image = new File("Book_001.jpg"); // Update with your image filename
    ```

### Running the Code
1. **Compile the program:**

    ```bash
    javac -cp .:mysql-connector-j-9.0.0.jar InsertImgInDB.java
    ```

2. **Run the program:**

    ```bash
    java -cp .:mysql-connector-j-9.0.0.jar InsertImgInDB
    ```

If successful, the console will display: `A book image was inserted successfully.`

## Retrieving an Image
To retrieve the image from the database, use the `RetrieveImgFromDB.java` file.

### Modifications Needed

1. **Update Database Credentials:** In the `RetrieveImgFromDB.java` file, modify the following lines with your MySQL username and password:

    ```java
    String username = "your_username";  // e.g., "root"
    String password = "your_password";  // e.g., "123456"
    ```

2. **Update ISBN:** Change the ISBN to the one used for insertion if needed:

    ```java
    pstmt.setString(1, "978-3-16-148410-1");
    ```

### Running the Code

1. Compile the program:

    ```bash
    javac -cp .:mysql-connector-j-9.0.0.jar RetrieveImgFromDB.java
    ```

2. Run the program:

    ```bash
    java -cp .:mysql-connector-j-9.0.0.jar RetrieveImgFromDB
    ```

If successful, the console will display: `Image retrieved and saved as Retrieved_Book_001.jpg`. The image will be saved in your working directory.