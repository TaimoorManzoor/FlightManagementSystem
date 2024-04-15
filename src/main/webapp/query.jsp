<%@page import="Model.AirportModel"%>
<%@page import="Model.FlightDetailModel"%>
<%@page import="java.util.List"%>
<%@page import="db_Dao.Dao"%>
<%@page import="Db_Connection.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="navbar_user.jsp" %>
 --%>
 <%
//Check if the user is logged in
if (request.getParameter("logout")!=null)
{
 session.invalidate();
 response.sendRedirect("home.jsp");
 return;               
}
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Filter</title>
</head>
<body style="background-color: #456789;">
	<form method="post" action="FilterFlight">
		<div class="input-group mb-1">
		<div class="input-group-prepend">
			<label class="input-group-text" for="inputGroupSelect01">Flying
				From</label>
		</div>
		<%
					Dao dao = new Dao(DatabaseConnection.connect());
					List<AirportModel> lists = dao.Airportfetchrecord();
					%>

					<select class="custom-select" name="flyingfrom">
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
<!-- 		<select class="custom-select" name="flyingfrom">
			<option selected>Choose...</option>
			<option value="karachi">Jinnah International Airport</option>
			<option value="islamabad">Islamabad International Airport</option>
			<option value="lahore">Allama Iqbal International Airport</option>
		</select> -->
		
	</div>
	<div class="input-group mb-1">
		<div class="input-group-prepend">
			<label class="input-group-text" for="inputGroupSelect01">Flying
				To</label>
		</div>
	

					<select class="custom-select" name="flyingto">
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
		<!-- <select class="custom-select" name="flyingto">
			<option selected>Choose...</option>
			<option value="karachi">Jinnah International Airport</option>
			<option value="islamabad">Islamabad International Airport</option>
			<option value="lahore">Allama Iqbal International Airport</option>
		</select> -->
	</div>
	<div class="input-group mb-1">
		<div class="input-group-prepend">
			<label class="input-group-text" for="inputGroupSelect01">Class</label>
		</div>
		<select class="custom-select" name="classes">
			<option selected value="Economy">Economy</option>
			<option value="PremiumEconomy">Premium Economy</option>
			<option value="Business">Business</option>
			<option value="First">First</option>
		</select>
	</div>
	
	<div class="input-group mb-1">
		<div class="input-group-prepend">
			<label class="input-group-text" for="inputGroupSelect01">Departing</label>
		</div>
		<input type="date" class="form-control" name="Departing"
			id="Departing" required>
	</div>

	<input type="submit" name="search" id="search" value="search">
	</form>

	<div class="col-sm-8">
			<div class="panel-body" style="text-align: center; ">
				<table id="tbl-student" style="color: white;"
					class="table table-responsive table-bordered" cellpadding="5"
					width="100%" >
			<thead style="color: white;">
				<%
				List<FlightDetailModel> flightDetails = (List<FlightDetailModel>) request.getAttribute("flightDetails");
				if (flightDetails != null && !flightDetails.isEmpty()) {
				%>
				<table id="tbl-student" style="color: white;"
					class="table table-responsive table-bordered" cellpadding="5"
					width="100%" >
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
							<th>Book</th>
							
						</tr>
					</thead>
					<tbody>
						<%
						for (FlightDetailModel flight : flightDetails) {
						%>
						<tr>
							<td><%=flight.getId()%></td>
							<td><%=flight.getFlyingFrom()%></td>
							<td><%=flight.getFlyingTo()%></td>
							<td><%=flight.getDeparting()%></td>
							<td><%=flight.getDepartingTime()%></td>
							<td><%=flight.getReturning()%></td>
							<td><%=flight.getReturningTime()%></td>
							<td><%=flight.getPrice()%></td>
							<td><a href="booking.jsp?id=<%=flight.getId()%>" style="color: #9ACD32">Book</a></td>
							
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
				<%
				} else {
				out.println("No flight details available."); // Or any other message you want to display
				}
				%>
				
		
				</table>
			</div>
					<br>
				<br>
				<br>
				<form action="home.jsp" method="post" >
	<input type="submit" name="logout" id="logout" value="logout">
	
	</form>
			</body>	
				