package net.bitacademy.java41.controls.project;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.vo.JsonResult;
import net.bitacademy.java41.vo.LoginInfo;
import net.bitacademy.java41.vo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("loginInfo")
@RequestMapping("/project")
public class ProjectControl {
	@Autowired ProjectService projectService;

	@RequestMapping("/myprojects")
	@ResponseBody
	public Object myprojects(
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
		
		return jsonResult;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public Object list(
			@RequestParam(value="pageNo", defaultValue="1") 
			int pageNo,
			@RequestParam(value="pageSize", defaultValue="10") 
			int pageSize) throws Exception {
		JsonResult jsonResult = new JsonResult();
		
		try {
			int startIndex = (pageNo - 1) * pageSize;
			if (startIndex < 0) {
				startIndex = 0;
			}
			jsonResult.setData( 
				projectService.getProjectList(startIndex,pageSize));
			jsonResult.setStatus("success");
		} catch (Throwable e) {
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			
			jsonResult.setStatus("fail");
			jsonResult.setData(out.toString());
		}
		
		return jsonResult;
	}
	
	@RequestMapping("/count")
	@ResponseBody
	public Object count() throws Exception {
		JsonResult jsonResult = new JsonResult();
		
		try {
			jsonResult.setData(projectService.countProject());
			jsonResult.setStatus("success");
		} catch (Throwable e) {
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			
			jsonResult.setStatus("fail");
			jsonResult.setData(out.toString());
		}
		
		return jsonResult;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Object add(
			Project project,
			HttpSession session) throws Exception {
		JsonResult jsonResult = new JsonResult();
		
		try {
			LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
			project.setLeader(loginInfo.getEmail());
			projectService.addProject(project);
			
			jsonResult.setStatus("success");
			
		} catch (Throwable e) {
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			
			jsonResult.setStatus("fail");
			jsonResult.setData(out.toString());
		}
		
		return jsonResult;
	}
	
	@RequestMapping("/view")
	@ResponseBody
	public Object view(int no, Model model) throws Exception {
		JsonResult jsonResult = new JsonResult();
		
		try {
			jsonResult.setData(projectService.getProject(no));
			jsonResult.setStatus("success");
		} catch (Throwable e) {
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			
			jsonResult.setStatus("fail");
			jsonResult.setData(out.toString());
		}
		
		return jsonResult;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public Object update(Project project) throws Exception {
		JsonResult jsonResult = new JsonResult();
		
		try {
			projectService.updateProject(project);
			jsonResult.setStatus("success");
			
		} catch (Throwable e) {
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			
			jsonResult.setStatus("fail");
			jsonResult.setData(out.toString());
		}
		
		return jsonResult;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(int no) throws Exception {
		JsonResult jsonResult = new JsonResult();
		
		try {
			projectService.removeProject(no);
			jsonResult.setStatus("success");
			
		} catch (Throwable e) {
			StringWriter out = new StringWriter();
			e.printStackTrace(new PrintWriter(out));
			
			jsonResult.setStatus("fail");
			jsonResult.setData(out.toString());
		}
		
		return jsonResult;
	}
}













