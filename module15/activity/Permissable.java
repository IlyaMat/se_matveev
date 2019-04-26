package sef.module15.activity;

import java.util.Set;

public interface Permissable{

	/**
	 * Sets the permission provided the Permissions passed as parameters
	 * 
	 * @param permissions
	 */
	public void setPermission(Permission...permissions);
	
	
	/**
	 * Removes the permissions specified in the parameters
	 * 
	 * @param permissions
	 */
	public void removePermission(Permission...permissions);
	
	
	/**
	 * @return
	 */
	public Set<Permission>getPermission();
	public boolean isPermissable(Permission permission);
}
