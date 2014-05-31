package com.factoryproject.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9214640148739782031L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		ActionContext ctx = ActionContext.getContext();
		Map<String,Object> session = ctx.getSession();
		Object user = session.get("user");
		//用户未登录
		if(user==null){
			HttpServletRequest req = ServletActionContext.getRequest();
			String path = req.getRequestURI().substring(0);
			String queryString = req.getQueryString();
			//预防空指针
			if(queryString==null){
				queryString = "";
			}
			String realPath = path + "?" +queryString;
			//原页面链接存入session
			session.put("prePage",realPath);
//			return "login";
		}
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		
//		ActionContext ctx = ActionContext.getContext();
//		Map<String,Object> session = ctx.getSession();
//		Object user = session.get("user");
//		//用户未登录
//		if(user==null){
//			HttpServletRequest req = ServletActionContext.getRequest();
//			String path = req.getRequestURI().substring(10);
//			String queryString = req.getQueryString();
//			//预防空指针
//			if(queryString==null){
//				queryString = "";
//			}
//			String realPath = path + "?" +queryString;
//			//原页面链接存入session
//			session.put("prePage",realPath);
////			return "login";
//		}
		//用户已经登录
		return arg0.invoke();
	}

}
