package net.bitacademy.java41.test;

import java.util.HashMap;

public class HashTest01 {

	static class Student {
		String name;
		int age;
	}
	
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.age = 20;
		
		// fully-qualified class name + '@' + hashCode
		System.out.println(s1.toString()); 
		// 결과 예) net.bitacademy.java41.test.HashTest01$Student@442b7fc2
		
		// hashCode: 해당 인스턴스를 구분하는 ID값
		System.out.println( Integer.toHexString(s1.hashCode()) );
		// 결과 예) 442b7fc2
		
		/* Hash Code?
		 * - 데이터를 구분하기 위한 ID
		 * - 원본 데이터를 특별한 계산공식(알고리즘)을 이용하여 짧은 ID값을 뽑아낸다.
		 * - 특별한 계산공식? MD4, MD5, SHA-1, ...
		 * 		. MD4 (Message Digest): 16byte
		 * 		. MD5 : 16byte
		 * 		. SHA-1 : 20byte
		 * 		. SHA-256 : 32byte
		 * - 원본 데이터를 비교하면 너무 시간이 많이 걸리기 때문에,
		 *   원본 데이터를 대표하는 ID 값을 비교함으로써 비교 시간을 줄일 수 있다.
		 *   단, 다른 데이터가 같은 ID 값을 가질 수 있기 때문에,
		 *   항상 오류의 가능 성을 내포하고 있다.
		 */
		
		Student s2 = new Student();
		s2.name = "홍길동";
		s2.age = 20;
		
		// Object로부터 상속받은 hashCode()는 비록 데이터가 같더라도
		// 인스턴스가 다르면 다른 해시코드를 리턴한다.
		if (s1.hashCode() == s2.hashCode()) {
			System.out.println("두개의 인스턴스는 같다.");
		}
		
		// 데이터가 같은데, 해시코드가 다를 때 발생되는 문제는?
		class Key {
			String data;
			int no;
			
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result
						+ ((data == null) ? 0 : data.hashCode());
				result = prime * result + no;
				return result;
			}
			
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Key other = (Key) obj;
				if (data == null) {
					if (other.data != null)
						return false;
				} else if (!data.equals(other.data))
					return false;
				if (no != other.no)
					return false;
				return true;
			}
			
			
		}
		
		Key k1 = new Key();
		k1.data = "aaabbbccc";
		k1.no = 300;
		
		Key k2 = new Key();
		k2.data = "aaabbbccc";
		k2.no = 300;
		
		HashMap<Key,String> map = new HashMap<Key,String>();
		System.out.println("k1's hashCode: " + k1.hashCode());
		/* HashMap의 put() 메서드는 key 객체에 대해 hashCode()를 호출하여
		 * 그 리턴 값을 데이터를 저장하는 인덱스로 사용한다. 
		 */
		map.put(k1, "몸에 좋은 개소주!");
		
		/* HashMap의 get() 메서드는 값을 꺼낼 때,
		 * key 객체의 hashCode()를 호출하여 인덱스를 알아낸다.
		 * 그 인덱스를 가지고 데이터를 찾는다.
		 * 마지막으로 키가 정말 같은지 검증하기 위해 equals() 메서드를 한번 더 호출한다.
		 * 
		 */
		System.out.println("k2's hashCode: " + k2.hashCode());
		String yak = map.get(k2);
		
		System.out.println(yak);
		
		
	}

}








