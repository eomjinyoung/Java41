package net.bitacademy.java41.step15.server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/* 스레드 프로그래밍
 * - 병행적으로 작업을 수행하기 위한 방법
 * - 1) Thread를 상속 받는다.
 * - 2) 병행으로 수행할 작업들을 run() 메서드에 넣는다.
 */
public class ServiceWorker extends Thread {
	private Socket socket;
	private MemberControl memberControl;
	private ProjectControl projectControl;
	
	public ServiceWorker(Socket socket) {
		this.socket = socket;
	}
	
	public void setMemberControl(MemberControl memberControl) {
		this.memberControl = memberControl;
	}

	public void setProjectControl(ProjectControl projectControl) {
		this.projectControl = projectControl;
	}

	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(socket.getInputStream());
			PrintStream out = new PrintStream(socket.getOutputStream());
		
			while(true) {
				String command = scanner.nextLine();
				System.out.println("Client:" + command);
				
				if (command.equals("member")) {
					if (memberControl != null) {
						memberControl.execute(scanner, out);
					} else {
						out.println("구현되지 않은 메뉴입니다.");
					}
				} else if (command.equals("project")) {
					if (projectControl != null) {
						projectControl.execute(scanner, out);
					} else {
						out.println("구현되지 않은 메뉴입니다.");
					}
				} else if (command.equals("quit")) {
					out.println("goodbye");
					break;
				
				} else if (!command.equals("hello")){
					out.println("없는 메뉴입니다.");
				}
				
				printPrompt(out);
			}
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void printPrompt(PrintStream out) {
		out.println("메뉴>");
		out.println("@@?");
	}
}
