package Model;

public class BookingModel
{


	@Override
	public String toString() {
		return "BookingModel [id=" + id + ", adult=" + adult + ", infant=" + infant + ", children=" + children
				+ ", id_user=" + id_user + ", id_flight=" + id_flight + ", total_amount=" + total_amount
				+ ", timestamp=" + timestamp + ", tracking=" + tracking + "]";
	}


	public String getTracking() {
		return tracking;
	}


	public void setTracking(String tracking) {
		this.tracking = tracking;
	}

	// attribute
	private String id;
	private String adult,infant,children,id_user,id_flight , total_amount, timestamp,tracking;
	public BookingModel() {
		
	}
	

	public BookingModel(String id, String adult, String infant, String children, String id_user, String id_flight, String total_amount, String timestamp, String tracking) {
		super();
		this.id = id;
		this.adult = adult;
		this.infant = infant;
		this.children = children;
		this.id_user = id_user;
		this.id_flight = id_flight;
		this.total_amount = total_amount;
		this.timestamp = timestamp;
		this.tracking = tracking;
	}

	// constructor
	public BookingModel(String id, String adult, String infant, String children, String id_user, String id_flight,
			String total_amount,String timestamp) {
		super();
		this.id = id;
		this.adult = adult;
		this.infant = infant;
		this.children = children;
		this.id_user = id_user;
		this.id_flight = id_flight;
		this.total_amount = total_amount;
		this.timestamp=timestamp;
	}

	public BookingModel(String adult, String infant, String children, String id_user, String id_flight,
			String total_amount,String timestamp) {
		super();
		this.adult = adult;
		this.infant = infant;
		this.children = children;
		this.id_user = id_user;
		this.id_flight = id_flight;
		this.total_amount = total_amount;
		this.timestamp=timestamp;

	}
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	//getter and setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdult() {
		return adult;
	}

	public void setAdult(String adult) {
		this.adult = adult;
	}

	public String getInfant() {
		return infant;
	}

	public void setInfant(String infant) {
		this.infant = infant;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getId_flight() {
		return id_flight;
	}

	public void setId_flight(String id_flight) {
		this.id_flight = id_flight;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	
	
	
	
	

}
