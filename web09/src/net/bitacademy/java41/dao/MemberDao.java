package net.bitacademy.java41.dao;

import java.util.HashMap;

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
/*	
	public List<Member> list() throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<Member> list = new ArrayList<Member>();

		try {
			con = conPool.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(
					"select EMAIL,MNAME,TEL,BLOG from SPMS_MEMBS "
					+ " order by MNAME");
			
			Member m = null;
			while(rs.next()) {
				m = new Member()
						.setEmail(rs.getString("EMAIL"))
						.setName(rs.getString("MNAME"))
						.setTel(rs.getString("TEL"))
						.setBlog(rs.getString("BLOG"));
						
				list.add(m);
			}
			
			return list;
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {rs.close();} catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}
*/
/*	
	public Member get(String email) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
					"select EMAIL,MNAME,TEL,BLOG,REG_DATE,DET_ADDR,TAG,LEVEL"
					+ " from SPMS_MEMBS"
					+ " where EMAIL=?");
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				Member member = new Member()
								.setEmail(rs.getString("EMAIL"))
								.setName(rs.getString("MNAME"))
								.setTel(rs.getString("TEL"))
								.setBlog(rs.getString("BLOG"))
								.setRegDate(rs.getDate("REG_DATE"))
								.setDetailAddress(rs.getString("DET_ADDR"))
								.setTag(rs.getString("TAG"))
								.setLevel(rs.getInt("LEVEL"));
				return member;
				
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {rs.close();} catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}
*/
/*	
	public int changePassword(
			String email, String oldPassword, String newPassword) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
				"update SPMS_MEMBS set"
				+ " PWD=?,UPDATE_DATE=now()"
				+ " where EMAIL=? and PWD=?");
			stmt.setString(1, newPassword);
			stmt.setString(2, email);
			stmt.setString(3, oldPassword);
			return stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		
		} finally {
			try {stmt.close();} catch(Exception e) {}
			if (con != null && con.getAutoCommit()) {
				conPool.returnConnection(con);
			}
		}
	}
*/	
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
/*	
	public List<Photo> listPhoto(String email) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
				"select INO,IMGURL from SPMS_MEMIMG"
				+ " where EMAIL=?"); 
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			
			ArrayList<Photo> list = new ArrayList<Photo>();
			while (rs.next()) {
				list.add(new Photo()
						.setNo(rs.getInt("INO"))
						.setEmail(email)
						.setFilename(rs.getString("IMGURL")));
			}
			
			return list;
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {rs.close();} catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}		
	}
*/	
	/*
	public int change(Member member) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
				"update MEMBERS set"
				+ " MNAME=?,PHONE=?,BLOG=?,AGE=?,REG_DATE=now()"
				+ " where EMAIL=?");
			stmt.setString(1, member.getName());
			stmt.setString(2, member.getPhone());
			stmt.setString(3, member.getBlog());
			stmt.setInt(4, member.getAge());
			stmt.setString(5, member.getEmail());
			return stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		
		} finally {
			try {stmt.close();} catch(Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}

	public int remove(String email) throws Exception {
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.createStatement();
			
			return stmt.executeUpdate(
				"delete from MEMBERS"
				+ " where EMAIL='" + email + "'");
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {stmt.close();} catch(Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}
*/

	
}




