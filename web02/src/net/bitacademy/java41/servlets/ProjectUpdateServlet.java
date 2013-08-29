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
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Project;

@WebServlet("/project/update")
@SuppressWarnings("serial")
public class ProjectUpdateServlet extends GenericServlet {
	private ProjectDao projectDao;
	
	public ProjectUpdateServlet() {
		this.projectDao = new ProjectDao(DBConnectionPool.getInstance());
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		
		try {
			Project project = projectDao.get(
					Integer.parseInt(request.getParameter("no")));
			Project copy = project.clone();
			String value = request.getParameter("managerEmail");
			if (value != null) {
				copy.setManagerEmail(value);
			}
			
			value = request.getParameter("title");
			if (value != null) {
				copy.setTitle(value);
			}
			
			value = request.getParameter("content");
			if (value != null) {
				copy.setContent(value.replace("\\n", "\n"));
			}
			
			value = request.getParameter("startDate");
			if (value != null) {
				copy.setStartDate(Date.valueOf(value));
			} 
			
			value = request.getParameter("endDate");
			if (value != null) {
				copy.setEndDate(Date.valueOf(value));
			} 
			
			int count = projectDao.change(copy);
			
			PrintWriter out = response.getWriter();
			if (count > 0) {
				out.println("변경되었습니다!");
			} else {
				out.println("해당 번호의 프로젝트를 찾을 수 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
