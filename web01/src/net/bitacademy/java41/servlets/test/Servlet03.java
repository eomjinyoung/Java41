package net.bitacademy.java41.servlets.test;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 라인 주석
/* 
 * 멀티라인 주석
 */
/** JavaDoc 주석
 * - javadoc.exe로 API 문서를 만들 때 사용하는 주석
 * - 이 주석에 들어있는 내용을 가지고 API 주석을 만든다.
 * - 개발자가 별도의 문서를 작성할 필요 없이, 소스 코드에 문서를 위한 내용을 포함하게 만든다.
 * @author jinyoungeom
 *
 */

// @애노테이션이름(값) 

/* 애노테이션(annotation)
 * - 컴파일러나 JVM에게 전달하는 주석 
 */

@WebServlet("/servlet03")
@SuppressWarnings("serial")
public class Servlet03 extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		// 클라이언트가 보낸 Data를 읽기 전에, 문자집합을 알려줘야 한다.
		// ** 반드시 getParameter()를 호출하기 전에 알려줘야 한다.
		//    호출한 후에는 의미없다.
		// ** 단, URL로 데이타를 보내는 경우(GET요청) 서블릿 컨테이너의 매뉴얼에 따라 설정한다.
		// 예) 톰캣인 경우, server.xml 파일의 <Connector> 태그의 다음 속성 값을 설정한다.
		// 			<Connector .....  URIEncoding="UTF-8">...</Connector>
		
		// 다음은 POST 요청시에 사용한다.
		//request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println(email);
		System.out.println(name);
		System.out.println(age);
		
	}

}







