package co.speedar.infra.itcool.threading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinTest {
	private static class SumTask extends RecursiveTask<Long> {
		private long[] numbers;
		private int from;
		private int to;

		public SumTask(long[] numbers, int from, int to) {
			this.numbers = numbers;
			this.from = from;
			this.to = to;
		}

		/**
		 * ForkJoin执行任务的核心方法
		 * @return
		 */
		@Override
		protected Long compute() {
			if (to - from < 10) { // 设置拆分的最细粒度，即阈值，如果满足条件就不再拆分，执行计算任务
				long total = 0;
				for (int i = from; i <= to; i++) {
					total += numbers[i];
				}
				return total;
			} else { // 否则继续拆分，递归调用
				int middle = (from + to) / 2;
				SumTask taskLeft = new SumTask(numbers, from, middle);
				SumTask taskRight = new SumTask(numbers, middle + 1, to);
				taskLeft.fork();
				taskRight.fork();
				return taskLeft.join() + taskRight.join();
			}
		}
	}

	public static long sumDirectly(long[] numbers) {
		long sum = 0;
		for (long i : numbers) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		long[] numbers = LongStream.rangeClosed(1, 100000000).toArray();
		long begin = System.currentTimeMillis();
		long result = sumDirectly(numbers);
		long consumed = System.currentTimeMillis() - begin;
		System.out.println("result: " + result + ", consumed: " + consumed + " ms");
		ForkJoinPool pool = ForkJoinPool.commonPool();
		begin = System.currentTimeMillis();
		result = pool.invoke(new SumTask(numbers, 0, numbers.length - 1));
		consumed = System.currentTimeMillis() - begin;
		pool.shutdown();
		System.out.println("result: " + result + ", consumed: " + consumed + " ms");
	}
}
