<%@page import="net.bitacademy.java41.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버 목록</title>
<link rel="stylesheet" href="${rootPath}/css/base.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.jsp"></jsp:include>

<div id="content">
<h1>멤버</h1>
<table>
<tr>
	<th>이메일</th>
	<th>이름</th>
	<th>전화</th>
	<th>블로그</th>
</tr>
<c:forEach var="member" items="${list}">
<tr>
	<td>${member.email}</td>
	<td><a href="view?email=${member.email}">${member.name}</a></td>
	<td>${member.tel}</td>
	<td>${member.blog}</td>
</tr>	
</c:forEach>
</table>

<p><a href="${rootPath}/member/add">[새멤버]</a></p>

</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









