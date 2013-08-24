package net.bitacademy.java41.step10.test.hyper;

public class HankookTire extends BaseTire {
	
	protected boolean snow;
	
	public HankookTire(String maker, double radius) {
		this.maker = maker;
		this.radius = radius;
	}
	
	public HankookTire(String maker, double radius, boolean snow) {
		this.maker = maker;
		this.radius = radius;
		this.snow = snow;
	}
	
	public boolean isSnow() {
		return snow;
	}


	
}
