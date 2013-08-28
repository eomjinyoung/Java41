package net.bitacademy.java41.servlets.test;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HttpServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8989);
		
		Socket s = ss.accept();
		Scanner in = new Scanner(s.getInputStream());
		PrintStream out = new PrintStream(s.getOutputStream());
		
		String line = null;
		while(true) {
			try {
				line = in.nextLine();
				if (line.equals("")) {
					break;
				} else { 
					System.out.println(line);
				}
			} catch(Exception e) {
				break;
			}
		}
		
		out.println("HTTP/1.1 200 ok");
		out.println("Date: Wed, 28 Aug 2013 02:33:46 GMT");
		out.println("Content-Type: text/plain");
		out.println("Connection: close");
		out.println();
		out.println("Welcome to my webserver!");
		out.flush();
		
		out.close();
		in.close();
		s.close();
		ss.close();
	}
}











