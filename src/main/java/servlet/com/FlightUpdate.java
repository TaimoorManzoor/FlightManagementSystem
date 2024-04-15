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

@WebServlet("/flightupdate")
public class FlightUpdate extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();

		String id=req.getParameter("id");
		String FlyingFrom= req.getParameter("FlyingFrom");
		String FlyingTo= req.getParameter("FlyingTo");
		String Departing= req.getParameter("Departing");
		String DepartingTime= req.getParameter("DepartingTime");
		String Returning= req.getParameter("Returning");
		String ReturningTime= req.getParameter("ReturningTime");
		String price= req.getParameter("price");
		String classes= req.getParameter("classes");

		int id_int=Integer.parseInt(id);
		
		FlightDetailModel FlightModel=new FlightDetailModel(FlyingFrom,FlyingTo,Departing,DepartingTime,Returning,ReturningTime,price,classes,id_int);
		
		Dao dao=new Dao(DatabaseConnection.connect());
		
		System.out.println(FlightModel.toString());
			int flag=dao.getUpdateFlight(FlightModel);
			
			if(flag>0)
			{
				out.print("<body><p>Update  Sucessfully<p></body>");
	            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
	            dispatcher.include(req, resp);                
	            return;
				/*
				 * out.print("Deleted sucessfully"); resp.sendRedirect("index.jsp");
				 */
			}
			else
			{
				out.print("<body><p>Update not Sucessfully<p></body>");
	            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
	            dispatcher.include(req, resp);                
	            return;
			}

	}
}
