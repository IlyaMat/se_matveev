package sef.module18.activity;

import java.util.List;

public interface EmployeeRepository {

	/**
	 * Returns a specific Employee instance represented by the specified ID or null
	 * if no match is found.
	 * The method will throw an HRSSystemException if errors during execution are encountered
	 * 
	 * @param employeeID the ID of the Employee to return
	 * @return an Employee object
	 */
	public Employee findEmployeeByID(int employeeID) throws HRSSystemException;
	
	
	/**
	 * Returns a list of Employee objects that contain the specified first name and last name. 
	 * This will return an empty List of no match is found.
	 * The method will throw an HRSSystemException if errors during execution are encountered.
	 * 
	 * @param name the name to search
	 * @return a list of Employee objects
	 */
	public List<Employee> findEmployeeByName(String firstname, String lastname) throws HRSSystemException;
	
	
	/**
	 * Returns a list of Employee objects with the level specified by the parameter.
	 * This will return an empty List of no match is found.
	 * The method will throw an HRSSystemException if errors during execution are encountered
	 * 
	 * @param level the EmployeeLevel to search
	 * @return a list of Employee objects
	 */
	public List<Employee> findEmployeeByProfLevel(int profLevel) throws HRSSystemException;
	
	
	/**
	 * Returns a list of Employees that belong to a Project with the specified
	 * ID. This will return an empty List of no match is found.
	 * The method will throw an HRSSystemException if errors during execution are encountered
	 * 
	 * @param projectID
	 * @return a list of Employee objects
	 */
	public List<Employee> findEmployeeByProject(int projectID) throws HRSSystemException;
	
	/**
	 * This method will attempt to insert an Employee into the repository.   
	 * The method will throw an HRSSystemException if errors during execution are encountered
	 * 
	 * @param employee the Employee to insert into the repository
	 * @return the ID of the entry in the repository
	 */	
	public int insertEmployee(Employee employee) throws HRSSystemException;
	
	
	/**
	 * Updates an existing Employee in the repository with the values represented by the Employee object passed
	 * as the parameter.  The Employee parameter must contain an ID that matches an existing ID in the repository 
	 * and all fields must be populated and valid.  
	 * 
	 * The method will throw an HRSSystemException if errors during execution are encountered
	 * 
	 * @param project the Project containing the details for the update
	 * @return true if row was updated.
	 */
	public boolean updateEmployee(Employee employee) throws HRSSystemException;
	
}
