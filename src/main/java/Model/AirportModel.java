package Model;

public class AirportModel 
{
	
	private int airport_id; 
    private String airport_name; 
    
    public int getAirport_id() {
		return airport_id;
	}
	public void setAirport_id(int airport_id) {
		this.airport_id = airport_id;
	}
	public String getAirport_name() {
		return airport_name;
	}
	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
	}
	public AirportModel(String airport_name) {
		super();
		this.airport_name = airport_name;
	}
	public AirportModel(int airport_id, String airport_name) {
		super();
		this.airport_id = airport_id;
		this.airport_name = airport_name;
	}
	public AirportModel() {
		super();
	}
}
