package net.bitacademy.java41.test;

public class RecursiveTest {

	public static void main(String[] args) {
		int result = sooyeol(10);
		System.out.println(result);

	}
	
	public static int sooyeol(int value) {
		if (value == 1) { 
			return 1;
		} else {
			return value + sooyeol(value - 1);
		}
	}

}
