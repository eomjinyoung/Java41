package net.bitacademy.java41.test.step1;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class AccAppSkeleton {
	public static void main(String[] args) throws Exception {
		AccApp app = new AccApp();
		ServerSocket ss = new ServerSocket(8989);
		
		Socket socket = null;
		PrintStream out = null;
		Scanner in = null;
		String method = null;
		String name = null;
		int salary = 0;
		while(true) {
			socket = ss.accept();
			out = new PrintStream(socket.getOutputStream());
			in = new Scanner(socket.getInputStream());
			
			method = in.nextLine();
			if (method.equals("getSalary")) {
				name = in.nextLine();
				salary = app.getSalary(name);
				out.println(salary);
			} else if (method.equals("addSalary")) {
				name = in.nextLine();
				salary = Integer.parseInt(in.nextLine());
				app.addSalary(name, salary);
				out.println("ok");
			}
			
			out.close();
			in.close();
			socket.close();
		}
	}
}










