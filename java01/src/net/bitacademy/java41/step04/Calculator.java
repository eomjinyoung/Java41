package net.bitacademy.java41.step04;

public class Calculator {
	// 중간 계산 결과를 저장할 변수 준비
	// 인스턴스 변수
	// - 개별적으로 관리되는 변수
	// - Heap 영역에 존재한다.
	// - new 라는 명령어로 인스턴스 변수를 Heap에 만들 수 있다.
	// - ex) new Calcualtor();
	private int result;
	
	public static void init(Calculator instance, int v1) {
		instance.result = v1;
	}
	
	public static int getResult(Calculator instance) {
		return instance.result;
	}
	
	public static int compute(Calculator instance, String op, int v1) {
		switch(op) {
		case "+":
			instance.result = plus(instance.result, v1); break;
		case "-":
			instance.result = minus(instance.result, v1); break;
		case "*":
			instance.result = multiple(instance.result, v1); break;
		case "/":
			instance.result = divide(instance.result, v1); break;
		}
		
		return instance.result;
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
