<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h1>사용자 로그인2</h1> 
<form action='login.do' method="post"> 
Email: <input type="text" name="email"
	<c:if test="${email != ''}">value='${email}'</c:if>
	placeholder="hong@test.com"><br>
Password: <input type="password" name="password" placeholder="password"><br>
<input type="checkbox" name="saveId"
	<c:if test="${isSaveId}">checked</c:if>
>ID저장<br>
<input type="submit" value="Login">
<a href="../member/signinForm.do">회원가입</a>
</form>
</body>
</html>







