package net.bitacademy.java41.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectMemberDao {
	@Autowired SqlSessionFactory sqlSessionFactory;

	public ProjectMemberDao() {}
	
	public int add(String email, int projectNo, int level) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("email", email);
			paramMap.put("projectNo", projectNo);
			paramMap.put("memberLevel", level);
			
			int count = sqlSession.insert(
				"net.bitacademy.java41.dao.ProjectMapper.addProjectMember", 
				paramMap);
			
			sqlSession.commit();
			return count;
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}

}
