<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>



</head>
<body>
<h1>REGISTRATION PAGE</h1>
       
<form action="RegistrationAuthenticate" method="post" >

<div style="text-align:center">
<b>${message} </b> <br>
Firstname* <input type="text" name="Firstname" value="${fName}" pattern="[a-zA-Z]+" title="No number allowed" required> 

Lastname* <input type="text" name="Lastname" value="${lName}" pattern="[a-zA-Z]+" title="No number allowed" required> <br><br>

Address* <input type="text" name="Address" value="${address}" required size="60" > <br><br>


 Email*  <input type="email" name="Email" value="${email}" required><br><br>
Password*  <input type="password" name="Password" pattern="(?=.*\W+)(?=.*[A-Z]).{6,12}" title="The password must be between 6-12 characters and must contain at least one uppercase letter and one special character" required>
<br><br>
Confirm Password*  <input type="password" name="CPassword"  pattern="(?=.*\W+)(?=.*[A-Z]).{6,12}" title="The password must be between 6-12 characters and must contain at least one uppercase letter and one special character"  required><br><br>

<input type="checkbox" name="checkboxAgree"> I agree to the <a href="">terms of service</a> <br> <br>
<button type="submit" name="RegisterBtn">Register</button>
<button type="submit" name="CancelBtn">Cancel</button>

</div>
</form>


</body>
</html>