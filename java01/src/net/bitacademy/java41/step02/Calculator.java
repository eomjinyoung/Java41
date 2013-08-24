package net.bitacademy.java41.step02;

// 클래스 이름 명명법
// - 역할 명을 부여한다.
// - 명사로 작성한다.
// 메서드 이름 명명법
// - 소속 역할을 수행하는데 필요한 기능명을 부여한다.
// - 일을 시키는 형태로, 주로 동사로 시작한다.
public class Calculator {
	public static int compute(int v1, String op, int v2) {
		switch(op) {
		case "+":
			return plus(v1, v2);
		case "-":
			return minus(v1, v2);
		case "*":
			return multiple(v1, v2);
		case "/":
			return divide(v1, v2);
		}
		
		return 0;
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
