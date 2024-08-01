package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.jasper.tagplugins.jstl.core.Out;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




@WebServlet("/submitForm")
public class MyServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    // Set the content type
	    res.setContentType("text/html");

	    // Get parameters from request
	    String myname = req.getParameter("name1");
	    String myemail = req.getParameter("email1");

	    // Print to console (for server logs)
	    System.out.println("Name: " + myname);
	    System.out.println("Email: " + myemail);

	    // Write response
	    PrintWriter out = res.getWriter();
	    out.println("<html><body>");
	    out.println("Name: " + myname + "<br>");
	    out.println("Email: " + myemail);
	    out.println("</body></html>");
	}
}
