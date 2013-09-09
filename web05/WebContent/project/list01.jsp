<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<jsp:useBean id="list" scope="request" type="java.util.List<Project>"></jsp:useBean>
<table>
<tr>
	<th>번호</th>
	<th>프로젝트</th>
	<th>시작</th>
	<th>종료</th>
</tr>
<%for(Project project : list) {%>
<tr>
	<td><%=project.getNo()%></td>
	<td><%=project.getTitle()%></td>
	<td><%=project.getStartDate()%></td>
	<td><%=project.getEndDate()%></td>
</tr>	
<%}%>
</table>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









