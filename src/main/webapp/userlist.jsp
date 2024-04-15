<%@page import="Model.FlightUserModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="Model.FlightDetailModel"%>
<%@page import="Db_Connection.DatabaseConnection"%>
<%@page import="db_Dao.Dao"%>
<%@ page import="java.sql.*" %>
<%@page import="java.util.List"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<meta charset="UTF-8">
<title>User List</title>
</head>
<body style="background-color: #456789;">
	
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<div class="panel-body" style="text-align: center; ">
				<table id="tbl-student" style="color: white;"
					class="table table-responsive table-bordered" cellpadding="0"
					width="100%" >
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Date of Birth</th>
							<th>Email</th>
							<th>Phone</th>
							<th>Password</th>
							<th>Delete</th>
							<th>Edit</th>
						</tr>
						<%
						Dao dao = new Dao(DatabaseConnection.connect());
						List<FlightUserModel> list = dao.fetchUserRecord();	
						
						for (FlightUserModel s : list) 
						{
						%>
						<tr>
						    <td><%= s.getId() %></td>
						    <td><%= s.getName() %></td>
						    <td><%= s.getDob() %></td>
						    <td><%= s.getEmail() %></td>
						    <td><%= s.getPhone() %></td>
						    <td><%= s.getPassword() %></td>
						</tr>
						<% 
						}
						%>
		
				</table>
			</div>

		</div>
				<div class="col-sm-2"></div>
		
</body>
</html>