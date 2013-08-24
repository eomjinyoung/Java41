package net.bitacademy.java41.step15.server;

import java.io.PrintStream;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import net.bitacademy.java41.step15.Project;

public class ProjectControl {
	private Project project;
	private ProjectDao projectDao;
	
	public ProjectControl(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public void execute(Scanner scanner, PrintStream out) {
		while(true) {
			printPrompt(out);
			
			String command = scanner.nextLine();

			if (command.equals("list")) {
				project = null;
				list(scanner, out);
			} else if (command.equals("add")) {
				project = null;
				add(scanner, out);
			} else if (command.startsWith("view")) {
				String[] values = command.split(" ");
				view(scanner, out, Integer.parseInt(values[1]) );
			} else if (command.equals("update")) {
				if (project != null) {
					update(scanner, out);
				} else {
					out.println("먼저 프로젝트를 조회하세요!");
				}
			} else if (command.equals("delete")) {
				if (project != null) {
					detele(scanner, out);
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
		out.println("프로젝트관리>");
		out.println("@@?");
	}
	
	private void list(Scanner scanner, PrintStream out) {
		try {
			List<Project> list = projectDao.list();

			for(Project project : list) {
				out.print(project.getNo() + ",");
				out.print(project.getTitle() + ",");
				out.print(project.getStartDate() + ",");
				out.println(project.getEndDate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void add(Scanner scanner, PrintStream out){
		Project project = new Project();
		out.println("관리자 이메일(예: test@test.com) : \n@@?");
		project.setManagerEmail(scanner.nextLine());
		out.println("제목 : \n@@?");
		project.setTitle(scanner.nextLine());
		
		out.println("내용(입력종료는 빈라인) : \n@@?");
		String temp = null;
		StringBuffer buffer = new StringBuffer();
		while(true) {
			temp = scanner.nextLine();
			if (temp.equals("")) {
				break;
			} else {
				out.println("@@?");
			}
			buffer.append(temp + "\n");
		}
		project.setContent(buffer.toString());
		
		while(true) {
			out.println("시작일(예: 2013-08-21) : \n@@?");
			try {
				project.setStartDate(Date.valueOf(scanner.nextLine()));
				break;
			} catch (Exception e) {
				out.println("날짜 형식이 맞지 않습니다. 다시 입력하세요!");
			}
		}
		
		while(true) {
			out.println("종료일(예: 2013-08-21) : \n@@?");
			try {
				project.setEndDate(Date.valueOf(scanner.nextLine()));
				break;
			} catch (Exception e) {
				out.println("날짜 형식이 맞지 않습니다. 다시 입력하세요!");
			}
		}
		
		out.println("등록하시겠습니까?(y/n)\n@@?");
		if(scanner.nextLine().equals("y")){
			try {
				projectDao.add(project);
				out.println("등록되었습니다!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			out.println("등록 취소하였습니다!");
		}
	}

	private void view(Scanner scanner, PrintStream out, int no) {
		try {
			this.project = projectDao.get(no);
			
			if (project != null) {
				out.println("번호:" + project.getNo());
				out.println("제목:" + project.getTitle());
				out.println("내용:");
				out.println(project.getContent());
				out.printf("시작일:%1$tY-%1$tm-%1$td \n", project.getStartDate());
				out.printf("종료일:%1$tY-%1$tm-%1$td \n", project.getEndDate());
				out.println("관리자:" + project.getManagerEmail());
			} else {
				out.println("해당 번호의 프로젝트가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	private void update(Scanner scanner, PrintStream out) {
		Project copy = project.clone();
		out.printf("번호(%1$d):\n", project.getNo());
		out.printf("관리자(%1$s):\n@@?\n", project.getManagerEmail());
		String value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setManagerEmail(value);
		}
		out.printf("제목(%1$s):\n@@?\n", project.getTitle());
		value = scanner.nextLine();
		if (value.length() > 0) {
			copy.setTitle(value);
		}
		out.println("내용(입력종료는 빈라인) : \n@@?");
		String temp = null;
		StringBuffer buffer = new StringBuffer();
		while(true) {
			temp = scanner.nextLine();
			if (temp.equals("")) {
				break;
			} else {
				out.println("@@?");
			}
			buffer.append(temp + "\n");
		}
		copy.setContent(buffer.toString());
		
		out.printf("시작일(%1$tY-%1$tm-%1$td) :\n@@?\n", project.getStartDate());
		try {
			copy.setStartDate(Date.valueOf(scanner.nextLine()));
		} catch (Exception e) {}
		
		out.printf("종료일(%1$tY-%1$tm-%1$td) :\n@@?\n", project.getEndDate());
		try {
			copy.setEndDate(Date.valueOf(scanner.nextLine()));
		} catch (Exception e) {}
		
		out.println("변경하시겠습니까?(y/n)\n@@?");
		if(scanner.nextLine().equals("y")){
			try {
				int count = projectDao.change(copy);
				
				if (count > 0) {
					out.println("변경되었습니다!");
				} else {
					out.println("해당 번호의 프로젝트를 찾을 수 없습니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			out.println("변경 취소하였습니다!");
		}
	}
	private void detele(Scanner scanner, PrintStream out) {
		out.print("정말 삭제하시겠습니까?(y/n)\n@@?\n");
		if(scanner.nextLine().equals("y")){
			try {
				
				int count = projectDao.remove(project.getNo());
				
				if (count > 0) {
					out.println("삭제되었습니다!");
				} else {
					out.println("해당 번호의 프로젝트를 찾을 수 없습니다!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			out.println("삭제 취소하였습니다.");
		}
	}

}
