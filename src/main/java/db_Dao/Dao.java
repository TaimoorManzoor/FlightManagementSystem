package db_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import Model.AirportModel;
import Model.BookingCustomerDetail;
import Model.BookingModel;
import Model.FlightDetailModel;
import Model.FlightUserModel;

public class Dao {

	public Connection conn;

	public Dao(Connection conn) {
		this.conn = conn;
	}

	public int addrecordFlight(FlightDetailModel detailModel) {
		int count = 0;
		try {
			String updateQuery = "INSERT INTO FlightDetail (FlyingFrom, FlyingTo,Departing,DepartingTime,Returning,ReturningTime,price,classes) VALUES (?, ?, ?, ? , ? ,? ,?,?);";
			PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);

			preparedStatement.setString(1, detailModel.getFlyingFrom());
			preparedStatement.setString(2, detailModel.getFlyingTo());
			preparedStatement.setString(3, detailModel.getDeparting());
			preparedStatement.setString(4, detailModel.getDepartingTime());
			preparedStatement.setString(5, detailModel.getReturning());
			preparedStatement.setString(6, detailModel.getReturningTime());
			preparedStatement.setString(7, detailModel.getPrice());
			preparedStatement.setString(8, detailModel.getClasses());

			count = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;

	}

	public int getUpdateFlight(FlightDetailModel detailModel) {
		int count = 0;
		System.out.println("Hello World");
		try {
			String updateQuery = "UPDATE FlightDetail  SET FlyingFrom=?, FlyingTo=?,Departing=?,DepartingTime=?,Returning=?,ReturningTime=?,price=? ,classes=? where id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);

			preparedStatement.setString(1, detailModel.getFlyingFrom());
			preparedStatement.setString(2, detailModel.getFlyingTo());
			preparedStatement.setString(3, detailModel.getDeparting());
			preparedStatement.setString(4, detailModel.getDepartingTime());
			preparedStatement.setString(5, detailModel.getReturning());
			preparedStatement.setString(6, detailModel.getDepartingTime());
			preparedStatement.setString(7, detailModel.getPrice());
			preparedStatement.setString(8, detailModel.getClasses());

			preparedStatement.setInt(9, detailModel.getId());
			count = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;

	}

	public FlightDetailModel getRecordsById(int id) {
		FlightDetailModel s = new FlightDetailModel();
		try {
			String fetchAllQuery = "Select * from FlightDetail where id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(fetchAllQuery);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				s.setId(rs.getInt(1));
				s.setFlyingFrom(rs.getString(2));
				s.setFlyingTo(rs.getString(3));
				s.setDeparting(rs.getString(4));
				s.setDepartingTime(rs.getString(5));
				s.setReturning(rs.getString(6));
				s.setReturningTime(rs.getString(7));
				s.setPrice(rs.getString(8));
				s.setClasses(rs.getString(9));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	public List<FlightDetailModel> fetchrecord()
	{
		List<FlightDetailModel> obj = new ArrayList<FlightDetailModel>();
		try {
			String fetchAllQuery = "Select * from FlightDetail";
			PreparedStatement preparedStatement = conn.prepareStatement(fetchAllQuery);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				FlightDetailModel s = new FlightDetailModel(); // Create a new instance for each record
				s.setId(rs.getInt(1));
				s.setFlyingFrom(rs.getString(2));
				s.setFlyingTo(rs.getString(3));
				s.setDeparting(rs.getString(4));
				s.setDepartingTime(rs.getString(5));
				s.setReturning(rs.getString(6));
				s.setReturningTime(rs.getString(7));
				s.setPrice(rs.getString(8));
				s.setClasses(rs.getString(9));


				obj.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public int deleteFlight(int id) {
		int count = 0;
		try {
			System.out.println(id);
			String updateQuery = "Delete from FlightDetail where id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
			preparedStatement.setInt(1, id);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int RegisterUser(FlightUserModel usermodel) {
		int count = 0;
		try {
			String updateQuery = "INSERT INTO FlightUser (name, email,dob,phone,password,retypepassword) VALUES (?, ?, ?, ? , ? ,?);";
			PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
			preparedStatement.setString(1, usermodel.getName());
			preparedStatement.setString(2, usermodel.getEmail());
			preparedStatement.setString(3, usermodel.getDob());
			preparedStatement.setString(4, usermodel.getPhone());
			preparedStatement.setString(5, usermodel.getPassword());
			preparedStatement.setString(6, usermodel.getRetypepassword());
			count = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return count;
	}

	public int LoginUser(String email, String password) {
		try {
			String query = "SELECT * FROM FlightUser WHERE email=? AND password=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				String userType = rs.getString("type");
				System.out.println("User Type: " + userType);
				System.out.println("Email: " + rs.getString("email"));
				System.out.println("Password: " + rs.getString("password"));
				if ("user".equals(userType)) {
					return 1; // User login successful
				} else if ("admin".equals(userType)) {
					return 2; // Admin login successful
				}
			} else {
				System.out.println("No data found for email: " + email);
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return 0; // Login failed
	}

	public String getUser_id(String email) {
		String user_id = null;

		try {
			String selectQuery = "Select id from flightuser where email=?";
			PreparedStatement preparedStatements = conn.prepareStatement(selectQuery);
			preparedStatements.setString(1, email);
			ResultSet adminRs = preparedStatements.executeQuery();
			if (adminRs.next()) {
				user_id = adminRs.getString("id");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user_id;

	}

	public String addrecordBook(BookingModel detailModel) {
		String booking_id = null;

		try {
			String insertQuery = "insert into booking (adult,infant,children,id_user,id_flight,total_amount,departure_time) values(?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);

			preparedStatement.setString(1, detailModel.getAdult());
			preparedStatement.setString(2, detailModel.getInfant());
			preparedStatement.setString(3, detailModel.getChildren());
			preparedStatement.setString(4, detailModel.getId_user());
			preparedStatement.setString(5, detailModel.getId_flight());
			preparedStatement.setString(6, detailModel.getTotal_amount());
			preparedStatement.setString(7, detailModel.getTimestamp());


			int count = preparedStatement.executeUpdate();

			if (count > 0) {
				String selectQuerys = "Select booking_id from booking where id_user=? and id_flight=? and departure_time=?";
				PreparedStatement preparedStatementss = conn.prepareStatement(selectQuerys); // corrected variable name
				preparedStatementss.setString(1, detailModel.getId_user());
				preparedStatementss.setString(2, detailModel.getId_flight());
				preparedStatementss.setString(3, detailModel.getTimestamp());

				ResultSet adminRss = preparedStatementss.executeQuery(); // corrected variable name

				if (adminRss.next()) {
					booking_id = adminRss.getString("booking_id");
				}
				return booking_id;// add booking_id parameter
			}

			else {
				booking_id = null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	public FlightUserModel getUserRecordsById(String id) {
		FlightUserModel s = new FlightUserModel();
		try {
			String fetchAllQuerys = "Select * from flightuser where id=?";
			PreparedStatement fetchAllStatements = conn.prepareStatement(fetchAllQuerys);
			fetchAllStatements.setString(1, id);
			ResultSet rs = fetchAllStatements.executeQuery();
			while (rs.next()) {
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setDob(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setPhone(rs.getString(5));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	public BookingModel getBookingRecordsById(String booking_id) {
		BookingModel s = new BookingModel();
		try {
			String fetchAllQuery_booking = "Select * from booking where booking_id=?";
			PreparedStatement fetchAllStatement_booking = conn.prepareStatement(fetchAllQuery_booking);
			fetchAllStatement_booking.setString(1, booking_id);
			ResultSet rs = fetchAllStatement_booking.executeQuery();
			while (rs.next()) {
				s.setAdult(rs.getString(2));
				s.setInfant(rs.getString(3));
				s.setChildren(rs.getString(4));
				s.setId_user(rs.getString(5));
				s.setId_flight(rs.getString(6));
				s.setTotal_amount(rs.getString(7));
				s.setTimestamp(rs.getString(8));
				s.setTracking(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	public List<FlightUserModel> fetchUserRecord() {
		List<FlightUserModel> obj = new ArrayList<FlightUserModel>();
		try {
			String fetchAllQuery = "Select * from FlightUser";
			PreparedStatement preparedStatement = conn.prepareStatement(fetchAllQuery);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				FlightUserModel s = new FlightUserModel(); // Create a new instance for each record
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setDob(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setPhone(rs.getString(5));
				s.setPassword(rs.getString(6));

				obj.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public int addrecordBookingCustomerDetail(BookingCustomerDetail detailModel)
	{
		int count = 0;
		try {
			String updateQuery = "INSERT INTO BookingCustomerDetail (booking_id, customer_name,contact_no,email,payment_status) VALUES (?, ?, ?, ?,? );";
			PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);

			preparedStatement.setString(1, detailModel.getBooking_id());
			preparedStatement.setString(2, detailModel.getCustomer_name());
			preparedStatement.setString(3, detailModel.getContact_no());
			preparedStatement.setString(4, detailModel.getEmail());
			preparedStatement.setString(5, detailModel.getPaymentStatus());


			count = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;

	}

	public boolean checkExistingRecord(String email, String phone) {
	    boolean message = false;
	    try {
	        String fetchQuery = "SELECT * FROM FlightUser WHERE email=? OR phone=?";
	        PreparedStatement statement = conn.prepareStatement(fetchQuery);
	        statement.setString(1, email);
	        statement.setString(2, phone);
	        ResultSet rs = statement.executeQuery();
	        if (rs.next()) {
	            if (email.equals(rs.getString("email")) || phone.equals(rs.getString("phone"))) {
	                message = true;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return message;
	}

	public List<BookingCustomerDetail> fetchConfirmBookingRecord()
	{
		List<BookingCustomerDetail> obj = new ArrayList<BookingCustomerDetail>();
		try {
			String fetchAllQuery = "Select * from BookingCustomerDetail";
			PreparedStatement preparedStatement = conn.prepareStatement(fetchAllQuery);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				BookingCustomerDetail s = new BookingCustomerDetail(); // Create a new instance for each record
				s.setSeat_id(rs.getString(1));
				s.setBooking_id(rs.getString(2));
				s.setCustomer_name(rs.getString(3));
				s.setContact_no(rs.getString(4));
				s.setEmail(rs.getString(5));

				obj.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public int addTrackBook(String tracking_id, String booking_id) {
	    int count = 0;
	    try {
	        String updateQuery = "UPDATE booking SET tracking_id = ? WHERE booking_id = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);

	        preparedStatement.setString(1, tracking_id);
	        preparedStatement.setString(2, booking_id);

	        count = preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }

	    return count;
	}
	
	public List<FlightDetailModel> addFilter(String flyingfrom, String flyingto, String departingdate, String classes) {
	    List<FlightDetailModel> obj = new ArrayList<>();

	    try {
	        String selectQuery = "SELECT * FROM FlightDetail WHERE FlyingFrom=? and FlyingTo=? and Departing=? and classes=?";
	        PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
	        preparedStatement.setString(1, flyingfrom);
	        preparedStatement.setString(2, flyingto);
	        preparedStatement.setString(3, departingdate);
	        preparedStatement.setString(4, classes);

	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) 
	        {
	            FlightDetailModel s = new FlightDetailModel();
	            s.setId(rs.getInt("ID"));
	            s.setFlyingFrom(rs.getString("FlyingFrom"));
	            s.setFlyingTo(rs.getString("FlyingTo"));
	            s.setDeparting(rs.getString("Departing"));
	            s.setDepartingTime(rs.getString("DepartingTime"));
	            s.setReturning(rs.getString("Returning"));
	            s.setReturningTime(rs.getString("ReturningTime"));
	            s.setPrice(rs.getString("Price"));
	            s.setClasses(rs.getString("classes"));


	            obj.add(s);
	        }
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }

	    return obj;
	}
	
	public List<AirportModel> Airportfetchrecord()
	{
		List<AirportModel> obj = new ArrayList<AirportModel>();
		try {
			String fetchAllQuery = "Select * from airport";
			PreparedStatement preparedStatement = conn.prepareStatement(fetchAllQuery);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				AirportModel s = new AirportModel(); // Create a new instance for each record
				s.setAirport_id(rs.getInt(1));
				s.setAirport_name(rs.getString(2));
			


				obj.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	public List<BookingCustomerDetail> CustomerBooking(String booking_id) 
	{
	    List<BookingCustomerDetail> obj = new ArrayList<>();
	    PreparedStatement preparedStatement = null;
	    ResultSet rs = null;
	    try {
	        String fetchAllQuery = "SELECT * FROM BookingCustomerDetail WHERE booking_id=?";
	        preparedStatement = conn.prepareStatement(fetchAllQuery);
	        preparedStatement.setString(1, booking_id);
	        rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            BookingCustomerDetail s = new BookingCustomerDetail();
	            s.setSeat_id(rs.getString(1)); 
	            s.setBooking_id(rs.getString(2));
	            s.setCustomer_name(rs.getString(3));
	            s.setContact_no(rs.getString(4));
	            s.setEmail(rs.getString(5));
	            s.setPaymentStatus(rs.getString(6));
	            obj.add(s);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Consider logging the error instead
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // Consider logging the error instead
	        }
	    }
	    return obj;
	}
	
	public BookingModel getBookingRecordsByTracking(String tracking_id) {
		BookingModel s = new BookingModel();
		try {
			String fetchAllQuery_booking = "Select * from booking where tracking_id=?";
			PreparedStatement fetchAllStatement_booking = conn.prepareStatement(fetchAllQuery_booking);
			fetchAllStatement_booking.setString(1, tracking_id);
			ResultSet rs = fetchAllStatement_booking.executeQuery();
			while (rs.next()) {
				s.setId(rs.getString(1));
				s.setAdult(rs.getString(2));
				s.setInfant(rs.getString(3));
				s.setChildren(rs.getString(4));
				s.setId_user(rs.getString(5));
				s.setId_flight(rs.getString(6));
				s.setTotal_amount(rs.getString(7));
				s.setTimestamp(rs.getString(8));
				s.setTracking(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
}
