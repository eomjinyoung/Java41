package net.bitacademy.java41.test;

import java.lang.reflect.Method;

class Student {
	String name;
	int age;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void m1() {
		System.out.println("오호라..");
	}
}

public class ReflectionTest01 {

	public static void main(String[] args) throws Exception {
		Student s1 = new Student();
		
		// * Class : 클래스 정보를 다루는 클래스 
		// - forName(클래스 전체 이름) : 
		//		클래스를 로딩하고, 그 클래스를 다룰 수 있는 객체를 얻는다.
		Class 클래스핸들러 = Class.forName("net.bitacademy.java41.test.Student");
		
		// 1) newInstance() : 인스턴스 생성
		Student s2 = (Student)클래스핸들러.newInstance();
		s2.name = "홍길동";
		s2.age = 30;
		s2.m1();
		
		// 2) 클래스의 메서드 목록 추출 및 메서드 호출
		System.out.println("메서드 목록 -----------------------------");
		Method[] methodList = 클래스핸들러.getMethods();
		for(Method m : methodList) {
			System.out.println(m.getName());
			if (m.getName().equals("m1")) {
				System.out.println("m1() 호출 >>>>>");
				m.invoke(s2);
				System.out.println("<<<<<<<< m1() 호출 끝");
			}
		}
		
		/* 클래스 핸들러 얻기
		 * - Class.forName("클래스전체이름"); // import 하더라도 전체 이름을 줘야한다.
		 * 		예) Class.forName("java.lang.String")
		 * - 클래스전체이름.class
		 * 		예) java.lang.String.class
		 */
		
		// 3) 단일 메서드 추출 및 메서드 호출 시 파라미터 넘기기
		Method m = 클래스핸들러.getMethod("setName", java.lang.String.class);
		m.invoke(s2, "일지매");
		
		System.out.println("s2.name = " + s2.getName());
		
	}

}









