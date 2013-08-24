package net.bitacademy.java41.step07;

import java.util.Scanner;

public class RedApp01 {
	protected Scanner scanner;
	private String name;
	private String phone;
	private String email;
	private String blog;
	// * 생성자
	// - 인스턴스가 사용되기 전에 역할을 수행하는데 필요한 
	//   최소한의 것을 준비하는 메서드
	// * default constructor
	// - 파라미터가 없는 생성자.
	// - 클래스에 명시적으로 선언된 생성자가 없다면,
	//   컴파일러가 자동으로 기본 생성자를 추가한다.
	//		public RedApp() {}

	public RedApp01() {
		scanner = new Scanner(System.in);
	}
	
	public void add(){
		System.out.print("이름 : ");
		name = scanner.nextLine();
		System.out.print("전화번호 : ");
		phone = scanner.nextLine();
		System.out.print("이메일 : ");
		email = scanner.nextLine();
		System.out.print("블로그 : ");
		blog = scanner.nextLine();
		System.out.print("등록하시겠습니까?(y/n)");
		if(scanner.nextLine().toLowerCase().equals("y")){
			System.out.println("등록되었습니다!");
		} else {
			System.out.println("등록 취소하였습니다!");
		}
	}
	
	public void execute() {
		while(true) {
			System.out.print("명령>");
			String command = scanner.nextLine();
			
			if (command.equals("add")) {
				
				add();
			} else if (command.equals("list")) {
				System.out.println("멤버 목록 출력!");
			} else if (command.equals("view")) {
				System.out.println("멤버 상세정보 출력!");
			} else if (command.equals("update")) {
				System.out.println("멤버 정보 변경!");
			} else if (command.equals("delete")) {
				System.out.println("멤버 삭제!");
			} else if (command.equals("quit")) {
				System.out.println("안녕!");
				break;
			}
		}
	}
	
	
	public static void main(String[] args) {
		// * 인스턴스 생성
		// - 개별적으로 값을 다루기 위해, 클래스에 선언된
		//   인스턴스 변수를 준비
		// - 인스턴스가 사용되기 전에 필요한 작업을 수행하도록
		//   생성자 메서드를 호출한다.
		RedApp01 app = new RedApp01();
		app.execute();
	}
}








