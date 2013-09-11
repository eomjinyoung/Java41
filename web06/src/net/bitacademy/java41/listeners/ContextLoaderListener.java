package net.bitacademy.java41.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.bitacademy.java41.controls.LoginControl;
import net.bitacademy.java41.controls.LoginFormControl;
import net.bitacademy.java41.controls.MainControl;
import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.util.DBConnectionPool;

public class ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext ctx = event.getServletContext();
		
		DBConnectionPool dbpool = new DBConnectionPool(
				ctx.getInitParameter("dburl"), 
				ctx.getInitParameter("user"), 
				ctx.getInitParameter("password"),
				ctx.getInitParameter("driverClass"));
		MemberDao memberDao = new MemberDao(dbpool);
		ProjectDao projectDao = new ProjectDao(dbpool);
		
		ctx.setAttribute("rootPath", ctx.getContextPath());
		ctx.setAttribute("/auth/loginForm.do", new LoginFormControl());
		ctx.setAttribute("/auth/login.do", new LoginControl()
											.setMemberDao(memberDao));
		ctx.setAttribute("/main.do", new MainControl()
										.setProjectDao(projectDao));
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}






