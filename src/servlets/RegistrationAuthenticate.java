package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import database.DatabaseAccess;


@WebServlet("/RegistrationAuthenticate")
public class RegistrationAuthenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationAuthenticate() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fName = request.getParameter("Firstname");
		String lName = request.getParameter("Lastname");
		String address = request.getParameter("Address");
		String email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		String cPassword = request.getParameter("CPassword");
		String checkbox = request.getParameter("checkboxAgree");
		
		request.setAttribute("fName", fName);
		request.setAttribute("lName", lName);
		request.setAttribute("address", address);
		request.setAttribute("email", email);
		
		
		if(Password.equals(cPassword)) {
			
			if(checkbox != null) {
				
				DatabaseAccess DB = new DatabaseAccess();
				
				try {
					if(!DB.Check(email)){
						DB.Insert(fName, lName, email, address, Password);
						
						//email the client need to do
						
					      
						request.getRequestDispatcher("/EmailSender").forward(request, response);
					}
					else {request.setAttribute("message", "User exists already");
					request.getRequestDispatcher("Registration.jsp").forward(request, response);
					
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
						
			}
			else {request.setAttribute("message", "Terms of service not checked");
			request.getRequestDispatcher("Registration.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("message", "Please enter correct passwords");
			request.getRequestDispatcher("Registration.jsp").forward(request, response);
			
			
		}
		
	
		
		
	}





}
