<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 목록</title>
<link rel="stylesheet" href="<%=application.getContextPath()%>/css/base.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.jsp"></jsp:include>

<div id="content">
<h1>프로젝트</h1>
<table>
<tr>
	<th>번호</th>
	<th>프로젝트</th>
	<th>시작</th>
	<th>종료</th>
</tr>
<%-- Expression Language
. ServletContext, HttpSession, ServletRequest 등으로부터 데이터를 좀 더 쉽게 꺼내고,
. VO 객체의 getXXX() 메서드 호출을 좀 더 쉽게 하기 위해 등장한 문법.
. ${applicationScope.xxxx}  <== ServletContext
. ${sessionScope.xxxx}  <== HttpSession
. ${requestScope.xxxx}  <== ServletRequest
. ${pageScope.xxxx}  <== PageContext
. ${xxxx}  <== PageContext > ServletRequest > HttpSession > ServletContext 
 --%>
<c:forEach var="project" items="${list}">
<tr>
	<td>${project.no}</td>
	<td>${project.title}</td>
	<td>${project.startDate}</td>
	<td>${project.endDate}</td>
</tr>	
</c:forEach>
</table>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









