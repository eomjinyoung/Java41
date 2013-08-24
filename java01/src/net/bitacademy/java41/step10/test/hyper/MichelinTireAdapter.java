package net.bitacademy.java41.step10.test.hyper;

public class MichelinTireAdapter implements Tire {
	MichelinTire tire = new MichelinTire();

	@Override
	public String getMaker() {
		return tire.getCorp();
	}

	@Override
	public double getRadius() {
		return tire.getRound() / 3.14159 ;
	}
	
	
}
