package net.bitacademy.java41.step15.test;

public class OuterTest {

	public static void main(String[] args) {
		// top level inner 클래스는 static 멤버처럼 사용한다.
		// 즉, 클래스이름.멤버이름(변수,메서드,inner 클래스)
		Outer.staticVar = 20;
		Outer.staticMethod();
		Outer.TopLevelInner p = new Outer.TopLevelInner();
		
		// member inner 클래스는 인스턴스 생성 후 사용한다.
		// 인스턴스의 멤버처럼 사용한다.
		Outer obj1 = new Outer();
		obj1.instanceVar = 30;
		obj1.instanceMethod();
		Outer.MemberInner obj2 = obj1.new MemberInner();

	}

}
