package servlet.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Db_Connection.DatabaseConnection;
import Model.BookingCustomerDetail;
import Model.BookingModel;
import Model.FlightDetailModel;
import db_Dao.Dao;

/**
 * Servlet implementation class TrackingSearch
 */
@WebServlet("/TrackingSearch")
public class TrackingSearch extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// Fetch flight details based on filter parameters
		Dao dao = new Dao(DatabaseConnection.connect());
		String tracking = request.getParameter("search_tag");
		BookingModel list = dao.getBookingRecordsByTracking(tracking);
		List<BookingCustomerDetail> lists = dao.CustomerBooking(list.getId());
		System.out.print(lists);
		request.setAttribute("flightDetails", list); // Assuming flightDetails is your data
		
		 request.setAttribute("flightUserDetails", lists); // Assuming flightDetails
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher("tracking.jsp");
		dispatcher.forward(request, response); // Use forward instead of include

	}

}
