package net.bitacademy.java41;

import java.util.Scanner;

/*
1팀:(박준혁,손창철,박유진,고유한,김영화)
2팀:(김상헌,공경식,이지우,안성헌)
3팀:(박치하,김태경,박재원,박혜경)
4팀:(장종혁,이진세,송재우,임재완)
5팀:(정재우,정선진,이영균,정승호)
6팀:(이용준,허승희,강윤원,오다환)
 */
public class TeamMaker2 {
	static int[] studentList = new int[19];
	static int[] absentList = {
		
	};
	
	static int cursor = 0;
	
	public static void main(String[] args) {
		int selectedNo = -1;
		while (cursor < studentList.length) {
			selectedNo = (int)(Math.random() * studentList.length + 1);
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
				new int[4],
				new int[3],
				new int[3],
				new int[3],
				new int[3],
				new int[3]
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
