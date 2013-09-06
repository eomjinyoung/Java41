<%@page import="net.bitacademy.java41.vo.Member"%>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" 
	scope="session" 
	type="net.bitacademy.java41.vo.Member"/>    
<div id="sidebar">
<div id="member">
<img id="memberPhoto" src="<%=application.getContextPath()%>/images/test01.png">
<div id="memberInfo">
<p id="name"><%=member.getName()%></p>
<p id="tel"><%=member.getTel()%></p>
<p id="email"><%=member.getEmail()%></p>
</div>
</div>

<h3>프로젝트들 <a href="<%=application.getContextPath()%>/project/list">[전체]</a></h3>
<ul>
	<li>프로젝트1</li>
	<li>프로젝트2</li>
	<li>프로젝트3</li>
</ul>

</div>






