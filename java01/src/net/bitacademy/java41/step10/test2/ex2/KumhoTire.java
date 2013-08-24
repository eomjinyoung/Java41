package net.bitacademy.java41.step10.test2.ex2;

public class KumhoTire extends Tire {
	protected boolean wide;
	
	public KumhoTire(String comp, double diam, String created) {
		maker = comp;
		diameter = diam;
		dotNo = created;
	}
	public boolean isWide() {
		return wide;
	}
	public KumhoTire setWide(boolean wide) {
		this.wide = wide;
		return this;
	}
}
