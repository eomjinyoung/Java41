package net.bitacademy.java41.servlets.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/* 서블릿 만들기 2
 * - 매번 서블릿을 만들 때 마다 구현에 관심없는 메서드들도 만들기 때문에 
 *   짜증난다. 예) init(), destroy(), getServletConfig(), getServletInfo()
 * - 주로 어떤 작업을 수행할 것인지 service() 메서드를 구현하는데 집중할 필요가 있다.
 * - 대안? 도우미 클래스(BaseServlet)를 정의하여 상속 받는다.
 * 
 */
public class Servlet01 extends BaseServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("okok");
		
	}

}






