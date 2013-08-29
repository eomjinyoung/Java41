package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.vo.Project;

@WebServlet("/project/add")
@SuppressWarnings("serial")
public class ProjectAddServlet extends GenericServlet {
	private ProjectDao projectDao;
	
	public ProjectAddServlet() {
		this.projectDao = ProjectDao.getInstance();
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		
		try {
			Project project = new Project();
			project.setManagerEmail(request.getParameter("managerEmail"));
			project.setTitle(request.getParameter("title"));
			project.setContent(
					request.getParameter("content").replace("\\n", "\n"));
			
			project.setStartDate(Date.valueOf(request.getParameter("startDate")));
			project.setEndDate(Date.valueOf(request.getParameter("endDate")));
			
			projectDao.add(project);
			
			PrintWriter out = response.getWriter();
			out.println("등록되었습니다!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
