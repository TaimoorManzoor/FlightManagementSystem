package servlet.com;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Db_Connection.DatabaseConnection;
import Model.BookingModel;
import Model.FlightDetailModel;
import db_Dao.Dao;

/**
 * Servlet implementation class booking_servlet
 */
@WebServlet("/booking_servlet")
public class booking_servlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session = request.getSession();        
		String id_flight = request.getParameter("id");
		String adult = request.getParameter("adult");
		String infant = request.getParameter("infant");
		String children = request.getParameter("children");
		String price = request.getParameter("price");
		int total_amounts = Integer.parseInt(price) * (Integer.parseInt(adult) + Integer.parseInt(infant) + Integer.parseInt(children));
		String total_amount = String.valueOf(total_amounts);
        String email = (String) session.getAttribute("email");
		Dao dao=new Dao(DatabaseConnection.connect());
		String user_id=dao.getUser_id(email);
		  // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        
        // Define the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        // Format the LocalDateTime object to a string
        String formattedDateTime = currentDateTime.format(formatter);
		
		BookingModel bookingModel=new BookingModel(adult,infant,children,user_id,id_flight,total_amount,formattedDateTime);
		
		
		String  booking_id=dao.addrecordBook(bookingModel);
		
		if(booking_id!=null)
		{
		    response.sendRedirect("checkout.jsp?flight_id=" + id_flight + "&user_id=" + user_id + "&booking_id=" + booking_id); 
		}
		else
		{
			System.out.println("something going wrong");
		}
	}

}
