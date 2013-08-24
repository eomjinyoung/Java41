package net.bitacademy.java41.step03;

public class CalcTest {
	// * 참고: 용어 정리
	// Calculator ==> 클래스 이름
	// net.bitacademy.java41.step03.Calculator 
	//		==> 패키지명 + 클래스명 = fully-qualified name = QName
	public static void main(String[] args) {
		// (10 + 20) * 3 = 90
		//1. step02 의 Calculator는 중간 결과 값을 관리하지 않는다.
		int result = net.bitacademy.java41.step02.Calculator.compute(10, "+", 20);
		result = net.bitacademy.java41.step02.Calculator.compute(result, "*", 3);
		System.out.println(result);
		
		//2. step03의 Calculator는 중간 결과 값을 관리해준다.
		Calculator.init(10);
		Calculator.compute("+", 20);
		Calculator.compute("*", 3);
		System.out.println( Calculator.getResult());
	}

}
