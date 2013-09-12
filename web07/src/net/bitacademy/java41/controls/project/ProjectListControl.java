package net.bitacademy.java41.controls.project;

import java.util.Map;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.ProjectService;

public class ProjectListControl implements PageControl {
	ProjectService projectService;

	public ProjectListControl setProjectService(ProjectService projectService) {
		this.projectService = projectService;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("list", projectService.getProjectList());
		return "/project/list.jsp";
	}
}













