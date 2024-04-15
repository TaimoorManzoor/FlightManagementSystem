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
import Model.FlightUserModel;
import db_Dao.Dao;

@WebServlet("/register_page")
public class RegistrationUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String retypepassword = request.getParameter("retypepassword");
		System.out.println("Hello World");
		if (password.equals(retypepassword)) {
			FlightUserModel flightModel = new FlightUserModel(name, email, dob, phone, password, retypepassword);
			Dao dao = new Dao(DatabaseConnection.connect());

			// Check if the email or phone already exists
			if (!dao.checkExistingRecord(email, phone)) {
				// Attempt to register the user
				int flag = dao.RegisterUser(flightModel);
				if (flag > 0) {
					out.print("<body><font color='yellow'><p>User are register</p></font></body>");
					RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
					dispatcher.include(request, resp);
					return;

				} else {
					// Registration successful, set success message and forward to user.jsp
					out.print("<body><font color='red'><p>User are not register<p></body>");
					RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
					dispatcher.include(request, resp);
					return;
				}
			} else {

				out.print("<body><font color='red'><p>User with email or phone already exists<p></body>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
				dispatcher.include(request, resp);
				return;
			}

		} else {
			out.print("<body><font color='red'><p>Password and Retype are not same<p></body>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.include(request, resp);
			return;
		}

	}
}
