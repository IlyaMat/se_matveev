package sef.module18.activity;

public class EmployeeImpl implements Employee {

	private int id;
	private String firstname;
	private String lastname;
	private int profLevel;
	
	public EmployeeImpl(int id, String firstname, String lastname, int profLevel){
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.profLevel = profLevel;
	}

	public int getEmployeeID() {
		return id;
	}


	public int getProfLevel() {
		return profLevel;
	}

	
	public String getFirstName() {
		return firstname;
	}


	public String getLastName() {
		return lastname;
	}


	public void setEmployeeID(int id) {
		this.id = id;
	}


	public void setProfLevel(int profLevel) {
		this.profLevel = profLevel;
	}

	
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
}
