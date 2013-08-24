package net.bitacademy.java41.step03;

public class Calculator {
	// 중간 계산 결과를 저장할 변수 준비
	private static int result;
	
	public static void init(int v1) {
		result = v1;
	}
	
	public static int getResult() {
		return result;
	}
	
	public static int compute(String op, int v1) {
		switch(op) {
		case "+":
			result = plus(result, v1); break;
		case "-":
			result = minus(result, v1); break;
		case "*":
			result = multiple(result, v1); break;
		case "/":
			result = divide(result, v1); break;
		}
		
		return result;
	}
	
	private static int plus(int v1, int v2) {
		return v1 + v2;
	}
	
	private static int minus(int v1, int v2) {
		return v1 - v2;
	}
	
	private static int multiple(int v1, int v2) {
		return v1 * v2;
	}
	
	private static int divide(int v1, int v2) {
		return v1 / v2;
	}
}
