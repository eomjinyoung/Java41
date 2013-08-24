package net.bitacademy.java41.step10.ex1;

public class KimbopNara {
	int capacity;
	String time;
	String address;
	
	public KimbopNara(int c, String t, String addr) {
		capacity = c;
		time = t;
		address = addr;
	}
	
	/* Design Pattern: Factory Method
	 * - 객체 생성이 복잡한 경우 특정 메서드를 통해 얻는 방식.
	 */
	public Kimbop create() {
		SpecialBop bop = new SpecialBop();
		bop.bop = "밥";
		bop.chamgirum = "해표참기름";
		bop.sokum = "천일염 + 맛소금";
		
		Kimbop k = new Kimbop();
		k.bop = bop;
		k.danggun = "용인당근";
		k.danmuji = "서울단무지";
		k.egg = "자연란";
		k.ham = "밀가루 + 돼지고기 + 수입생선(명태)";
		k.kim = "남해김";
		k.oi = "남산오이";
		k.sikumchi = "포항시금치";
		
		return k;
	}
}
