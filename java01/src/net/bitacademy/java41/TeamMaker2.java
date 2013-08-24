package net.bitacademy.java41;

import java.util.Scanner;

/*

*/
public class TeamMaker2 {
	static int[] studentList = new int[27];
	static int[] absentList = {
		
	};
	
	static int cursor = 0;
	
	public static void main(String[] args) {
		int selectedNo = -1;
		while (cursor < 27) {
			selectedNo = (int)(Math.random() * 27 + 1);
			if (isExist(selectedNo)) {
				//System.out.print(".");
				continue;
			} else {
				//System.out.println(selectedNo);
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
		int[][] teams = new int[][]{
				new int[5],
				new int[5],
				new int[5],
				new int[4],
				new int[4],
				new int[4]
		};
		
		int no = 0;
		teamLabel: 
		
		for(int i = 0; i < 5; i++) {
			for(int team = 0; team < teams.length; team++) {
				if (no < cursor) {
					teams[team][i] = studentList[no++];
				} else {
					break teamLabel;
				}
			}
		}
		
		for(int team = 0; team < teams.length; team++) {
			for(int i = 0; i < teams[team].length; i++) {
				System.out.print(teams[team][i] + ",");
			}
			System.out.println();
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
