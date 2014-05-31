<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>


<%@taglib prefix="s" uri="/struts-tags"%>

<html>
  <head>
  	<title><s:text name="message"/></title>
  	<script language="javascript" src="/js/check.js"></script>
  </head>
  <a href="/home.jsp">首页</a>
  <s:if test="null==#session.user">
  	<s:a href="/account.jsp">我的账户</s:a>
  </s:if>
  <br/>
  <body>
  	留言板<br/>
  	<s:if test="#session.messageList!=null">
  		Messaage is not lost.
  	</s:if>
  	<%
  	String [] str = session.getValueNames();
  	for(String s:str)System.out.println(s);
  	 %>
  	<s:iterator value="#session.messageList" id="message">
  		<tr>
  			<td><s:property value="message.ID"></s:property></td>
  			<td><s:property value="message.content"></s:property></td>
  			<td><s:property value="message.speaker.username"></s:property></td>
  			<td><s:property value="message.dateAdded"></s:property></td>
  		</tr>
  	</s:iterator>
  	<br/>
  	
  	
  	<!-- 未登录将不显示留言框 -->
  	<s:if test="null==#session.user||#session.user.isEmpty()">
	    <a href="index.jsp">登录</a><font>之后才能评论哦!</font><br/>
	    <font>还没注册？赶紧</font><a href="register.jsp">注册</a><font>吧!</font>
    </s:if>
    <s:else>
    	<s:form action="leavingMessage">
	    	<s:textarea name="content" key="content"/>
	    	<s:submit key="leavingMessage"/>
	    </s:form>
    </s:else>
  </body>
</html>
