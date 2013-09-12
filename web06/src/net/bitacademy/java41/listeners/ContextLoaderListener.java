package net.bitacademy.java41.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.bitacademy.java41.controls.LoginControl;
import net.bitacademy.java41.controls.LoginFormControl;
import net.bitacademy.java41.controls.LogoutControl;
import net.bitacademy.java41.controls.MainControl;
import net.bitacademy.java41.controls.SidebarControl;
import net.bitacademy.java41.controls.SigninControl;
import net.bitacademy.java41.controls.SigninFormControl;
import net.bitacademy.java41.controls.member.MemberAddControl;
import net.bitacademy.java41.controls.member.MemberListControl;
import net.bitacademy.java41.controls.member.MemberViewControl;
import net.bitacademy.java41.controls.member.PasswordChangeControl;
import net.bitacademy.java41.controls.project.ProjectAddControl;
import net.bitacademy.java41.controls.project.ProjectAddFormControl;
import net.bitacademy.java41.controls.project.ProjectListControl;
import net.bitacademy.java41.controls.project.ProjectViewControl;
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
		ctx.setAttribute("memberDao", memberDao);
		ctx.setAttribute("projectDao", projectDao);
		ctx.setAttribute("/sidebar.do", new SidebarControl()
											.setProjectDao(projectDao));
		ctx.setAttribute("/auth/loginForm.do", new LoginFormControl());
		ctx.setAttribute("/auth/login.do", new LoginControl()
											.setMemberDao(memberDao));
		ctx.setAttribute("/auth/logout.do", new LogoutControl());
		ctx.setAttribute("/main.do", new MainControl()
										.setProjectDao(projectDao));
		ctx.setAttribute("/member/signinForm.do", new SigninFormControl());
		ctx.setAttribute("/member/signin.do", new SigninControl()
												.setMemberDao(memberDao) );
		ctx.setAttribute("/project/list.do", new ProjectListControl()
												.setProjectDao(projectDao));
		ctx.setAttribute("/project/view.do", new ProjectViewControl()
												.setProjectDao(projectDao));
		ctx.setAttribute("/project/addForm.do", new ProjectAddFormControl());
		ctx.setAttribute("/project/add.do", new ProjectAddControl()
												.setProjectDao(projectDao));
		ctx.setAttribute("/member/list.do", new MemberListControl()
												.setMemberDao(memberDao));
		ctx.setAttribute("/member/view.do", new MemberViewControl()
												.setMemberDao(memberDao));
		ctx.setAttribute("/member/passwordChange.do", new PasswordChangeControl()
												.setMemberDao(memberDao));	
		ctx.setAttribute("/member/add.do", new MemberAddControl()
											.setMemberDao(memberDao));
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}






