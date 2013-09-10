package net.bitacademy.java41.servlets.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

@WebServlet("/member/add")
@SuppressWarnings("serial")
public class MemberAddServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = 
				request.getRequestDispatcher("/member/newForm.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDao memberDao = 
				(MemberDao) this.getServletContext().getAttribute("memberDao");
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			Member member = new Member()
				.setEmail(request.getParameter("email"))
				.setName(request.getParameter("name"))
				.setPassword(request.getParameter("password"))
				.setTel(request.getParameter("tel"))
				.setBlog(request.getParameter("blog"))
				.setDetailAddress(request.getParameter("detailAddr"))
				.setTag(request.getParameter("tag"))
				.setLevel(Integer.parseInt(request.getParameter("level")));
			
			memberDao.add(member);
			response.sendRedirect("list");
			
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = 
					request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}











