package net.bitacademy.java41.step07;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class RedApp {
	protected Scanner scanner;
	protected ArrayList<Member> list = new ArrayList<Member>();
	private int no;
	
	// * 생성자
	// - 인스턴스가 사용되기 전에 역할을 수행하는데 필요한 
	//   최소한의 것을 준비하는 메서드
	// * default constructor
	// - 파라미터가 없는 생성자.
	// - 클래스에 명시적으로 선언된 생성자가 없다면,
	//   컴파일러가 자동으로 기본 생성자를 추가한다.
	//		public RedApp() {}

	public RedApp() {
		scanner = new Scanner(System.in);
		
		list.add(new Member()
					.setName("홍길동")
					.setPhone("111-2222")
					.setEmail("hong@test.com")
					.setBlog("hong.blogspot.com")
					.setAge(20)
					.setRegDate(new Date()));
		list.add(new Member()
					.setName("임꺽정")
					.setPhone("111-3333")
					.setEmail("leem@test.com")
					.setBlog("leem.blogspot.com")
					.setAge(30)
					.setRegDate(new Date()));
		list.add(new Member()
					.setName("일지매")
					.setPhone("111-4444")
					.setEmail("ill@test.com")
					.setBlog("ill.blogspot.com")
					.setAge(40)
					.setRegDate(new Date()));
		
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
	
	public void execute() {
		while(true) {
			System.out.print("명령>");
			String command = scanner.nextLine();
			
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
			}
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








