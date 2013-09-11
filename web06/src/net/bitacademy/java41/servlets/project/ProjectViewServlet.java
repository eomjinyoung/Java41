package net.bitacademy.java41.servlets.project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java41.dao.ProjectDao;

@WebServlet("/project/view")
@SuppressWarnings("serial")
public class ProjectViewServlet extends HttpServlet {
	@Override
	protected void doGet(
		HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int no = Integer.parseInt(request.getParameter("no"));
			ProjectDao projectDao = 
				(ProjectDao)this.getServletContext().getAttribute("projectDao");
			
			request.setAttribute("project", projectDao.get(no));
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("/project/view.jsp");
			rd.forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = 
					request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}













