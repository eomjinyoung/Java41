package net.bitacademy.java41.test;

public class MiniMapTest {
	Object[] valueList = new Object[10000000];// [ x , y , z , , , ... ]
	
	public void put(String key, Object value) {
		int hash = key.hashCode();
		int index = hash % 10000000;
		
		valueList[index] = value;
	}
	
	public Object get(String key) {
		int hash = key.hashCode();
		int index = hash % 10000000;
		
		return valueList[index];
	}
	
	public static void main(String[] args) {
		class Student {
			String name;
			int age;
			
			public String toString() {
				return name + "," + age;
			}
		}
		
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.age = 30;
		
		Student s2 = new Student();
		s2.name = "임꺽정";
		s2.age = 40;
		
		String k1 = new String("hong");
		String k2 = new String("leem");
		
		MiniMapTest map = new MiniMapTest();
		map.put(k1, s1);
		map.put(k2, s2);
		
		
		String k3 = new String("hong");
		String k4 = new String("leem");
		System.out.println(map.get(k3));
		System.out.println(map.get(k4));
		
		
	}

}













