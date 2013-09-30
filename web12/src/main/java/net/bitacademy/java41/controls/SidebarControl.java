package net.bitacademy.java41.controls;

import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("member")
public class SidebarControl {
	@Autowired ProjectService projectService;
	
	@RequestMapping("/sidebar")
	public String execute(
			@ModelAttribute("member") Member member,
			Model model) throws Exception {
		model.addAttribute("myprojects", 
				projectService.getMyProjects(member.getEmail()));
		return "sidebar";
	}
}







