package sef.module18.activity;

@SuppressWarnings("serial")
public class HRSSystemException extends Exception {
	public static final String ERROR_FIND_EMPLOYEE_ID="Exception occcured while finding Employee via ID.";
	public static final String ERROR_FIND_EMPLOYEE_NAME="Exception occcured while finding Employee via Name.";
	public static final String ERROR_FIND_EMPLOYEE_LEVEL="Exception occcured while finding Employee via Level.";
	public static final String ERROR_FIND_EMPLOYEE_PROJECTID="Exception occcured while finding Employee via Project ID.";
	public static final String ERROR_INSERT_EMPLOYEE="Exception occured while inserting new Employee.";
	public static final String ERROR_UPDATE_EMPLOYEE="Exception occured while updating an Employee.";

	
	public static final String ERROR_FIND_PROJECT_ID="Exception occcured while finding Project via ID.";
	public static final String ERROR_FIND_PROJECT_NAME="Exception occcured while finding Project via Name.";
	public static final String ERROR_FIND_PROJECT_EMPLOYEEID="Exception occcured while finding Project via Employee ID.";
	public static final String ERROR_INSERT_PROJECT="Exception occured while inserting new Project.";
	public static final String ERROR_UPDATE_PROJECT="Exception occured while updating a Project.";
	
	public HRSSystemException(String message, Throwable cause){
		super(message, cause);
	}
}
