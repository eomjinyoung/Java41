package net.bitacademy.java41.step10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class RedApp01 {
	protected Scanner scanner;
	private Member member;
	
	public RedApp01() {
		scanner = new Scanner(System.in);
	}

	public void execute() {
		while(true) {
			System.out.print("명령>");
			String command = scanner.nextLine().toLowerCase();

			if (command.equals("add")) {
				member = null;
				add();
			} else if (command.equals("list")) {
				member = null;
				list();
			} else if (command.startsWith("view")) {
				//명령>view a@test.com
				String[] values = command.split(" ");
				view( values[1] );
			} else if (command.equals("update")) {
				if (member != null) {
					update();
				} else {
					System.out.println("먼저 멤버를 조회하세요!");
				}
			} else if (command.equals("delete")) {
				if (member != null) {
					detele();
				} else {
					System.out.println("먼저 멤버를 조회하세요!");
				}
			} else if (command.equals("quit")) {
				System.out.println("안녕!");
				break;
			} else {
				System.out.println("지원하지 않는 명령어입니다.");
			}
		}
	}

	private void add(){
		Member m = new Member();
		System.out.print("이름 : ");
		m.setName(scanner.nextLine());
		System.out.print("전화번호 : ");
		m.setPhone(scanner.nextLine());
		System.out.print("이메일 : ");
		m.setEmail(scanner.nextLine());
		System.out.print("블로그 : ");
		m.setBlog(scanner.nextLine());
		System.out.print("나이 : ");
		m.setAge( Integer.parseInt( scanner.nextLine() ) );

		System.out.print("등록하시겠습니까?(y/n)");
		if(scanner.nextLine().toLowerCase().equals("y")){
			m.setRegDate(new Date());
			
			Connection con = null;
			Statement stmt = null;
			
			try {
				String driverClass = System.getProperty("driverClass");
				Class.forName(driverClass);
				
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost/test", "test", "test");
				
				stmt = con.createStatement();
				
				int count = stmt.executeUpdate(
					"insert into MEMBERS("
					+ "MNAME,PHONE,EMAIL,BLOG,AGE,REG_DATE"
					+ ") values("
					+ "'" + m.getName() + "','" 
					+ m.getPhone() + "','"
					+ m.getEmail() + "','"
					+ m.getBlog() + "',"
					+ m.getAge() + ",now()"
					+ ")");
				
				System.out.println("등록되었습니다!");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {stmt.close();} catch(Exception e) {}
				try {con.close();} catch(Exception e) {}
			}
		} else {
			System.out.println("등록 취소하였습니다!");
		}
	}

	private void list() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// MySQL 서버에 연결할 도구를 준비
			// - JDBC Driver 클래스 중(.jar 파일에 들어있는 클래스들 중에서)
			//   java.sql.Driver 인터페이스를 구현한 클래스를 먼저 로딩한다.
			// - 이 클래스가 java.sql.Connection 인터페이스를 구현한 클래스를 알고 있다.
			String driverClass = System.getProperty("driverClass");
			Class.forName(driverClass);
			//Class.forName("com.mysql.jdbc.Driver");
			
			// 1. 서버와 연결
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/test", "test", "test");
			
			// 2. SQL문을 보낼 도구를 얻기
			// - createStatement()를 호출하여 SQL문을 서버에 보낼 도구를 얻는다.
			stmt = con.createStatement();
			
			// 3. SQL을 서버에 보냄
			// - executeQuery()는 서버에 SQL문을 보낸다.
			// - 서버는 결과를 준비한다.
			// - executeQuery()는 서버에서 결과를 가져올 도구를 리턴한다. 
			rs = stmt.executeQuery(
					"select MNAME,PHONE,EMAIL from MEMBERS order by MNAME");
			
			// 4. 서버의 결과를 가져와서 출력
			// - next()를 호출하여 서버로부터 1 레코드의 결과를 가져온다.
			while(rs.next()) {
				System.out.print(rs.getString("MNAME") + ",");
				System.out.print(rs.getString("PHONE") + ",");
				System.out.println(rs.getString("EMAIL"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();} catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
			try {con.close();} catch (Exception e) {}
		}
	}

	private void detele() {
		Connection con = null;
		Statement stmt = null;
		
		try {
			String driverClass = System.getProperty("driverClass");
			Class.forName(driverClass);
			
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/test", "test", "test");
			
			stmt = con.createStatement();
			
			int count = stmt.executeUpdate(
				"delete from MEMBERS"
				+ " where EMAIL='" + member.getEmail() + "'");
			
			System.out.println("삭제되었습니다!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {stmt.close();} catch(Exception e) {}
			try {con.close();} catch(Exception e) {}
		}
	}

	private void update() {
		Member copy = member.clone();
		System.out.printf("이메일(%1$s):\n", member.getEmail());
		System.out.printf("이름(%1$s):", member.getName());
		String value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setName(value);
		}
		System.out.printf("전화(%1$s):", member.getPhone());
		value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setPhone(value);
		}
		System.out.printf("블로그(%1$s):", member.getBlog());
		value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setBlog(value);
		}
		System.out.printf("나이(%1$d):", member.getAge());
		value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setAge( Integer.parseInt(value) );
		}

		System.out.print("변경하시겠습니까?(y/n)");
		if(scanner.nextLine().toLowerCase().equals("y")){
			Connection con = null;
			Statement stmt = null;
			
			try {
				String driverClass = System.getProperty("driverClass");
				Class.forName(driverClass);
				
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost/test", "test", "test");
				
				stmt = con.createStatement();
				
				int count = stmt.executeUpdate(
					"update MEMBERS set"
					+ " MNAME='" + copy.getName() + "'," 
					+ " PHONE='" + copy.getPhone() + "',"
					+ " BLOG='" + copy.getBlog() + "',"
					+ " AGE=" + copy.getAge() + ","
					+ " REG_DATE=now()"
					+ " where EMAIL='" + member.getEmail() + "'");
				
				System.out.println("변경되었습니다!");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {stmt.close();} catch(Exception e) {}
				try {con.close();} catch(Exception e) {}
			}
		} else {
			System.out.println("변경 취소하였습니다!");
		}
	}

	private void view(String email) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			String driverClass = System.getProperty("driverClass");
			Class.forName(driverClass);
			
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/test", "test", "test");
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(
					"select MNAME,PHONE,EMAIL,BLOG,AGE,REG_DATE"
					+ " from MEMBERS"
					+ " where EMAIL='" + email + "'");
			
			if (rs.next()) {
				member = new Member();
				member.setName(rs.getString("MNAME"));
				member.setPhone(rs.getString("PHONE"));
				member.setEmail(rs.getString("EMAIL"));
				member.setBlog(rs.getString("BLOG"));
				member.setAge(rs.getInt("AGE"));
				member.setRegDate(rs.getDate("REG_DATE"));
				
			} else {
				throw new Exception("해당 이메일의 멤버가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			try {rs.close();} catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
			try {con.close();} catch (Exception e) {}
		}
		
		System.out.println("이름:" + member.getName());
		System.out.println("전화:" + member.getPhone());
		System.out.println("이메일:" + member.getEmail());
		System.out.println("블로그:" + member.getBlog());
		System.out.println("나이:" + member.getAge());
		System.out.printf("등록일:%1$tY-%1$tm-%1$td \n", member.getRegDate());
	}

	public static void main(String[] args) {
		RedApp01 app = new RedApp01();
		app.execute();
	}
}








