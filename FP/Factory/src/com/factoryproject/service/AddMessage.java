package com.factoryproject.service;

import com.factoryproject.dao.MessageHibernateDAO;
import com.factoryproject.data.Message;

public class AddMessage {

	public static void add(Message m) {
		MessageHibernateDAO mdao = new MessageHibernateDAO();
		mdao.addMessage(m);
		mdao.destory();
	}

}
