package net.bitacademy.java41.test.t06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	protected String name;
	protected int age;
	protected String tel;
	
	@Autowired
	protected School school;
	
	@Autowired
	protected Award award;
	
	public Student() {}
	
	public Student(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}








