package net.bitacademy.java41.step13;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class ProjectControl {
	protected Scanner scanner;
	private Project project;
	private ProjectDao projectDao;
	
	public ProjectControl(ProjectDao projectDao, Scanner scanner) {
		this.projectDao = projectDao;
		this.scanner = scanner;
	}

	public void execute() {
		while(true) {
			System.out.print("프로젝트관리>");
			String command = scanner.nextLine().toLowerCase();

			if (command.equals("list")) {
				project = null;
				list();
			} else if (command.equals("add")) {
				project = null;
				add();
			} else if (command.startsWith("view")) {
				String[] values = command.split(" ");
				view( Integer.parseInt(values[1]) );
			} else if (command.equals("update")) {
				if (project != null) {
					update();
				} else {
					System.out.println("먼저 프로젝트를 조회하세요!");
				}
			} else if (command.equals("delete")) {
				if (project != null) {
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
	
	private void list() {
		try {
			List<Project> list = projectDao.list();

			for(Project project : list) {
				System.out.print(project.getNo() + ",");
				System.out.print(project.getTitle() + ",");
				System.out.print(project.getStartDate() + ",");
				System.out.println(project.getEndDate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void add(){
		Project project = new Project();
		System.out.print("관리자 이메일(예: test@test.com) : ");
		project.setManagerEmail(scanner.nextLine());
		System.out.print("제목 : ");
		project.setTitle(scanner.nextLine());
		
		System.out.println("내용(입력종료는 빈라인) : ");
		String temp = null;
		StringBuffer buffer = new StringBuffer();
		while(true) {
			temp = scanner.nextLine();
			if (temp.equals("")) break;
			buffer.append(temp + "\n");
		}
		project.setContent(buffer.toString());
		
		while(true) {
			System.out.print("시작일(예: 2013-08-21) : ");
			try {
				project.setStartDate(Date.valueOf(scanner.nextLine()));
				break;
			} catch (Exception e) {
				System.out.println("날짜 형식이 맞지 않습니다. 다시 입력하세요!");
			}
		}
		
		while(true) {
			System.out.print("종료일(예: 2013-08-21) : ");
			try {
				project.setEndDate(Date.valueOf(scanner.nextLine()));
				break;
			} catch (Exception e) {
				System.out.println("날짜 형식이 맞지 않습니다. 다시 입력하세요!");
			}
		}
		
		/*
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		System.out.print("시작일(예: 8/21/2013) : ");
		try {
			java.util.Date date = df.parse(scanner.nextLine());
			project.setStartDate(new Date(date.getTime()));
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.print("종료일(예: 8/30/2013) : ");
		try {
			java.util.Date date = df.parse(scanner.nextLine());
			project.setEndDate(new Date(date.getTime()));
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		System.out.print("등록하시겠습니까?(y/n)");
		if(scanner.nextLine().toLowerCase().equals("y")){
			try {
				projectDao.add(project);
				System.out.println("등록되었습니다!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("등록 취소하였습니다!");
		}
	}

	private void view(int no) {
		try {
			this.project = projectDao.get(no);
			
			if (project != null) {
				System.out.println("번호:" + project.getNo());
				System.out.println("제목:" + project.getTitle());
				System.out.println("내용:");
				System.out.println(project.getContent());
				System.out.printf("시작일:%1$tY-%1$tm-%1$td \n", project.getStartDate());
				System.out.printf("종료일:%1$tY-%1$tm-%1$td \n", project.getEndDate());
				System.out.println("관리자:" + project.getManagerEmail());
			} else {
				System.out.println("해당 번호의 프로젝트가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	private void update() {
		Project copy = project.clone();
		System.out.printf("번호(%1$d):\n", project.getNo());
		System.out.printf("관리자(%1$s):", project.getManagerEmail());
		String value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setManagerEmail(value);
		}
		System.out.printf("제목(%1$s):", project.getTitle());
		value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setTitle(value);
		}
		System.out.println("내용(입력종료는 빈라인) : ");
		String temp = null;
		StringBuffer buffer = new StringBuffer();
		while(true) {
			temp = scanner.nextLine();
			if (temp.equals("")) break;
			buffer.append(temp + "\n");
		}
		copy.setContent(buffer.toString());
		
		System.out.printf("시작일(%1$tY-%1$tm-%1$td) :", project.getStartDate());
		try {
			copy.setStartDate(Date.valueOf(scanner.nextLine()));
		} catch (Exception e) {}
		
		System.out.printf("종료일(%1$tY-%1$tm-%1$td) :", project.getEndDate());
		try {
			copy.setEndDate(Date.valueOf(scanner.nextLine()));
		} catch (Exception e) {}
		
		System.out.print("변경하시겠습니까?(y/n)");
		if(scanner.nextLine().toLowerCase().equals("y")){
			try {
				int count = projectDao.change(copy);
				
				if (count > 0) {
					System.out.println("변경되었습니다!");
				} else {
					System.out.println("해당 번호의 프로젝트를 찾을 수 없습니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("변경 취소하였습니다!");
		}
	}
	private void detele() {
		System.out.print("정말 삭제하시겠습니까?(y/n)");
		if(scanner.nextLine().toLowerCase().equals("y")){
			try {
				
				int count = projectDao.remove(project.getNo());
				
				if (count > 0) {
					System.out.println("삭제되었습니다!");
				} else {
					System.out.println("해당 번호의 프로젝트를 찾을 수 없습니다!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("삭제 취소하였습니다.");
		}
	}

}
