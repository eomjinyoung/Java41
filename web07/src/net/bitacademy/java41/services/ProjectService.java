package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

public class ProjectService {
	ProjectDao projectDao;
	
	public ProjectService setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
	
	public List<Project> getProjectList() throws Exception {
		return projectDao.list();
	}
	
	public List<MemberProject> getMyProjects(String email) throws Exception {
		return projectDao.listByMember(email);
	}
	
	public Project getProject(int no) throws Exception {
		return projectDao.get(no);
	}
	
	public void addProject(Project project) throws Exception {
		projectDao.add(project);
	}
}
