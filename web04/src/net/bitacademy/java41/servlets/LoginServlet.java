package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

@WebServlet("/auth/login")
@SuppressWarnings("serial")
public class LoginServlet extends GenericServlet {

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
			out.println("<html><head><title>로그인 결과!</title></head>");
			if (member != null) {
				out.println("<body><p>로그인 성공입니다!</p>"
						+ "<p>이메일:" + member.getEmail() + "<br>" 
						+ "이름:" + member.getName() + "<br>"
						+ "전화:" + member.getTel() + "</p>"
						+ "</body></html>");
			} else {
				out.println("<body><p>해당 사용자를 찾을 수 없습니다.</p></body></html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<html><head><title>시스템오류!</title></head>");
			out.println("<body><p>실행 오류입니다.</p></body></html>");
		}
	}

}







