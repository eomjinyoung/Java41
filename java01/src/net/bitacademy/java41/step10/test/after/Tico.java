package net.bitacademy.java41.step10.test.after;

public class Tico {
	Tire[] tires = new Tire[5];
	
	public Tico() {
		tires[0] = new HankookTire("(주)한국타이어", 15.8);
		//tires[1] = new HankookTire();
		tires[1] = new KumhoTire("(주)금호타이어", 31.6);
		tires[2] = new HankookTire("(주)한국타이어", 15.8);
		tires[3] = new HankookTire("(주)한국타이어", 15.8, true);
		//tires[4] = new HankookTire();
	}
	
	public void run() {
		System.out.println("씽씽~~~");
	}
	
	public void describe() {
		System.out.println("타이어:");
		for(Tire tire : tires) {
			if (tire != null) {
				System.out.print(tire.getMaker() + ",");
				System.out.println("휠지름:" + tires[0].getRadius() * 2);
			}
		}
		System.out.println();
		
		
	}
	public static void main(String[] args) {
		Tico car = new Tico();
		car.run();
		car.describe();
	}
}









