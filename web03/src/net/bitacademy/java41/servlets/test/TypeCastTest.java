package net.bitacademy.java41.servlets.test;

public class TypeCastTest {

	static class Car {
		public void m() {}
	}
	
	static class Tico extends Car{
		public void m2() {}
	}
	
	public static void main(String[] args) {
		Tico t = new Tico();
		t.m();
		t.m2();
		
		Car c = new Tico();
		c.m();
		//c.m2();
		
		Object o = new Tico();
		//o.m();
		//o.m2();
		
		Tico p = (Tico)o;
		p.m();
		p.m2();

		Object o2 = new Car();
		
		Tico p2 = (Tico) o2; 
		p2.m();
		p2.m2();
		
	}

}














