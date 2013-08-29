package net.bitacademy.java41.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool {
	String dburl;
	String id;
	String pwd;
	String driverClass;
	
	ArrayList<Connection> list = new ArrayList<Connection>();
	
	/* Singleton 패턴 시작 */
	static DBConnectionPool instance;
	
	public static DBConnectionPool getInstance() {
		if (instance == null) {
			instance = new DBConnectionPool(
				"jdbc:mysql://localhost/test", 
				"test", 
				"test",
				System.getProperty("driverClass"));
		} 
		return instance;
	}
	/* Singleton패턴 끝 */
	
	/* Singleton 패턴에서는 외부에서 객체를 직접 생성하지 못하도록 
	 * 생성자를 private으로 선언한다.
	 */
	private DBConnectionPool(
			String dburl, String id, String pwd, String driverClass) {
		this.dburl = dburl;
		this.id = id;
		this.pwd = pwd;
		this.driverClass = driverClass;
	}
	
	public Connection getConnection() throws Exception {
		if (list.size() > 0) {
			return list.remove(0);
		} else {
			Class.forName(driverClass);
			return DriverManager.getConnection(dburl, id, pwd);
		}
	}
	
	public void returnConnection(Connection con) {
		list.add(con);
	}
}







