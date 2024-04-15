package Model;

public class FlightUserModel 
{
	
	//attribute
	private int id;
	private String name, email, dob, phone, password, retypepassword,type;
	
	
	//constructor
	
	public FlightUserModel() {
	}
	
	
	
	public FlightUserModel(String name, String email, String dob, String phone, String password,
			String retypepassword) {
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
		this.password = password;
		this.retypepassword = retypepassword;
	}

	public FlightUserModel(int id, String name, String email, String dob, String phone, String password,
			String retypepassword) 
	{
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
		this.password = password;
		this.retypepassword = retypepassword;
	}
	
	
	
	//getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRetypepassword() {
		return retypepassword;
	}
	public void setRetypepassword(String retypepassword) {
		this.retypepassword = retypepassword;
	}

}
