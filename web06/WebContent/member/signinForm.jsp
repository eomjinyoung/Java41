<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<form action="signin" method="post">
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
<input type="submit" value="회원가입">
<input type="reset" value="취소">
</form>
</body>
</html>







