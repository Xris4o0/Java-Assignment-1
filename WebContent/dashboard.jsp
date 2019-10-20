<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dashboard</title>
<style>

#title{
  	padding: 10px 20px;
	text-align:center;
	font-size: 30px;
}

.box{
	text-align:justify;
	background-color: #f1f1f1;
	border: 2px solid grey;
  	border-radius: 5px;
  	width: 49%;
  	height: 300px;
  	float: left;
}

.boxright{
	text-align:justify;
	background-color: #f1f1f1;
	border: 2px solid grey;
  	border-radius: 5px;
  	width: 49%;
  	height: 150px;
  	float: right;
}

.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
}

.header-right {
  float: right;
}

.button {
  background-color: Blue;
  border: none;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 12px;
  border-radius: 45%;
}


</style>
</head>
<body>
	
	<div class="container">
		
		<div class="header">
			<button class="button" type="button">Tab 1</button>
			<button class="button" type="button">Tab 2</button>
			<button class="button" type="button">Tab 3</button>
			<form action="LogoutServlet" method="post" class="header-right">
				Welcome ${user.getName()}! <button class="button" type="submit">Logout</button>
			</form>
		</div>
		<p id="title">Dashboard</p>
		<span class="box">Future Enhancement</span>
		<span class="boxright">Future Enhancement</span>
		<span class="boxright">Future Enhancement</span>
	
	</div>
	
</body>
</html>