package net.bitacademy.java41.step07;

import java.util.Date;

public class MemberTest {
	public static void main(String[] args) {
		Member m1 = new Member();
		/*
		m1.name = "홍길동";
		m1.phone = "111-1111";
		m1.email = "hong@test.com";
		m1.blog = "http://hong.blogspot.com";
		m1.age = 300; // 객체의 역할에 유효하지 않은 값이 들어가면 시스템에 치명적이다.
		m1.regDate = new Date(); // 현재 날짜
		*/
		//* 캡슐화(Encapsulation) 
		// - 위의 m1.age의 경우처럼,
		//   객체가 역할을 수행하는데 유효하지 않는 값이 들어가는 것을 방지하기 위한 문법
		m1.setName("홍길동");
		m1.setPhone("111-1111");
		m1.setEmail("hong@test.com");
		m1.setBlog("http://hong.blogspot.com");
		m1.setAge(300); // 유효하지 않은 값은 무시한다!
		m1.setRegDate(new Date());
	}
}










