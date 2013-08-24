package net.bitacademy.java41.step08.test;

class A {
	int i;
	///* 안만들면 다음과 같이 기본 생성자가 만들어 진다.
	public A() {
		super(); // 생략하면 컴파일러가 자동으로 붙인다.
		System.out.println("A() 실행:");
		i = 100;
	}
	//*/
	public void m() {
		System.out.println("A의 m()");
	}
	
	public void m2() {
		System.out.println("A의 m2()");
	}
}
class B extends A{
	int j;
	///*
	public B(int v) {
		super();
		System.out.println("B() 실행:");
		j = v;
	}
	//*/
	public void m() {
		System.out.println("B의 m()");
	}
}
class C extends B{
	int k;
	///*
	public C() {
		super(500);
		System.out.println("C() 실행:");
		k = 300;
	}
	// */
	public void test() {
		this.m(); //B's m()
		super.m(); //B's m() => 오버라이딩 하지 않았기 때문에,
		
		this.m2(); // C's m()
		super.m2();// 오버라이딩 했기 때문에, A's m2()
	}
	
	public void m2() {
		System.out.println("C의 m2()");
	}
}
public class InheritTest {
	public static void main(String[] args) {
		C p = new C(); // [i][j][k]
		/*
		p.i = 10;
		p.j = 20;
		p.k = 30;
		*/
		
		System.out.println(p.i);
		System.out.println(p.j);
		System.out.println(p.k);
		
		p.test();
	}

}






