<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Flight Management System</title>

</head>
<body style="background-color: #456789;">
	<div class="row">
		<div class="col-sm-6">
			<form method="POST" action="register_page" style="padding: 10%;">
				<h3 style="text-align: center; color: #ffffff; padding: 5%;">Registration</h3>
				</br>
				<div alight="left">
					<label class="form-label">Name</label> <input type="text"
						class="form-control" name="name" id="name" required>
				</div>

				<div alight="left">
					<label class="form-label">Email</label> <input type="email"
						class="form-control" name="email" id="email" required>
				</div>
				<div alight="left">
					<label class="form-label">Date of Birth</label> <input type="date"
						class="form-control" name="dob" id="dob" required>
				</div>
				<div alight="left">
					<label class="form-label">Phone</label> <input type="phone"
						class="form-control" name="phone" id="phone" required>
				</div>
				<div alight="left">
					<label class="form-label">Password</label> <input type="password"
						class="form-control" name="password" id="password" required>
				</div>
				<div alight="left">
					<label class="form-label">Retype Password</label> <input
						type="password" class="form-control" name="retypepassword"
						id="retypepassword" required>
				</div>
				<br> <br>
				<div alight="right">
					<input type="submit" id="register" value="Register" name="register"
						class="btn btn-info">
				</div>
				
			</form>
		</div>
		
		<div class="col-sm-6">
			<form method="get" action="usermanage" style="padding: 10%;">
				<h3 style="text-align: center; color: #ffffff; padding: 5%;">Login</h3>
				</br>

				<div alight="left">
					<label class="form-label">Email</label> <input type="email" class="form-control" name="email_login" id="email_login" required>
				</div>

				<div alight="left">
					<label class="form-label">Password</label> <input type="password" class="form-control" name="password_login" id="password_login" required>
				</div>
				
				<br> <br>
				<div alight="right">
					<input type="submit" id="login" value="login" name="login" class="btn btn-info">
				</div>
			</form>
		</div>
	</div>

</body>
</html>