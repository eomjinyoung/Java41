package net.bitacademy.java41.controls.project;

import java.sql.Date;
import java.util.Map;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.vo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("/project/update.do")
public class ProjectUpateControl implements PageControl {
	@Autowired ProjectService projectService;
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 
				(Map<String,String[]>)model.get("params");
		
		if (params.get("title") == null) {
			return form(model); 
		} else {
			return update(model);
		}
	}
	
	public String form(Map<String, Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 
				(Map<String,String[]>)model.get("params");
		int no = Integer.parseInt(params.get("no")[0]);
		model.put("project", projectService.getProject(no));
		
		return "/project/updateForm.jsp";
	}
	
	public String update(Map<String, Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 
				(Map<String,String[]>)model.get("params");
		
		projectService.updateProject(new Project()
			.setNo(Integer.parseInt(params.get("no")[0]))
			.setTitle(params.get("title")[0])
			.setContent(params.get("content")[0])
			.setStartDate(
				Date.valueOf(params.get("startDate")[0]))
			.setEndDate(
				Date.valueOf(params.get("endDate")[0]))
			.setTag(params.get("tag")[0]));

		return "redirect:view.do?no=" + params.get("no")[0];
	}
	
}













