package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Member;

@WebServlet("/member/list")
@SuppressWarnings("serial")
public class MemberListServlet extends GenericServlet {
	private MemberDao memberDao;
	
	public MemberListServlet() {
		memberDao = new MemberDao( DBConnectionPool.getInstance());
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		
		try {
			PrintWriter out = response.getWriter();
			List<Member> list = memberDao.list();

			for(Member m : list) {
				out.println(m.getName() + ","
					+ m.getPhone() + ","
					+ m.getEmail());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
