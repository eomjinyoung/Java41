package net.bitacademy.java41.step01;

// import 문장 선언 시 *를 사용하기 보다는 가능한 정확하게 선언
// - 컴파일 속도를 조금이라도 빠르게 할 수 있다.
// - 코드의 가독성을 높인다.
// - 컴파일 시에 참고하는 용도 -> 컴파일 하고 난 후에는 버려짐.
//import java.util.*;
import java.util.Scanner;

public class CalculatorView02 {
	public static void inputForm() {
		// 로컬변수
		// - 메서드 및 블럭 안에 선언된 변수
		// - 해당 블럭 내에서만 사용 가능
		// - 메서드의 변수는 메서드의 블럭 안에서는 사용가능
		// - 메서드 안에 선언된 모든 로컬 변수는 다른 메서드에서 사용 불가능
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("값1:");
		int v1 = Integer.parseInt( scanner.nextLine() );
		
		System.out.print("연산자:");
		String op = scanner.nextLine();
		
		System.out.print("값2:");
		int v2 = Integer.parseInt( scanner.nextLine() );
	}
	
	public static void compute() {
		int result = 0;
	}
	
	public static void outputResult() {
		System.out.println("------------------------------");
		//System.out.println(v1 + " " + op + " " + v2 + " =");
		//System.out.println(result);
		System.out.println("------------------------------");
	}
	
	public static void main(String[] args) {
		inputForm();
		compute();
		outputResult();
	}

}
