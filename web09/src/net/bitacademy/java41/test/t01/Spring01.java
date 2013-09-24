package net.bitacademy.java41.test.t01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring01 {

	public static void main(String[] args) {
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
