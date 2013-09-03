package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

/* 서버에 자동 요청하는 방법
 * 1) Refresh
 * 	- setHeader("Refresh", "1;url=URL");
 * 	- <html><head><meta http-equiv="Refresh" content="1;url=URL"></head>...
 * 
 * 2) Redirect
 */
//@WebServlet("/auth/login")
@SuppressWarnings("serial")
public class LoginServlet02 extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		MemberDao memberDao = 
				(MemberDao) this.getServletContext().getAttribute("memberDao");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			Member member = memberDao.getMember(email, password);
			out.println("<html><head><title>로그인 결과!</title>");
					
			if (member != null) {
				out.println(
					"<meta http-equiv='Refresh' content='1;url=../main'>"
					+ "</head>");
				out.println("<body><p>로그인 성공입니다!</p>"
						+ "<p>이메일:" + member.getEmail() + "<br>" 
						+ "이름:" + member.getName() + "<br>"
						+ "전화:" + member.getTel() + "</p>"
						+ "</body></html>");
				
				//((HttpServletResponse)response).setHeader(
				//		"Refresh", "1;url=../main");

			} else {
				out.println(
					"<meta http-equiv='Refresh' content='1;url=LoginForm.html'>"
					+ "</head>");
				out.println("<body><p>해당 사용자를 찾을 수 없습니다.</p></body></html>");
				//((HttpServletResponse)response).setHeader(
				//		"Refresh", "1;url=LoginForm.html");	
				/* 응답결과 예시)
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Refresh: 1;url=LoginForm.html
Content-Type: text/html;charset=UTF-8
Content-Length: 124
Date: Tue, 03 Sep 2013 04:53:37 GMT

<html><head><title>로그인 결과!</title></head>
<body><p>해당 사용자를 찾을 수 없습니다.</p></body></html>
				 */				
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<html><head><title>시스템오류!</title></head>");
			out.println("<body><p>실행 오류입니다.</p></body></html>");
		}
	}

}







