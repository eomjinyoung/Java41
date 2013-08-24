package net.bitacademy.java41.step13.test;

class Member {
	String name;
	int age;
	
	// Object로부터 상속받은 toString()은 원래 "클래스명@인스턴스고유값"을 리턴한다.
	public String toString() {
		return "[" + this.name + "," + this.age + "]^^";
	};
	
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	*/
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	/*
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		// 문제점: instanceof는 자식 클래스에 대해서도 같다고 평가한다.
		//if (!(obj instanceof Member)) {
		//	return false;
		//}
		//
		
		if (!(obj.getClass() == this.getClass())) {
			return false;
		}
		
		Member other = (Member)obj;
		
		if (!this.name.equals(other.name)) {
			return false;
		}
		
		if (this.age != other.age) {
			return false;
		}
		
		return true;
	}
	*/
	
	
}

class Customer extends Member {
	String tel;
}

public class StringTest {

	public static void main(String[] args) {
		//test01();
		//test02();
		//test03();
		//test04();
		//test05();
		//test06();
		test07();
	}

	private static void test07() {
		StringBuffer buf = new StringBuffer("Hello,");
		buf.append(" World!");
		
		// println() 메서드는 해당 객체의 toString() 리턴 값을 출력한다.
		System.out.println(buf);
		
		Member m1 = new Member();
		m1.name = "aaa";
		m1.age = 20;
		
		System.out.println(m1);
		
	}

	private static void test06() {
		StringBuffer s1 = new StringBuffer("Hello");
		StringBuffer s2 = new StringBuffer("Hello");
		
		if (s1.equals(s2)){
			System.out.println("s1.equals(s2)");
		}
		
	}

	private static void test05() {
		Member m1 = new Member();
		m1.name = "aaa";
		m1.age = 20;
		
		Customer c1 = new Customer();
		c1.name = "aaa";
		c1.age = 20;
		
		if(m1.equals(c1)) { 
			System.out.println("m1.equals(c1)");
		}
		
	}

	private static void test04() {
		Member m1 = new Member();
		m1.name = "aaa";
		m1.age = 20;
		
		Member m2 = new Member();
		m2.name = "aaa";
		m2.age = 20;
		
		if(m1 == m2) {
			System.out.println("m1 == m2");
		}
		
		if(m1.equals(m2)) {  // Object로부터 상속받은 메서드는 주소가 같은지를 비교한다.
			System.out.println("m1.equals(m2)");
		}
		
	}

	private static void test03() {
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		
		if (s1 == s2) {
			System.out.println("s1 == s2");
		}
		
		if (s1.equals(s2)) {
			System.out.println("s1.equals(s2)");
		}
		
	}

	private static void test02() {
		// Mutable 객체(StringBuffer)
		StringBuffer buf = new StringBuffer("Hello");
		buf.replace(2, 5, "xx");
		
		System.out.println(buf);
		
		buf.append("aaa");
		buf.append("bbb");
		buf.append("ccc");
		
		System.out.println(buf);
		
	}

	private static void test01() {
		// String 은 불변의 객체다. (immutable)
		String s1 = new String("Hello");
		String s2 = s1.replace('l', 'x');
		
		System.out.println(s1);
		System.out.println(s2);
		
	}

}












