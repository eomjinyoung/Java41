package net.bitacademy.java41.test.step1;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class AccAppStub {
	String ip;
	int port;
	
	public AccAppStub(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	public int getSalary(String name) throws Exception {
		Socket socket = new Socket(ip, port);
		PrintStream out = new PrintStream(socket.getOutputStream());
		Scanner in = new Scanner(socket.getInputStream());
		
		out.println("getSalary");
		out.println(name);
		out.flush();
		
		int salary = Integer.parseInt(in.nextLine());
		
		out.close();
		in.close();
		socket.close();
		
		return salary;
	}
	
	public void addSalary(String name, int salary) throws Exception {
		Socket socket = new Socket("localhost", 8989);
		PrintStream out = new PrintStream(socket.getOutputStream());
		Scanner in = new Scanner(socket.getInputStream());
		
		out.println("addSalary");
		out.println(name);
		out.println(salary);
		out.flush();
		
		System.out.println(in.nextLine());
		
		out.close();
		in.close();
		socket.close();
	}
	
	
}










