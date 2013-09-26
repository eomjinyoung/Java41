package net.bitacademy.java41.test.t01;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring01 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t01/application-context.xml");
		Student s = (Student)ctx.getBean("s9");
		
		System.out.println(s.getName());
		System.out.println(s.getAge());
		System.out.println(s.getTel());
		
		Map<String,String> fm = s.getFamilyMap();
		System.out.println(fm.get("아빠"));
		System.out.println(fm.get("엄마"));
		System.out.println(fm.get("동생"));
	}
	
	public static void main08(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t01/application-context.xml");
		Student s = (Student)ctx.getBean("s8");
		
		System.out.println(s.getName());
		System.out.println(s.getAge());
		System.out.println(s.getTel());
		for(String value : s.getCourseList() ) {
			System.out.println(value);
		}
	}
	
	public static void main07(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t01/application-context.xml");
		Student s = (Student)ctx.getBean("s7");
		
		System.out.println(s.getName());
		System.out.println(s.getAge());
		System.out.println(s.getTel());
		for(String school : s.getSchoolList() ) {
			System.out.println(school);
		}
	}
	
	public static void main06(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t01/application-context.xml");
		Student s = (Student)ctx.getBean("s6");
		
		System.out.println(s.getName());
		System.out.println(s.getAge());
		System.out.println(s.getTel());
		for(int i : s.getScores() ) {
			System.out.println(i);
		}
	}
	
	public static void main05(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t01/application-context.xml");
		Student s = (Student)ctx.getBean("s5");
		
		System.out.println(s.getName());
		System.out.println(s.getAge());
		System.out.println(s.getTel());
	}
	
	public static void main04(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t01/application-context.xml");
		Student s = (Student)ctx.getBean("s4");
		
		// 기본으로 객체는 싱글톤 방식으로 관리한다.
		Student s2 = (Student)ctx.getBean("s4");
		s2.setName("임꺽정2");
		s2.setAge(50);
		s2.setTel("7878-7979");
		
		System.out.println(s.getName());
		System.out.println(s.getAge());
		System.out.println(s.getTel());
		
		System.out.println("--------------------------");
		System.out.println(s2.getName());
		System.out.println(s2.getAge());
		System.out.println(s2.getTel());
		
		if(s == s2) {
			System.out.println("우리는 같은 객체^^");
		} else {
			System.out.println("우리는 서로 달라요!");
		}
	}
	
	public static void main03(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t01/application-context.xml");
		Student s = (Student)ctx.getBean("s3");
		
		System.out.println(s.getName());
		System.out.println(s.getAge());
		System.out.println(s.getTel());
		
		// 기본으로 객체는 싱글톤 방식으로 관리한다.
		Student s2 = (Student)ctx.getBean("s3");
		if(s == s2) {
			System.out.println("우리는 같은 객체^^");
		}
	}
	
	public static void main02(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t01/application-context.xml");
		Student s2 = (Student)ctx.getBean("s2");
		
		System.out.println(s2.getName());
		System.out.println(s2.getAge());
		System.out.println(s2.getTel());
	}
	
	public static void main01(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t01/application-context.xml");
		Student s1 = (Student)ctx.getBean("s1");
		if (s1 != null) {
			System.out.println("오호라... 정말 자동 생성되었네!");
		} else {
			System.out.println("뭥미....");
		}
	}

}
