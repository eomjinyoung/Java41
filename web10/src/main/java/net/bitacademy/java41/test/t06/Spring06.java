package net.bitacademy.java41.test.t06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 컴포넌트 등록 자동화 
 * @Component
 * - 이 애노테이션이 선언된 객체를 찾아서 자동으로 등록할 수 있다.
 * - 컴포넌트를 등록할 때 이름은 클래스 이름을 사용한다.(단, 첫글자는 소문자)
 * - 이름을 지정하고 싶으면, @Component(객체이름)
 * */
public class Spring06 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t06/application-context.xml");
		
		Student student = (Student)ctx.getBean("student");
		School school = student.school;
		if (school != null) {
			System.out.println("school 등록됨.");
		}
		
		Award award = student.award;
		if (award != null) {
			System.out.println("award 등록됨.");
		}
	}
	
	public static void main01(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"net/bitacademy/java41/test/t06/application-context.xml");
		
		String[] names = ctx.getBeanDefinitionNames();
		for(String beanName : names) {
			System.out.println(beanName);
		}
	}
	
}
