package net.bitacademy.java41.controls;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.AuthService;
import net.bitacademy.java41.vo.JsonResult;
import net.bitacademy.java41.vo.LoginInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("loginInfo")
@RequestMapping("/auth")
public class UserAuthControl {
	@Autowired AuthService authService;

	@RequestMapping("/logout")
	@ResponseBody
	public Object logout(SessionStatus status) throws Exception {
		status.setComplete();
		JsonResult jsonResult = new JsonResult();
		jsonResult.setStatus("success");
		
		return jsonResult;
	}
	
	@RequestMapping(value="/loginInfo")
	@ResponseBody
	public Object loginInfo(
			HttpSession session,
			SessionStatus status) throws Exception {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		
		JsonResult jsonResult = null;
		if (loginInfo != null) {
			jsonResult = new JsonResult().setStatus("success")
								.setData(loginInfo);
		} else {
			status.setComplete();
			jsonResult = new JsonResult().setStatus("fail");
		}
		
		return jsonResult;
	}
	
	@RequestMapping(value="/login",
			method=RequestMethod.POST)
	@ResponseBody
	public Object login(
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
		
		return jsonResult;
	}
}







