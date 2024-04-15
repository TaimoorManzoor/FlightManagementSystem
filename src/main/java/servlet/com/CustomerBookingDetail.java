package servlet.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Db_Connection.DatabaseConnection;
import Model.BookingCustomerDetail;
import Model.BookingModel;
import db_Dao.Dao;

@WebServlet("/CustomerBookingDetail")
public class CustomerBookingDetail extends HttpServlet {

	public static String generateRandomNumber(int length) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(random.nextInt(10)); // append a random digit (0-9)
		}
		return sb.toString();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status;
		int count = 0;
		PrintWriter out = response.getWriter();
		String[] customerNames = request.getParameterValues("names[]");
		String booking_id = request.getParameter("booking_id");
		String email = request.getParameter("email");
		String contact_no = request.getParameter("contact_no");
		String Recipient = request.getParameter("Recipient");
		String id_flight = request.getParameter("id_flight");
		String user_id = request.getParameter("user_id");

		Dao dao = new Dao(DatabaseConnection.connect());

		if (request.getParameter("payphysical") != null) {

			status = request.getParameter("payphysical");
		} else {
			status = request.getParameter("payonline");
			String tracking = CustomerBookingDetail.generateRandomNumber(10);
			dao.addTrackBook(tracking, booking_id);

		}

		if (customerNames != null) {
			for (int i = 0; i < customerNames.length; i++) {
				BookingCustomerDetail bookingCustomerDetail = new BookingCustomerDetail(booking_id, customerNames[i],
						contact_no, email, status);

				

				if (Recipient.equals("Recipient")) {
					System.out.println("REesdasdasdas");
					RequestDispatcher dispatcher = request.getRequestDispatcher("Recipient.jsp");
					dispatcher.include(request, response);
					break;
				} 
				int flag = dao.addrecordBookingCustomerDetail(bookingCustomerDetail);

				BookingModel sb = dao.getBookingRecordsById(booking_id);
				System.out.println("Tracking Id" + sb.getTracking());
				if (flag > 0 && status.equals("Payment Online")) {
					count++;
					if (customerNames.length == count) 
					{
					
						response.sendRedirect("checkout.jsp?flight_id=" + id_flight + "&user_id=" + user_id
								+ "&booking_id=" + booking_id);

					}
				} else if (flag > 0 && status.equals("payment Physical")) {
					count++;
					if (customerNames.length == count)
					{
						out.print("<body><font color='yellow'><p>Booking is Register Sucessfully<p></body>");
						RequestDispatcher dispatcher = request.getRequestDispatcher("query.jsp");
						dispatcher.include(request, response);

					}
				} else {
					out.print("<body><font color='green'><p>Flight is not Register Sucessfully<p></body>");
					RequestDispatcher dispatcher = request.getRequestDispatcher("query.jsp");
					dispatcher.include(request, response);
				}
			}
		} else {
			System.out.println("No customer names submitted.");
		}

		System.out.println("Booking ID: " + booking_id);
		System.out.println("Email: " + email);
		System.out.println("Contact Number: " + contact_no);
	}

}
