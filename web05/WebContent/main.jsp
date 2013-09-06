<%@page import="net.bitacademy.java41.vo.Member"%>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="net.bitacademy.java41.vo.Member" 
		scope="session"></jsp:useBean>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPMS by java41</title>
<style type="text/css">
body {
	font-size: small;
}

/*header정보를 출력하는 태그를 찾아아 다음 블럭의 스타일을 적용하라*/ 
#header {
	background-color: #00008b;
	color: #ffffff;
/* 	border: 2px solid gray; */
	height: 40px;
	margin-bottom: 5px;
}

#header a:LINK {
	color: white;
}

#logout {
/* 	border: 1px solid red; */
	margin-top: 15px;
	margin-right: 5px;
	float:right;
}

/*tail 정보를 출력하는 태그를 찾아서 다음 블럭의 스타일을 적용하라*/
#tail {
	background-color: #dcdcdc;
	border-top: 2px solid gray;
	height: 40px;
	clear: left;
	text-align: center;
}

#sidebar {
/* 	border: 2px solid red; */
	background: #fff8dc;
	float: left;
	width: 180px; 
	margin-bottom: 5px;
	padding: 0px 5px 0px 5px;
}

#content {
/* 	border: 2px solid blue; */
	margin-left: 200px;
}

#memberPhoto {
	width: 50px;
	float: left;
}

#memberInfo {
/* 	border: 2px solid blue; */
	padding: 10px;
	margin-left: 55px;
}

#name {
	font-size: 120%;
	font-weight: bold;
	line-height: 130%;
	padding: 0px;
	margin: 0px;
}

#tel {
	font-size: 80%;
	color: gray;
	line-height: 130%;
	padding: 0px;
	margin: 0px;
	
}

#email {
	line-height: 130%;
	padding: 0px;
	margin: 0px;
}

</style>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.jsp"></jsp:include>

<div id="content">
<h1>사용자정보2</h1>
이름:<%=member.getName()%><br>
이메일:<%=member.getEmail()%><br>
전화:<%=member.getTel()%><br>
</div>

<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>













