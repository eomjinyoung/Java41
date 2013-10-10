package net.bitacademy.java41.controls;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.AuthService;
import net.bitacademy.java41.vo.JsonResult;
import net.bitacademy.java41.vo.LoginInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.google.gson.Gson;

@Controller
@SessionAttributes("loginInfo")
@RequestMapping("/auth")
public class UserAuthControl {
	@Autowired AuthService authService;

	@RequestMapping("/logout")
	public String logout(SessionStatus status) throws Exception {
		status.setComplete();
		return "redirect:login.do";
	}
	
	@RequestMapping(value="/login",
			method=RequestMethod.GET)
	public String form(
			@CookieValue(value="email", required=false) String email,
			Model model) {
		boolean isSaveId = false;
		if (email != null) {
			isSaveId = true;
		}
		
		model.addAttribute("email", email);
		model.addAttribute("isSaveId", isSaveId);
		
		return "auth/LoginForm";
	}
	
	@RequestMapping(value="/login",
			method=RequestMethod.POST)
	public ResponseEntity<String> login(
			String email,
			@RequestParam("password") String pwd,
			String saveId,
			HttpServletResponse response,
			HttpSession session,
			Model model,
			SessionStatus status) throws Exception {
		LoginInfo loginInfo = authService.getLoginInfo(email, pwd);
		
		if(saveId != null) {
			Cookie cookie = new Cookie("email", email);
			cookie.setMaxAge(60); 
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("email", null);
			cookie.setMaxAge(0); 
			response.addCookie(cookie);
		}
		
		JsonResult jsonResult = null;
		if (loginInfo != null) {
			model.addAttribute("loginInfo", loginInfo);
			jsonResult = new JsonResult().setStatus("success")
								.setData("한글");
		} else {
			status.setComplete();
			jsonResult = new JsonResult().setStatus("fail");
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "text/plain;charset=UTF-8");
		return new ResponseEntity<String>(
						new Gson().toJson( jsonResult ),
						headers,
						HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/login2",
			method=RequestMethod.POST)
	@ResponseBody /* 리턴 값이 응답 데이터임을 선언 */
	public String login2(
			String email,
			@RequestParam("password") String pwd,
			String saveId,
			HttpServletResponse response,
			HttpSession session,
			Model model,
			SessionStatus status) throws Exception {
		LoginInfo loginInfo = authService.getLoginInfo(email, pwd);
		
		if(saveId != null) {
			Cookie cookie = new Cookie("email", email);
			cookie.setMaxAge(60); 
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("email", null);
			cookie.setMaxAge(0); 
			response.addCookie(cookie);
		}
		
		JsonResult jsonResult = null;
		if (loginInfo != null) {
			model.addAttribute("loginInfo", loginInfo);
			jsonResult = new JsonResult().setStatus("success")
								.setData("한글");
		} else {
			status.setComplete();
			jsonResult = new JsonResult().setStatus("fail");
		}
		
		response.setContentType("text/plain;charset=UTF-8");
		return new Gson().toJson( jsonResult );
	}
	
	@RequestMapping(value="/login1",
			method=RequestMethod.POST)
	public String login1(
			String email,
			@RequestParam("password") String pwd,
			String saveId,
			HttpServletResponse response,
			HttpSession session,
			Model model,
			SessionStatus status) throws Exception {
		LoginInfo loginInfo = authService.getLoginInfo(email, pwd);
		
		if(saveId != null) {
			Cookie cookie = new Cookie("email", email);
			cookie.setMaxAge(60); 
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("email", null);
			cookie.setMaxAge(0); 
			response.addCookie(cookie);
		}
		
		if (loginInfo != null) {
			model.addAttribute("loginInfo", loginInfo);
			model.addAttribute("jsonResult", new JsonResult()
												.setStatus("success") );
			//model.addAttribute("status", "success");
		} else {
			status.setComplete();
			model.addAttribute("jsonResult", new JsonResult()
												.setStatus("fail") );
			//model.addAttribute("status", "fail");
		}
		
		return "auth/loginResult";
	}

}







