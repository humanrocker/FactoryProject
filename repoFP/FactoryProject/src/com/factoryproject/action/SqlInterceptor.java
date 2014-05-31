package com.factoryproject.action;

import java.sql.*;

import com.factoryproject.util.SqlOperator;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;;

public class SqlInterceptor implements Interceptor{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6827618106252269184L;
	private Connection conn = null;
	
	public void init(){
		conn = SqlOperator.getConnection();
		if(conn.equals(null)){
			System.err.print("Interceptor initing database connection failed.");
			System.exit(-1);
		}
	}

	@Override
	public void destroy() {
		try {
			if(!conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		arg0.getStack().getContext().put("conn", conn);
		String r = arg0.invoke();
		arg0.getStack().getContext().remove("conn");
		destroy();
		return r;
	}
	

}
