package com.factoryproject.service;

import java.util.ArrayList;

import com.factoryproject.dao.MessageHibernateDAO;
import com.factoryproject.data.Message;

public class GetMessageFromDb {
	
	/**
	 * No need to create a class for this service.
	 * 12/06/2014
	 * 
	 * @author TonyHong
	 * @deprecated
	 * @return The messages in an ArrayList<Message> object. 
	 */
	@Deprecated
	public static ArrayList<Message> getAll(){
		MessageHibernateDAO mdao = new MessageHibernateDAO();
		ArrayList<Message> all = (ArrayList<Message>) mdao.getAllMessages();
		mdao = null;
		return all;
	}
}
