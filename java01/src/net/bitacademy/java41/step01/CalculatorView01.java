package net.bitacademy.java41.step01;

// import 문장 선언 시 *를 사용하기 보다는 가능한 정확하게 선언
// - 컴파일 속도를 조금이라도 빠르게 할 수 있다.
// - 코드의 가독성을 높인다.
// - 컴파일 시에 참고하는 용도 -> 컴파일 하고 난 후에는 버려짐.
//import java.util.*;
import java.util.Scanner;

public class CalculatorView01 {

	public static void main(String[] args) {
		// 사용자로부터 입력 받기: 값1, 연산자, 값2
		Scanner scanner = new Scanner(System.in);
		System.out.print("값1:");
		int v1 = Integer.parseInt( scanner.nextLine() );
		
		System.out.print("연산자:");
		String op = scanner.nextLine();
		
		System.out.print("값2:");
		int v2 = Integer.parseInt( scanner.nextLine() );
		
		// 계산하기
		int result = 0;
		
		// 계산 결과를 출력하기
		System.out.println("------------------------------");
		System.out.println(v1 + " " + op + " " + v2 + " =");
		System.out.println(result);
		System.out.println("------------------------------");
		
	}

}
