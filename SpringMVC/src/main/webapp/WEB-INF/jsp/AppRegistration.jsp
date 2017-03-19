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
			<div style="font: bold; color: DarkBlue; font-size: xx-large;">Welcome!! Enter the details to Register</div>
			<br> <label><span>Username</span> <input type="text" name="username" id="username" class="input"></label>
			<br> <label><span>Password</span><input type="password" name="password" id="password" class="input"></label>
			<br> <label><span>Confirm Password</span><input type="password" name="confirmpassword" id="confirmpassword" class="input"></label>
			<br>
			<br> <label><span>EmailId</span><input type="text" name="email" id="email" class="input"></label>
			<br> <label><span>Phone</span><input type="text" name="phone" id="phone" class="input"></label>
			<br> <label><span>Full Name</span><input type="text" name="name" id="name" class="input"></label>
			<br>
			<br> <label><span>Address</span><input type="text" name="address" id="address" class="input"></label>
			<br> <label><span>Age</span><input type="text" name="age" id="age" class="input"></label>
			<br> <label><span>SSN</span><input type="text" name="ssn" id="ssn" class="input"></label>
			<br> <label><span>Security Question </span><select name="Security Question" onclick="">
					<option value="1" class="input">Select</option>
    				<option value="1" class="input">What is the name of your first Car?</option>
    				<option value="2" class="input">What is the name of your first School?</option>
    				<option value="3" class="input">Which city were you born in?</option>
  				  </select></label>
			<br> <INPUT TYPE="SUBMIT" value="Register" class="submit" align="left"> 
		</div>
	</div>
</body>
</html>