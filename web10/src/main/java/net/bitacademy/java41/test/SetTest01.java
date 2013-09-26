package net.bitacademy.java41.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetTest01 {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		HashSet<String> names2 = new HashSet<String>();
		
		names.add("홍길동");
		names.add("임꺽정");
		names.add("유관순");
		names.add("유관순");
		
		for(String item : names) {
			System.out.println(item);
		}
		
		names2.add("홍길동");
		names2.add("임꺽정");
		names2.add("유관순");
		names2.add("유관순");
		
		System.out.println("---------------------");
		for(Object obj : names2.toArray()) {
			System.out.println(obj);
		}
	}

}
