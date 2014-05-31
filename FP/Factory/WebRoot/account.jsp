<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>


<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="html" uri="/struts-tags"%>
<html>
  <head>
  	<title><s:text name="loginPage"/></title>
  	<script language="javascript" src="/js/check.js"></script>
  </head>
  
  <body>
    Account Management. <br>
    <a href="home.jsp">返回首页</a>
    <s:form action="displayMessage">
    	<s:submit value="留言板"></s:submit>
    </s:form>
    
  </body>
</html>
