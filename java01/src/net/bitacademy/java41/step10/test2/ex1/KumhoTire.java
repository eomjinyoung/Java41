package net.bitacademy.java41.step10.test2.ex1;

public class KumhoTire {
	protected String company;
	protected double diameter;
	protected String createdDate;
	protected boolean wide;
	
	public KumhoTire(String comp, double diam, String created) {
		company = comp;
		diameter = diam;
		createdDate = created;
	}
	
	public String getCompany() {
		return company;
	}
	public KumhoTire setCompany(String company) {
		this.company = company;
		return this;
	}
	public double getDiameter() {
		return diameter;
	}
	public KumhoTire setDiameter(double diameter) {
		this.diameter = diameter;
		return this;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public KumhoTire setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
		return this;
	}
	public boolean isWide() {
		return wide;
	}
	public KumhoTire setWide(boolean wide) {
		this.wide = wide;
		return this;
	}
}
