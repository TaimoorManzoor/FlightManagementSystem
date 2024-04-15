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
@WebServlet("/delete_flight")
public class FlightDelete extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter out= resp.getWriter();
		int id= Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		FlightDetailModel FlightModel=new FlightDetailModel();
		
		Dao dao=new Dao(DatabaseConnection.connect());
		int flag=dao.deleteFlight(id);
		
		System.out.println(FlightModel.toString());
		
		if(flag>0)
		{
		 	out.print("<body><font color='green'><p>Delete Sucessfully<p></body>");
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.include(req, resp);                
            return;
			/*
			 * out.print("iNSERT sucessfully"); resp.sendRedirect("index.jsp");
			 */
		}
		else
		{
			out.print("<body><font color='red'><p>Delete not Sucessfully<p></body>");
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.include(req, resp);                
            return;
			/*
			 * out.print("iNSERT not sucessfully"); resp.sendRedirect("index.jsp");
			 */
		}
	}
}
