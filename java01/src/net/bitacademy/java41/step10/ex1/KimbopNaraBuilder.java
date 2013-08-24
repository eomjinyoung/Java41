package net.bitacademy.java41.step10.ex1;

public class KimbopNaraBuilder {
	static public KimbopNara build(int capacity, String address) {
		KimbopNara building = 
				new KimbopNara(capacity, "07:00 ~ 24:00", address);
		return building;
	}
}
