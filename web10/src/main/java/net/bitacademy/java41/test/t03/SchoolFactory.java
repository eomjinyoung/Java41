package net.bitacademy.java41.test.t03;

public class SchoolFactory {
	public static School createSchool() {
		School s = new School();
		s.setName("비트중학교");
		
		return s;
	}
}
