package net.bitacademy.java41.step15.test;
/* 스레드 만들기
 * 1) Thread의 서브클래스
 * 2) Runnable 인터페이스를 구현
 */

/* Thread의 서브클래스 방식 
 * - 단점: 만약 다른 클래스를 이미 상속받고 있는 중이라면 
 *        Thread를 상속 받을 수 없어서 유연성이 떨어진다. 
 */
class Worker1 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 20000; i++) {
			System.out.println("Worker1:" + i);
		}
	}
}

/* Runnable 인터페이스를 구현하는 방식 
 * - Thread를 통해 수행된다.
 * - 다른 클래스를 상속받을 수 있다.
 */
class Other {
	public void print(int i) {
		System.out.println("Worker2 ********** " + i);
	}
}

/* 직접 스레드가 되기 보다는 스레드가 할 일을 정의하는 방식 */
class Worker2 extends Other implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i < 20000; i++) {
			print(i);
		}
	}
}


public class ThreadTest02 {
	public static void main(String[] args) {
		// Worker1은 main 스레드의 자식이다. 부모와 같은 우선순위를 갖는다.(5)
		Worker1 w1 = new Worker1();
		w1.start();
		
		Worker2 w2 = new Worker2();
		// t는 main 스레드의 자식이다. 
		Thread t = new Thread(w2);
		t.start();
		
		for(int i = 0; i < 20000; i++) {
			System.out.println("main ===>" + i);
		}
	}

}












