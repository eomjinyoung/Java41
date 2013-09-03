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

/* HTTP 요청 프로토콜에서 get과 post 구분하기
 * - getMethod()
 */
//@WebServlet("/auth/login")
@SuppressWarnings("serial")
public class LoginServlet04 extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 다음 명령문은 그냥 클라이언트에서 요청한 방식이 무엇인지 알아내는 법을 배우기 위한
		// 억지 예제이다.
		String method = ((HttpServletRequest)request).getMethod();
		if ("get".equals(method.toLowerCase())) {
			out.println("<html><body>GET 요청을 받을 수 없습니다.</body></html>");
			return;
		}
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		MemberDao memberDao = 
				(MemberDao) this.getServletContext().getAttribute("memberDao");
		try {
			Member member = memberDao.getMember(email, password);
			HttpSession session = ((HttpServletRequest)request).getSession();
			
			if (member != null) {
				session.setAttribute("member", member);
				((HttpServletResponse)response).sendRedirect("../main");
				
			} else {
				session.invalidate();
				out.println("<html><head><title>로그인 결과!</title></head>");
				out.println("<body><p>해당 사용자를 찾을 수 없습니다.</p></body></html>");
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







