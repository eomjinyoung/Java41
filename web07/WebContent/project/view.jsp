<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 정보</title>
<link rel="stylesheet" href="${rootPath}/css/base.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.jsp"></jsp:include>

<div id="content">
<h1>프로젝트 정보</h1>
번호: ${project.no}<br>
프로젝트명: ${project.title }<br>
내용:<br> 
${project.content }<br>
시작일: ${project.startDate }<br>
종료일: ${project.endDate }<br>
태그: ${project.tag }<br>

<p>
<a href="list">[목록]</a>
<a href="update.do?no=${project.no}">[변경]</a>
<a href="delete.do?no=${project.no}">[삭제]</a>
</p>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









