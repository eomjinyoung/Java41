package net.bitacademy.java41.test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * Annotation 
 * - 컴파일러에게 제공하는 특별한 정보
 * - 컴파일이나 배포하는 동안 사용할 특별한 정보
 * - 실행하는 동안 사용할 특별한 정보
 * - 문법
 * @애노테이션이름(속성=값,속성=값, ...)
 * 
 * - 만약 속성 이름이 다음과 같이 'value'일 경우 생략가능
 * @애노테이션이름(value="okok")
 * ==> @애노테이션이름("okok")
 * 
 * - 그러나, 속성이 2개 이상일 경우는 value 이름을 생략할 수 없다.
 * @애노테이션이름("okok",age="20") // !오류
 * ==> @애노테이션이름(value="okok",age="20") //OK
 * 
 */

/* 애노테이션 정의
 * - 애노테이션 유지 정책: @Retention()
 * 	  . CLASS (.class 파일에 존재, 컴파일러에게 제공할 정보)
 *    . RUNTIME (.class 파일에 존재, JVM에게 제공할 정보)
 *    . SOURCE (.class 파일에 없다. 컴파일할 때 버려짐)
 */
@Retention(RetentionPolicy.RUNTIME)
@interface Book {
	/* 속성 정의 */
	String value();
	
	/* 속성 정의: 기본 값을 갖는 속성 */
	int page() default 100;
	
	String language() default "korean";
	
	/* 속성 정의: 배열 */
	String[] authors() default {""};
}

@Book("오호라..자바")
class Item {
	int no;
	int price;
}

@Book(
	value="두번째",
	page=250,
	language="English",
	authors="홍길동"
)
class Item2 {}

@Book(value="세번째",authors={"홍길동","임꺽정"})
class Item3 {}

public class AnnotationTest {

	public static void main(String[] args) throws Exception {
		Item item = new Item();
		item.no = 1;
		item.price = 10000;
		
		Class clazz = item.getClass();
		
		Book book = (Book)clazz.getAnnotation(Book.class);
		System.out.println(book.value());
		
		// Class.forName("net.bitacademy.java41.test.Item2") == Item2.class
		System.out.println("------------------------");
		Book book2 = Class.forName("net.bitacademy.java41.test.Item2").getAnnotation(Book.class);
		System.out.println(book2.value());
		System.out.println(book2.page());
		System.out.println(book2.language());
		System.out.println(book2.authors()[0]);
		
		System.out.println("------------------------");
		Book book3 = Item3.class.getAnnotation(Book.class);
		System.out.println(book3.value());
		System.out.println(book3.authors()[0]);
		System.out.println(book3.authors()[1]);
		
	}

}

















