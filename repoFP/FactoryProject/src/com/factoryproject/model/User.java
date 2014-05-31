

package com.factoryproject.model;

import java.io.Serializable;



public  class User implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -3856022692878024470L;
	private String username;
    private String password;
    /**
     * permission has 3 kinds,"user","employee" and "administrator".
     * The 0 is the lowest rank,1 is user,2 is employee,3 is administrator.
     */
    private int permission = 0;
    public User(){
    	
    }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public String toString(){
		String str = "username = "+getUsername()+",password = "+getPassword();
		return str;
	}

 }