package servlet.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Db_Connection.DatabaseConnection;
import Model.FlightDetailModel;
import db_Dao.Dao;

@WebServlet("/flightdetail")
public class FlightDetailInsert extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter out= resp.getWriter();
		String FlyingFrom= req.getParameter("FlyingFrom");
		String FlyingTo= req.getParameter("FlyingTo");
		String Departing= req.getParameter("Departing");
		String DepartingTime= req.getParameter("DepartingTime");
		String Returning= req.getParameter("Returning");
		String ReturningTime= req.getParameter("ReturningTime");
		String price= req.getParameter("price");
		String classes= req.getParameter("classes");

		
		FlightDetailModel FlightModel=new FlightDetailModel(FlyingFrom,FlyingTo,Departing,DepartingTime,Returning,ReturningTime,price,classes);
		
		Dao dao=new Dao(DatabaseConnection.connect());
		int flag=dao.addrecordFlight(FlightModel);
		
		System.out.println(FlightModel.toString());
		
		if(flag>0)
		{
			out.print("<body><font color='green'><p>Inserted Sucessfully<p></body>");
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.include(req, resp);                
            return;
			/*
			 * out.print("iNSERT sucessfully"); resp.sendRedirect("index.jsp");
			 */
		}
		else
		{
			out.print("<body><font color='green'><p>iNSERT not Sucessfully<p></body>");
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.include(req, resp);                
            return;
			/*
			 * out.print("iNSERT not sucessfully"); resp.sendRedirect("index.jsp");
			 */
		}
	}
}
