### Overview
Servlets and JSP are fundamental components of Java web applications. Servlets are Java programs that handle requests and responses, while JSP allows for dynamic content generation using HTML and embedded Java code.

# Servlets

#### Basic Concepts
- **HttpServlet**: A class that you extend to create a servlet.
- **doGet()**: Handles GET requests.
- **doPost()**: Handles POST requests.
- **Request and Response**: Objects that represent the client’s request and the server’s response.

#### Example
Here’s a simple servlet that responds with "Hello, World!" when accessed:

```java
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>Hello, World!</h1>");
    }
}
```

# JSP (JavaServer Pages)

#### Basic Concepts
- **Directives**: Provide global information about an entire JSP page (e.g., `<%@ page language="java" contentType="text/html; charset=UTF-8" %>`).
- **Scriptlets**: Allow you to embed Java code in HTML using `<% %>`.
- **Expressions**: Used to output data directly (e.g., `<%= variable %>`).

#### Example
Here’s a simple JSP page that displays a greeting:

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Greeting Page</title>
</head>
<body>
    <h1>Welcome to JSP!</h1>
    <p>Current Time: <%= new java.util.Date() %></p>
</body>
</html>
