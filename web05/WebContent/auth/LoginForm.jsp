<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSP Action Tag : JSP 전용 프로그래밍 태그 
. 특정 자바 코드를 생성함.
. 예)
[JSP Action 태그]
<jsp:useBean id="aaa" class="java.lang.String" scope="request"></jsp:useBean>

[예상 자바 코드]
java.lang.String aaa = (java.lang.String)request.getAttribute("aaa");
if (aaa == null) {
	aaa = new java.lang.String();
	request.setAttribute("aaa", aaa);
}

. 예2)
[JSP 액션 태그]
<jsp:useBean id="aaa" class="java.lang.Boolean" scope="request"></jsp:useBean>

[예상 자바 코드]
java.lang.Boolean aaa = (java.lang.Boolean)request.getAttribute("aaa");
if (aaa == null) {
	aaa = new java.lang.Boolean();
	request.setAttribute("aaa", aaa);
}

. 예3)
[JSP 액션 태그]
<jsp:useBean id="aaa" type="java.lang.Boolean" scope="request"></jsp:useBean>

[예상 자바 코드]
java.lang.Boolean aaa = (java.lang.Boolean)request.getAttribute("aaa");

. 예4)
[JSP 액션 태그]
<jsp:useBean id="aaa" type="java.lang.String" scope="request"></jsp:useBean>

[예상 자바 코드]
java.lang.String aaa = (java.lang.String)request.getAttribute("aaa");
--%>
<jsp:useBean id="email" type="java.lang.String" scope="request"></jsp:useBean>
<jsp:useBean id="isSaveId" type="java.lang.Boolean" scope="request" ></jsp:useBean> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h1>사용자 로그인2</h1> 
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







