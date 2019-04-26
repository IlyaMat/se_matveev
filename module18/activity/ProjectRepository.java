package sef.module18.activity;

import java.util.List;

public interface ProjectRepository {
	
	/**
	 * Returns a specific Project from the repository with the specified ID or null
	 * if no match is found. The method will throw an HRSSystemException if errors 
	 * during execution are encountered
	 * 
	 * @param id of the Project 
	 * @return

	 */
	public Project findProjectByID(int id) throws HRSSystemException;
	
	
	/**
	 * Returns a list of Project objects that contain the name specified in the parameter
	 * This will return an empty List of no match is found.
	 * 
	 * @param name the name to search
	 * @return a list of Projects 

	 */
	public List<Project> findProjectByName(String name) throws HRSSystemException;
	
	

	/**
	 * Finds a list of Projects based on the Employee project passed as the parameter
	 * This will return an empty List of no match is found. 
	 * The method will throw an HRSSystemException if errors during execution are encountered
	 * 
	 * @param id the ID of the Employee used as the basis of the search
	 * @return a list of Projects

	 */
	public List<Project> findProjectByEmployee(int employeeID) throws HRSSystemException;
	
	
	/**
	 * This method will attempt to insert a Project into the repository.   
	 * The method will throw an HRSSystemException if errors during execution are encountered
	 * 
	 * @param project the Project to insert into the repository
	 * @return the ID of the entry in the repository
	 */
	public int insertProject(Project project) throws HRSSystemException;
	
	/**
	 * Updates an existing Project in the repository with the values represented by the Project object passed
	 * as the parameter.  The Project parameter must contain an ID that matches an existing ID in the repository 
	 * and all fields must be populated and valid.  
	 * The method will throw an HRSSystemException if errors during execution are encountered
	 * 
	 * @param project the Project containing the details for the update
	 * @return true if row was updated.
	 */
	public boolean updateProject(Project project) throws HRSSystemException;
	
	
}
