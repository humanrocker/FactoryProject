<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Welcome</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
            欢迎，${sessionScope.id } <br>
     ${requestScope.tip } <br>
    <h1>你有多海？</h1>
        <!--  
    <form name="f1" id="f1" action="basicstruts2/askSillyExpert.action" method="post">
        <select name="sillyLevel" size="1">
            <option>很笨
            <option>非常笨
            <option>超笨
            <option>笨死了
        </select>
        <br><br>
        <center>
            <input type="SUBMIT">
        </center>
    </form>
            -->
    <s:form action="askSillyExpert">
    <!--  
		<s:iterator value="sillyOptions" status="options">
			<s:if test="options.odd == true">
                
			</s:if>
			<s:else>
			</s:else>
		</s:iterator>
		-->
		<s:select name="sillyLevel" value="选择海的程度" labelposition="top"
			multiple="true"
			list="{
		'很high',
		'非常high',
        '你们high不high啊？',
        '嗨！！！！！！！！！！！！！！！！！！！！！！！'
		}" />
		<s:submit value="提交" />
	</s:form>
    
    访问次数为 ${applicationScope.counter } <br>
  </body>
</html>
