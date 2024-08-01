package in.sp.backend;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login");
public class Login extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String myemail = req.getParameter("email1");
		String mypass = req.getParameter("pass1");
		
		if(myemail.equals("hardik@gmail.com")&&mypass.equals("123456")) {
			RequestDispatcher rd =  req.getRequestDispatcher("/profile.jsp");
			rd.forward(req,res);
		}
		else {
			RequestDispatcher rd =  req.getRequestDispatcher("/index.html");
			rd.forward(req, res);
		}
	}
}
