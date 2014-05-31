package com.factoryproject.action;

import org.apache.struts2.ServletActionContext;

import com.factoryproject.dao.UserHibernateDAO;
import com.factoryproject.data.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.factoryproject.service.VerifyUser;

public class LoginAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * this action is for an account to login
	 */
	private static final long serialVersionUID = -7325326470596711055L;

	private User user = new User();

	// 登录之前的页面
	private String prePage = null;

	public String getPrePage() {
		return prePage;
	}

	public String execute() {

		ActionContext ctx = ActionContext.getContext();
		// 获取登录前页面
		prePage = (String) ctx.getSession().get("prePage");

		if (VerifyUser.doVerify(user)) {
			ctx.getSession().put("user", user);
			return SUCCESS;
		}
		return INPUT;
	}

	public void validate() {
		if (user.getUsername() == null || user.getUsername().trim().equals("")) {
			addFieldError("username", getText("username.required"));
		}

		if (user.getPassword() == null || user.getPassword().trim().equals("")) {
			addFieldError("password", getText("password.required"));
		}
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}