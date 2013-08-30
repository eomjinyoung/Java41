package net.bitacademy.java41;

import java.util.Scanner;

/*
3,4

13,25

23,7

6,2

18,24

11,12

15,19

9,21

17,16

22,8

20,10

14,1

5,26
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
