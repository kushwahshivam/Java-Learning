<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSP Page Demo</h3>
	<p>jsp page used to display dynamic web content as shownd below</p>
	
	<%
		String name = "Master Name";
		int len = name.length();
	%>
	
	<p>Length of String "<%= name %>" is <%= len %></p>
	
	<hr>
	
	<p> The JSP Life Cycle is as below </p>
	<ol>
		<li>Translation: JSP -> Servlet</li>
		<li>Compilation: Servlet -> .class</li>
		<li>Loading & installation: .class file is loaded on server & object is created</li>
		<li>Initialization:[jspInit()] {as init() method in servlet)</li>
		<li>Request Handling:[_jspService()] {as service(), doGet(), doPost() method in servlet)</li>
		<li>Destroy: [jspDestroy()]{as destroy() in servlet}</li>
	</ol>
</body>
</html>