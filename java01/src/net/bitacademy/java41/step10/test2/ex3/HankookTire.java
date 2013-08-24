package net.bitacademy.java41.step10.test2.ex3;

public class HankookTire extends Tire {
	protected boolean 	snow;
	protected int 		maxSpeed;
	
	public HankookTire(String maker, double radius, String dotNo) {
		this.maker = maker;
		this.diameter = radius * 2;
		this.dotNo = dotNo;
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
