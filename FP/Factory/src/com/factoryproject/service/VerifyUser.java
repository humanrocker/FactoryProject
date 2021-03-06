package com.factoryproject.service;

import com.factoryproject.dao.UserHibernateDAO;
import com.factoryproject.data.User;

public class VerifyUser {
	/**
	 * No need to create a class for this service.
	 * 12/06/2014
	 * 
	 * @author TonyHong
	 * @deprecated
	 * @param user
	 * @return The result of verification. 
	 */
	@Deprecated
	public static boolean doVerify(User user) {
		UserHibernateDAO udao = new UserHibernateDAO();
		java.util.List<User> userList = udao.findAll();
		udao = null;
		
		if (!userList.contains(user)) {
			System.out.println("用户名或者密码错误！");
			return false;
		}
		return true;
	}

}
