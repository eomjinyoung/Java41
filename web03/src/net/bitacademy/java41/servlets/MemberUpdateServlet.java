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

@WebServlet("/member/update")
@SuppressWarnings("serial")
public class MemberUpdateServlet extends GenericServlet {
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		
		try {
			MemberDao memberDao = 
					(MemberDao) this.getServletContext().getAttribute("memberDao");
			Member member = memberDao.get(request.getParameter("email"));
			Member copy = member.clone();
			
			String value = request.getParameter("name");
			if (value != null) {
				copy.setName(value);
			}
			
			value = request.getParameter("phone");
			if (value != null) {
				copy.setPhone(value);
			}
			
			value = request.getParameter("blog");
			if (value != null) {
				copy.setBlog(value);
			}
			
			value = request.getParameter("age");
			if (value != null) {
				copy.setAge( Integer.parseInt(value) );
			}

			int count = memberDao.change(copy);
			
			PrintWriter out = response.getWriter();
			if (count > 0) {
				out.println("변경되었습니다!");
			} else {
				out.println("해당 이메일의 멤버를 찾을 수 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
