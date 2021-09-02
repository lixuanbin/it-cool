package co.speedar.infra.itcool;

import java.util.concurrent.TimeUnit;

public class SleepTest {
	private static Object o = new Object();
	private static Runnable r = () -> {
		System.out.println(Thread.currentThread().getName() + " is about to get lock...");
		synchronized (o) {
			try {
				System.out.println(Thread.currentThread().getName() + " lock acquired, about to sleep...");
				TimeUnit.SECONDS.sleep(300l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	public static void main(String[] args) {
		Thread t1 = new Thread(r, "t1");
		Thread t2 = new Thread(r, "t2");
		t1.start();
		t2.start();
	}
}
