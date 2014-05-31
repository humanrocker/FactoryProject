

package com.factoryproject.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.struts2.ServletActionContext;
import com.factoryproject.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;




public  class LoginAction extends ActionSupport implements ModelDriven<User>{

	/**
	 * this action is for an account to login
	 */
	private static final long serialVersionUID = -7325326470596711055L;

	private User user = new User();
	
	//登录之前的页面
	private String prePage = null;
	
    public String getPrePage() {
		return prePage;
	}


	public String execute() throws Exception{
        
    	ActionContext ctx = ActionContext.getContext();
    	//获取登录前页面
    	prePage = (String) ctx.getSession().get("prePage");
    	
    	//取到输入的用户名(user)和密码(pwd)
    	user.setUsername(ServletActionContext.getRequest().getParameter("username"));
    	user.setPassword(ServletActionContext.getRequest().getParameter("password"));
    	    	Connection conn = null;
		try{
			
			//从拦截器中取到参数
			ValueStack stack = ActionContext.getContext().getValueStack();
			conn = (Connection) stack.getContext().get("conn");
//			if(conn != null){
//				System.out.println("conn:Connection 非空！Action已经接收到来自Interceptor的参数！");
//			}else{
//				System.out.println("conn:Connection 空！Action未接收到来自Intercptor的参数！");
//			}
			
			//用户名不能为空
	    	if(user.getUsername().equals(null))return "input";
	    	//数据库连接
	    	Statement stmt = conn.createStatement();
	    	ResultSet rs = null;
	    	String sql="select * from user where username ='"+user.getUsername()+"'";

	    	//查询输入用户名对应的正确密码
	    	rs = stmt.executeQuery(sql);
	    	String correctPassword = null;
	    	
	    	//取到正确密码
	    	while(rs.next()){
	    		correctPassword = rs.getString(2);
	    	}
	    	//检查密码是否正确
	    	if(user.getPassword().equals(correctPassword)){
	    		//保存登录信息到session
	    		ctx.getSession().put("user", user);
	    		System.out.println("登录成功");
	    		
	    		//读取session，测试是否写入session成功
//	    		System.out.println("ctx.getSession().get(\"user\")="+ctx.getSession().get("user").toString());
	    		
	    		//访问登录页面方式
	    		if(prePage==null){
	    			return "home";
	    		}
	    		else return "success";
	    	}
	    	else{
	    		//密码不正确
	    		System.out.println("登录失败");
//	    		inputstream = new ByteArrayInputStream("登录失败！".getBytes("utf-8"));
	    		return "input";
	    	}
			
			
		}catch(Exception e){
			System.out.println("数据库连接失败..."+e.getMessage());
			return "error";
		}
		
    }


	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
 }