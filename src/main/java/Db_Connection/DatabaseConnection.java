package Db_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
	
	private static Connection con;
	
	public static Connection connect() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlightManagement", "root", "root");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	/*
	 * public static void main(String arg[]) {
	 * 
	 * }
	 */
    

}
