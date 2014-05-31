<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>


<%@taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
</head>
<body>
	Factory - RSPAGE
	
		您的用户名是<br/>
		${sessionScope.user }<br/>
		<a href="login.jsp">登陆页面</a>
	
</body>
</html>