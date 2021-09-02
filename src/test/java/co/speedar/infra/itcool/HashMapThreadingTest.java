package co.speedar.infra.itcool;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class HashMapThreadingTest {
	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(1);
		final HashMap<String, Integer> map = new HashMap<>();
		Runnable r = () -> {
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " begin...");
			for (int i = 0; i < 10000000; i++) {
				map.put(Thread.currentThread().getName(), i);
			}
			System.out.println(Thread.currentThread().getName() + " done...");
		};
		for (int i = 0; i < 1000; i++) {
			Thread t = new Thread(r, "t" + i);
			t.start();
		}
		latch.countDown();
		System.out.println(Thread.currentThread().getName() + " done...");
	}
}
