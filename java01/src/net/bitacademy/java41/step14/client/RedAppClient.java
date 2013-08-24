package net.bitacademy.java41.step14.client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class RedAppClient {
	protected Scanner keyboard;
	
	public RedAppClient() {
		keyboard = new Scanner(System.in);
	}

	public void execute() throws Exception {
		/* Socket
		 * - 서버에 연결할 때 사용.
		 * - 생성자에 연결할 서버의 주소와 포트번호를 넘긴다.
		 */
		Socket socket = new Socket("localhost", 8888);
		Scanner scanner = new Scanner(socket.getInputStream());
		PrintStream out = new PrintStream(socket.getOutputStream());
		
		out.println("hello");
		
		String command = null;
		String response = null;
		quit:
		while(true) {
			while(true) {
				response = scanner.nextLine();
				if (response.equals("goodbye")) {
					System.out.println("서버와의 연결을 끊었습니다!");
					break quit;
				} else if (response.equals("@@?")) {
					break;
				} else {
					System.out.println(response);
				}
			}
			
			command = keyboard.nextLine().toLowerCase();
			out.println(command);
		}
		
		out.close();
		scanner.close();
		socket.close();
	}

	public static void main(String[] args) throws Exception{
		RedAppClient app = new RedAppClient();
		app.execute();
	}
}

