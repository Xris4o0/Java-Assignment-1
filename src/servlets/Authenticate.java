package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.User;

/*
 * Responsibilities: 
 * -Validating a forarded username and password
 * -Will not generate any HTML
 * -If any mandatory parameters are missing, direct user back without display error messages
 * -Store user info in a session object and direct to dashboard
 */

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Authenticate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		User user = new User();
		
		String username = request.getParameter("adminEmail");
		String password = request.getParameter("adminPassword");
		
		user.authen(username, password, request, response);
		
	}

}
