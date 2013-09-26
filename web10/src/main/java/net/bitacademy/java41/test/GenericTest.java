package net.bitacademy.java41.test;

class Sword {}

class Gun {}

class Laser {}

class Truck {
	String name;
	Object weapon;
	
	public void setWeapon(Object w) {
		weapon = w;
	}
	
	public Object getWeapon() {
		return weapon;
	}
}

/* Generic
 * - 하나의 클래스를 가지고 여러 타입의 객체를 다루기 위해
 *   => Generic이 없다면, 각 타입 별로 클래스를 여러개 만들어야 한다.
 * - type casting에서 자유롭기 위해
 * - 객체 보관할 때 사용
 */
/*
 * 지름을 x라고 하자!
 * 원의 넓이는 = 3.14 * (x/2) ^ 2
 */

// 특정 타입만을 다루도록 제약을 가함.
class GenericTruck<T> {
	String name;
	Object weapon;
	
	public void setWeapon(T w) {
		weapon = w;
	}
	
	public T getWeapon() {
		return (T)weapon;
	}
}

// 특정 타입에 대한 제약이 없음.
// 저장할 때 타입과 꺼낼 때 타입이 다른 경우에 문제가 발생할 수 있다.
// 개발자가 조심해서 사용해야 한다.
class GenericTruck2 {
	String name;
	Object weapon;
	
	public <T> void setWeapon(T w) {
		weapon = w;
	}
	
	public <T> T getWeapon() {
		return (T)weapon;
	}
}

public class GenericTest {

	public static void main(String[] args) {
		Sword w1 = new Sword();
		Gun w2 = new Gun();
		Laser w3 = new Laser();
		
		GenericTruck2 t = new GenericTruck2();
		t.name = "오호라 트럭";
		
		t.setWeapon(w1);
		Sword s = t.getWeapon();

		t.setWeapon(w2);
		Gun s2 = t.getWeapon();
		
		t.setWeapon(w3);
		Sword s3 = t.getWeapon();
		
	}
	
	public static void main02(String[] args) {
		Sword w1 = new Sword();
		Gun w2 = new Gun();
		Laser w3 = new Laser();
		
		GenericTruck<Sword> t = new GenericTruck<Sword>();
		t.name = "오호라 트럭";
		
		t.setWeapon(w1);		
		Sword s = t.getWeapon();
		
		//t.setWeapon(w2); // Error!
	}
	
	public static void main01(String[] args) {
		Sword w1 = new Sword();
		Gun w2 = new Gun();
		Laser w3 = new Laser();
		
		Truck t = new Truck();
		t.name = "오호라 트럭";
		
		t.setWeapon(w1);
		Sword s = (Sword) t.getWeapon();
		

	}

}







