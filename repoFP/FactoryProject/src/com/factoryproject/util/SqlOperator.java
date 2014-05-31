package com.factoryproject.util;

import java.sql.*;

public class SqlOperator {
	public static Connection getConnection(){
		Connection conn = null;
		try{
//			Class.forName(SqlParameter.getDriver());//注册数据库驱动
			Class.forName("com.mysql.jdbc.Driver");//加载mysql驱动
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "123456";
			conn = DriverManager.getConnection(url, user, password);
//			conn = DriverManager.getConnection(SqlParameter.getConnection(),SqlParameter.getUser(),SqlParameter.getPassword());
			System.out.println("数据库连接成功");
		}catch(Exception e){
			System.out.println("数据库连接失败..."+e.getMessage());
		}
		return conn;
		
	}

}
