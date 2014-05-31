package com.factoryproject.action;

import com.factoryproject.data.Message;
import com.factoryproject.service.AddMessage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CreateMessageAction extends ActionSupport implements
		ModelDriven<Message> {

	private Message message;

	public String excute() {
		AddMessage.add(message);
		return SUCCESS;
	}

	@Override
	public Message getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
