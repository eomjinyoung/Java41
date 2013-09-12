package net.bitacademy.java41.controls.project;

import java.util.Map;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.dao.ProjectDao;

public class ProjectListControl implements PageControl {
	ProjectDao projectDao;
	
	public ProjectListControl setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("list", projectDao.list());
		return "/project/list.jsp";
	}
}













