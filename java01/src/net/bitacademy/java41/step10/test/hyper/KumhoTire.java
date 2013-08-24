package net.bitacademy.java41.step10.test.hyper;

public class KumhoTire extends BaseTire {
	protected String maker;
	protected double radius;
	
	public KumhoTire(String maker, double diameter) {
		this.maker = maker;
		this.radius = diameter / 2;
	}
	
	public double getDiameter() {
		return this.radius * 2;
	}
}