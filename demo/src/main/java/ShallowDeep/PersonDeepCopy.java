package ShallowDeep;

public class PersonDeepCopy implements Cloneable {
	private String name;
	private int age;
	private Address address;
	private Contact contact;

	public PersonDeepCopy(String name, int age, Address address, Contact contact) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.contact = contact;
	}

	// Getter 和 Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		PersonDeepCopy cloned = (PersonDeepCopy) super.clone();
		cloned.address = (Address) this.address.clone();
		cloned.contact = (Contact) this.contact.clone();
		return cloned;
	}

	@Override
	public String toString() {
		return "Person{name='" + name + "', age=" + age + ", address=" + address + ", contact=" + contact + "}";
	}
}
