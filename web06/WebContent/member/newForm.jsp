<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버 등록</title>
<link rel="stylesheet" href="${rootPath}/css/base.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.jsp"></jsp:include>

<div id="content">
<h1>멤버 등록</h1>
<form action="add.do" method="post">
*이메일: <input type="text" name="email"><br>
*암호: <input type="password" name="password"><br>
암호 확인: <input type="password" name="password2"><br>
*이름: <input type="text" name="name"><br>
*전화: <input type="text" name="tel"><br>
블로그: <input type="text" name="blog"><br>
우편번호: <input type="text" name="postno">
		<input type="button" value="우편번호찾기"><br>
기본주소: <input type="text" name="basicAddr"><br>
상세주소: <input type="text" name="detailAddr"><br>
태그: <input type="text" name="tag"><br>
권한: <select name="level">
<option value="0" selected>일반회원</option>
<option value="1">관리자</option>
<option value="2">PM</option>
<option value="9">손님</option>
</select><br>

<input type="submit" value="등록">
<input type="reset" value="취소">
</form>
<p><a href="list.do">[목록]</a></p>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









