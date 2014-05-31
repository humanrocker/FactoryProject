package com.factoryproject.action;

import java.util.ArrayList;

import com.factoryproject.data.Message;
import com.factoryproject.service.GetMessageFromDb;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DisplayMessageAction extends ActionSupport {

	private ArrayList<Message> messageList;

	public String excute() {
		messageList = GetMessageFromDb.getAll();
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put("messageList", messageList);
		return SUCCESS;
	}
}
