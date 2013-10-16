package net.bitacademy.java41.dao;

import java.util.List;
import java.util.Map;

import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

public interface ProjectDao {
	List<Project> list(Map<String,Object> params) throws Exception;
	
	int size() throws Exception;
	
	Project get(int no) throws Exception;
	
	List<MemberProject> listByMember(String email) throws Exception;
	
	int add(Project project) throws Exception;

	void update(Project project) throws Exception;

	void delete(int no) throws Exception;
}
