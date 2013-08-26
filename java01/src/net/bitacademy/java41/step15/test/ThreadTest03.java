package net.bitacademy.java41.step15.test;

/* 스레드의 lifecycle
 *     start()                                       sleep(), wait()
 * new -------> runnable(only one thread is running) <------------> not runnable
 *                            | 
 *                            |   stop(), run() 호출 종료
 *                            |
 *                          dead (dead 상태에서는 다시 runnable 상태로 복귀 불가)
 */
public class ThreadTest03 implements Runnable {

	public static void main(String[] args) {
		Thread t = new Thread(new ThreadTest03());
		t.start();
		

		for(int i = 0; i < 10000; i++) {
			System.out.println("main ===>" + i);
		}
		
		// 멈춘 스레드는 다시 실행할 수 있는가? NO
		// 한번 멈춘 스레드는 다시 실행할 수 없다.
		t.start();
	}

	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("Worker1:" + i);
		}
	}

}
