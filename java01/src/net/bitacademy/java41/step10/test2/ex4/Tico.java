package net.bitacademy.java41.step10.test2.ex4;

import net.bitacademy.java41.util.MichelinTire;

public class Tico {
	Tire[] tires = new Tire[5];
	
	public Tico() {
		//tires[0] = new HankookTire("(주)한국타이어", 16.5, "1013");
		MichelinTire foreignTire = new MichelinTire();
		foreignTire.setCorp("미쉘린타이어");
		foreignTire.setRadius(16);
		foreignTire.setMadeDate("3410");
		
		MichelinTireAdapter adapter = new MichelinTireAdapter(foreignTire);
		tires[0] = adapter;
		tires[1] = new HankookTire("(주)한국타이어", 16.5, "1013");
		tires[2] = new HankookTire("(주)한국타이어", 16.5, "1013");
		tires[3] = new KumhoTire("(주)금호타이어", 33, "2112");
		tires[4] = new HankookTire("(주)한국타이어", 16.5, "1013");
	}
	
	public void printInfo() {
		int count = 0;
		for(int i = 0; i < tires.length ; i++ ) {
			if (tires[i] != null) {
				count++;
			}
		}
		System.out.println("타이어 개수: " + count + "개");
		
		for(int i = 0; i < tires.length; i++) {
			if (i < 4) {
				System.out.print((i + 1) + "번 타이어: "); 
			} else {
				System.out.print("스페어 타이어: "); 
			}
			
			if (tires[i] != null) {
				System.out.println(
					tires[i].getMaker() + "," +
					(tires[i].getDiameter()) + ", " +
					"20" + tires[i].getDotNo().substring(2, 4) + "년 " +		
					tires[i].getDotNo().substring(0, 2) + "주차");
			} else {
				System.out.println("없음");
			}
		}
		
	}
	
	public static void main(String[] args) {
		Tico c1 = new Tico();
		c1.printInfo();
		/* printInfo()의 출력결과:
		 * 타이어 개수: 4개
		 * 1번 타이어: (주)한국타이어, 33, 2013년 10주차
		 * 2번 타이어: (주)한국타이어, 33, 2013년 10주차
		 * 3번 타이어: (주)한국타이어, 33, 2013년 10주차
		 * 4번 타이어: (주)한국타이어, 33, 2013년 10주차
		 * 스페어 타이어: 없음
		 */
	}

}








