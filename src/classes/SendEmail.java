package classes;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

/*
 *
 *  Project: StressGrammers
 * Assignment: Java Assignment 1
 * Author(s): Jason Thai, Hristo Tsvetkov, Nunkedie Steeven Wemin
 * Student Number: 101107083, 100719969, 101091788
 * Date: Oct. 20, 2019
 * Description: This is a project that can log in, register, and view a dashboard page. 
 * 
 */

public class SendEmail extends HttpServlet {  
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request,  
 HttpServletResponse response)  
    throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
      
    String to = (String)request.getAttribute("email");  
    String subject = "Verification Email";  
    String msg = "This is a confirmation that your registration has been succesfully done.";  
          
    Mailer.send(to, subject, msg);  
    out.print("message has been sent successfully");  
    out.close();  
    }  
  
} 