package co.speedar.infra.itcool.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TopK {
	public int[] topKMax(int[] array, int k) {
		MyBoundedPriorityQueue<Integer> pq = new MyBoundedPriorityQueue<>(k, Comparator.naturalOrder());
		addToQueue(array, pq);
		int[] result = queueToArray(pq);
		reverseArray(result);
		return result;
	}

	public int[] topKMin(int[] array, int k) {
		MyBoundedPriorityQueue<Integer> pq = new MyBoundedPriorityQueue<>(k, Comparator.reverseOrder());
		addToQueue(array, pq);
		int[] result = queueToArray(pq);
		reverseArray(result);
		return result;
	}

	private void addToQueue(int[] array, PriorityQueue<Integer> queue) {
		for (int i : array) {
			queue.add(i);
		}
	}

	private int[] queueToArray(PriorityQueue<Integer> queue) {
		int size = queue.size();
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			result[i] = queue.poll();
		}
		return result;
	}

	private void reverseArray(int[] array) {
		int h = array.length / 2 - 1;
		for (int i = 0; i <= h; i++) {
			int tmp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = tmp;
		}
	}

	class MyBoundedPriorityQueue<E> extends PriorityQueue<E> {
		// 实现一个有界的优先队列，入列时候按照大小放到对应的位置，re-balance一下
		// https://stackoverflow.com/questions/7878026/is-there-a-priorityqueue-implementation-with-fixed-capacity-and-custom-comparato
		private int boundary;

		MyBoundedPriorityQueue(int boundary, Comparator<? super E> comparator) {
			super(comparator);
			this.boundary = boundary;
		}

		// 重写入列方法
		@Override
		public boolean add(E o) {
			if (size() < boundary) {
				return super.add(o);
			} else {
				if (super.comparator().compare(o, peek()) > 0) {
					poll();
					return super.add(o);
				} else {
					return false;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = {99897, 1, 2, 3, 2, 33, 234, -134};
		System.out.println(Arrays.toString(new TopK().topKMax(a, 3))); // NOSONAR
		System.out.println(Arrays.toString(new TopK().topKMin(a, 3))); // NOSONAR
	}
}
