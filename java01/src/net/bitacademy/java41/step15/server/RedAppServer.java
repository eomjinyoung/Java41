package net.bitacademy.java41.step15.server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class RedAppServer {
	private MemberDao memberDao;
	private MemberControl memberControl;
	private ProjectDao projectDao;
	private ProjectControl projectControl;
	
	public RedAppServer() {
		DBConnectionPool conPool = new DBConnectionPool(
			"jdbc:mysql://localhost/test", 
			"test", 
			"test",
			System.getProperty("driverClass"));
		
		memberDao = new MemberDao(conPool);
		projectDao = new ProjectDao(conPool);
		memberControl = new MemberControl(memberDao);
		projectControl = new ProjectControl(projectDao); 
	}

	public void execute() throws Exception {
		ServerSocket serverSocket = new ServerSocket(8888);
		while(true) {
			Socket socket = serverSocket.accept();
			
			ServiceWorker worker = new ServiceWorker(socket);
			worker.setProjectControl(projectControl);
			worker.setMemberControl(memberControl);
			
			/* 스레드에게 일을 시킬 때는 run()을 호출하지 말고, start()를 호출해야 한다.
			 * start()를 호출하면 JVM은 스레드를 준비시키고, run()을 호출한다.
			 */
			worker.start();
		}
		//serverSocket.close();
	}

	public static void main(String[] args) throws Exception {
		RedAppServer app = new RedAppServer();
		app.execute();
	}
}






