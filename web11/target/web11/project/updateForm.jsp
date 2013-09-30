<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 변경</title>
<link rel="stylesheet" href="${rootPath}/css/base.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.do"></jsp:include>

<div id="content">
<h1>프로젝트 정보</h1>
<form action="update.do" method="post">
번호: <input type="text" name="no" value="${project.no}" readonly><br>
프로젝트명: <input type="text" name="title" value="${project.title}"><br>
내용:<br> 
<textarea name="content" rows="4" cols="50">${project.content}</textarea><br>
시작일: <input type="text" name="startDate" placeholder="예)2013-4-5" value="${project.startDate}"><br>
종료일: <input type="text" name="endDate" placeholder="예)2013-6-5" value="${project.endDate}"><br>
태그: <input type="text" name="tag" placeholder="예)태그1 태그2 태그3 (공백으로 구분)"  value="${project.tag}"><br>
<input type="submit" value="변경"><input type="reset" value="취소"><br>
</form>
<p><a href="list.do">[목록]</a></p>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









