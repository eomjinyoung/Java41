package net.bitacademy.java41.step11;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String 	name;
	private String 	phone;
	private String 	email;
	private String 	blog;
	private int 		age;
	private Date 	regDate;
	
	public String getName() {
		return name;
	}
	public Member setName(String name) {
		this.name = name;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public Member setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Member setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getBlog() {
		return blog;
	}
	public Member setBlog(String blog) {
		this.blog = blog;
		return this;
	}
	public int getAge() {
		return age;
	}
	public Member setAge(int age) {
		if (age > 0 && age < 120) {
			this.age = age;
		} 
		return this;
	}
	public Date getRegDate() {
		return regDate;
	}
	public Member setRegDate(Date regDate) {
		this.regDate = regDate;
		return this;
	}
	
	public Member clone() {
		Member m = new Member();
		m.name = this.name;
		m.phone = this.phone;
		m.email = this.email;
		m.blog = this.blog;
		m.age = this.age;
		m.regDate = this.regDate;
		
		return m;
	}
	
	
}
















