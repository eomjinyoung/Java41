package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

@WebServlet("/member/signin")
@SuppressWarnings("serial")
public class SigninServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = 
				request.getRequestDispatcher("/member/signinForm.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		MemberDao memberDao = 
				(MemberDao) this.getServletContext().getAttribute("memberDao");
		
		try {
			Member member = new Member()
							.setEmail(request.getParameter("email"))
							.setName(request.getParameter("name"))
							.setPassword(request.getParameter("password"))
							.setTel(request.getParameter("tel"))
							.setBlog(request.getParameter("blog"))
							.setDetailAddress(request.getParameter("detailAddr"))
							.setTag(request.getParameter("tag"));
			
			memberDao.add(member);
			
			request.getSession().setAttribute("member", member);
			
			
												
			
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = 
					request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}











