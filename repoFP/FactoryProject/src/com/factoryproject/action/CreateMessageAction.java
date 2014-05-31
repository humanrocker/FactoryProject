

package com.factoryproject.action;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import org.apache.struts2.ServletActionContext;

import com.factoryproject.model.Message;
import com.factoryproject.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;




public  class CreateMessageAction extends ActionSupport implements ModelDriven<Message>{
	
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -2972047313362881091L;
	private Message message = new Message();


    public String execute() {
    	
    	ActionContext ctx = ActionContext.getContext();
    	
        //get the speaker
    	message.setSpeaker((User) ctx.getSession().get("user"));
    	//get the content
    	message.setContent(ServletActionContext.getRequest().getParameter("content"));
    	//get the date and time when leaving message
    	message.setDateAdded(new Timestamp(System.currentTimeMillis()));
    	//get the replyingMessageID
    	int rid;
    	message.setReplyingMessageID((Message) ServletActionContext.getRequest().getAttribute("replyingMessageID"));
    	if(message.getReplyingMessageID()==null){
    		rid = 0;
    	}else
    		rid = message.getReplyingMessageID().getId();
    	//check out if words are over the limit or no words input
    	byte[] b_content = message.getContent().getBytes();
    	if(b_content.length>=255||0==b_content.length){
    		ctx.put("tip", "Words of the content are over the limit.");
    		return INPUT;
    	}
    	
    	Connection conn = null;
    	
    	//database connection
    	try {
    		ValueStack stack = ActionContext.getContext().getValueStack();
        	conn = (Connection) stack.getContext().get("conn");
        	
        	//for debug
        	if(conn!=null)System.out.print("conn has been caught.");
        	else System.out.print("conn hasn't been caught.");
        	
        	Statement stmt = conn.createStatement();
			String sql = "insert into message(content,dateAdded,speaker,RE_MESSAGE_ID)values('"+
					message.getContent()+
					"','"+
					message.getDateAdded()+
					"','"+
					message.getSpeaker().getUsername()+
					"','"+
//					message.getReplyingMessageID().getId()+
					rid+
					"') ";
			int rows = stmt.executeUpdate(sql);
			if(rows==0){
				ctx.put("tip", "Saving failed.");
				System.out.println("写入数据库失败！");
				return INPUT;
			}
			else{
				System.out.println("写入数据库成功！");
				return SUCCESS;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ERROR;
        
    }


	@Override
	public Message getModel() {
		// TODO Auto-generated method stub
		return message;
	}	


 }