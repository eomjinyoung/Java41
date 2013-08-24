package net.bitacademy.java41.step13;

import java.util.List;
import java.util.Scanner;

public class MemberControl {
	protected Scanner scanner;
	private Member member;
	private MemberDao memberDao;
	
	public MemberControl(MemberDao memberDao, Scanner scanner) {
		this.memberDao = memberDao;
		this.scanner = scanner;
	}

	public void execute() {
		while(true) {
			System.out.print("멤버관리>");
			String command = scanner.nextLine().toLowerCase();

			if (command.equals("add")) {
				member = null;
				add();
			} else if (command.equals("list")) {
				member = null;
				list();
			} else if (command.startsWith("view")) {
				String[] values = command.split(" ");
				view( values[1] );
			} else if (command.equals("update")) {
				if (member != null) {
					update();
				} else {
					System.out.println("먼저 멤버를 조회하세요!");
				}
			} else if (command.equals("delete")) {
				if (member != null) {
					detele();
				} else {
					System.out.println("먼저 멤버를 조회하세요!");
				}
			} else if (command.equals("menu")) {
				break;

			} else {
				System.out.println("지원하지 않는 명령어입니다.");
			}
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
			try {
				memberDao.add(m);
				System.out.println("등록되었습니다!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("등록 취소하였습니다!");
		}
	}

	private void list() {
		try {
			List<Member> list = memberDao.list();

			for(Member m : list) {
				System.out.print(m.getName() + ",");
				System.out.print(m.getPhone() + ",");
				System.out.println(m.getEmail());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void detele() {
		try {
			int count = memberDao.remove(member.getEmail());
			
			if (count > 0) {
				System.out.println("삭제되었습니다!");
			} else {
				System.out.println("해당 이메일의 멤버를 찾을 수 없습니다!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void update() {
		Member copy = member.clone();
		System.out.printf("이메일(%1$s):\n", member.getEmail());
		System.out.printf("이름(%1$s):", member.getName());
		String value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setName(value);
		}
		System.out.printf("전화(%1$s):", member.getPhone());
		value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setPhone(value);
		}
		System.out.printf("블로그(%1$s):", member.getBlog());
		value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setBlog(value);
		}
		System.out.printf("나이(%1$d):", member.getAge());
		value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setAge( Integer.parseInt(value) );
		}

		System.out.print("변경하시겠습니까?(y/n)");
		if(scanner.nextLine().toLowerCase().equals("y")){
			try {
				int count = memberDao.change(copy);
				
				if (count > 0) {
					System.out.println("변경되었습니다!");
				} else {
					System.out.println("해당 이메일의 멤버를 찾을 수 없습니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("변경 취소하였습니다!");
		}
	}

	private void view(String email) {
		try {
			this.member = memberDao.get(email);
			
			if (member != null) {
				System.out.println("이름:" + member.getName());
				System.out.println("전화:" + member.getPhone());
				System.out.println("이메일:" + member.getEmail());
				System.out.println("블로그:" + member.getBlog());
				System.out.println("나이:" + member.getAge());
				System.out.printf("등록일:%1$tY-%1$tm-%1$td \n", member.getRegDate());
			} else {
				System.out.println("해당 이메일의 멤버가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
