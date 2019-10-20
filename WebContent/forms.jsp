<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%-- Client Side (for image to appear) --%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory"%>

<%-- Server Side (for validation) --%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaImpl"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaResponse" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forms</title>
<script src="https://www.recaptcha.net/recaptcha/api.js" async defer></script>
</head>
<body>
	<form method="post" action="LoginServlet">
		<p>Username: <input type="email" name="adminEmail" placeholder="Enter username"></p>
		<p>Password: <input type="password" name="adminPassword"placeholder="Enter password"></p>

		<br>

		<%
			/*
		
			ReCaptcha c = ReCaptchaFactory.newReCaptcha("6Le6m7wUAAAAAMKKFEV-FCAHyjatbXuFYHxzK4UN","6Le6m7wUAAAAAPnZwErOTMjbcHAMM-tzdNB63GFq", false);
			out.print(c.createRecaptchaHtml(null, null));
			
			// remoteAddr --> Users IP address
			String remoteAddr = request.getRemoteAddr();
			ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
			reCaptcha.setPrivateKey("6Le6m7wUAAAAAPnZwErOTMjbcHAMM-tzdNB63GFq");

			String challenge = request.getParameter("recaptcha_challenge_field");

			// uresponse --> Contains user's answer to CAPTCHA
			String uresponse = request.getParameter("recaptcha_response_field");
			ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

			if (reCaptchaResponse.isValid()) {
				out.print("Answer was entered correctly!");
			} else {
				out.print("Answer is wrong");
			}
			
			*/
		%>			
		<button>Login</button>
		
	</form>
	
	<a href="#">Forgot your password?</a>
    <a href="Registration.jsp"> Register</a>

</body>
</html>