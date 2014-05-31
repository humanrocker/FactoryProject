package com.factoryproject.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -554846702770615875L;

	public String execute() {

		ActionContext ctx = ActionContext.getContext();
//		ctx.getSession().clear();
		 ctx.getSession().remove("user");
		//
		if (ctx.getSession().isEmpty()) {
			System.out.println("Logout success.");
			// 
			return "input";
		} else {
			// ctx.getSession().containsKey("user");
			System.out.println("Logout failed.");
			return "error";
		}

	}

}