package Model;

public class BookingCustomerDetail {
	@Override
	public String toString() {
		return "BookingCustomerDetail [seat_id=" + seat_id + ", booking_id=" + booking_id + ", customer_name="
				+ customer_name + ", contact_no=" + contact_no + ", email=" + email + ", paymentStatus=" + paymentStatus
				+ "]";
	}

	String seat_id;
	String booking_id;
	String customer_name;
	String contact_no;
	String email;
	String paymentStatus;

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BookingCustomerDetail(String booking_id, String customer_name, String contact_no, String email , String paymentStatus) {
		super();
		this.booking_id = booking_id;
		this.customer_name = customer_name;
		this.contact_no = contact_no;
		this.email = email;
		this.paymentStatus=paymentStatus;
	}

	public BookingCustomerDetail(String seat_id, String booking_id, String customer_name, String contact_no,
			String email,String paymentStatus) {
		super();
		this.seat_id = seat_id;
		this.booking_id = booking_id;
		this.customer_name = customer_name;
		this.contact_no = contact_no;
		this.email = email;
		this.paymentStatus=paymentStatus;

	}

	public String getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(String seat_id) {
		this.seat_id = seat_id;
	}

	public String getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public BookingCustomerDetail() {
		super();
	}

}
