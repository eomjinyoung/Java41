package net.bitacademy.java41.step10.test.advanced;

public class KumhoTire extends Tire{
	
	public KumhoTire(String maker, double diameter) {
		this.maker = maker;
		this.radius = diameter / 2;
	}
	
	public double getDiameter() {
		return this.radius * 2;
	}
}
