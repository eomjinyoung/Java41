package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import net.bitacademy.java41.dao.ProjectDao;

@WebServlet("/project/delete")
@SuppressWarnings("serial")
public class ProjectDeleteServlet extends GenericServlet {
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		
		try {
			ProjectDao projectDao = 
					(ProjectDao) this.getServletContext().getAttribute("projectDao");
			int count = projectDao.remove(
					Integer.parseInt(request.getParameter("no")));
			
			PrintWriter out = response.getWriter();
			if (count > 0) {
				out.println("삭제되었습니다!");
			} else {
				out.println("해당 번호의 프로젝트를 찾을 수 없습니다!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
