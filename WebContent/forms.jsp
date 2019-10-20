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
<!-- <script src="https://www.recaptcha.net/recaptcha/api.js" async defer></script> -->
</head>
<body>
	<form method="post" action="LoginServlet">
		<p>Username: <input type="email" name="adminEmail" placeholder="Enter username" required></p>
		<p>Password: <input type="password" name="adminPassword" placeholder="Enter password" pattern="(?=.*\W+)(?=.*[A-Z]).{6,12}" required title="Passwords must be 6 to 12 characters and must contain at least 1 uppercase letter and at least 1 special character"></p>

		<br>

		<%
			
		/*
			ReCaptcha c = ReCaptchaFactory.newReCaptcha("6Le6m7wUAAAAAMKKFEV-FCAHyjatbXuFYHxzK4UN","6Le6m7wUAAAAAPnZwErOTMjbcHAMM-tzdNB63GFq", false);
			out.print(c.createRecaptchaHtml(null, null));
		*/
			/*
			
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
		<button>Register</button>
		<button
		class="g-recaptcha"
		data-sitekey=""
		data-callback="">
			Submit
		</button>
	</form>
	<a href="#">Forgot your password?</a>


</body>
</html>