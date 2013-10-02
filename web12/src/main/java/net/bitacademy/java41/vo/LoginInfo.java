package net.bitacademy.java41.vo;

public class LoginInfo {
	String 	name;
	String 	email;
	String 	tel;
	String 	photoPath;
	int		level;
	
	public String getName() {
		return name;
	}
	public LoginInfo setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public LoginInfo setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getTel() {
		return tel;
	}
	public LoginInfo setTel(String tel) {
		this.tel = tel;
		return this;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public LoginInfo setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
		return this;
	}
	public int getLevel() {
		return level;
	}
	public LoginInfo setLevel(int level) {
		this.level = level;
		return this;
	}
	
	
}
