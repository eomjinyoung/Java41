package net.bitacademy.java41.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/header")
public class HeaderControl{

	@RequestMapping
	public String execute() throws Exception {
		return "header";
	}

}












