package net.bitacademy.java41.services;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.dao.ProjectMemberDao;
import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired PlatformTransactionManager txManager;
	@Autowired ProjectDao projectDao;
	@Autowired ProjectMemberDao projectMemberDao;
	
	public List<Project> getProjectList() throws Exception {
		return projectDao.list();
	}
	
	public List<MemberProject> getMyProjects(String email) throws Exception {
		return projectDao.listByMember(email);
	}
	
	public Project getProject(int no) throws Exception {
		return projectDao.get(no);
	}
	
	@Transactional(
			propagation=Propagation.REQUIRED,
			rollbackFor=Throwable.class)
	public void addProject(Project project) throws Exception {
		try {
			projectDao.add(project);
			
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("email", project.getLeader());
			paramMap.put("projectNo", project.getNo());
			paramMap.put("memberLevel", 0);
			
			projectMemberDao.add(paramMap);
			
		} catch (Throwable e) {
			throw e;
		}
	}

	@Transactional(
			propagation=Propagation.REQUIRED,
			rollbackFor=Throwable.class)
	public void updateProject(Project project) throws Exception {
		try {
			projectDao.update(project);
			
		} catch (Exception e) {
			throw e;
		} 
		
	}

	@Transactional(
			propagation=Propagation.REQUIRED,
			rollbackFor=Throwable.class)
	public void removeProject(int no) throws Exception{
		try {
			projectMemberDao.deleteAll(no);
			projectDao.delete(no);
		} catch (Exception e) {
			throw e;
		} 
		
	}
}













