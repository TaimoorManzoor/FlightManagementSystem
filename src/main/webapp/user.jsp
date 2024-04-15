<%@page import="db_Dao.Dao"%>
<%@page import="java.util.List"%>
<%@page import="Db_Connection.DatabaseConnection"%>
<%@page import="Model.FlightDetailModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%-- <%@ include file="navbar_user.jsp" %>
 --%>
<%
// Check if the user is logged in
if (session.getAttribute("email") == null) {
    // Redirect to the login page if not logged in
    response.sendRedirect("home.jsp");
    return;
}
%>

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
<meta charset="UTF-8">
<title>Flight Management System</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body style="background-color:#456789;">
	<h3 style="text-align: center; color:#ffffff;  padding: 4px;">Flight Management System</h3>	</br>
	<div class="row">
	<div class="col-sm-2" >
	</div> 
			<div class="col-sm-8">
			<div class="panel-body" style="text-align: center; ">
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
						<%
						Dao dao = new Dao(DatabaseConnection.connect());
						List<FlightDetailModel> list = dao.fetchrecord();

						for (FlightDetailModel s : list) {
						%>
						<tr>
							 <td><%= s.getId() %></td>
						    <td><%= s.getFlyingFrom() %></td>
						    <td><%= s.getFlyingTo() %></td>
						    <td><%= s.getDeparting() %></td>
						    <td><%= s.getDepartingTime() %></td>
						    <td><%= s.getReturning() %></td>
						    <td><%= s.getReturningTime() %></td>
						    <td><%= s.getPrice() %></td> 
							<td><a href="booking.jsp?id=<%=s.getId()%>" style="color: #9ACD32">Book</a></td>
						</tr>
						<% 
						}
						%>
		
				</table>
			</div>
		</div>
		<div class="col-sm-2">
		
	</div>
	
	<form action="home.jsp" method="post" >
	<input type="submit" name="logout" id="logout" value="logout">
	
	</form>
	</div>
</body>
</html>