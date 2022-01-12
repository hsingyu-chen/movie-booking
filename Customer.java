

public class Customer implements Comparable <Customer> {
	
	private String name;
	private String email;
	private String phone;
	private String password;
	private boolean isMember;
	
	public Customer() {
		name = "";
		email = "";
		phone = "";
		password = "";
	}
	
	public Customer(String name, String email, String phone, String password) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	public Customer(String email, String phone) {
		this.email = email;
		this.phone = phone;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	
	public boolean VarifiedPassword(String input) {
		return input.equals(password);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
    public int emailLength() {
    	return email.length();
	}

	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isMemberShip(int input) {
		if(input != -1) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "\nName: " + name
				+ "\nEmail: " + email
				+ "\nPhone: (" + phone.substring(0,3) + ")" + phone.substring(3,6) + "-" + phone.substring(6);
	}
	
	@Override
	public boolean equals(Object o) {
		Customer c = (Customer) o;
		if(email.equals(c.getEmail()) && phone.equals(c.getPhone())) {
			return true;
		} 
		return false;
	}
	
	@Override
	public int compareTo(Customer c) {
		if(this.equals(c)) {
			return 0;
		}else if(!email.equals(c.getEmail())) {
			return email.compareTo(c.getEmail());
		}else if(!phone.equals(c.getPhone())){
			return phone.compareTo(c.getPhone());
		}else  {
			return name.compareTo(c.getName());
		} 
	}

}
