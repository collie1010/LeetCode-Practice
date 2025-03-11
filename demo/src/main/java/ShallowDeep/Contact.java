package ShallowDeep;

public class Contact implements Cloneable {
    private String phone;
    private String email;
    
    public Contact(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }
    
    // Getter 和 Setter
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    @Override
    public String toString() {
        return "Contact{phone='" + phone + "', email='" + email + "'}";
    }
}
