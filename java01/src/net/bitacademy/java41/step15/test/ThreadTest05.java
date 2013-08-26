package net.bitacademy.java41.step15.test;
/* 스레드 동기화 */

public class ThreadTest05 {

	static class Account {
		long balance;
		
		public Account(long money) {
			this.balance = money;
		}
		
		public long getBalance() {
			return this.balance;
		}
		
		// * critical section
		// - 여러 스레드가 동시에 진입하여 같은 객체를 다룰 때 문제가 발생되는 코드 
		// - 해결책: 한번에 하나의 스레드 만이 접근할 수 있도록 한다.
		// - 번호표 나눠준다. -> 화장실 키!
		// 		접근 가능 여부를 관리하기 위한 값 => mutual exclusion (mutex:뮤텍스)
		// * Mutex(뮤텍스)
		// - 뮤텍스 방식은 오로지 1개의 스레드만이 접근 가능한 것.
		// - 1개만 가능한 세미포어 
		
		// * Semaphore(세마포어)
		// - 일정한 스레드의 개수까지는 접근 가능하게 하는 방식
		//
		// * synchronized 
		// - 한번에 하나의 스레드만이 진입할 수 있게 하는 설정
		// - synchronized로 설정된 블럭은 한번에 하나의 스레드 만이 접근 가능하다.
		// - 그러나 객체가 다르다면 동시 진입가능하다. 
		// - mutex(semaphore)는 같은 객체에 대해서 적용한다.
		// - synchronized void 메서드() {}
		// - void 메서드() {
		//		....
		// 		synchronized(객체) { 
		//			critical section 
		//		}
		//		....
		//   }
		synchronized public boolean withdraw(long money) throws Exception {
			long currMoney = this.balance;
			
			if (currMoney <= 0)
				return false;
			
			/* 약간의 지연 발생 */
			int end = (int)(Math.random() * 900)  + 100;
			for(int i = 0; i < end; i++) {
				Math.sin(300);
				Math.tan(20);
			}
			
			currMoney -= money;
			this.balance = currMoney;
			
			return true;
		}
	}
	
	static class ATM extends Thread {
		String location;
		Account account;
		
		public ATM(String location, Account account) {
			this.location = location;
			this.account = account;
		}
		
		@Override
		public void run() {
			try {
				long 찾은금액 = 0;
				for(int i = 0; i < 500; i++) {
					if(account.withdraw(10000)) {
						찾은금액 += 10000;
					}
				}
				System.out.println(location + ":" + 찾은금액);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		Account account = new Account(5000000);
		System.out.println("현재 잔액: " + account.getBalance());
		
		ATM 종로 = new ATM("종로", account);
		ATM 강남 = new ATM("강남", account);
		ATM 부산 = new ATM("부산", account);
		ATM 광주 = new ATM("광주", account);
		ATM 강릉 = new ATM("강릉", account);
		
		종로.start();
		강남.start();
		부산.start();
		광주.start();
		강릉.start();
		
		

	}

}














