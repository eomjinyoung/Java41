package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

/* 서버에 자동 요청하는 방법
 * 1) Refresh
 * 	- setHeader("Refresh", "1;url=URL");
 * 	- <html><head><meta http-equiv="Refresh" content="1;url=URL"></head>...
 * 
 * 2) Redirect
 *  - sendRedirect("URL");
 */
//@WebServlet("/auth/login")
@SuppressWarnings("serial")
public class LoginServlet03 extends GenericServlet {

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
			HttpSession session = ((HttpServletRequest)request).getSession();
			
			if (member != null) {
				//request.setAttribute("member", member);
				session.setAttribute("member", member);
				((HttpServletResponse)response).sendRedirect("../main");
				
			} else {
				session.invalidate();
				out.println("<html><head><title>로그인 결과!</title></head>");
				out.println("<body><p>해당 사용자를 찾을 수 없습니다.</p></body></html>");
				// setHeader() 메서드는 service() 호출이 끝나기 전까지 호출하면 된다.
				// 어차피 응답 헤더를 설정하는 명령어기 때문이다.
				((HttpServletResponse)response).setHeader(
						"Refresh", "1;url=LoginForm.html");
			}
	
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<html><head><title>시스템오류!</title></head>");
			out.println("<body><p>실행 오류입니다.</p></body></html>");
		}
	}

}







