<%@page import="Model.FlightDetailModel"%>
<%@page import="Db_Connection.DatabaseConnection"%>
<%@page import="db_Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
if (request.getParameter("Book") != null) {
	String user_id = null;
	String booking_id=null;
%>
<script type="text/javascript">
	alert("Record Updated");
</script>
<%
}
%>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Flight Management</title>
</head>


<body style="background-color: #456789;">
	<h3 style="text-align: center; color: #ffffff; padding: 4px;">Flight
		Management System</h3>
	</br>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<form method="post" action="booking_servlet" style="padding: 10%;">
				<%
				int id=Integer.parseInt(request.getParameter("id"));
				Dao dao=new Dao(DatabaseConnection.connect());
				FlightDetailModel s=dao.getRecordsById(id);
		
				
				%>

				<div alight="left">
					<label class="form-label">Flying From</label> <input type="text"
						class="form-control" name="FlyingFrom" id="Flying From"
						value="<%=s.getFlyingFrom()%>" readonly>
				</div>

				<div alight="left">
					<label class="form-label">Flying To</label> <input type="text"
						class="form-control" name="FlyingTo"
						value="<%=s.getFlyingTo()%>" id="FlyingTo" readonly>
				</div>

				<div alight="left">
					<label class="form-label">Departing</label> <input type="date"
						class="form-control" name="Departing" id="Departing"
						value=<%=s.getDeparting()%> readonly>
				</div>
				<div alight="left">
					<label class="form-label">Departing Time</label> <input type="time"
						class="form-control" name="DepartingTime" id="DepartingTime"
						value=<%=s.getDepartingTime()%> readonly>
				</div>
				<div alight="left">
					<label class="form-label">Returning</label> <input type="date"
						class="form-control"  name="Returning" id="Returning"
						value=<%=s.getReturning()%> readonly>
				</div>
				<div alight="left">
					<label class="form-label">Returning Time</label> <input type="time"
						class="form-control"  name="ReturningTime" id="ReturningTime"
						value=<%=s.getReturningTime()%> readonly>
				</div>
				<div alight="left">
					<label class="form-label">Price</label> <input type="number"
						value=<%=s.getPrice()%> class="form-control"
						name="price" id="price" readonly>
				</div>
				<div>
					<label class="form-label">Adult</label> <input type="number"
						class="form-control" name="adult" id="adult" required="required" min="0" max="9">
				</div>
				<div>
					<label class="form-label">Children</label> <input type="number"
						class="form-control" name="children" id="children" required="required"  min="0" max="9">
				</div>
				<div>
					<label class="form-label">Infant</label> <input type="number"
						class="form-control" name="infant" id="infant" required="required"  min="0" max="9">
				</div>
				<div class="mb-3">
						<input type="hidden" class="form-control" name="id" value=<%=s.getId() %>>
				</div>
				<%
				
				%>
				<br> <br>
				<div alight="right">
					<input type="submit" id="Book" value="Book" name="Book"
						class="btn btn-info">
				</div>

				<div align="right">

					<p>
						<a href="query.jsp" style="color: #ffffff">Click Back</a>
					</p>
				</div>
			</form>
		</div>
		<div class="col-sm-4"></div>
</body>
</html>