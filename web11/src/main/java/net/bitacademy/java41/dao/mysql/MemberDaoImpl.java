package net.bitacademy.java41.dao.mysql;

import java.util.List;
import java.util.Map;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDaoImpl implements MemberDao {
	@Autowired SqlSessionFactory sqlSessionFactory;
	
	public MemberDaoImpl() {	}
	
	public Member getMember(Map<String,String> paramMap) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
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
	
	public int changePassword (Map<String,String> paramMap) throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
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

	public void addPhoto(Map<String,String> paramMap) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
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




