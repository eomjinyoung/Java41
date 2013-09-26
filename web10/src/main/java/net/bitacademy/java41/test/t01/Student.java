package net.bitacademy.java41.test.t01;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
	private String name;
	private int age;
	private String tel;
	private int[] scores;
	private List<String> schoolList;
	private Set<String> courseList;
	private Map<String,String> familyMap;
	
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
	public int[] getScores() {
		return scores;
	}
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	public List<String> getSchoolList() {
		return schoolList;
	}
	public void setSchoolList(List<String> schoolList) {
		this.schoolList = schoolList;
	}
	public Set<String> getCourseList() {
		return courseList;
	}
	public void setCourseList(Set<String> courseList) {
		this.courseList = courseList;
	}
	public Map<String, String> getFamilyMap() {
		return familyMap;
	}
	public void setFamilyMap(Map<String, String> familyMap) {
		this.familyMap = familyMap;
	}
	
	
}








