package net.bitacademy.java41.servlets.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/* javax.servlet.GenericServlet 클래스
 * - 서블릿 생성 시 모든 메서드를 구현하는 번거로움을 막기 위해 
 *   미리 4개의 메서드(init, destory, getServletConfig, getServletInfo)를 구현한
 *   추상 클래스이다.
 * - 이전에 우리가 직접 만들었던 BaseServlet과 같은 역할을 한다.
 *   GenericServlet의 용도를 이해하는데 도움이 될 것 같아 BaseServlet을 만들었다.
 *   BaseServlet에 대해 왜 만들었는지 궁금해 하지 말라!
 * 
 * - 클라이언트로 출력하기!
 */
public class Servlet02 extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("오호라...~~~ ");
	}

}








