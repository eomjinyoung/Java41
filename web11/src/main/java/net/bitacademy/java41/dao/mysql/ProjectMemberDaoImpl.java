package net.bitacademy.java41.dao.mysql;

import java.util.Map;

import net.bitacademy.java41.dao.ProjectMemberDao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectMemberDaoImpl implements ProjectMemberDao {
	@Autowired SqlSessionFactory sqlSessionFactory;

	public ProjectMemberDaoImpl() {}
	
	public int add(Map<String,Object> paramMap) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
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
