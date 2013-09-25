package net.bitacademy.java41.dao;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectDao {
	@Autowired SqlSessionFactory sqlSessionFactory;

	public ProjectDao() {}
	
	public List<Project> list() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectList(
					"net.bitacademy.java41.dao.ProjectMapper.list");
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	
	public Project get(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne(
					"net.bitacademy.java41.dao.ProjectMapper.get",
					no);
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
			
		}
	}
	
	public List<MemberProject> listByMember(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList(
					"net.bitacademy.java41.dao.ProjectMapper.listByMember",
					email);
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	
	public int add(Project project) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.insert(
				"net.bitacademy.java41.dao.ProjectMapper.add", project);
			
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("email", project.getLeader());
			paramMap.put("projectNo", project.getNo());
			paramMap.put("memberLevel", 0);
			
			sqlSession.insert(
				"net.bitacademy.java41.dao.ProjectMapper.addProjectMember", 
				paramMap);
			
			sqlSession.commit();
			return project.getNo();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}

	public void update(Project project) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.update(
				"net.bitacademy.java41.dao.ProjectMapper.update", project);
			
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
		
	}

	public void delete(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.delete(
					"net.bitacademy.java41.dao.ProjectMapper.deleteProjectMember", no);
			sqlSession.delete(
					"net.bitacademy.java41.dao.ProjectMapper.delete", no);
			
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
			
		}
	}
}
