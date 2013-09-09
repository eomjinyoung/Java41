<%@page import="net.bitacademy.java41.vo.MemberProject"%>
<%@page import="net.bitacademy.java41.vo.Member"%>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<div id="sidebar">
<div id="member">
<img id="memberPhoto" src="${rootPath}/images/test01.png">
<div id="memberInfo">
<p id="name">${member.name }</p>
<p id="tel">${member.tel }</p>
<p id="email">${member.email }</p>
</div>
</div>
<jsp:useBean id="myprojects" 
	scope="session" 
	type="java.util.List<net.bitacademy.java41.vo.MemberProject>"></jsp:useBean>
<h3>프로젝트들3 <a href="${rootPath}/project/list">[전체]</a></h3>
<ul>
<c:forEach var="project" items="${myprojects}">
	<li><a href="${rootPath}/project/view?no=${project.no}"
	>${project.title}<c:if test="${project.level == 0}">(PL)</c:if></a></li>
</c:forEach>
</ul>

</div>






