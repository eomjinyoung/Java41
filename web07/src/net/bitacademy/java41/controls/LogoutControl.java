package net.bitacademy.java41.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

public class LogoutControl implements PageControl {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		session.invalidate();
		return "redirect:loginForm.do";
	}
}












