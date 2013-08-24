package net.bitacademy.java41.step10.test.advanced;

/* Adapter 패턴 
 * - 기존에 작성된 클래스를 새로운 규칙에 맞추어 사용하고자 할 때 
 *   쓰는 설계 기법
 */

public class NexenTireAdapter extends Tire {
	NexenTire tire = new NexenTire();
	
	@Override
	public String getMaker() {
		return tire.getCompany();
	}
	
	@Override
	public double getRadius() {
		return tire.getDiameter() / 2;
	}
}
