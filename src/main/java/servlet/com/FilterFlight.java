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
import Model.FlightDetailModel;
import db_Dao.Dao;


@WebServlet("/FilterFlight")
public class FilterFlight extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
        String flyingfrom = request.getParameter("flyingfrom");
        String flyingto = request.getParameter("flyingto");
        String Departing = request.getParameter("Departing");
        String classes = request.getParameter("classes");

        
        System.out.println(flyingfrom);
        System.out.println(flyingto);
        System.out.println(Departing);

        // Fetch flight details based on filter parameters
        Dao dao = new Dao(DatabaseConnection.connect());
        List<FlightDetailModel> list = dao.addFilter(flyingfrom, flyingto, Departing,classes);
        request.setAttribute("flightDetails", list); // Assuming flightDetails is your data
        RequestDispatcher dispatcher = request.getRequestDispatcher("query.jsp");
        dispatcher.forward(request, response);
       
    }
		
	}

