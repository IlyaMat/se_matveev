package sef.module13.activity;

import java.util.List;

public interface AccountDAO {

	/**
	 * Returns a list of accounts that with first names and last names that contain
	 * the specified first name and last name.  The result list will be ordered via ID
	 * in an ascending manner
	 * 
	 * @param firstName the first name of the account to search
	 * @param lastName the last name of the account to search
	 * @return list of accounts that match the criteria
	 * 
	 * @throws AccountDAOException when a problem occurs during search
	 */
	public List<Account> findAccount(String firstName, String lastName) throws AccountDAOException;
	
	
	/**
	 * Returns a specific account that matches the specified ID
	 * 
	 * @param id the id of the account
	 * @return an account that matches the ID specified, null if no match is found
	 * 
	 * @throws AccountDAOException when a problem occurs during search
	 */
	public Account findAccount(int id) throws AccountDAOException;
	
	
	
	/**
	 * Adds a new account based on the values passed
	 * 
	 * @param firstName the first name of the account
	 * @param lastName the last name of the account
	 * @param email the email of the account
	 * 
	 * @return true if a row was inserted	 
	 * 
	 * @throws AccountDAOException thrown when a problem occurs during search
	 */
	public boolean insertAccount(String firstName, String lastName, String email) throws AccountDAOException;
	
}