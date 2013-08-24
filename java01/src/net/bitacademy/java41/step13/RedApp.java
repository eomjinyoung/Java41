package net.bitacademy.java41.step13;

import java.util.Scanner;

public class RedApp {
	protected Scanner scanner;
	private MemberDao memberDao;
	private MemberControl memberControl;
	private ProjectDao projectDao;
	private ProjectControl projectControl;
	
	public RedApp() {
		scanner = new Scanner(System.in);
		
		DBConnectionPool conPool = new DBConnectionPool(
			"jdbc:mysql://localhost/test", 
			"test", 
			"test",
			System.getProperty("driverClass"));
		
		memberDao = new MemberDao(conPool);
		memberControl = new MemberControl(memberDao, scanner);
		
		projectDao = new ProjectDao(conPool);
		projectControl = new ProjectControl(projectDao, scanner);
	}

	public void execute() {
		while(true) {
			System.out.print("메뉴>");
			String command = scanner.nextLine().toLowerCase();

			if (command.equals("member")) {
				memberControl.execute();
				
			} else if (command.equals("project")) {
				projectControl.execute();
				
			} else if (command.equals("quit")) {
				System.out.println("안녕!");
				break;
				
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		}
	}

	public static void main(String[] args) {
		RedApp app = new RedApp();
		app.execute();
	}
}


/* RedApp 사용 명세 */
/*
 * 메뉴>member
 * 멤버관리>list
 * ...
 * 멤버관리>view test@test.com
 * ...
 * 멤버관리>menu
 * 메뉴>project
 * 프로젝트관리>list
 * 번호,제목,시작일,종료일
 * ...
 * 프로젝트관리>view 프로젝트번호
 * 번호: 1
 * 제목: ....
 * 내용: 
 * ....
 * ...
 * 시작일: 2013-08-20
 * 종료일: 2013-10-31
 * 관리자: hong@test.com
 * 프로젝트관리>update
 * ...
 * 프로젝트관리>delete
 * 정말 삭제하시겠습니까?(y/n)y
 * 삭제되었습니다.
 * 정말 삭제하시겠습니까?(y/n)n
 * 삭제 취소하였습니다.
 * 프로젝트관리>add
 * 제목: ...
 * 내용:
 * ...
 * 시작일: 2013-08-20
 * 종료일: 2013-10-20
 * 관리자: hong@test.com
 * 
 * 프로젝트관리>menu
 * 메뉴>quit
 * 안녕!
 */







