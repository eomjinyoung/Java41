package net.bitacademy.java41.test.t03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring03 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t03/application-context.xml");
		Student s = (Student)ctx.getBean("st2");
		
		School school = s.getSchool();
		System.out.println(school.getName());
	}
	
	public static void main02(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t03/application-context.xml");
		Student s = (Student)ctx.getBean("st1");
		
		School school = s.getSchool();
		System.out.println(school.getName());
	}
	
	public static void main01(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t03/application-context.xml");
		Object obj = ctx.getBean("s1");
		
		System.out.println(obj.getClass().getName());
		
		Object obj2 = ctx.getBean("s1");
		if(obj == obj2) {
			System.out.println("같은 객체다!");
		}
	}
	

}
