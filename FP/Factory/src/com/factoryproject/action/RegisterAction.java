package com.factoryproject.action;

import java.sql.Connection;
import java.sql.Statement;

import org.apache.struts2.ServletActionContext;

import com.factoryproject.dao.UserHibernateDAO;
import com.factoryproject.data.User;
import com.factoryproject.service.AddUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class RegisterAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * this action is used for browse-by to register an account
	 */
	private static final long serialVersionUID = 2158346796850031514L;

	private User user = new User();

	public String execute() {

		if (AddUser.add(user)) {
			return SUCCESS;
		}
		return ERROR;

	}

	public void validate() {

		//
		if (user.getUsername().substring(0, 0).matches("^[A-Za-z]+$")) {
			addFieldError("Username", getText("username.startwithLetter"));
		}
		//
		if (4 <= user.getUsername().length()
				&& 12 >= user.getUsername().length()) {
			addFieldError("Username", getText("username.length"));
		}
		//
		if (user.getUsername().matches("^[A-Za-z0-9]+$ ")) {
			addFieldError("Username", getText("username.contains"));
		}
		//
		if (4 <= user.getPassword().length()
				&& 12 >= user.getPassword().length()) {
			addFieldError("Password", getText("password.length"));
		}

	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}