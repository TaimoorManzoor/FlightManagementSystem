<%@page import="Model.AirportModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Model.FlightDetailModel"%>
<%@page import="Db_Connection.DatabaseConnection"%>
<%@page import="db_Dao.Dao"%>
<%@ page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@ include file="navbar.jsp"%>
<%
Dao dao = new Dao(DatabaseConnection.connect());
// Check if the user is logged in
if (session.getAttribute("email") == null) {
	// Redirect to the login page if not logged in
	response.sendRedirect("home.jsp");
	return;
}
%>
<%
// Check if the user is logged in
if (request.getParameter("logout") != null) {
	session.invalidate();
	response.sendRedirect("home.jsp");
	return;
}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Flight Management System</title>
</head>
<body style="background-color: #456789;">



	<h3 style="text-align: center; color: #ffffff; padding: 4px;">Flight Management System</h3>
	</br>
	<div class="row">
		<div class="col-sm-4">
			<form method="POST" action="flightdetail" style="padding: 10%;">

				<div alight="left">
					<label class="form-label">Flying From</label>
					<%
					List<AirportModel> lists = dao.Airportfetchrecord();
					%>

					<select class="custom-select" name="FlyingFrom">
						<option selected>Choose...</option>
						<%
						// Iterate over the list of AirportModel objects
						for (AirportModel airport : lists) {
						%>
						<option value="<%=airport.getAirport_name()%>"><%=airport.getAirport_name()%></option>
						<%
						}
						%>
					</select>
				</div>

				<div alight="left">
					<label class="form-label">Flying To</label> <select
						class="custom-select" name="FlyingTo">
						<option selected>Choose...</option>
						<%
						// Iterate over the list of AirportModel objects
						for (AirportModel airport : lists) {
						%>
						<option value="<%=airport.getAirport_name()%>"><%=airport.getAirport_name()%></option>
						<%
						}
						%>
					</select>
				</div>

				<div alight="left">
					<label class="form-label">Departing</label> <input type="date"
						class="form-control" name="Departing" id="Departing" required>
				</div>
				<div alight="left">
					<label class="form-label">Departing Time</label> <input type="time"
						class="form-control" name="DepartingTime" id="DepartingTime"
						required>
				</div>
				<div alight="left">
					<label class="form-label">Returning</label> <input type="date"
						class="form-control" name="Returning" id="Returning" required>
				</div>
				<div alight="left">
					<label class="form-label">Returning Time</label> <input type="time"
						class="form-control" name="ReturningTime" id="ReturningTime"
						required>
				</div>
				<div alight="left">
					<label class="form-label">Price</label> <input type="number"
						class="form-control" name="price" id="price" required min="0">
				</div>
				<div alight="left">
					<label class="form-label">Class</label> <select
						class="custom-select" name="classes">
						<option selected value="Economy">Economy</option>
						<option value="PremiumEconomy">Premium Economy</option>
						<option value="Business">Business</option>
						<option value="First">First</option>
					</select>
				</div>

				<br> <br>
				<div alight="right">
					<input type="submit" id="submit" value="submit" name="submit"
						class="btn btn-info"> <input type="reset" id="reset"
						value="reset" name="reset" class="btn btn-warning">
				</div>

			</form>
		</div>



		<div class="col-sm-8">
			<div class="panel-body" style="text-align: center;">
				<table id="tbl-student" style="color: white;"
					class="table table-responsive table-bordered" cellpadding="0"
					width="100%">
					<thead>
						<tr>
							<th>ID</th>
							<th>Flying From</th>
							<th>Flying To</th>
							<th>Departing</th>
							<th>Departing Time</th>
							<th>Returning</th>
							<th>Returning Time</th>
							<th>Price</th>
							<th>Class</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
						<%
						List<FlightDetailModel> list = dao.fetchrecord();
						for (FlightDetailModel s : list) {
						%>
						<tr>
							<td><%=s.getId()%></td>
							<td><%=s.getFlyingFrom()%></td>
							<td><%=s.getFlyingTo()%></td>
							<td><%=s.getDeparting()%></td>
							<td><%=s.getDepartingTime()%></td>
							<td><%=s.getReturning()%></td>
							<td><%=s.getReturningTime()%></td>
							<td><%=s.getPrice()%></td>
							<td><%=s.getClasses()%></td>
							<td><a href="updateflight.jsp?id=<%=s.getId()%>"
								style="color: #9ACD32">Edit</a></td>
							<td><a href="delete_flight?id=<%=s.getId()%>"
								style="color: red">Delete</a></td>
						</tr>
						<%
						}
						%>
					
				</table>
			</div>
		</div>
	</div>

	<form action="home.jsp" method="post">
		<input type="submit" name="logout" id="logout" value="logout">

	</form>
</body>
</html>