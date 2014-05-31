package com.factoryproject.service;

import com.factoryproject.dao.UserHibernateDAO;
import com.factoryproject.data.User;

public class VerifyUser {

	public static boolean doVerify(User user) {
		UserHibernateDAO udao = new UserHibernateDAO();
		java.util.List<User> userList = udao.findAll();
		udao.destory();

		if (!userList.contains(user)) {
			System.out.println("用户名或者密码错误！");
			return false;
		}
		return true;
	}

}
