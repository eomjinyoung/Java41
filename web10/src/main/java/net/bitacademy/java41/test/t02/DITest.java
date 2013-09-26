package net.bitacademy.java41.test.t02;

class A {	}

class B { 
	D _d;
	A _a;
}

class C {
	D _d;
}

class D {}

public class DITest {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		
		
		c._d = d;
		b._a = a;
		b._d = d;
		
		
		

	}

}












