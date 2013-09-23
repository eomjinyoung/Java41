package net.bitacademy.java41.controls;

import java.util.Map;

import net.bitacademy.java41.annotations.Component;

@Component("/main.do")
public class MainControl implements PageControl {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		return "/main.jsp";
	}

}












