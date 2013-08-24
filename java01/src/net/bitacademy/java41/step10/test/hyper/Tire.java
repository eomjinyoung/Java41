package net.bitacademy.java41.step10.test.hyper;

/* 인터페이스 
 * - 사용 객체와 사용당하는 객체 사이의 호출 규칙
 * - 자동차 ==> [타이어] <== 한국타이어, 금호타이어 등등 
 * - 인터페이스의 메서드는 단지 규칙으로 역할을 하기 때문에 구현하지 않는다.
 *   => 인터페이스의 모든 메서드는 추상메서드 이다.
 *   => abstract 생략가능
 * - 규칙은 반드시 공개되어야 하기 때문에, public이다.
 * 	 => public 은 생략가능
 */
public interface Tire {
	/*public*/ /*abstract*/ String getMaker();
	public abstract double getRadius();
}
