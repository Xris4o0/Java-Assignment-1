package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Responsibilities:
 * -user for the necessary credentials (username / password) 
 * -contain a “reCaptcha” check box that will help to verify human interaction
 * -user requests a page that requires a user to be successfully logged in first 
 * -displaying error messages
 * -credentials --> username=admin@isp.net, password=P@ssword1
 * 
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Authenticate").forward(request, response);
	}

}
