package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

public interface ProjectService {
	List<Project> getProjectList(int startIndex, int pageSize) throws Exception;
	
	int countProject() throws Exception;
	
	List<MemberProject> getMyProjects(String email) throws Exception;
	
	Project getProject(int no) throws Exception;
	
	void addProject(Project project) throws Exception;

	void updateProject(Project project) throws Exception;

	void removeProject(int no) throws Exception;
}













