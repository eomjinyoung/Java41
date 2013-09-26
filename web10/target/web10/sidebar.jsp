<%@page import="net.bitacademy.java41.vo.MemberProject"%>
<%@page import="net.bitacademy.java41.vo.Member"%>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<jsp:useBean id="member" 
	type="net.bitacademy.java41.vo.Member" scope="session"/>
<jsp:useBean id="projectService" 
	type="net.bitacademy.java41.services.ProjectService" scope="application"/>  
<%
pageContext.setAttribute("myprojects", 
		projectService.getMyProjects(member.getEmail()) );
%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<div id="sidebar">
<div id="member">
<c:choose>
	<c:when test="${member.photos != null}">
		<img id="memberPhoto" src="${rootPath}/file/${member.photos[0]}">
	</c:when>
	<c:otherwise>
		<img id="memberPhoto" src="${rootPath}/images/test01.png">
	</c:otherwise>
</c:choose>
<div id="memberInfo">
<p id="name"><a href="${rootPath}/member/updateMyInfo.do">${member.name }</a></p>
<p id="tel">${member.tel }</p>
<p id="email">${member.email }</p>
</div>
</div>

<c:choose>
<c:when test="${member.level == 0}">
<h3>프로젝트들3 <a href="${rootPath}/project/list.do">[전체]</a></h3>
<ul>
<c:forEach var="project" items="${myprojects}">
	<li><a href="${rootPath}/project/view.do?no=${project.no}"
	>${project.title}<c:if test="${project.level == 0}">(PL)</c:if></a></li>
</c:forEach>
</ul>
</c:when>
<c:when test="${member.level == 1}">
<h3>관리</h3>
<ul>
	<li><a href="${rootPath}/member/list.do">멤버관리</a></li>
	<li><a href="${rootPath}/project/list.do">프로젝트관리</a></li>
</ul>
</c:when>
</c:choose>
</div>






