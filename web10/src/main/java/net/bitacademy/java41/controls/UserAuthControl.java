package net.bitacademy.java41.controls;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.AuthService;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @Conroller 애노테이션
 * . DispatcherServlet(프론트 컨트롤러)에게 이 객체가 페이지 컨트롤러임을 선언한다.
 * . @RequestMapping(요청URL) 정보를 읽어서 '요청URL'과 같은 요청이 들어오면,
 *   해당 메서드를 호출할 것을 지정한다.
 *   
 * @Component 애노테이션
 * . 만약 이 애노테이션을 선언하게 되면, DipatcherServlet은 일반 객체로 취급한다.
 * . 요청처리와 상관없게 된다.
 * 
 */

@Controller
@RequestMapping("/auth")
public class UserAuthControl {
	@Autowired AuthService authService;

	@RequestMapping("/logout")
	public String execute(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:loginForm.do";
	}
	
	@RequestMapping("/loginForm")
	public String execute() {
		/*
		String email = "";
		boolean isSaveId = false;
		if (cookies.get("email") != null) {
			email = cookies.get("email");
			isSaveId = true;
		}
		*/
		String email = "";
		boolean isSaveId = false;
		
		//model.put("email", email);
		//model.put("isSaveId", isSaveId);
		
		return "/auth/LoginForm.jsp";
	}
	
	@RequestMapping("/login")
	public String execute(
			@RequestParam("email") String email, 
			@RequestParam("password") String password, 
			HttpSession session) throws Exception {
		Member member = authService.getUserInfo(email, password);
		
		/*
		if(request.getParameter("saveId") != null) {
			Cookie cookie = new Cookie("email", email);
			cookie.setMaxAge(60); 
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("email", null);
			cookie.setMaxAge(0); 
			response.addCookie(cookie);
		}*/
		
		if (member != null) {
			session.setAttribute("member", member);
			return "redirect:../main.do";
			
		} else {
			session.invalidate();
			return "/auth/loginFail.jsp";
		}
	}

}







