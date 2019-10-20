package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.User;
import classes.VerifyRecaptcha;
// import net.tanesha.recaptcha.ReCaptchaImpl;
// import net.tanesha.recaptcha.ReCaptchaResponse;
import database.DatabaseAccess;

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

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseAccess authDao;
    
    public Authenticate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		/*
		// remoteAddr --> Users IP address
		String remoteAddr = request.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6Lf4hL4UAAAAAHbg87ZzyTgGJn3XlI7IK7GjQzD5");

		String challenge = request.getParameter("recaptcha_challenge_field");

		// uresponse --> Contains user's answer to CAPTCHA
		String uresponse = request.getParameter("recaptcha_response_field");
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
		
		if (reCaptchaResponse.isValid()) {
		
			User user = new User();
			
			user.setUsername(request.getParameter("adminEmail"));
			
			user.authen(user, request, response);
		
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		*/
		
		User user = new User();
		user.setUsername(request.getParameter("adminEmail"));
		
		authen(user, request, response);	
		
	}
	
	// For LoginServlet
	public void authen(User user, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		
		boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
		
		if (verify) {
			// Direct user back to index if missing required fields
			if (user.getUsername().isEmpty() || request.getParameter("adminPassword").isEmpty()) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} 
			else {
				authDao = null;
				// Get credentials
				user.getUsername();
				
				// Connect to database to validate
				try {
					authDao.checkCredentials(user.getUsername(), request.getParameter("adminPassword"));
				}
				catch (Exception e) {
					e.printStackTrace();
				}

				// Store in a session object
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			}
		} 
		else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/index.jsp");
			PrintWriter out = response.getWriter();
			if (verify) {
				out.println("<font color=red>Either user name or password is wrong.</font>");
			} else {
				out.println("<font color=red>You missed the Captcha.</font>");
			}
			rd.include(request, response);
		}
	}
		
}


