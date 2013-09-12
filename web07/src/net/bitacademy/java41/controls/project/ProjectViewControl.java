package net.bitacademy.java41.controls.project;

import java.util.Map;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.dao.ProjectDao;

public class ProjectViewControl implements PageControl {
	ProjectDao projectDao;
	
	public ProjectViewControl setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 
				(Map<String,String[]>)model.get("params");
		int no = Integer.parseInt(params.get("no")[0]);
		model.put("project", projectDao.get(no));
		
		return "/project/view.jsp";
	}
}













