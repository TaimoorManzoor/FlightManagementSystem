package servlet.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import Db_Connection.DatabaseConnection;
import Model.FlightUserModel;
import db_Dao.Dao;

@WebServlet("/usermanage")
public class loginservlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = request.getSession();        
        String email_login = request.getParameter("email_login");
        String password_login = request.getParameter("password_login");

        Dao dao = new Dao(DatabaseConnection.connect());
        int hasData = dao.LoginUser(email_login, password_login);


        try
        {
            if (hasData == 1) 
            {
            	out.print("<body><p>Login Sucessfully<p></font></body>");
                session.setAttribute("email", email_login);
                session.setAttribute("password", password_login);

                RequestDispatcher dispatcher = request.getRequestDispatcher("query.jsp");
                dispatcher.include(request, resp);
                return; // Redirected, no further processing needed
            }
            else if (hasData == 2)
            {
            	out.print("<body><p>Login Sucessfully<p></font></body>");
                System.out.println("Value of hasData:asdasd " + hasData); // Debugging
                session.setAttribute("email", email_login);
                session.setAttribute("password", password_login);
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.include(request, resp);                
                return; // Redirected, no further processing needed
            }
            else 
            {
            	out.print("<body><p>Login Fail<p></body>");
                System.out.println("Value of hasData:asdasd " + hasData); // Debugging
                RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                dispatcher.include(request, resp);                
                return;
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace(); // Log exceptions for debugging
        }
    }
}

