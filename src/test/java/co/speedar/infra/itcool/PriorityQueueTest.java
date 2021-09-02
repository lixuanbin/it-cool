package co.speedar.infra.itcool;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	@Test
	public void testNegative() {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Integer::compareTo);
		priorityQueue.add(-1);
		priorityQueue.add(-2);
		priorityQueue.add(-3);
		priorityQueue.add(-4);
		priorityQueue.add(-5);
		Iterator<Integer> iterator = priorityQueue.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		while(!priorityQueue.isEmpty()) {
			System.out.println(priorityQueue.poll());
		}
	}

	@Test
	public void testLinkedList() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(-1);
		list.add(-2);
		list.add(-3);
		list.add(-4);
		list.add(-5);
		list.add(1, 1);
		System.out.println(list);
	}
}
