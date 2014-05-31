package com.factoryproject.service;

import java.util.ArrayList;

import com.factoryproject.dao.MessageHibernateDAO;
import com.factoryproject.data.Message;

public class GetMessageFromDb {
	
	public static ArrayList<Message> getAll(){
		
		MessageHibernateDAO mdao = new MessageHibernateDAO();
		ArrayList<Message> all = (ArrayList<Message>) mdao.getAllMessages();
		mdao.destory();
		return all;
		
	}

}
