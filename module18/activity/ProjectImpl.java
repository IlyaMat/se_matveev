package sef.module18.activity;

public class ProjectImpl implements Project {

	private int id;
	private String name;
	private String description;

	public ProjectImpl(int id, String name, String description){
		this.id = id;
		this.name = name;
		this.description = description;
	}
	

	public String getProjectDescription() {
		return description;
	}


	public int getProjectID() {
		return id;
	}


	public String getProjectName() {
		return name;
	}


	public void setProjectDescription(String description) {
		this.description = description;
	}

	
	public void setProjectID(int id) {
		this.id = id;
	}


	public void setProjectName(String name) {
		this.name = name;
	}

}
