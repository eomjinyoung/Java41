package net.bitacademy.java41.step01;

// import 문장 선언 시 *를 사용하기 보다는 가능한 정확하게 선언
// - 컴파일 속도를 조금이라도 빠르게 할 수 있다.
// - 코드의 가독성을 높인다.
// - 컴파일 시에 참고하는 용도 -> 컴파일 하고 난 후에는 버려짐.
//import java.util.*;
import java.util.Scanner;

public class CalculatorView {
	// 클래스 변수
	// - 클래스에 static 으로 선언된 변수
	// - 클래스가 메모리에 로딩될 때 준비된다.
	// - 클래스의 모든 메서드가 접근 가능.
	// - 만약 해당 변수가 public, (default), protected로 공개되었다면,
	//   그 조건에 맞추어 다른 클래스에서 접근할 수 있다.
	
	private static int v1;
	private static String op;
	private static int v2;
	private static int result;
	private static Scanner scanner;
	
	// static 블럭
	// - 클래스가 로딩되고 난 후 사용되기 전에 필요한 값을 준비하는 블럭
	// - 스태틱 블럭에서는 스태틱 변수와 스태틱 메서드만 사용가능. 인스턴스 변수/메서드 접근 불가!
	// - 클래스가 로딩되고 난 후 즉시 딱 한 번 이 블럭을 수행한다.
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
		// JDK 1.6.x 이하에서는 op의 값은 4바이트 정수값만 가능(char,short,int)
		// JDK 1.7.x 부터 op는 String도 가능 
		switch(op) {
		case "+":
			result = v1 + v2;
			break;
		case "-":
			result = v1 - v2;
			break;
		case "*":
			result = v1 * v2;
			break;
		case "/":
			result = v1 / v2;
			break;
		}
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









