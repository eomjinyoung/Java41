package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

public interface ProjectService {
	List<Project> getProjectList() throws Exception;
	
	List<MemberProject> getMyProjects(String email) throws Exception;
	
	Project getProject(int no) throws Exception;
	
	void addProject(Project project) throws Exception;

	void updateProject(Project project);

	void removeProject(int no);
}













