<%@page import="java.util.List"%>
<%@page import="Model.AirportModel"%>
<%@page import="Model.FlightDetailModel"%>
<%@page import="servlet.com.FlightDetailInsert"%>
<%@page import="Db_Connection.DatabaseConnection"%>
<%@page import="db_Dao.Dao"%>
<%@page import="java.text.ParseException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<%
// Check if the user is logged in
if (session.getAttribute("email") == null) {
    // Redirect to the login page if not logged in
    response.sendRedirect("home.jsp");
    return;
}
%>
 <%
// Check if the user is logged in
if (request.getParameter("logout")!=null) {
    session.invalidate();
    response.sendRedirect("home.jsp");
    return;
}%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body style="background-color: #456789;">
	<h3 style="text-align: center; color: #ffffff; padding: 4px;">Flight
		Management System</h3>
	</br>
	<div class="row">
	<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<form method="post" action="flightupdate" style="padding: 10%;">
				<%
				int id=Integer.parseInt(request.getParameter("id"));
				Dao dao=new Dao(DatabaseConnection.connect());
				FlightDetailModel s=dao.getRecordsById(id);
				
				%>

				<div alight="left">
					<label class="form-label">Flying From</label> 
					<%-- <input type="text"
						class="form-control" name="FlyingFrom" id="Flying From" required
						value="<%=s.getFlyingFrom()%>"> --%>
						
						<%
					List<AirportModel> lists = dao.Airportfetchrecord();
					%>

					<select class="custom-select" name="FlyingFrom">
						<option selected value="<%=s.getFlyingFrom()%>"><%=s.getFlyingFrom()%></option>
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
					<label class="form-label">Flying To</label> 
					<%-- <input type="text"
						class="form-control" name="FlyingTo"
						value="<%=s.getFlyingTo()%>" id="FlyingTo" required> --%>
							<select class="custom-select" name="FlyingTo">
						<option selected value="<%=s.getFlyingTo()%>"><%=s.getFlyingTo()%></option>
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
						class="form-control" name="Departing" id="Departing"
						value=<%=s.getDeparting()%> required>
				</div>
				<div alight="left">
					<label class="form-label">Departing Time</label> <input type="time"
						class="form-control" name="DepartingTime" id="DepartingTime"
						value=<%=s.getDepartingTime()%> required>
				</div>
				<div alight="left">
					<label class="form-label">Returning</label> <input type="date"
						class="form-control" " name="Returning" id="Returning"
						value=<%=s.getReturning()%> required>
				</div>
				<div alight="left">
					<label class="form-label">Returning Time</label> <input type="time"
						class="form-control" " name="ReturningTime" id="ReturningTime"
						value=<%=s.getReturningTime()%> required>
				</div>
				<div alight="left">
					<label class="form-label">Price</label> <input type="number"
						value=<%=s.getPrice()%> class="form-control"
						name="price" id="price" required>
				</div>
					<div alight="left">
		<label class="form-label">Class</label>
		<select class="custom-select" name="classes">
			<option selected value=<%=s.getClasses()%>><%=s.getClasses()%></option>
			<option value="PremiumEconomy">Premium Economy</option>
			<option value="Business">Business</option>
			<option value="First">First</option>
			<option  value="Economy">Economy</option>
			
		</select>
		</div>
				<div class="mb-3">
			<input type="hidden" class="form-control" name="id" value=<%=s.getId() %>>
				</div>
				<%
				
				%>
				<br> <br>
				<div alight="right">
					<input type="submit" id="submit"  name="submit" value="Update"
						class="btn btn-info">
						
						 <input type="reset" id="reset"
						value="reset" name="reset" class="btn btn-warning">
				</div>
				

				<div align="right">

					<p>
						<a href="index.jsp" style="color: #ffffff">Click Back</a>
					</p>
				</div>
			</form>

		</div>
			<div class="col-sm-4"></div>
		
</body>
</html>