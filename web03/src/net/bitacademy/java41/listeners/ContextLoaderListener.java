package net.bitacademy.java41.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.util.DBConnectionPool;

/* ServletContextListener 
 * - 서블릿 컨테이너가 웹 애플리케이션을 시작하거나 종료할 때 알리기 위한 규칙이다.
 */
public class ContextLoaderListener implements ServletContextListener {

	// 웹 애플리케이션이 시작될 때 호출됨.
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext ctx = event.getServletContext();
		
		// 웹 애플리케이션이 시작될 때 서블릿들이 사용할 객체를 준비한다.
		DBConnectionPool dbpool = new DBConnectionPool(
				ctx.getInitParameter("dburl"), 
				ctx.getInitParameter("user"), 
				ctx.getInitParameter("password"),
				ctx.getInitParameter("driverClass"));
		MemberDao memberDao = new MemberDao(dbpool);
		ProjectDao projectDao = new ProjectDao(dbpool);
		
		// 서블릿들이 사용할 객체를 어디에 보관할까? ServletContext
		// - 웹 애플리케이션이 실행되는 동안 계속 유지할 수 있기 때문에.
		ctx.setAttribute("memberDao", memberDao);
		ctx.setAttribute("projectDao", projectDao);
		
	}
	
	// 웹 애플리케이션이 종료될 때 호출됨.
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}
