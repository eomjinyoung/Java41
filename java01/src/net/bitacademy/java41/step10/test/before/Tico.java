package net.bitacademy.java41.step10.test.before;

public class Tico {
	HankookTire[] tires = new HankookTire[5];;
	
	public Tico() {
		tires[0] = new HankookTire();
		//tires[1] = new HankookTire();
		//tires[1] = new KumhoTire();
		tires[2] = new HankookTire();
		tires[3] = new HankookTire();
		//tires[4] = new HankookTire();
	}
	
	public void run() {
		System.out.println("씽씽~~~");
	}
	
	public void describe() {
		System.out.println("타이어:");
		for(HankookTire tire : tires) {
			if (tire != null) {
				System.out.print(tire.getMaker() + ",");
			}
		}
		System.out.println();
		
		System.out.println("휠지름:" + tires[0].getRadius() * 2);
	}
	public static void main(String[] args) {
		Tico car = new Tico();
		car.run();
		car.describe();
	}
}









