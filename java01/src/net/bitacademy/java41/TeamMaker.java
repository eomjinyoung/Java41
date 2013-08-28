package net.bitacademy.java41;

import java.util.Scanner;

/*

17,8

22,10

7,5

9,23

16,1

2,25

21,18

26,6

14,20

12,15

4,11

13,24

3,19
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
