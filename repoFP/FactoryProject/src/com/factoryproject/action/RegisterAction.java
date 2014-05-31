

package com.factoryproject.action;
import java.sql.Connection;
import java.sql.Statement;

import org.apache.struts2.ServletActionContext;

import com.factoryproject.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;



public  class RegisterAction extends ActionSupport implements ModelDriven<User>{
	
    /**
	 * this action is used for browse-by to register an account
	 */
	private static final long serialVersionUID = 2158346796850031514L;
	
	private User user = new User();

    public String execute() throws Exception{
        
    	//取到输入的用户名(user)和密码(pwd)
    	user.setUsername(ServletActionContext.getRequest().getParameter("username"));
    	user.setPassword(ServletActionContext.getRequest().getParameter("password"));
    	Connection conn = null;
    	//测试提交
    	if(user.toString().isEmpty())return INPUT;
    	try{
    		//从拦截器中取到参数
			ValueStack stack = ActionContext.getContext().getValueStack();
			conn = (Connection) stack.getContext().get("conn");
//			if(conn != null){
//				System.out.println("conn:Connection 非空！Action已经接收到来自Interceptor的参数！");
//			}else{
//				System.out.println("conn:Connection 空！Action未接收到来自Intercptor的参数！");
//			}
			
			//用户名和密码不能为空
	    	if(user.getUsername().equals(null)||user.getPassword().equals(null))return INPUT;
	    	//数据库连接
	    	Statement stmt = conn.createStatement();
	    	String sql="insert into user(username,password)values('"+user.getUsername()+"','"+user.getPassword()+"')";

	    	//在数据库中添加新用户
	    	int rows = stmt.executeUpdate(sql);
	    	if(rows==0){
	    		return ERROR;
	    	}
	    	else
	    		return SUCCESS;
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    		return ERROR;
    	}
        
    }



	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}



 }