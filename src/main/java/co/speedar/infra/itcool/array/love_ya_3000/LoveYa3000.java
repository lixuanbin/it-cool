package co.speedar.infra.itcool.array.love_ya_3000;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LoveYa3000 {
	final static AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);
	static class LoveYaTask extends Thread {
		@Override
		public void run() {
			System.out.println("我爱你" + ATOMIC_INTEGER.get());
			if (ATOMIC_INTEGER.incrementAndGet() < 10000) {
				new LoveYaTask().start();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		new LoveYaTask().start();
//		final AtomicInteger count = new AtomicInteger(0);
//		final CountDownLatch latch = new CountDownLatch(1);
//		final ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(1);
//		scheduler.scheduleWithFixedDelay(new Runnable() {
//			@Override
//			public void run() {
//				if (count.incrementAndGet() <= 10000) {
//					System.out.println("我爱你");
//				} else {
//					latch.countDown();
//					scheduler.shutdown();
//				}
//			}
//		}, 0, 1, TimeUnit.MILLISECONDS);
//		latch.await();
//		System.out.println("done...");
//
//		loveYa10000();
	}

	public static void loveYa10() {
		System.out.println("我爱你");
		System.out.println("我爱你");
		System.out.println("我爱你");
		System.out.println("我爱你");
		System.out.println("我爱你");
		System.out.println("我爱你");
		System.out.println("我爱你");
		System.out.println("我爱你");
		System.out.println("我爱你");
		System.out.println("我爱你");
	}

	public static void loveYa100() {
		loveYa10();
		loveYa10();
		loveYa10();
		loveYa10();
		loveYa10();
		loveYa10();
		loveYa10();
		loveYa10();
		loveYa10();
		loveYa10();
	}

	public static void loveYa1000() {
		loveYa100();
		loveYa100();
		loveYa100();
		loveYa100();
		loveYa100();
		loveYa100();
		loveYa100();
		loveYa100();
		loveYa100();
		loveYa100();
	}

	public static void loveYa10000() {
		loveYa1000();
		loveYa1000();
		loveYa1000();
		loveYa1000();
		loveYa1000();
		loveYa1000();
		loveYa1000();
		loveYa1000();
		loveYa1000();
		loveYa1000();
	}
}
