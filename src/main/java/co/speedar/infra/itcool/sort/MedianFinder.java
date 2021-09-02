package co.speedar.infra.itcool.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	private PriorityQueue<Integer> left;
	private PriorityQueue<Integer> right;

	/** initialize your data structure here. */
	public MedianFinder() {
		left = new PriorityQueue<>(Comparator.reverseOrder());
		right = new PriorityQueue<>();
	}

	public void addNum(int num) {
		if ((left.peek() != null && left.peek() > num) || left.isEmpty()) {
			left.offer(num);
		} else {
			right.offer(num);
		}
		// re-balance
		while (left.size() - right.size() > 1) {
			right.offer(left.poll());
		}
		while (right.size() - left.size() > 1) {
			left.offer(right.poll());
		}
	}

	public double findMedian() {
		if (left.size() - right.size() == 1) {
			return left.peek();
		} else if (right.size() - left.size() == 1) {
			return right.peek();
		} else if (left.size() == right.size()) {
			return (left.peek() + right.peek()) / 2.0d;
		} else {
			throw new IllegalStateException("Illegal state, left heap and right is not balance!");
		}
	}

	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		/*medianFinder.addNum(1);
		medianFinder.print();
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(9);
		medianFinder.print();
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(2);
		medianFinder.print();
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(4);
		medianFinder.print();
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(5);
		medianFinder.print();
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(6);
		medianFinder.print();
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(7);
		medianFinder.print();
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(8);
		medianFinder.print();
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(3);
		medianFinder.print();
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(10);
		medianFinder.print();
		System.out.println(medianFinder.findMedian());*/
		medianFinder = new MedianFinder();
		medianFinder.addNum(6);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(10);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(2);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(6);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(5);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(0);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(6);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(3);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(1);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(0);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(0);
		System.out.println(medianFinder.findMedian());
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */