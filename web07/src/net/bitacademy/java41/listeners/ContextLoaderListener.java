package net.bitacademy.java41.listeners;

import java.io.FileReader;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.bitacademy.java41.controls.LoginControl;
import net.bitacademy.java41.controls.LoginFormControl;
import net.bitacademy.java41.controls.LogoutControl;
import net.bitacademy.java41.controls.MainControl;
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
import net.bitacademy.java41.services.AuthService;
import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.util.DBConnectionPool;

public class ContextLoaderListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext ctx = event.getServletContext();
		try {
			loadContextProperties(
					ctx.getRealPath("/WEB-INF/context.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadContextProperties(String filePath) throws Exception {
		Properties props = new Properties();
		props.load( new FileReader(filePath));
		
		Enumeration enums = props.keys();
		String key = null;
		String value = null;
		while(enums.hasMoreElements()) {
			key = (String)enums.nextElement();
			value = (String)props.get(key);
			System.out.println(key + "=" + value);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}






