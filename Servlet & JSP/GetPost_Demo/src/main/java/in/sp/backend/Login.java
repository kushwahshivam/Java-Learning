package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/myLogin")
public class Login extends HttpServlet{
	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {  // now if i use the GET in form action then it will throw Http STatus 405 Not Allowed
		String myemail= (String)req.getParameter("email1");
		String mypass = (String)req.getParameter("pass1");
		if(myemail.equals("hardik@gmail.com") && mypass.equals("123456")) {
			System.out.println("success");
			// Write response
		    PrintWriter out = res.getWriter();
		    out.println("Hi !, "+myemail);
		    out.println("Welcome :) you are successfully logged in");
		}
		else {
			System.out.println("Failure");
			PrintWriter out = res.getWriter();
			out.println("Failure");
		}
	}
}

 // when I use the Get url = "http://localhost:8080/GetPost_Demo/myLogin?email1=hardik%40gmail.com&pass1=123456"
// but when i use Post url = "http://localhost:8080/GetPost_Demo/myLogin"
