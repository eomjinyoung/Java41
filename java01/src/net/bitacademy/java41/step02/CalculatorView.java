package net.bitacademy.java41.step02;

import java.util.Scanner;

public class CalculatorView {
	private static int v1;
	private static String op;
	private static int v2;
	private static int result;
	private static Scanner scanner;
	
	static {
		scanner = new Scanner(System.in);
	}
	
	public static void inputForm() {
		System.out.print("값1:");
		v1 = Integer.parseInt( scanner.nextLine() );
		
		System.out.print("연산자:");
		op = scanner.nextLine();
		
		System.out.print("값2:");
		v2 = Integer.parseInt( scanner.nextLine() );
	}
	
	public static void compute() {
		result = Calculator.compute(v1, op, v2);
	}
	
	public static void outputResult() {
		System.out.println("------------------------------");
		System.out.println(v1 + " " + op + " " + v2 + " =");
		System.out.println(result);
		System.out.println("------------------------------");
	}
	
	public static boolean promptContinue() {
		System.out.print("계속 하시겠습니까?(y/n)");
		String str = scanner.nextLine();
		
		if (str.equals("y")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		// Refactoring: replace temp with query
		// - 한 번 밖에 사용되지 않는 임시 변수는 직접 메서드 호출로 대체한다.
		
		//boolean yes = true;
		do {
			inputForm();
			compute();
			outputResult();
			//yes = promptContinue();
		} while(/*yes*/promptContinue());
	}

}









