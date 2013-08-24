package net.bitacademy.java41.step05;

public class Calculator {
	// 중간 계산 결과를 저장할 변수 준비
	// 인스턴스 메서드
	// - static 붙지 않는다.
	// - 호출할 때 반드시 인스턴스 주소를 앞에 붙여야 한다.
	//   ex) c1.compute(...)
	private int result;
	
	public void init(/*Calculator this,*/ int v1) {
		this.result = v1;
	}
	
	public int getResult(/*Calculator this,*/) {
		return this.result;
	}
	
	public int compute(/*Calculator this,*/ String op, int v1) {
		switch(op) {
		case "+":
			this.result = plus(this.result, v1); break;
		case "-":
			this.result = minus(this.result, v1); break;
		case "*":
			this.result = multiple(this.result, v1); break;
		case "/":
			this.result = divide(this.result, v1); break;
		}
		
		return this.result;
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
