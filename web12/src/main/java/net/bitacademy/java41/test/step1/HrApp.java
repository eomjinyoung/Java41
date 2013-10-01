package net.bitacademy.java41.test.step1;

public class HrApp {
	
	public static void main(String[] args) throws Exception {
		AccAppStub stub = new AccAppStub("localhost", 8989);
		
		System.out.println( stub.getSalary("홍길동") );
		stub.addSalary("가나다", 9000);
		System.out.println( stub.getSalary("가나다") );

	}

}











