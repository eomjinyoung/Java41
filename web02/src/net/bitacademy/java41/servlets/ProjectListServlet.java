package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Project;

@WebServlet("/project/list")
@SuppressWarnings("serial")
public class ProjectListServlet extends GenericServlet {
	private ProjectDao projectDao;
	
	public ProjectListServlet() {
		this.projectDao = new ProjectDao(DBConnectionPool.getInstance());
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		
		try {
			List<Project> list = projectDao.list();

			PrintWriter out = response.getWriter();
			for(Project project : list) {
				out.print(project.getNo() + ",");
				out.print(project.getTitle() + ",");
				out.print(project.getStartDate() + ",");
				out.println(project.getEndDate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
