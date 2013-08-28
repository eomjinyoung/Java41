package net.bitacademy.java41.servlets.test;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class HttpClient {

	public static void main(String[] args) throws Exception{
		while(true) {
			Socket socket = new Socket("www.president.go.kr", 80);
			Scanner in = new Scanner(socket.getInputStream());
			PrintStream out = new PrintStream(socket.getOutputStream());
			
			out.println("GET /news/newsList.php HTTP/1.1");
			out.println("Host: www.president.go.kr");
			out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			out.println("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.57 Safari/537.36");
			out.println("Cookie: __atuvc=1%7C21; PHPSESSID=8a88696c670dd0b26ee2042811a958a9");
			out.println();
			
			while(true) {
				try {System.out.println(in.nextLine());} catch(Exception e) {break;}
			}
			
			in.close();
			out.close();
			socket.close();
		}
	}

}
