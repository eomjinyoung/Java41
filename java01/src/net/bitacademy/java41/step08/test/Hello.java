package net.bitacademy.java41.step08.test;

// * Application Arguments vs JVM Arguments
// 프롬프트> java.exe -Daaa=111 -Dbbb=222 Hello aaa bbb ccc
// 1) application arguments : aaa bbb ccc
// 2) JVM arguments: aaa=111 bbb=222

public class Hello {

	public static void main(String[] args) {
		// 1) application arguments 알아내기
		for (String item : args) {
			System.out.println(item);
		}
		
		// 2) JVM arguments 알아내기
		System.out.println(System.getProperty("aaa"));
		System.out.println(System.getProperty("bbb"));

		// 배열
		int[] x = new int[5];
		
		System.out.println(x[4]);
		
		
		
	}

}









