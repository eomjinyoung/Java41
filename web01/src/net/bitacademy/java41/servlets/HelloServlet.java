package net.bitacademy.java41.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/* 서블릿 만들기
 * - javax.servlet.Servlet 인터페이스 구현
 * - 이 인터페이스에 선언된 메서드를 서블릿 컨테이너(의 스레드)가 호출한다.
 * 
 * 서블릿의 인스턴스 생성 시점
 * - 클라이언트가 요청할 때
 * - 서버가 시작될 때 만들어지는 것이 아님!!!
 * - 한번 만들면 다시 만들지 않음.
 * 
 * 서블릿 등록
 * - 서블릿이 실행되려면 web.xml에 등록되어야 한다.
 * - 1) 서블릿 선언: <servlet></servlet>
 * - 2) 서블릿에 URL 부여: <servlet-mapping></servlet-mapping>
 */
public class HelloServlet implements Servlet {

	/* - 서블릿 인스턴스 생성 시 호출됨.
	 * - 서블릿이 사용되기 전에 준비함.
	 * - 딱 한번만 호출됨.-> 서블릿은 하나만 생성됨.
	 */
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init()...");
	}
	
	/* - 클라이언트의 요청이 들어올 때 마다 호출됨.
	 * - 실제 서비스할 작업을 기술한다. 
	 */
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("service()...");
		
	}
	
	/* - 웹 애플리케이션이 종료될 때 마무리 작업을 위해서 호출됨.
	 */
	@Override
	public void destroy() {
		System.out.println("destroy()...");
		
	}

	/* - 서블릿 컨테이너의 관리자 메뉴에서 서블릿 정보를 얻기 위해 호출한다. 
	 */
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig()...");
		return null;
	}

	/* - 서블릿 컨테이너의 관리자 메뉴에서 서블릿 정보를 얻기 위해 호출한다. 
	 */
	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo()...");
		return null;
	}
}






