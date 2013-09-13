package net.bitacademy.java41.test;

import java.io.FileReader;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest01 {

	public static void main(String[] args) throws Exception {
		/* java.util.Properties 클래스
		 * - xxx.properties 파일 다루기
		 * 
		 */
		Properties props = new Properties();
		props.load(new FileReader("test01.properties"));
		
		// 1) 값 꺼내기
		System.out.println(props.get("student"));
		System.out.println(props.get("name"));
		System.out.println(props.get("age"));
		
		// 2) 키 목록 추출
		// * Enumeration
		// - 저장소로부터 값을 꺼내주는 역할
		System.out.println("2) ---------------------------");
		Enumeration enums = props.keys();
		String key = null;
		String value = null;
		while(enums.hasMoreElements()) {
			key = (String) enums.nextElement();
			value = (String) props.get(key);
			System.out.println(key + "=" + value);
		}

	}

}















