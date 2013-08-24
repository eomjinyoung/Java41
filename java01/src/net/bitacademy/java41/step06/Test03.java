package net.bitacademy.java41.step06;

public class Test03 {

	public static void main(String[] args) {
		// 1. equals() 사용 
		// - Object에서 상속받은 메서드이다.
		// - 원래는 인스턴스 주소를 비교하는 메서드다.
		// - 하지만, String 클래스에서 값을 비교하도록 재정의(Overriding) 하였다.
		String s1 = new String("홍길동");
		String s2 = new String("홍길동");
		String s3 = "홍길동";
		
		if (s1.equals(s2)) {
			System.out.println("s1.equals(s2)");
		} else {
			System.out.println("s1 != s2");
		}
	}

}






