<%@page import="Model.BookingCustomerDetail"%>
<%@page import="java.util.List"%>
<%@page import="Model.FlightUserModel"%>
<%@page import="Db_Connection.DatabaseConnection"%>
<%@page import="db_Dao.Dao"%>
<%@ include file="navbar.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: #456789;">
	<div class="col-sm-8">
			<div class="panel-body" style="text-align: center; ">
				<table id="tbl-student" style="color: white;"
					class="table table-responsive table-bordered" cellpadding="0"
					width="100%" >
					<thead>
						<tr>
							<th>Seat No</th>
							<th>Booking No</th>
							<th>Customer Name</th>
							<th>Contact Number</th>
							<th>Email Address</th>
						
						</tr>
						<%
						Dao dao = new Dao(DatabaseConnection.connect());
						List<BookingCustomerDetail> list = dao.fetchConfirmBookingRecord();	
					
						for (BookingCustomerDetail s : list) 
						{
						%>
						<tr>
						    <td><%= s.getSeat_id() %></td>
						    <td><%= s.getBooking_id() %></td>
						    <td><%= s.getCustomer_name() %></td>
						    <td><%= s.getContact_no() %></td>
						    <td><%= s.getEmail() %></td>  
						</tr>
						<% 
						}
						%>
		
				</table>
			</div>

		</div>
</body>
</html>