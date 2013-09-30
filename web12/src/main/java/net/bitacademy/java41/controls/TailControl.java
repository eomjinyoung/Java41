package net.bitacademy.java41.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tail")
public class TailControl{

	@RequestMapping
	public String execute() throws Exception {
		return "tail";
	}

}












