package Model;

public class FlightDetailModel 
{
	
	public FlightDetailModel() {
		
	}
	//attribute
	private String FlyingFrom;
	private String FlyingTo;
	private String Departing;
	private String DepartingTime;
	private String Returning;
	private String ReturningTime;
	private String price;
	private int id;
	private String classes;
	
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	//constructor
	public FlightDetailModel(String flyingFrom, String flyingTo, String departing, String departingTime,
			String returning, String returningTime, String price, String classes, int id) {
		FlyingFrom = flyingFrom;
		FlyingTo = flyingTo;
		Departing = departing;
		DepartingTime = departingTime;
		Returning = returning;
		ReturningTime = returningTime;
		this.price = price;
		this.id = id;
		this.classes=classes;
	}
	public FlightDetailModel(String flyingFrom, String flyingTo, String departing, String departingTime,
			String returning, String returningTime, String price,String classes) {
		FlyingFrom = flyingFrom;
		FlyingTo = flyingTo;
		Departing = departing;
		DepartingTime = departingTime;
		Returning = returning;
		ReturningTime = returningTime;
		this.price = price;
		this.classes=classes;

	}
	
	
	//getter and setter
	public String getFlyingFrom() {
		return FlyingFrom;
	}
	public void setFlyingFrom(String flyingFrom) {
		FlyingFrom = flyingFrom;
	}
	public String getFlyingTo() {
		return FlyingTo;
	}
	public void setFlyingTo(String flyingTo) {
		FlyingTo = flyingTo;
	}
	public String getDeparting() {
		return Departing;
	}
	public void setDeparting(String departing) {
		Departing = departing;
	}
	public String getDepartingTime() {
		return DepartingTime;
	}
	public void setDepartingTime(String departingTime) {
		DepartingTime = departingTime;
	}
	public String getReturning() {
		return Returning;
	}
	public void setReturning(String returning) {
		Returning = returning;
	}
	public String getReturningTime() {
		return ReturningTime;
	}
	public void setReturningTime(String returningTime) {
		ReturningTime = returningTime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "FlightDetailModel [FlyingFrom=" + FlyingFrom + ", FlyingTo=" + FlyingTo + ", Departing=" + Departing
				+ ", DepartingTime=" + DepartingTime + ", Returning=" + Returning + ", ReturningTime=" + ReturningTime
				+ ", price=" + price + ", id=" + id + ", classes=" + classes + "]";
	}
	
	
	
	
	
}
