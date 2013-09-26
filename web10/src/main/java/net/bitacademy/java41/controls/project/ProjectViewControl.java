package net.bitacademy.java41.controls.project;

import java.util.Map;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("/project/view.do")
public class ProjectViewControl implements PageControl {
	@Autowired ProjectService projectService;
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 
				(Map<String,String[]>)model.get("params");
		int no = Integer.parseInt(params.get("no")[0]);
		model.put("project", projectService.getProject(no));
		
		return "/project/view.jsp";
	}
}













