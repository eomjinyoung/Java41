package net.bitacademy.java41.servlets.project;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Project;

@WebServlet("/project/add")
@SuppressWarnings("serial")
public class ProjectAddServlet extends HttpServlet {
	@Override
	protected void doGet(
		HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = 
				request.getRequestDispatcher("/project/newForm.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(
		HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProjectDao projectDao = 
				(ProjectDao) this.getServletContext().getAttribute("projectDao");
		
		try {
			request.setCharacterEncoding("UTF-8");
			Member member = (Member)request.getSession().getAttribute("member");
			Project project = new Project()
							.setTitle(request.getParameter("title"))
							.setContent(request.getParameter("content"))
							.setStartDate(
								Date.valueOf(request.getParameter("startDate")))
							.setEndDate(
								Date.valueOf(request.getParameter("endDate")))
							.setTag(request.getParameter("tag"))
							.setLeader(member.getEmail());
			
			projectDao.add(project);
			
			response.sendRedirect("list");
			
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = 
					request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	
	}
}













