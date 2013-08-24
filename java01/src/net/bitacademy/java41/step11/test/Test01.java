package net.bitacademy.java41.step11.test;

public class Test01 {
	public static void main(String[] args) {
		A p1 = null;
		B p2 = null;
		
		p1 = new AImpl();
		p1 = new BImpl();
		
		//p2 = new AImpl();
		p2 = new BImpl();
	}
}
