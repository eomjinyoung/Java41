package net.bitacademy.java41.step10.test2.ex4;

public class HankookTire implements Tire {
	protected String 	maker;
	protected double 	diameter;
	protected String		dotNo;
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

	@Override
	public String getMaker() {
		return this.maker;
	}

	@Override
	public String getDotNo() {
		return this.dotNo;
	}

	@Override
	public double getDiameter() {
		return this.diameter;
	}
	
	
}
