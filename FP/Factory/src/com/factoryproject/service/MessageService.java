package com.factoryproject.service;

import java.util.ArrayList;

import com.factoryproject.dao.MessageHibernateDAO;
import com.factoryproject.data.Message;
import com.factoryproject.data.News;

public class MessageService {

	public static void add(Message m) {
		MessageHibernateDAO mdao = new MessageHibernateDAO();
		mdao.addMessage(m);
		mdao = null;
	}
	
	/**
	 * No need to create a class for this service.
	 * 12/06/2014
	 * 
	 * @author TonyHong
	 * @return The messages in an ArrayList<Message> object. 
	 */
	public static ArrayList<Message> getAll(){
		MessageHibernateDAO mdao = new MessageHibernateDAO();
		ArrayList<Message> all = (ArrayList<Message>) mdao.getAllMessages();
		mdao = null;
		return all;
	}

}
