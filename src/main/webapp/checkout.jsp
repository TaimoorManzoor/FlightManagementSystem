<%@page import="Model.BookingModel"%>
<%@page import="Model.FlightUserModel"%>
<%@page import="Db_Connection.DatabaseConnection"%>
<%@page import="Model.FlightDetailModel"%>
<%@page import="db_Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%

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

<%
String booking_id = request.getParameter("booking_id");
Dao dao = new Dao(DatabaseConnection.connect());
BookingModel sb = dao.getBookingRecordsById(booking_id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flight Management System</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body style="background-color: #456789;">
	<h3 style="text-align: center; color: #ffffff; padding: 4px;">Flight
		Management System</h3>
	</br>
	<div class="row">
		<div class="col-sm-4">
			<form method="POST" action="CustomerBookingDetail"
				style="padding: 10%;">
				<%
				String id = request.getParameter("user_id");
				FlightUserModel sa = dao.getUserRecordsById(id);
				%>
				<%
				int i;
				for (i = 0; i < (Integer.parseInt(sb.getInfant()) + Integer.parseInt(sb.getAdult())
						+ Integer.parseInt(sb.getChildren())); i++) {
				%>
				<div align="left">
					<label class="form-label">Customer Name <%=i + 1%></label> <input
						type="text" class="form-control" name="names[]" id="name<%=i%>">
				</div>
				<%
				}
				%>
				<div align="left">
					<label class="form-label">Contact Email</label> <input type="email"
						class="form-control" name="email" value=<%=sa.getEmail()%>
						id="email">
				</div>

				<div align="left">
					<label class="form-label">phone</label> <input type="tel"
						class="form-control" name="contact_no" id="phone"
						value=<%=sa.getPhone()%>>
				</div>
				<div align="left">
					<input type="hidden" class="form-control" name="booking_id"
						id="booking_id" value=<%=booking_id%>>
				</div>
		</div>

		<div class="col-sm-4">
			<%
			int id_flight = Integer.parseInt(request.getParameter("flight_id"));
			FlightDetailModel s = dao.getRecordsById(id_flight);
			%>

			<div alight="left">
				<label class="form-label">Flying From</label> <input type="text"
					class="form-control" name="FlyingFrom" id="Flying From"
					value="<%=s.getFlyingFrom()%>" readonly>
			</div>

			<div alight="left">
				<label class="form-label">Flying To</label> <input type="text"
					class="form-control" name="FlyingTo" value="<%=s.getFlyingTo()%>"
					id="FlyingTo" readonly>
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
					class="form-control" name="Returning" id="Returning"
					value=<%=s.getReturning()%> readonly>
			</div>
			<div alight="left">
				<label class="form-label">Returning Time</label> <input type="time"
					class="form-control" name="ReturningTime" id="ReturningTime"
					value=<%=s.getReturningTime()%> readonly>
			</div>
			<div alight="left">
				<label class="form-label">Price of Each Ticket</label> <input
					type="number" value=<%=s.getPrice()%> class="form-control"
					name="price" id="price" readonly>
			</div>
			<input type="hidden" class="form-control" name="id_flight"
				id="id_flight" value="<%=id_flight%>" readonly> <input
				type="hidden" class="form-control" name="user_id" id="user_id"
				value="<%=id%>" readonly>

		</div>
		<div class="col-sm-2 card " style="padding: 10px;">
<div style="padding: 10%; color:#ffffff; background-color:#123456">			
			<label>Infant</label>
			<p><%=sb.getInfant()%></p>
			<br>
			<label> Adult</label>
			<p><%=sb.getAdult()%></p>
			<br>
			<label> Children</label>
			<p><%=sb.getChildren()%></p>
			<br> <label>Total Amount</label>
			<p><%=sb.getTotal_amount()%></p>
			
			<%
			if (sb.getTracking() == null || sb.getTracking().isEmpty()) {
			%>
			<input style="margin: 2%; color:#ffffff; background-color:#456789" type="submit" value="Payment Online" class="form-control"
				name="payonline" id="payonline"> <input style="margin: 2%; color:#ffffff; background-color:#456789" type="submit"
				value="payment Physical" class="form-control" name="payphysical"
				id="payphysical"> <input type="hidden" value="1"
				class="form-control" name="Recipient" id="Recipient">

			<%
			} else {
			%>
			<input type="submit" value="Payment Online" class="form-control"
				name="payonline" style="margin: 2%; color:#ffffff; background-color:#456789" id="payonline" disabled="disabled"> <input
				type="submit" value="payment Physical" class="form-control"
				name="payphysical" style="margin: 2%; color:#ffffff; background-color:#456789" id="payphysical" disabled="disabled">
			<h1>Paid</h1>
			<input type="submit" value="Recipient" class="form-control"
				name="Recipient" id="Recipient">


			<%
			}
			%>
			</div>
		</div>
		</form>
	</div>

</body>
</html>