<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.text.*"%>
<%@ page import="java.net.*,java.util.*" %>
<%--
[JSP 구성 요소]
* 템플릿 데이터(Template data)
- 출력문으로 만들기 위해 그냥 작성하는 텍스트
- out.write()와 같은 출력문으로 변환됨.

* 스크립트릿(scriptlet)
- 자바 코드를 작성하는 태그 
- 예) <% 자바코드 %>
- 그대로 자바소스파일에 복사된다.

* 표현식(expression element)
- 변수나 어떤 식의 결과 값을 출력할 때
- 예) <%= 자바 변수나 식 %>
- out.print(자바 변수나 식) 으로 변환된다.

* 지시문(directive element)
- 특정 자바 코드로 변환된다.
- 예) <%@ page import="java.util.*,java.net.*"%>
    => 자바소스 파일에서 import 문으로 변환된다.
- 예) <%@ page contentType="text/html;charset=UTF-8"%>
    => response.setContentType("text/html;charset=UTF-8"); 문으로 변환됨.
 
* 선언문(declaration element)
- 클래스 블럭에 복사됨.
- 인스턴스 및 클래스 변수/메서드/스태틱블럭
- 예) <%! 인스턴스변수, 클래스변수, 메서드, 스태틱블럭, 초기화블럭 %>    
- 어차피 클래스 블럭에 복사되기 때문에 작성하는 위치에 상관없다.

 --%>
<!-- 이것도 출력된다. -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
int i = 20;
int j = 30;
String s = "okok";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test01</title>
</head>
<%
s = "nono";
j = i * j;

%>
<body>
<h1>오호라<% if(i == 20) {out.println("^^");}%>...test01</h1>
<p>okok</p>
<%
if (j > 50) {
	out.println("오우..노우.....");
} else {
	out.println("푸하하하하....");
}
%><br>
m()호출했다면 = <%=m()%><br>
i = <%=i%><br>
j = <%=j%><br>
s = <%=s.toLowerCase()%><br>

</body>

<%!
public String m() {
	return "okok";
}

static final double PI = 3.14;
%>

</html>









