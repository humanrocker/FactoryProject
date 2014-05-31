package com.factoryproject.service;

import com.factoryproject.dao.UserHibernateDAO;
import com.factoryproject.data.User;

public class AddUser {

	public static boolean add(User user) {
		UserHibernateDAO udao = new UserHibernateDAO();
		udao.addUser(user);// 
		if(udao.findUserByName(user.getUsername()).equals(user)){
			udao.destory();
			return true;
		}else{
			udao.destory();
			return false;
		}
		
	}

}
