package net.bitacademy.java41.step15.test;

/* 중첩 클래스(inner class)
 * - 클래스 내부에 선언하는 클래스
 * - 해당 클래스 내부에서만 사용하기 위함.
 * 1) top level inner class: static inner class
 *    - 다른 클래스에서도 사용하기 위함.
 * 2) member inner class: 
 *    - outer 클래스의 인스턴스를 통해서만 사용 가능한 클래스
 * 3) local inner class
 * 	  - 해당 클래스가 선언된 블럭 내에서만 사용 가능한 클래스   
 * 4) anonymous inner class
 * 	  - 이름이 없는 클래스 
 *    - 클래스를 정의한 직후 바로 인스턴스 생성함.
 *    - 오로지 한개의 인스턴스만 필요한 경우에 사용.
 */
public class Outer {
	//1) Top level inner class
	static class TopLevelInner { }
	static int staticVar = 10;
	static public void staticMethod() {}
	
	//2) Member inner class
	class MemberInner { }
	int instanceVar = 20;
	public void instanceMethod() {};
	
	public void test() {
		//3) Local inner class
		class LocalInner {
			public void print() {
				System.out.println("나는 local inner 클래스이다.");
			}
		}
		
		LocalInner p = new LocalInner();
		p.print();
		
		MemberInner m = new MemberInner();
		
		/* 4) 이름 없는 클래스 정의
		 * new (수퍼클래스 또는 인터페이스) () { // 클래스 정의 }
		 */
		Object obj1 = new Object() {
			int i = 0; 
			
			// 이름이 없기 때문에 생성자를 가질 수 없다. 
			// 호출되는 메서드는 -> 수퍼 클래스의 생성자 
			
			public void m() {
				System.out.println("okok");
			}
		};
				
	}
	
	public void test2() {
		// Error!
		//LocalInner p2 = new LocalInner();
		
		MemberInner m2 = new MemberInner();
	}
	
}











