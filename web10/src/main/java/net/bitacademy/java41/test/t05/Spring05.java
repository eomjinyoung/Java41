package net.bitacademy.java41.test.t05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring05 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t05/application-context.xml");
		
		Student3 student = (Student3)ctx.getBean("st3");
		School school = student.school;
		System.out.println(school.getName());
		
		Award award = student.award;
		System.out.println(award.title);
	}
	
	public static void main02(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t05/application-context.xml");
		
		Student2 student = (Student2)ctx.getBean("st2");
		School school = student.school;
		System.out.println(school.getName());
	}
	
	public static void main01(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t05/application-context.xml");
		
		Student student = (Student)ctx.getBean("st1");
		School school = student.getSchool();
		Award award = student.getAward();
		
		System.out.println(school.getName());
		System.out.println(award.getTitle());
	}
	
}
