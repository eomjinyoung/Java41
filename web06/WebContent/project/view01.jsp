<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 정보</title>
<link rel="stylesheet" href="<%=application.getContextPath()%>/css/base.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.jsp"></jsp:include>

<div id="content">
<h1>프로젝트 정보</h1>
<jsp:useBean id="project" 
		scope="request" 
		type="net.bitacademy.java41.vo.Project"></jsp:useBean>
번호: <%=project.getNo() %><br>
프로젝트명: <%=project.getTitle() %><br>
내용:<br> 
<%=project.getContent() %><br>
시작일: <%=project.getStartDate() %><br>
종료일: <%=project.getEndDate() %><br>
태그: <%=project.getTag() %><br>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









