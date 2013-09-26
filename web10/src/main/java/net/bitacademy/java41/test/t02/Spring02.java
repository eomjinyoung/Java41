package net.bitacademy.java41.test.t02;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring02 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t02/application-context.xml");
		Student s = (Student)ctx.getBean("st1");
		
		System.out.println(s.getName());
		System.out.println(s.getAge());
		System.out.println(s.getTel());
		
		School sc = s.getSchool();
		System.out.println(sc.getName());
		System.out.println(sc.getLevel());
		System.out.println(sc.getTel());
		System.out.println(sc.getHomepage());
		
		
	}
	
	

}
