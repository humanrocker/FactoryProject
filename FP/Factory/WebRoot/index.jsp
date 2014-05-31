<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>


<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="html" uri="/struts-tags"%>
<html>
  <head>
  	<title><s:text name="index"/></title>
  	<script language="javascript" src="/js/check.js"></script>
  </head>
  
<body>
	<a href="message.jsp">留言板</a>
	<s:if test="null==#session.user||#session.user.isEmpty()">
		<a href="login.jsp">登录</a>
		<a href="register.jsp">注册</a>
	</s:if>
	<s:else>
		<a href="account.jsp">${sessionScope.user }</a>
	</s:else>
</body>
</html>