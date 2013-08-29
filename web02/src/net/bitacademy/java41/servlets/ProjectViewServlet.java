package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Project;

@WebServlet("/project/view")
@SuppressWarnings("serial")
public class ProjectViewServlet extends GenericServlet {
	private ProjectDao projectDao;
	
	public ProjectViewServlet() {
		this.projectDao = new ProjectDao(DBConnectionPool.getInstance());
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		
		try {
			Project project = projectDao.get(
					Integer.parseInt(request.getParameter("no")));
			
			PrintWriter out = response.getWriter();
			if (project != null) {
				out.println("번호:" + project.getNo());
				out.println("제목:" + project.getTitle());
				out.println("내용:");
				out.println(project.getContent());
				out.printf("시작일:%1$tY-%1$tm-%1$td \n", project.getStartDate());
				out.printf("종료일:%1$tY-%1$tm-%1$td \n", project.getEndDate());
				out.println("관리자:" + project.getManagerEmail());
			} else {
				out.println("해당 번호의 프로젝트가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
