package net.bitacademy.java41.step10.test2.ex4;

public class KumhoTire implements Tire {
	protected String company;
	protected double	 radius;
	protected String createdDate;
	protected boolean wide;
	
	public KumhoTire(String comp, double diam, String created) {
		this.company = comp;
		this.radius = diam / 2;
		this.createdDate = created;
	}
	public boolean isWide() {
		return wide;
	}
	public KumhoTire setWide(boolean wide) {
		this.wide = wide;
		return this;
	}
	@Override
	public String getMaker() {
		return this.company;
	}
	@Override
	public String getDotNo() {
		return this.createdDate;
	}
	@Override
	public double getDiameter() {
		return this.radius * 2;
	}
}
