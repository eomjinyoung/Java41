package net.bitacademy.java41.dao;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.vo.Member;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	@Autowired SqlSessionFactory sqlSessionFactory;
	
	public MemberDao() {	}
	
	public Member getMember(String email, String password) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("email", email);
			paramMap.put("password", password);
			
			Member member = sqlSession.selectOne(
				"net.bitacademy.java41.dao.MemberMapper.getMember",
				paramMap);
				
			return member;
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}		
	}
	
	public int add(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.insert(
				"net.bitacademy.java41.dao.MemberMapper.add", member);
			sqlSession.commit();
			
			return count;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
	
	public List<Member> list() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList(
				"net.bitacademy.java41.dao.MemberMapper.list");
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
	
	public Member get(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne(
				"net.bitacademy.java41.dao.MemberMapper.view", email);
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
	
	public int changePassword (
			String email, String oldPassword, String newPassword) throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			HashMap<String,String> paramMap = new HashMap<String,String>();
			paramMap.put("email", email);
			paramMap.put("oldPassword", oldPassword);
			paramMap.put("newPassword", newPassword);
			
			int count = sqlSession.insert(
				"net.bitacademy.java41.dao.MemberMapper.changePassword", paramMap);
			sqlSession.commit();
			return count;
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
	
	public int udpate(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.insert(
				"net.bitacademy.java41.dao.MemberMapper.update", member);
			sqlSession.commit();
			
			return count;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
	
	public int delete(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.insert(
				"net.bitacademy.java41.dao.MemberMapper.delete", email);
			sqlSession.commit();
			
			return count;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}

	public void addPhoto(String email, String path) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("email", email);
			paramMap.put("path", path);
			
			sqlSession.insert(
				"net.bitacademy.java41.dao.MemberMapper.addPhoto", paramMap);
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
	
	public List<String> listPhoto(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList(
				"net.bitacademy.java41.dao.MemberMapper.listPhoto", email);
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
	
	public void deleteAllPhoto(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.insert(
				"net.bitacademy.java41.dao.MemberMapper.deleteAllPhoto", email);
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
}




