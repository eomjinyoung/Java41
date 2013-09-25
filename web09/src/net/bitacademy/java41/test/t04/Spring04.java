package net.bitacademy.java41.test.t04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring04 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t04/application-context.xml");
		
		School school = (School)ctx.getBean("sc1");
		Student student = (Student)ctx.getBean("st1");
		
	}
}
