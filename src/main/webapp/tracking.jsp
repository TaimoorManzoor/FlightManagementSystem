<%@page import="Model.BookingCustomerDetail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Model.FlightDetailModel"%>
<%@page import="Model.BookingModel"%>
<%@page import="db_Dao.Dao"%>
<%@page import="Db_Connection.DatabaseConnection"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search By Tracking ID</title>
    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
</head>
<body style="background-color: #456789;">

    <form action="TrackingSearch" method="get" id="searchtrackingForm">
        <input type="search"  name="search_tag" id="search_tag">
        <input type="submit" name="submit_search" id="submit_search" value="Search">
    </form>
    
    <table id="bookingDetails" class="table table-responsive table-bordered" cellpadding="5"
					width="100%" align="center">
        <tr>
            <th>ID</th>
            <th>Adult</th>
            <th>Infant</th>
            <th>Children</th>
            <th>User ID</th>
            <th>Flight ID</th>
            <th>Total Amount</th>
            <th>Timestamp</th>
            <th>Tracking</th>
        </tr>
        <tr>
            <!-- Accessing BookingModel properties using EL -->
            <td>${flightDetails.id}</td>
            <td>${flightDetails.adult}</td>
            <td>${flightDetails.infant}</td>
            <td>${flightDetails.children}</td>
            <td>${flightDetails.id_user}</td>
            <td>${flightDetails.id_flight}</td>
            <td>${flightDetails.total_amount}</td>
            <td>${flightDetails.timestamp}</td>
            <td>${flightDetails.tracking}</td>
        </tr>
    </table>
    


    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script>
        $(document).ready(function () {
            $("#searchtrackingForm").submit(function (event) {
                event.preventDefault(); // Prevent form submission

                // Get the form data
                var formData = $(this).serialize();

                // Send the AJAX request
                $.ajax({
                    type: "GET",
                    url: "TrackingSearch", // URL to your servlet or server-side script
                    data: formData,
                    success: function (response) {
                        console.log("Ajax is working");
                        // Update the booking details section with the response
                        
                           $("#bookingDetails").html(response);
                    },
                    error: function () {
                        alert("Error occurred while processing the request.");
                    }
                });
            });
        });
    </script>
</body>
</html>

