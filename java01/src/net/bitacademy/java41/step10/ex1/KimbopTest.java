package net.bitacademy.java41.step10.ex1;

public class KimbopTest {

	public static void main(String[] args) {
		//step1();
		//step2();
		step3();

	}

	private static void step3() {
		KimbopNara store = KimbopNaraBuilder.build(15, "종로구");
		Kimbop kimbop = store.create();
		
	}

	private static void step2() {
		KimbopNara factory = new KimbopNara(20, "07:00 ~ 24:00", "강남구");
		Kimbop k = factory.create();
		
	}

	private static void step1() {
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
		
	}

}
