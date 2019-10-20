package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

/*	
 *	
 * Project: StressGrammers	
 * Assignment: Java Assignment 1	
 * Author(s): Jason Thai, Hristo Tsvetkov, Nunkedie Steeven Wemin	
 * Student Number: 101107083, 100719969, 101091788	
 * Date: Oct. 20, 2019	
 * Description: This is a project that can log in, register, and view a dashboard page. 	
 * 	
 */

@WebServlet("/EmailSender")
public class EmailSender extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EmailSender() {
        super();
   }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // Recipient's email ID needs to be mentioned.
	      String to = (String)request.getAttribute("email");
	 
	      // Sender's email ID needs to be mentioned
	      String from = "hackersprojectjava@gmail.com";
	 
	      // Assuming you are sending email from localhost
	      String host = "localhost";
	 
	      // Get system properties
	      Properties properties = System.getProperties();
	 
	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);
	 
	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);
	      
	      // Set response content type
	      response.setContentType("text/html");
	     

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);
	         
	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));
	         
	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	         
	         // Set Subject: header field
	         message.setSubject("Email Confirmation");
	         
	         // Now set the actual message
	       //headers.addHeader("Content-type", "text/html; charset=UTF-8");
	     	//String html = "\n<a href='localhost:8080/Java-Assignment-1/index.jsp'>Go to login page</a>";
	     	//MimeBodyPart body = new MimeBodyPart(headers, html.getBytes("UTF-8"));
	         
	         message.setText("Your email has been verified you can login now."+"<a href='localhost:8080/Java-Assignment-1/index.jsp'>Go to login page</a>");
	         
	         // Send message
	         Transport.send(message);
	        
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
		
		
		request.getRequestDispatcher("SuccessfulRegistration.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
