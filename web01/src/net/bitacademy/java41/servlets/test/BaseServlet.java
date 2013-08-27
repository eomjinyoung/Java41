package net.bitacademy.java41.servlets.test;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/* 이 클래스는 하위 클래스에 Servlet 인터페이스에 선언된 메서드 중 4개를 상속해주는 용도 */
abstract public class BaseServlet implements Servlet{
	ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
	
	@Override
	public void destroy() {}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return this.toString();
	}

	
}









