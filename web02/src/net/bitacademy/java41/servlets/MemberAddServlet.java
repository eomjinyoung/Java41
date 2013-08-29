package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Member;

@WebServlet("/member/add")
@SuppressWarnings("serial")
public class MemberAddServlet extends GenericServlet {
	private MemberDao memberDao;
	
	public MemberAddServlet() {
		memberDao = new MemberDao( DBConnectionPool.getInstance());
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		
		try {
			Member m = new Member()
				.setName(request.getParameter("name"))
				.setPhone(request.getParameter("phone"))
				.setEmail(request.getParameter("email"))
				.setBlog(request.getParameter("blog"))
				.setAge( Integer.parseInt( request.getParameter("age") ) );

			memberDao.add(m);
			PrintWriter out = response.getWriter();
			out.println("등록되었습니다!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
