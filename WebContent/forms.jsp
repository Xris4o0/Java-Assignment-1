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
<style>

.button{
  font: bold 18px Arial;
  text-decoration: none;
  background-color: #EEEEEE;
  color: #333333;
  padding: 2px 6px 2px 6px;
  border-top: 1px solid #CCCCCC;
  border-right: 1px solid #333333;
  border-bottom: 1px solid #333333;
  border-left: 1px solid #CCCCCC;

}

</style>
<script src="https://www.google.com/recaptcha/api.js"></script>
</head>
<body>
	<form method="post" action="LoginServlet">
		<p>Username: <input type="email" name="adminEmail" placeholder="Enter username" required></p>
		<p>Password: <input type="password" name="adminPassword" placeholder="Enter password" pattern="(?=.*\W+)(?=.*[A-Z]).{6,12}" required title="Passwords must be 6 to 12 characters and must contain at least 1 uppercase letter and at least 1 special character"></p>

		<br>

		<%
			/*
			ReCaptcha c = ReCaptchaFactory.newReCaptcha("6Lf4hL4UAAAAAJa-tnbK6O8sFxbqfOEaz-aYKZNM","6Lf4hL4UAAAAAHbg87ZzyTgGJn3XlI7IK7GjQzD5", false);
			out.print(c.createRecaptchaHtml(null, null));
			// OLD KEYS "6Le6m7wUAAAAAMKKFEV-FCAHyjatbXuFYHxzK4UN","6Le6m7wUAAAAAPnZwErOTMjbcHAMM-tzdNB63GFq"
			*/
		%>			
		
		<div class="g-recaptcha" data-sitekey="6Lf4hL4UAAAAAJa-tnbK6O8sFxbqfOEaz-aYKZNM"></div>
		<br/>
		<a class="button" href="Registration.jsp">Register</a>
		<input class="button" type="submit" value="Login">
	</form>
	
	<a href="#">Forgot your password?</a>

</body>
</html>