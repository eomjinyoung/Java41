package net.bitacademy.java41.step10.test2.ex3;

abstract public class Tire {
	protected String 	maker;
	protected String 	dotNo;
	protected double 	diameter;
	
	public String getMaker() {
		return maker;
	}
	public Tire setMaker(String maker) {
		this.maker = maker;
		return this;
	}
	
	public String getDotNo() {
		return dotNo;
	}
	public Tire setDotNo(String dotNo) {
		this.dotNo = dotNo;
		return this;
	}
	
	public double getDiameter() {
		return diameter;
	}
	public Tire setDiameter(double diameter) {
		this.diameter = diameter;
		return this;
	}
}
