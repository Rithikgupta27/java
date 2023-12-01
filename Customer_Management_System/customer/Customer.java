package customer;

import java.time.LocalDate;

public class Customer implements Comparable<Customer> {
	private ServicePlan plan;
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int registrationAmount;
	private LocalDate dob;

	public Customer(ServicePlan plan, int id, String firstName, String lastName, String email, String password,
			int registrationAmount, LocalDate dob) {
//	super();
		this.plan = plan;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
	}

	public Customer(String email) {
		super();
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [plan=" + plan + ", id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", registrationAmount=" + registrationAmount + ", dob=" + dob + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Customer) {
			Customer temp = (Customer) o;
			return this.email.equals(temp.email);
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(Customer newCustomer) {
//	if(o instanceof Customer) {
//		Customer temp=(Customer)o;
		Integer Id = this.id;
		return Id.compareTo((Integer) newCustomer.id);

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
