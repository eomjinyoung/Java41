package net.bitacademy.java41.test.t05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Student {
	private String name;
	private int age;
	private String tel;
	private School school;
	private Award award;
	
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
	
	// school 프로퍼티에 대해서만 자동으로 의존 객체를 주입한다.(byType)
	/* @Autowired
	 * - 기본은 해당 타입의 의존객체가 없다면 오류가 발생한다.
	 * - required를 false로 설정하면, 선택 사항이 된다.
	 */
	@Autowired(required=false)
	public void setSchool(School school) {
		this.school = school;
	}
	
	public Award getAward() {
		return award;
	}
	public void setAward(Award award) {
		this.award = award;
	}
	
}








