package net.bitacademy.java41.step04;

public class CalcTest {
	public static void main(String[] args) {
		// (10 + 20) * 3 = 90
		// 10 / 2 + 30 = 35
		
		// 위의 계산을 병행하여 수행하기!
		// 1. step03의 Calculator는 중간 계산결과를 보관하기 위해
		//    클래스를 변수를 사용한다. ==> 병행 계산이 불가하다.
		net.bitacademy.java41.step03.Calculator.init(10);
		net.bitacademy.java41.step03.Calculator.init(10);

		net.bitacademy.java41.step03.Calculator.compute("+", 20);
		net.bitacademy.java41.step03.Calculator.compute("/", 2);

		net.bitacademy.java41.step03.Calculator.compute("*", 3);
		net.bitacademy.java41.step03.Calculator.compute("+", 30);
		
		System.out.println( net.bitacademy.java41.step03.Calculator.getResult());
		
		// 중간 계산 결과를 개별적으로 관리하기 방안 필요!
		// ==> 역할을 수행하는 동안 사용되는 값을 개별화 시키는 기법
		// ==> 인스턴스화
		// ==> 개별적으로 관리되어야 할 값은 인스턴스 변수에 저장해야 한다.
		// ==> 인스턴스 변수 만들기? static 을 빼라!
		// Calculator의 인스턴스 변수를 두 개 준비한다.
		
		// stack 메모리 영역
		// - 메서드에서 만드는 로컬 변수를 저장
		// - 메서드 호출이 끝나면 그 메서드를 위해 만들었던 모든 변수를 삭제.
		// Heap 메모리 영역
		// - 인스턴스 변수를 저장
		
		Calculator c1 = new Calculator(); // JVM에게 명령하노니, 
						  // Calculator 클래스를 확인하여 인스턴스 변수가
		                  // 있다면 해당 변수를 Heap 영역에 준비하라!
						  // => 인스턴스 생성! 
						  // => 인스턴스 변수가 시작되는 바이트의 주소를 리턴 
						  // c1 변수는 인스턴스의 시작 주소를 저장한다. 주소 변수. 포인터 변수.
		
		Calculator c2 = new Calculator();
		
		// c1: (10 + 20) * 3 = 90
		// c2: 10 / 2 + 30 = 35
		
		Calculator.init(c1, 10);
		Calculator.init(c2, 10);
		
		Calculator.compute(c1, "+", 20);
		Calculator.compute(c2, "/", 2);
		
		Calculator.compute(c1, "*", 3);
		Calculator.compute(c2, "+", 30);
		
		System.out.println(Calculator.getResult(c1));
		System.out.println(Calculator.getResult(c2));
		
	}

}





















