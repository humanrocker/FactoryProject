package com.factoryproject.action;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.factoryproject.model.Message;
import com.factoryproject.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

@SuppressWarnings("rawtypes")
public class DisplayMessageAction extends ActionSupport implements
		ModelDriven<List> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6262405462518811726L;

	public String excute() {
		ActionContext ctx = ActionContext.getContext();
		Connection conn = null;

		List<Message> list = new ArrayList<Message>();

		try {
			System.out.println("£¡£¡£¡£¡£¡£¡");
			ValueStack stack = ctx.getValueStack();
			conn = (Connection) stack.getContext().get("conn");

			// if(conn.equals(null))System.out.println("conn is empty.");

			Statement stmt = conn.createStatement();
			String sql = "select * from message";
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.equals(null))
				System.out.println("rs is empty.");

			while (rs.next()) {
				Message m = new Message();

				m.setContent(rs.getString(2));
				m.setDateAdded((Timestamp) rs.getObject(3));
				m.setSpeaker((User) rs.getObject(4));
				m.setReplyingMessageID((Message) rs.getObject(5));

				list.add(m);
			}

			System.out.println(list);
			for (Message ms : list)
				System.out.println(ms);
			ctx.getSession().put("messageList", list);
			if (ctx.getSession().get("messageList") != null)
				System.out.println("session has put messageList.");

			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	@Override
	public List<Message> getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
