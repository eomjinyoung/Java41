<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String email = (String)request.getAttribute("email");
boolean isSaveId = (Boolean)request.getAttribute("isSaveId");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h1>사용자 로그인</h1> 
<form action='login' method="post"> 
Email: <input type="text" name="email"
	<%= (!email.equals("")) ? ("value='" + email + "'") : "" %>
	placeholder="hong@test.com"><br>
Password: <input type="password" name="password" placeholder="password"><br>
<input type="checkbox" name="saveId"
	<%= isSaveId ? "checked" : ""%>
>ID저장<br>
<input type="submit" value="Login">
<a href="../member/signin">회원가입</a>
</form>
</body>
</html>







