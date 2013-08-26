package net.bitacademy.java41.step15.test;

/* JVM이 관리하는 스레드 */
public class ThreadTest01 {

	public static void main(String[] args) {
		Thread t1 = Thread.currentThread();
		System.out.println("1:" + t1.getName()); // main thread

		ThreadGroup tg = t1.getThreadGroup();
		System.out.println("2:" + tg.getName()); // main tread group
		
		ThreadGroup tg2 = null;
		if (tg.getParent() != null) {
			tg2 = tg.getParent();
			System.out.println("3:" + tg2.getName()); // system thread group
		}
		
		if (tg2.getParent() != null) { // system's parent thread group is null.
			tg2 = tg2.getParent();
			System.out.println("4:" + tg2.getName());
		}
		
		tg2.list();
		/*
		 * Priority: 
		 * - 1 ~ 10
		 * - 자식 스레드는 부모의 우선 순위와 같은 값을 가진다.
		 * 
java.lang.ThreadGroup[name=system,maxpri=10]
Thread[Reference Handler,10,system]
Thread[Finalizer,8,system]
Thread[Signal Dispatcher,9,system]
java.lang.ThreadGroup[name=main,maxpri=10]
    Thread[main,5,main]
		 */
	}

}










