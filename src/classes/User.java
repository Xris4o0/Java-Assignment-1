package classes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DatabaseAccess;

public class User {

	protected String username;
	protected String password;
	protected DatabaseAccess authDao;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// For LoginServlet
	public void login(String username, String password, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String u = request.getParameter("adminEmail");
		String n = request.getParameter("adminPassword");
		
		try {
			authDao.checkCredentials(u, n);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!username.equals(u) &&  !password.equals(n)) {			
			request.getRequestDispatcher("Authenticate.java").forward(request, response);
		}


	}

	// For Authenticate
	public void authen(String username, String password, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Direct user back to index if missing required fields
		if (username.isEmpty() || password.isEmpty()) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {

			// Get credentials
			User user = new User();
			user.getUsername();
			user.getPassword();

			// Connect to database to validate
			try {
				authDao.checkCredentials(username, password);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Store in a session object
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("test.jsp").forward(request, response);

		}
	}
}
