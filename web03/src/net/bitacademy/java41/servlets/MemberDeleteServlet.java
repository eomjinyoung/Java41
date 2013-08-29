package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import net.bitacademy.java41.dao.MemberDao;

@WebServlet("/member/delete")
@SuppressWarnings("serial")
public class MemberDeleteServlet extends GenericServlet {
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		
		try {
			MemberDao memberDao = 
					(MemberDao) this.getServletContext().getAttribute("memberDao");
			int count = memberDao.remove(request.getParameter("email"));
			
			PrintWriter out = response.getWriter();
			if (count > 0) {
				out.println("삭제되었습니다!");
			} else {
				out.println("해당 이메일의 멤버를 찾을 수 없습니다!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
