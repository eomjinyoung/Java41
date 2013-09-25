package net.bitacademy.java41.test.t05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class Student3 {
	protected String name;
	protected int age;
	protected String tel;
	
	@Autowired
	protected School school;
	
	@Autowired
	@Qualifier("award2")
	protected Award award;
	
	public Student3() {}
	
	public Student3(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Required
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








