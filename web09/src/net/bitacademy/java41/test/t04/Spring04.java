package net.bitacademy.java41.test.t04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring04 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t04/application-context.xml");
		
		Student3 student = (Student3)ctx.getBean("st4");
		School school = student.getSchool();
		Award award = student.getAward();
		
		System.out.println(school.getName());
		System.out.println(award.getTitle());
	}
	
	public static void main03(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t04/application-context.xml");
		
		Student2 student = (Student2)ctx.getBean("st3");
		Award award = student.getAward();
		
		System.out.println(award.getTitle());
		
		
	}
	
	public static void main02(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t04/application-context.xml");
		
		Student student = (Student)ctx.getBean("st2");
		School school = student.getSchool();
		
		System.out.println(school.getName());
		
		
	}
	
	public static void main01(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t04/application-context.xml");
		
		School school = (School)ctx.getBean("sc1");
		Student student = (Student)ctx.getBean("st1");
		
	}
}
