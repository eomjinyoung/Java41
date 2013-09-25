package net.bitacademy.java41.listeners;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextLoaderListener implements ServletContextListener {
	ServletContext ctx;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ctx = event.getServletContext();
		
		ctx.setAttribute("rootPath", ctx.getContextPath());
		ctx.setAttribute("rootRealPath", ctx.getRealPath("/"));
		
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"net/bitacademy/java41/conf/application-context.xml");
			
			String[] beanNameList = ctx.getBeanDefinitionNames();
			for(String beanName : beanNameList) {
				System.out.println(beanName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}






