<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/welcome.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/css/LoginLayout.css">
</head>
<body background="resources/images/wc.jpg">
	<div align="center">
		<div class="myLogin">
			<br>
			<div style="font: bold; color: DarkBlue; font-size: xx-large;">Welcome
				Back!! Enter the details to Login</div>
			<br> <label><span>Username</span> <input type="text" name="username" id="username" class="input"></label>
			<br> <label><span>Password</span> <input type="password" name="password" id="password" class="input"></label>
			<br>
			<br> <INPUT TYPE="SUBMIT" value="Login" class="submit" align="left"> 
		</div>
	</div>
</body>
</html>