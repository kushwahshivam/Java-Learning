<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Scripting Tag Demo Page</title>
</head>
<body>
    <h3>JSP Scripting Tag Demo Page</h3>
    <p>1. JSP Scripting tag has 3 types of tags: <i>Scriptlet tag, Declaration tag, Expression tag</i></p>
    
    <%
    	// Define variables
        String name = "Master";
        int a = 10;
        int len = name.length();
        int n = 10; // Define 'n' with a value
        
        // Calculate square directly in the scriptlet
        int square = a * a;
        
        // Print information
        System.out.println("a: " + a);
        out.println("\nName: " + name);
        out.println("\nLength of Name: " + len);
        out.println("\nSquare of a: " + square);
        
        // Conditional logic
        int b = 20;
        if (b < 100) {
            out.println("b is smaller than 100");
        } else {
            out.println("b is greater than 100");
        }
        
        // Loop example
        for (int i = 0; i < n; i++) {
            out.println(i);
        }
    %>
    
    <p>Hi <%= name %></p>
</body>
</html>
