package net.bitacademy.java41.test.step1;

import java.util.HashMap;

public class AccApp {
	static HashMap<String,Integer> table = new HashMap<String,Integer>();
	
	public AccApp() {
		table.put("홍길동", 6000);
		table.put("임꺽정", 8000);
		table.put("일지매", 4000);
	}
	
	public int getSalary(String name) {
		return table.get(name);
	}
	
	public void addSalary(String name, int salary) {
		table.put(name, salary);
	}
}

