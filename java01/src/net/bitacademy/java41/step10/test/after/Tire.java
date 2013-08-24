package net.bitacademy.java41.step10.test.after;

/* 추상클래스 
 * - 서브클래스들에게 공통 속성 및 기능을 상속해주기 위한 용도.
 */
abstract public class Tire {
	protected String maker;
	protected double radius;
	
	public String getMaker() {
		return maker;
	}
	
	public double getRadius() {
		return radius;
	}
}
