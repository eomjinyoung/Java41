package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

/* HTTP 요청을 구분하여 쉽게 다루는 방법 
 * - GenericServlet을 상속받지 말고, HttpServlet을 상속 받아라.
 * - get 요청을 처리하고 싶으면 doGet()을 재정의.
 * - post 요청을 처리하고 싶으면 doPost()을 재정의.
 * - xxx 요청을 처리하고 싶으면 doXxx()을 재정의.
 * - 상속 및 구현관계
 * 		- public interface Servlet {...}
 * 		- public abstract class GenericServlet implements Servlet {
 * 			init() {...} 구현
 *  			destroy() {...} 구현
 *  			getServletInfo() {...} 구현
 *  			getServletConfig() {...} 구현
 *  			service()는 구현하지 않음.
 * 		}
 * 		- public abstract class HttpServlet extends GenericServlet {
 * 			service() {
 * 				String method = ...getMethod();
 * 				if("get".equals(method)) {
 * 					doGet();
 * 				} else if("post".equals(method)) {
 * 					doPost();
 * 				} ...
 * 				...
 * 			}
 * 			doGet() {...}
 * 			doPost() {...}
 * 			doXxx() {...}
 * 			...
 * 		}
 */
@WebServlet("/auth/login")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>GET 요청을 받을 수 없습니다.2</body></html>");
		return;
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		MemberDao memberDao = 
				(MemberDao) this.getServletContext().getAttribute("memberDao");
		try {
			Member member = memberDao.getMember(email, password);
			HttpSession session = request.getSession();
			
			if (member != null) {
				session.setAttribute("member", member);
				response.sendRedirect("../main");
				
			} else {
				session.invalidate();
				out.println("<html><head><title>로그인 결과!</title></head>");
				out.println("<body><p>해당 사용자를 찾을 수 없습니다.2</p></body></html>");
				response.setHeader(
						"Refresh", "1;url=LoginForm.html");
			}
	
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<html><head><title>시스템오류!</title></head>");
			out.println("<body><p>실행 오류입니다.</p></body></html>");
		}
	}

}







