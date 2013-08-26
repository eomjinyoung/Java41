package net.bitacademy.java41.step15.test;

// 이미 해당 이름으로 패키지 멤버 클래스가 존재한다면,
// 중복해서 정의할 수 없다.
/*
class Worker1 {
	
}
*/

// 일반 클래스의 명칭: 패키지 멤버 클래스 
/* sleep(): 지정한 시간만큼 not runnable 상태로 만드는 것.
 * - 시간이 경과되면 다시 runnable 상태로 된다.
 */
public class ThreadTest04 {

	// Top level inner class
	static class Worker1 extends Thread {
		@Override
		public void run() {
			for(int i = 1; i <= 10000; i++) {
				if ((i % 1000) == 0) {
					try {
						this.sleep(50); // CPU 쟁탈전에서 제외 시킴.(not runnable)
					} catch (Exception e) {}
				}
				System.out.println("Worker1 ===>" + i);
			}
		}
	}
	
	public static void main(String[] args) {
		Worker1 t = new Worker1();
		t.start();
		
		for(int i = 0; i < 10000; i++) {
			System.out.println("main ===>" + i);
		}

	}

}





