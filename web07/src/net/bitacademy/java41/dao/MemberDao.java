package net.bitacademy.java41.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Member;

public class MemberDao {
	DBConnectionPool conPool;
	
	public MemberDao(DBConnectionPool conPool) {
		this.conPool = conPool;
	}
	
	public Member getMember(String email, String password) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
				"select EMAIL,MNAME,TEL,LEVEL from SPMS_MEMBS "
				+ " where EMAIL=? and PWD=?"); // ? -> in-parameter
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				Member member = new Member()
								.setEmail(rs.getString("EMAIL"))
								.setName(rs.getString("MNAME"))
								.setTel(rs.getString("TEL"))
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
	
	public int add(Member member) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
				"insert into SPMS_MEMBS("
				+ " EMAIL,MNAME,PWD,TEL,"
				+ " BLOG,REG_DATE,UPDATE_DATE,DET_ADDR,TAG,LEVEL)"
				+ " values(?,?,?,?,?,now(),now(),?,?,?)");
			stmt.setString(1, member.getEmail());
			stmt.setString(2, member.getName());
			stmt.setString(3, member.getPassword());
			stmt.setString(4, member.getTel());
			stmt.setString(5, member.getBlog());
			stmt.setString(6, member.getDetailAddress());
			stmt.setString(7, member.getTag());
			stmt.setInt(8, member.getLevel());
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




