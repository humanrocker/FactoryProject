<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>


<%@taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
</head>
<body>
	Factory - HOMEPAGE
	<s:if test="#session.user!=null">
		已登录<br/>
		<a href="account.jsp">${sessionScope.user }</a>
		<s:form action="logout">
			<s:submit key="logout"/>
		</s:form>
	</s:if>
	<s:else>
		未登录
	</s:else>
	
</body>
</html>