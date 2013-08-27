package net.bitacademy.java41.servlets;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

public class MemberServlet {
	private MemberDao memberDao;
	
	public MemberServlet(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void execute(Scanner scanner, PrintStream out) {
		Member member = null;
		while(true) {
			printPrompt(out);
			
			String command = scanner.nextLine();

			if (command.equals("list")) {
				member = null;
				list(scanner, out);
			} else if (command.equals("add")) {
				member = null;
				add(scanner, out);
			} else if (command.startsWith("view")) {
				String[] values = command.split(" ");
				member = view(scanner, out, values[1] );
			} else if (command.equals("update")) {
				if (member != null) {
					update(member, scanner, out);
				} else {
					out.println("먼저 멤버를 조회하세요!");
				}
			} else if (command.equals("delete")) {
				if (member != null) {
					detele(member.getEmail(), scanner, out);
				} else {
					out.println("먼저 멤버를 조회하세요!");
				}
			 
			} else if (command.equals("menu")) {
				break;

			} else {
				out.println("지원하지 않는 명령어입니다.");
			}
		}
	}
	
	private void printPrompt(PrintStream out) {
		out.println("멤버관리>");
		out.println("@@?");
	}
	
	private void list(Scanner scanner, PrintStream out) {
		try {
			List<Member> list = memberDao.list();

			for(Member m : list) {
				out.println(m.getName() + ","
					+ m.getPhone() + ","
					+ m.getEmail());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void add(Scanner scanner, PrintStream out){
		Member m = new Member();
		out.println("이름 : \n@@?");
		m.setName(scanner.nextLine());
		out.println("전화번호 : \n@@?");
		m.setPhone(scanner.nextLine());
		out.println("이메일 : \n@@?");
		m.setEmail(scanner.nextLine());
		out.println("블로그 : \n@@?");
		m.setBlog(scanner.nextLine());
		out.println("나이 : \n@@?");
		m.setAge( Integer.parseInt( scanner.nextLine() ) );

		out.println("등록하시겠습니까?(y/n)\n@@?");
		if(scanner.nextLine().equals("y")){
			try {
				memberDao.add(m);
				out.println("등록되었습니다!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			out.println("등록 취소하였습니다!");
		}
	}

	private Member view(Scanner scanner, PrintStream out, String email) {
		try {
			Member member = memberDao.get(email);
			
			if (member != null) {
				out.println("이름:" + member.getName());
				out.println("전화:" + member.getPhone());
				out.println("이메일:" + member.getEmail());
				out.println("블로그:" + member.getBlog());
				out.println("나이:" + member.getAge());
				out.printf("등록일:%1$tY-%1$tm-%1$td \n", member.getRegDate());
				
				return member;
			} else {
				out.println("해당 이메일의 멤버가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private void update(Member member, Scanner scanner, PrintStream out) {
		Member copy = member.clone();
		out.printf("이메일(%1$s):\n", member.getEmail());
		out.printf("이름(%1$s):\n@@?\n", member.getName());
		String value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setName(value);
		}
		out.printf("전화(%1$s):\n@@?\n", member.getPhone());
		value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setPhone(value);
		}
		out.printf("블로그(%1$s):\n@@?\n", member.getBlog());
		value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setBlog(value);
		}
		out.printf("나이(%1$d):\n@@?\n", member.getAge());
		value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setAge( Integer.parseInt(value) );
		}

		out.println("변경하시겠습니까?(y/n)\n@@?");
		if(scanner.nextLine().toLowerCase().equals("y")){
			try {
				int count = memberDao.change(copy);
				
				if (count > 0) {
					out.println("변경되었습니다!");
				} else {
					out.println("해당 이메일의 멤버를 찾을 수 없습니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			out.println("변경 취소하였습니다!");
		}
	}

	private void detele(String email, Scanner scanner, PrintStream out) {
		try {
			int count = memberDao.remove(email);
			
			if (count > 0) {
				out.println("삭제되었습니다!");
			} else {
				out.println("해당 이메일의 멤버를 찾을 수 없습니다!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
