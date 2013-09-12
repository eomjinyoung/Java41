package net.bitacademy.java41.controls.project;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Project;

public class ProjectAddControl implements PageControl {
	ProjectService projectService;

	public ProjectAddControl setProjectService(ProjectService projectService) {
		this.projectService = projectService;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		Member member = (Member)session.getAttribute("member");
		
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 
				(Map<String,String[]>)model.get("params");
		
		projectService.addProject(new Project()
						.setTitle(params.get("title")[0])
						.setContent(params.get("content")[0])
						.setStartDate(
							Date.valueOf(params.get("startDate")[0]))
						.setEndDate(
							Date.valueOf(params.get("endDate")[0]))
						.setTag(params.get("tag")[0])
						.setLeader(member.getEmail()) );
		
		return "redirect:list.do";
	}
}













