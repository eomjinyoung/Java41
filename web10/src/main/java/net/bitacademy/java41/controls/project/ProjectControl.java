package net.bitacademy.java41.controls.project;

import java.util.Map;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/project")
public class ProjectControl {
	@Autowired ProjectService projectService;

	@RequestMapping("/list2")
	public String list2(Model model) throws Exception {
		model.addAttribute("list", projectService.getProjectList());
		return "/project/list.jsp";
	}
	
	@RequestMapping("/list")
	public ModelAndView list() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/project/list.jsp");
		mv.addObject("list", projectService.getProjectList());
		return mv;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String form() {
		return "/project/newForm.jsp";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(
			Project project,
			HttpSession session) throws Exception {
		Member member = (Member)session.getAttribute("member");
		project.setLeader(member.getEmail());
		
		projectService.addProject(project);
		
		return "redirect:list.do";
	}
	
	@RequestMapping("/view")
	public String view(int no, Model model) throws Exception {
		model.addAttribute("project", projectService.getProject(no));
		
		return "/project/view.jsp";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateForm(int no, Model model) throws Exception {
		model.addAttribute("project", projectService.getProject(no));
		return "/project/updateForm.jsp";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Project project) throws Exception {
		projectService.updateProject(project);
		return "redirect:view.do?no=" + project.getNo();
	}
	
	@RequestMapping("/delete")
	public String delete(int no) throws Exception {
		projectService.removeProject(no);
		return "redirect:list.do";
	}
}













