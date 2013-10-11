<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버 변경</title>
<link rel="stylesheet" href="${rootPath}/css/base.css">
</head>
<body>
<jsp:include page="/header.do"></jsp:include>

<jsp:include page="/sidebar.do"></jsp:include>

<div id="content">
<h1>멤버 변경</h1>
<form action="update.do" method="post" enctype="multipart/form-data">
*이메일: <input type="text" name="email" value="${memberInfo.email}" readonly><br>
*암호: <input type="password" name="password"><br>
암호 확인: <input type="password" name="password2"><br>
*이름: <input type="text" name="name" value="${memberInfo.name}"><br>
*전화: <input type="text" name="tel" value="${memberInfo.tel}"><br>
<c:choose>
	<c:when test="${memberInfo.photos != null}">
		<img src="${rootPath}/file/${memberInfo.photos[0]}"><br>
	</c:when>
	<c:otherwise>
		<img src="${rootPath}/images/test01.png"><br>
	</c:otherwise>
</c:choose>
사진: <input type="file" name="photo"><br>
블로그: <input type="text" name="blog" value="${memberInfo.blog}"><br>
우편번호: <input type="text" name="postno">
		<input type="button" value="우편번호찾기"><br>
기본주소: <input type="text" name="basicAddress"><br>
상세주소: <input type="text" name="detailAddress" value="${memberInfo.detailAddress}"><br>
태그: <input type="text" name="tag" value="${memberInfo.tag}"><br>
권한: <select name="level">
<option value="0" <c:if test="${memberInfo.level == 0}">selected</c:if>>일반회원</option>
<option value="1" <c:if test="${memberInfo.level == 1}">selected</c:if>>관리자</option>
<option value="2" <c:if test="${memberInfo.level == 2}">selected</c:if>>PM</option>
<option value="9" <c:if test="${memberInfo.level == 9}">selected</c:if>>손님</option>
</select><br>

<input type="submit" value="변경">
<input type="reset" value="취소">
</form>
<p><a href="list.do">[목록]</a></p>
</div>

<jsp:include page="/tail.do"></jsp:include>

</body>
</html>









