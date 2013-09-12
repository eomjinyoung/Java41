package net.bitacademy.java41.controls;

import java.util.Map;


import net.bitacademy.java41.dao.ProjectDao;

public class MainControl implements PageControl {
	ProjectDao projectDao;
	
	public MainControl setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		return "/main.jsp";
	}

}












