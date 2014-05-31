

package com.factoryproject.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public  class LogoutAction extends ActionSupport {


	/**
	 * 
	 */
	private static final long serialVersionUID = -554846702770615875L;

	public String execute() throws Exception{
        
    	
        ActionContext ctx = ActionContext.getContext();
        ctx.getSession().clear();
//        ctx.getSession().remove("user");
        //验证是否退出成功
        try{
        	ctx.getSession().clear();
        	if(ctx.getSession().isEmpty()){
            	System.out.println("Logout success.");
            	//返回登陆
                return "input";
            }
            else{
//            	ctx.getSession().containsKey("user");
            	System.out.println("Logout failed.");
            	return "error";
            }
        }catch(Exception e){
        	System.out.println("Logout exception.");
        	return "error";
        }
     
        
    }	


 }