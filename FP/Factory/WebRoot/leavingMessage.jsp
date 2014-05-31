<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>


<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="html" uri="/struts-tags"%>
<html>
  <head>
  	<title><s:text name="loginPage"/></title>
  	<script language="javascript" src="/js/check.js"></script>
  </head>
  <body>
    <s:form action="leavingMessage">
    	<s:textfield name="replyingMessageID" key="replyto"/>
    	<s:textarea name="content" key="content"/>
    	<s:submit key="leavingMessage"/>
    </s:form>
  </body>
</html>
