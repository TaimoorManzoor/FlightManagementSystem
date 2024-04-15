<%@page import="Model.BookingCustomerDetail"%>
<%@page import="java.util.List"%>
<%@page import="Model.FlightDetailModel"%>
<%@page import="Model.BookingModel"%>
<%@page import="db_Dao.Dao"%>
<%@page import="Db_Connection.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recipient</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body style="background-color: #456789;">
	<%
	String booking_id = request.getParameter("booking_id");
	String user_id = request.getParameter("user_id");

	Dao dao = new Dao(DatabaseConnection.connect());
	BookingModel sb = dao.getBookingRecordsById(booking_id);
	FlightDetailModel sf = dao.getRecordsById(Integer.parseInt(sb.getId_flight()));
	List<BookingCustomerDetail> list = dao.CustomerBooking(booking_id);
	BookingCustomerDetail firstBooking = list.get(0);
	String contactno = firstBooking.getContact_no();
	String email = firstBooking.getEmail();
	String customerName = firstBooking.getCustomer_name();
	%>
	<div class="row">
		<div class="col-sm-4">
			<form style="padding: 10%;">
				<div align="left">
					<label class="form-label">Infant</label> <input type="text"
						class="form-control" value="<%=sb.getInfant()%>"
						readonly="readonly">
				</div>

				<div>
					<div align="left">
						<label class="form-label">Adult</label> <input type="text"
							class="form-control" value="<%=sb.getAdult()%>"
							readonly="readonly">
					</div>
					<label>Children</label>: <input type="text" class="form-control"
						value="<%=sb.getChildren()%>" readonly="readonly">
				</div>

				<label class="form-label">Flying From</label> <input
					class="form-control" type="text" value="<%=sf.getFlyingFrom()%>"
					readonly="readonly"><label class="form-label">Flying
					To</label>: <input class="form-control" type="text"
					value="<%=sf.getFlyingTo()%>" readonly="readonly">
		</div>
		<div class="col-sm-4">

			<div style="padding: 10%;">
								
					<label class="form-label">Class</label>
					<input class="form-control" type="text" value="<%=sf.getClasses()%>" readonly="readonly">
			 <label
					class="form-label">Total Amount</label> <input class="form-control"
					type="text" value="<%=sb.getTotal_amount()%>" readonly="readonly">
			<label class="form-label">Tracking ID</label>: <input
				class="form-control" type="text" value="<%=sb.getTracking()%>"
				readonly="readonly"> <label class="form-label">Contact</label>
			<input class="form-control" type="text" value="<%=contactno%>"
				readonly="readonly"> <label class="form-label">Email</label>
			<input class="form-control" type="text" value="<%=email%>"
				readonly="readonly">
			</div>
		</div>


		<div class="col-sm-4">
			<div class="panel-body" style="text-align: center; padding: 10%; margin: 10% ">
				<table id="tbl-student" style="color: white;"
					class="table table-responsive table-bordered" cellpadding="1">
					<thead>
						<tr>
							<th>Seat Number</th>
							<th>Passenger Name</th>

						</tr>
						<%
						for (BookingCustomerDetail s : list) {
						%>
						<tr>
							<td><%=s.getSeat_id()%></td>
							<td><%=s.getCustomer_name()%></td>
						</tr>
						<%
						}
						%>
					
				</table>
				
				<a href="query.jsp">Go to Home</a>
				
			</div>
		</div>
	</div>


</body>
</html>