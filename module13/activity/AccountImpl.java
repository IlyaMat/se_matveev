package sef.module13.activity;

public class AccountImpl implements Account{

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	public AccountImpl(int id, String firstName, String lastName, String email){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	public int getID() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	
	
	
}
