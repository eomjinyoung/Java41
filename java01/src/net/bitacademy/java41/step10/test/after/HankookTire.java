package net.bitacademy.java41.step10.test.after;

public class HankookTire extends Tire {
	protected boolean snow;
	
	// 다형성: overloading
	// - 같은 기능을 하는 메서드에 대해 같은 이름을 부여함으로써 프로그래밍의 일관성을 확보
	public HankookTire(String maker, double radius) {
		this.maker = maker;
		this.radius = radius;
		//this.snow = false;
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
