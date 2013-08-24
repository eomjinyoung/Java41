package net.bitacademy.java41.step09;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class RedApp {
	protected Scanner scanner;
	protected ArrayList<Member> list = new ArrayList<Member>();
	private int no;
	
	public RedApp() {
		scanner = new Scanner(System.in);
	}
	
	public void execute() {
		while(true) {
			System.out.print("명령>");
			String command = scanner.nextLine().toLowerCase();
			
			if (command.equals("add")) {
				no = 0;
				add();
			} else if (command.equals("list")) {
				no = 0;
				list();
			} else if (command.startsWith("view")) {
				//명령>view 2
				String[] values = command.split(" ");
				no = Integer.parseInt(values[1]);
				view( no );
			} else if (command.equals("update")) {
				if (no > 0) {
					update();
				} else {
					System.out.println("먼저 멤버를 조회하세요!");
				}
			} else if (command.equals("delete")) {
				if (no > 0) {
					detele();
				} else {
					System.out.println("먼저 멤버를 조회하세요!");
				}
			} else if (command.equals("quit")) {
				System.out.println("안녕!");
				break;
			} else if (command.startsWith("save")) {
				String[] values = command.split(" ");
				String filename = "default.data";
				if (values.length > 1) { //저장할 파일을 지정한 경우,
					filename = values[1];
				}
				
				save(filename);
				
			}  else if (command.startsWith("open")) {
				String[] values = command.split(" ");
				String filename = "default.data";
				if (values.length > 1) { //저장할 파일을 지정한 경우,
					filename = values[1];
				}
				
				open(filename);
				
			} else {
				System.out.println("지원하지 않는 명령어입니다.");
			}
		}
	}
	
	private void open(String filename) {
		list.clear();
		
		FileInputStream in = null;
		ObjectInputStream in2 = null;
		try {
			in = new FileInputStream(filename);
			in2 = new ObjectInputStream(in);
			
			Member m = null;
			while(true) {
				try {
					m = (Member)in2.readObject();
					list.add(m);
				} catch (EOFException e) {
					break;
				}
			}
			System.out.println("데이터 로딩 완료!");
		} catch(Exception e) {
			System.out.println("데이터 로딩 중 오류발생!");
			e.printStackTrace();
		} finally {
			try{in2.close();} catch(Exception e) {}
			try{in.close();} catch(Exception e) {}
		}
	}

	private void save(String filename) {
		FileOutputStream out = null;
		ObjectOutputStream out2 = null;
		try {
			out = new FileOutputStream(filename);
			out2 = new ObjectOutputStream(out);
			
			for(Member m : list) {
				out2.writeObject(m);
			}
			
			System.out.println("저장되었습니다!");
		} catch (Exception e) {
			System.out.println("파일저장 중에 오류가 발생했습니다!");
		} finally {
			try {out2.close();} catch(Exception e) {}
			try {out.close();} catch(Exception e) {}
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
			list.add(m);
			System.out.println("등록되었습니다!");
		} else {
			System.out.println("등록 취소하였습니다!");
		}
	}
	
	private void list() {
		System.out.printf("%1$3s %2$10s %3$15s %4$30s\n", 
				"번호", "이름", "전화", "이메일");
		/*
		for(int i = 0; i < list.size(); i++) {
			Member m = list.get(i);
		}
		*/
		// 위의 for문 보다 간결한 표현식
		int no = 1;
		for(Member m : list) {
			System.out.printf("%1$3d %2$10s %3$15s %4$30s\n", 
				no++, m.getName(), m.getPhone(), m.getEmail());
		}
	}
	
	private void detele() {
		list.remove(no - 1);
		no = 0;
		System.out.println("삭제되었습니다!");
	}

	private void update() {
		Member m = list.get(no - 1);
		Member copy = m.clone();
		System.out.printf("번호(%1$d):", no);
		System.out.printf("이름(%1$s):", m.getName());
		String value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setName(value);
		}
		System.out.printf("전화(%1$s):", m.getPhone());
		value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setPhone(value);
		}
		System.out.printf("이메일(%1$s):", m.getEmail());
		value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setEmail(value);
		}
		System.out.printf("블로그(%1$s):", m.getBlog());
		value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setBlog(value);
		}
		System.out.printf("나이(%1$d):", m.getAge());
		value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setAge( Integer.parseInt(value) );
		}
		
		System.out.print("변경하시겠습니까?(y/n)");
		if(scanner.nextLine().toLowerCase().equals("y")){
			copy.setRegDate(new Date());
			list.set(no-1, copy);
			System.out.println("변경되었습니다!");
		} else {
			System.out.println("변경 취소하였습니다!");
		}
	}

	private void view(int no) {
		if (no > 0 && no <= list.size()) {
			Member m = list.get(no - 1);
			System.out.println("번호:" + no);
			System.out.println("이름:" + m.getName());
			System.out.println("전화:" + m.getPhone());
			System.out.println("이메일:" + m.getEmail());
			System.out.println("블로그:" + m.getBlog());
			System.out.println("나이:" + m.getAge());
			System.out.printf("등록일:%1$tY-%1$tm-%1$td \n", m.getRegDate());
		} else {
			System.out.println("존재하지 않는 멤버의 번호입니다.");
		}
	}

	public static void main(String[] args) {
		// * 인스턴스 생성
		// - 개별적으로 값을 다루기 위해, 클래스에 선언된
		//   인스턴스 변수를 준비
		// - 인스턴스가 사용되기 전에 필요한 작업을 수행하도록
		//   생성자 메서드를 호출한다.
		RedApp app = new RedApp();
		app.execute();
	}
}








