<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
/* 	String id = request.getParameter("id");
	
	String updateQuery = "Delete from FlightDetail where id=?";
	PreparedStatement preparedStatement = con.prepareStatement(updateQuery);

	preparedStatement.setString(1, id);
	preparedStatement.executeUpdate(); */
	 
%>
<script type="text/javascript">
	alert("Record Deleted");
</script>
<%
RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
dispatcher.forward(request, response);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flight Management</title>
</head>
<body>

</body>
</html>