package com.factoryproject.service;

import com.factoryproject.dao.UserHibernateDAO;
import com.factoryproject.data.User;

public class UserService {

	public static boolean add(User user) {
		UserHibernateDAO udao = new UserHibernateDAO();
		udao.addUser(user);// 
		if(udao.findUserByName(user.getUsername()).equals(user)){
			udao = null;
			return true;
		}else{
			udao = null;
			return false;
		}
		
	}
	
	/**
	 * To verify a user.
	 * 
	 * @author TonyHong
	 * @param user The user object to verify.
	 * @return The result of verification. 
	 */
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
