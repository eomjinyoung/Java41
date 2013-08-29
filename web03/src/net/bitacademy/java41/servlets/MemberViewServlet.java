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

@WebServlet("/member/view")
@SuppressWarnings("serial")
public class MemberViewServlet extends GenericServlet {
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		
		try {
			MemberDao memberDao = 
					(MemberDao) this.getServletContext().getAttribute("memberDao");
			Member member = memberDao.get(request.getParameter("email"));
			
			PrintWriter out = response.getWriter();
			if (member != null) {
				out.println("이름:" + member.getName());
				out.println("전화:" + member.getPhone());
				out.println("이메일:" + member.getEmail());
				out.println("블로그:" + member.getBlog());
				out.println("나이:" + member.getAge());
				out.printf("등록일:%1$tY-%1$tm-%1$td \n", member.getRegDate());
			} else {
				out.println("해당 이메일의 멤버가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
