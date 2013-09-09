package net.bitacademy.java41;

import java.util.Scanner;

/*
10,5

2,1

24,21

20,7

11,15

16,13

9,25

23,12

8,22

3,17

18,6

26,19

14,4
*/
public class TeamMaker {
	static int[] studentList = new int[26];
	static int[] absentList = {
		
	};
	
	static int cursor = 0;
	
	public static void main(String[] args) {
		int selectedNo = -1;
		while (cursor < 26) {
			selectedNo = (int)(Math.random() * 26 + 1);
			if (isExist(selectedNo)) {
				System.out.print(".");
				continue;
			} else {
				System.out.println(selectedNo);
				studentList[cursor] = selectedNo;
				cursor++;
			}
		}
		
		printTeam();
	}
	
	public static boolean isExist(int no) {
		for (int i = 0; i < cursor; i++) {
			if (studentList[i] == no) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void printTeam() {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < cursor; i += 2) {
			System.out.print(getLabel(studentList[i]));
			System.out.print(",");
			System.out.println(getLabel(studentList[i+1]));
			scanner.nextLine();
		}
	}
	
	public static String getLabel(int no) {
		for (int i = 0; i < absentList.length; i++) {
			if (absentList[i] == no) {
				return "X";
			}
		}
		
		return Integer.toString(no);
	}

}
