package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.MemberProject;

@WebServlet("/main")
@SuppressWarnings("serial")
public class MainServlet extends HttpServlet {

	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ProjectDao projectDao = 
				(ProjectDao)this.getServletContext().getAttribute("projectDao");
			
			Member member = (Member)request.getSession().getAttribute("member");
			
			List<MemberProject> list = 
					projectDao.listByMember(member.getEmail());
			
			request.getSession().setAttribute("myprojects", list);
		
			RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = 
					request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}

}












