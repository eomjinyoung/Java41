package net.bitacademy.java41.step13.test;

interface X {}
interface Y {}
class A {}
class B extends A implements X {}
class C extends B implements Y {}

public class TypeTest {
	public static void main(String[] args) {
		//test01();
		//test02();
		test03();
	}

	private static void test03() {
		B p1 = new C();
		B p2 = new B();
		if (p1.getClass() == p2.getClass()) {
			System.out.println("p1.getClass() == p2.getClass()");
		}
	}

	private static void test02() {
		B p = new C();
		if (p instanceof A)
			System.out.println("p instanceof A");
		if (p instanceof B) 
			System.out.println("p instanceof B");
		if (p instanceof C)
			System.out.println("p instanceof C");
		if (p instanceof X)
			System.out.println("p instanceof X");
		if (p instanceof Y)
			System.out.println("p instanceof Y");
	}

	private static void test01() {
		B p = new B();
		if (p instanceof A)
			System.out.println("p instanceof A");
		if (p instanceof B) 
			System.out.println("p instanceof B");
		if (p instanceof C)
			System.out.println("p instanceof C");
		if (p instanceof X)
			System.out.println("p instanceof X");
		if (p instanceof Y)
			System.out.println("p instanceof Y");
		
	}

}
