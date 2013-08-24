package net.bitacademy.java41.step06;

public class Test02 {

	public static void main(String[] args) {
		// 1. 문자열 표현 
		
		String s1 = new String("홍길동");
		String s2 = new String("홍길동");
		
		if (s1 == s2) {
			System.out.println("s1 == s2");
		} else {
			System.out.println("s1 != s2");
		}
		
		// 2. 상수 문자열 표현  
		// - '가' => 내부적으로 가 라는 문자의 유니코드 값을 리턴
		// - "홍길동" => 내부적으로 홍길동 문자열을 가진 인스턴스를 생성 
		// - 상수 문자열은 Heap이 아닌 Constant Pool 영역에 인스턴스를 만든다.
		// - 상수풀은 같은 값을 갖는 인스턴스를 만들지 않는다. => 메모리 낭비 방지!
		String s3 = "홍길동";  // 상수풀에 새로운 인스턴스를 만든다.
		String s4 = "홍길동";  // 상수풀에 기존에 만들어져 있던 인스턴스의 주소를 리턴한다.
		
		if (s3 == s4) {
			System.out.println("s3 == s4");
		} else {
			System.out.println("s3 != s4");
		}
		
		// 3. Heap에 만든 스트링을 상수풀에도 만드는 방법: intern()
		String s5 = new String("홍길동");
		String s6 = s5.intern();
		
		if (s5 == s6) {
			System.out.println("s5 == s6");
		} else {
			System.out.println("s5 != s6");
		}
		
		if (s3 == s6) {
			System.out.println("s3 == s6");
		} else {
			System.out.println("s3 != s6");
		}
	}

}














