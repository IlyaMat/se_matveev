package sef.module15.activity;

import java.util.HashSet;
import java.util.Set;

public class PermissionList implements Permissable{
	
	private String permissionID;
	private Set<Permission> permission;
	
	/**
	 * Creates a permission object and provides an identifier for it
	 * 
	 * @param permissionID
	 */
	public PermissionList(String permissionID){
		this.permissionID = permissionID;
		this.permission = new HashSet<>();
	}

	/* (non-Javadoc)
	 * @see sef.module14.activity.Permissable#getPermission()
	 */
//	@Override
	public Set<Permission> getPermission() {
		return permission;
	}


	/* (non-Javadoc)
	 * @see sef.module14.activity.Permissable#removePermission(sef.module14.activity.Permission[])
	 */
//	@Override
	public void removePermission(Permission... permissions) {
		if (permissions != null)
			for(Permission permission : permissions) {
				this.permission.remove(permission);
			}
	}


	/* (non-Javadoc)
	 * @see sef.module14.activity.Permissable#setPermission(sef.module14.activity.Permission[])
	 */
//	@Override
	public void setPermission(Permission... permissions) {
		if (permissions != null) {
			for (Permission p : permissions) {
				this.permission.add(p);
			}
		}
	}


	/* (non-Javadoc)
	 * @see sef.module14.activity.Permissable#isPermissable(sef.module14.activity.Permission)
	 */
//	@Override
	public boolean isPermissable(Permission permission) {
		return this.permission.contains(permission);
	}

	public String getPermissionID() {
		return permissionID;
	}


	public void setPermissionID(String permissionID) {
		this.permissionID = permissionID;
	}
}
