package net.bitacademy.java41.step14.server;

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
		/* Client / Server
		 * - Client: 먼저 요청하는 쪽
		 * - Server: 요청 받은 후 응답하는 쪽
		 */
		
		/* ServerSocket
		 * - Client와의 연결을 제공하는 객체
		 * - 포트번호: 실행 중인 컴퓨터에서 서버 프로그램을 구분하기 위한 고유 번호
		 * - 운영체제는 랜선으로 데이터가 들어오면 포트번호를 확인하여 
		 *   해당 프로그램으로 데이터를 전달한다. 
		 */
		ServerSocket serverSocket = new ServerSocket(8888);
		
		/* accept()
		 * - 클라이언트의 연결을 기다리고 있다가 연결 요청이 들어오면 즉시 리턴한다.
		 * - 리턴 값: 클라이언트와 데이터를 주고 받을 수 있는 도구이다.
		 */
		/* Socket
		 * - 상대편과 데이터를 주고 받을 수 있는 도구이다.
		 */
		while(true) {
			Socket socket = serverSocket.accept();
			Scanner scanner = new Scanner(socket.getInputStream());
			PrintStream out = new PrintStream(socket.getOutputStream());
		
			while(true) {
				String command = scanner.nextLine();
				System.out.println("Client:" + command);
				
				if (command.equals("member")) {
					memberControl.execute(scanner, out);
					
				} else if (command.equals("project")) {
					projectControl.execute(scanner, out);
					
				} else if (command.equals("quit")) {
					out.println("goodbye");
					break;
				
				} else if (!command.equals("hello")){
					out.println("없는 메뉴입니다.");
				}
				
				printPrompt(out);
			}
			socket.close();
		}
		
		//serverSocket.close();
	}

	private void printPrompt(PrintStream out) {
		out.println("메뉴>");
		out.println("@@?");
	}

	public static void main(String[] args) throws Exception {
		RedAppServer app = new RedAppServer();
		app.execute();
	}
}






