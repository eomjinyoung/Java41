package net.bitacademy.java41.test.t04;

import org.springframework.beans.factory.annotation.Required;

public class Student {
	private String name;
	private int age;
	private String tel;
	private School school;
	
	public Student() {}
	
	public Student(String name) {
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
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
}








