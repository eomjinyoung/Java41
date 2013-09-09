package net.bitacademy.java41.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

public class ProjectDao {
	DBConnectionPool conPool;
	
	public ProjectDao(DBConnectionPool conPool) {
		this.conPool = conPool;
	}
	
	public List<Project> list() throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<Project> list = new ArrayList<Project>();

		try {
			con = conPool.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(
					"select PNO,TITLE,START_DATE,END_DATE"
					+ " from SPMS_PRJS"
					+ " order by PNO desc");
			
			while(rs.next()) {
				list.add(new Project()
							.setNo(rs.getInt("PNO"))
							.setTitle(rs.getString("TITLE"))
							.setStartDate(rs.getDate("START_DATE"))
							.setEndDate(rs.getDate("END_DATE")));
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
	
	public Project get(int no) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
					"select PNO,TITLE,CONTENT,START_DATE,END_DATE,TAG"
							+ " from SPMS_PRJS"
							+ " where PNO=?");
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return new Project()
							.setNo(rs.getInt("PNO"))
							.setTitle(rs.getString("TITLE"))
							.setContent(rs.getString("CONTENT"))
							.setStartDate(rs.getDate("START_DATE"))
							.setEndDate(rs.getDate("END_DATE"))
							.setTag(rs.getString("TAG"));
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
	
	public List<MemberProject> listByMember(String email) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList<MemberProject> list = new ArrayList<MemberProject>();

		try {
			con = conPool.getConnection();
			
			String sql = "select t1.PNO,t1.TITLE,t2.LEVEL ";
			sql += " from SPMS_PRJS t1, SPMS_PRJMEMB t2 ";
			sql += " where t1.PNO=t2.PNO ";
			sql += " and t2.EMAIL=?";
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				list.add(new MemberProject()
							.setNo(rs.getInt("PNO"))
							.setTitle(rs.getString("TITLE"))
							.setLevel(rs.getInt("LEVEL")));
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
	
	public int add(Project project) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = conPool.getConnection();
			
			// 1. 프로젝트를 등록한다.
			stmt = con.prepareStatement(
				"insert into SPMS_PRJS("
				+ " TITLE,CONTENT,START_DATE,END_DATE,TAG)"
				+ " values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, project.getTitle());
			stmt.setString(2, project.getContent());
			stmt.setDate(3, project.getStartDate());
			stmt.setDate(4, project.getEndDate());
			stmt.setString(5, project.getTag());
			stmt.executeUpdate();
			
			// * 자동 생성된 PK 값 알아내기
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				project.setNo( rs.getInt(1) );
			}
			rs.close();
			stmt.close();
			
			// 2. 프로젝트의 PL을 등록한다.
			stmt = con.prepareStatement(
					"insert into SPMS_PRJMEMB("
					+ " EMAIL,PNO,LEVEL)"
					+ " values(?,?,0)");
			stmt.setString(1, project.getLeader());
			stmt.setInt(2, project.getNo());
			stmt.executeUpdate();
			
			return project.getNo();
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {stmt.close();} catch(Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}
/*
	
	
	
	
	public int change(Project project) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
				"update PROJECTS set"
				+ " MGR=?,TITLE=?,CONTENT=?,"
				+ " START_DAT=?,END_DAT=?,CREATED_DAT=now()"
				+ " where PNO=?");
			stmt.setString(1, project.getManagerEmail());
			stmt.setString(2, project.getTitle());
			stmt.setString(3, project.getContent());
			stmt.setDate(4, project.getStartDate());
			stmt.setDate(5, project.getEndDate());
			stmt.setInt(6, project.getNo());
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
	
	public int remove(int no) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
				"delete from PROJECTS"
				+ " where PNO=?"	);
			stmt.setInt(1, no);
			
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
*/
}
