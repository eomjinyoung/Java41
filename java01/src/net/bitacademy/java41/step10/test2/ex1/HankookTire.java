package net.bitacademy.java41.step10.test2.ex1;

public class HankookTire {
	protected String 	maker;
	protected double 	radius;
	protected String 	dotNo;
	protected boolean 	snow;
	protected int 		maxSpeed;
	
	public HankookTire(String maker, double radius, String dotNo) {
		this.maker = maker;
		this.radius = radius;
		this.dotNo = dotNo;
	}
	
	public String getMaker() {
		return maker;
	}
	public HankookTire setMaker(String maker) {
		this.maker = maker;
		return this;
	}
	public double getRadius() {
		return radius;
	}
	public HankookTire setRadius(double radius) {
		this.radius = radius;
		return this;
	}
	public String getDotNo() {
		return dotNo;
	}
	public HankookTire setDotNo(String dotNo) {
		this.dotNo = dotNo;
		return this;
	}
	public boolean isSnow() {
		return snow;
	}
	public HankookTire setSnow(boolean snow) {
		this.snow = snow;
		return this;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public HankookTire setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
		return this;
	}
	
	
}
