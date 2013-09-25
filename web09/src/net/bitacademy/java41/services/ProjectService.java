package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectService {
	@Autowired ProjectDao projectDao;
	
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
		try {
			projectDao.add(project);
		} catch (Exception e) {
			throw e;
			
		} finally {
		}
	}

	public void updateProject(Project project) {
		try {
			projectDao.update(project);
		} catch (Exception e) {
			throw e;
			
		} finally {
		}
		
	}

	public void removeProject(int no) {
		try {
			projectDao.delete(no);
		} catch (Exception e) {
			throw e;
			
		} finally {
		}
		
	}
}













