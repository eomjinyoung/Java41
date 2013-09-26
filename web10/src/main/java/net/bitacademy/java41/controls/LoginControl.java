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

@Controller
public class LoginControl {
	@Autowired AuthService authService;

	@RequestMapping("/auth/login.do")
	public String executejkldfsjklfdsljkdfskljsdfsdfjkldfs(
			String email, 
			String password, 
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse resposne) throws Exception {
		Member member = authService.getUserInfo(email, password);
		
		if (request != null) {
			System.out.println("오호라..놀라워라..이럴수가...");
		}
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







