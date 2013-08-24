package net.bitacademy.java41.step08.test;

public class ExceptionTest {

	public static void main(String[] args) {
		case1();
		//case2();
		//case3();
	}
	
	// 예외처리 방법1
	// - 오류 발생 시 자신이 처리하지 않고 호출자에게 떠 넘긴다.
	// - 호출자에게 오류를 넘기기 위해서는 메서드 선언부에 어떤 오류를 넘길지 선언해야 한다.
	// - 문법
	// void method throws 떠넘길오류클래스명, 떠넘길오류클래스명, ... { 
	// 
	// }
	public static void case1()  {
		System.out.println("작업 준비...");
		work();
		System.out.println("다른 작업...");
	}
	
	// 예외처리 방법2
	// - try... catch 문법을 사용하여 오류를 적절히 처리하여 시스템이 멈추지 않게 한다.
	// - 이것이 예외처리 문법의 존재이유이다.
	// - 문법
	/*	try {
	 * 		...
	 * 	} catch ( 파라미터 선언 ) {
	 * 		...
	 * 	} catch ( 파라미터 선언 ) {
	 * 		...
	 * 	} ...
	 * 
	 */
	public static void case2() {
		System.out.println("작업 준비...");
		try {
			work();
		} catch (Error e) {
			System.out.println("오류 났네요. 그래도 계속 고~~~");
		}
		System.out.println("다른 작업...");
	}
	
	// 예외처리 방법3
	// - 예외 발생 시 '방법2'와 같이 적절한 처리를 한다.
	// - 추가적으로 보고도 한다.
	// - 예외 발생 상황을 호출자에게 전달할 필요가 있을 때
	// - 문법
	/*	try {
	 * 		...
	 * 	} catch ( 파라미터 선언 ) {
	 * 		throw 보고;
	 * 	} catch ( 파라미터 선언 ) {
	 * 		throw 보고;
	 * 	} finally {
	 * 		예외 처리 
	 * 	}
	 * - finally 블럭은 try...catch 블럭을 탈출하기 전에 반드시 수행된다.
	 */
	public static void case3() throws Error{
		System.out.println("작업 준비...");
		try {
			work();
			int a = 20;
			if (a == 20)
				return;
		} catch (Error e) {
			throw e;  // throw 명령어로 던질 수 있는 인스턴스는 오로지 Throwable 만 가능!
			/* Throwable 클래스
			 * - 예외 상황을 보고할 때 사용하는 클래스
			 * - 보통 예외 상황이 발생했을 때의 정보를 담고 있다. 
			 * - throw 명령어로 해당 객체를 호출자에게 전달한다.
			 * - 두 타입의 자식 클래스가 있다.
			 * 1) Exception 자식 클래스
			 * 		- 애플리케이션에 작업 도중에 발생하는 오류를 표현 
			 * 		- 이런 예외를 보고 받는 호출자는 반드시 오류 처리를 해야 한다.
			 * 		  만약 오류 처리를 하지 않으면, 컴파일 시 오류가 발생한다.
			 * 		- RuntimeException 
			 * 			: Error와 마찬가지로 호출자에게 던졌을 때 
			 * 			  오류를 잘 받는지 컴파일러가 검사하지 않는다.
			 * 2) Error 자식 클래스 
			 * 		- JVM 시스템에서 발생하는 오류를 표현 
			 * 		- 이런 예외를 보고 받는 호출자는 오류를 처리하지 않아도 컴파일 오류가 
			 * 		  발생하지 않는다.
			 */
			
			
		} finally {
			System.out.println("예외에 대해 일단 마무리 조치를 했습니다.");
		}
		System.out.println("다른 작업...");
	}
	
	public static void work() {
		throw new Error("오호라.. 오류!");
	}

}








