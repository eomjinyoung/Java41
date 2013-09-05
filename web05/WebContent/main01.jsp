<%@page import="net.bitacademy.java41.vo.Member"%>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Member member = (Member)session.getAttribute("member");
%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPMS by java41</title>
</head>
<body>
<h1>사용자정보</h1>
이름:<%=member.getName()%><br>
이메일:<%=member.getEmail()%><br>
전화:<%=member.getTel()%><br>
</body>
</html>













