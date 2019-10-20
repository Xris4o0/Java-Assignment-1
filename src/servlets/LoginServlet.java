package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
