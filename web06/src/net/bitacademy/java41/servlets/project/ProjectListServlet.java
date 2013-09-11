package net.bitacademy.java41.servlets.project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java41.dao.ProjectDao;

@WebServlet("/project/list")
@SuppressWarnings("serial")
public class ProjectListServlet extends HttpServlet {
	@Override
	protected void doGet(
		HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ProjectDao projectDao = 
				(ProjectDao)this.getServletContext().getAttribute("projectDao");
			
			request.setAttribute("list", projectDao.list());
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("/project/list.jsp");
			rd.forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = 
					request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}













