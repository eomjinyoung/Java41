package net.bitacademy.java41.controls.project;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.vo.JsonResult;
import net.bitacademy.java41.vo.LoginInfo;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Controller
@RequestMapping("/project")
public class ProjectControl {
	@Autowired ProjectService projectService;

	@RequestMapping("/myprojects")
	public ResponseEntity<String> execute(
			@ModelAttribute("loginInfo") LoginInfo loginInfo) throws Exception {
		
		JsonResult jsonResult = new JsonResult();
		
		try {
			jsonResult.setData(
					projectService.getMyProjects(loginInfo.getEmail()));
			jsonResult.setStatus("success");
		} catch (Throwable e) {
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			
			jsonResult.setStatus("fail");
			jsonResult.setData(out.toString());
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/plain;charset=UTF-8");
		
		return new ResponseEntity<String>(
				new Gson().toJson(jsonResult),
				responseHeaders,
				HttpStatus.OK);
	}
	
	@RequestMapping("/list2")
	public String list2(Model model) throws Exception {
		model.addAttribute("list", projectService.getProjectList());
		return "project/list";
	}
	
	@RequestMapping("/list")
	public ModelAndView list() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("project/list");
		mv.addObject("list", projectService.getProjectList());
		return mv;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String form() {
		return "project/newForm";
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
		
		return "project/view";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateForm(int no, Model model) throws Exception {
		model.addAttribute("project", projectService.getProject(no));
		return "project/updateForm";
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













