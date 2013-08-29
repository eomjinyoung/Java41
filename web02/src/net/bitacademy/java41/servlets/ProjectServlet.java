package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Project;

@WebServlet("/project")
@SuppressWarnings("serial")
public class ProjectServlet extends GenericServlet {
	private Project project;
	private ProjectDao projectDao;
	
	public ProjectServlet() {
		this.projectDao = new ProjectDao(DBConnectionPool.getInstance());
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		response.setContentType("text/plain;charset=UTF-8");
		
		try {
			if ("list".equals(command)) {
				list(request, response);
			} else if ("add".equals(command)) {
				add(request, response);
			} else if ("view".equals(command)) {
				view(request, response);
			} else if ("delete".equals(command)) {
				delete(request, response);
			} else if ("update".equals(command)) {
				update(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("해당 명령어를 지원하지 않습니다!");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void list(ServletRequest request, ServletResponse response) {
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

	private void add(ServletRequest request, ServletResponse response)
		throws Exception
	{
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
	}

	private void view(ServletRequest request, ServletResponse response)
		throws Exception
	{
		try {
			this.project = projectDao.get(
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
	
	private void update(ServletRequest request, ServletResponse response)
		throws Exception
	{
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
	}
	
	private void delete(ServletRequest request, ServletResponse response) 
		throws Exception 
	{
		int count = projectDao.remove(
				Integer.parseInt(request.getParameter("no")));
		
		PrintWriter out = response.getWriter();
		if (count > 0) {
			out.println("삭제되었습니다!");
		} else {
			out.println("해당 번호의 프로젝트를 찾을 수 없습니다!");
		}
	}

}
