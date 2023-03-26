package co.speedar.infra.itcool.sort;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortTest {
	private void doTest(Sort sort, int round) {
		Set<SortHelper.Order> resultSet = new HashSet<>();
		long consumed = 0;
		for (int i = 1; i <= round; i++) {
			// System.out.println(i); // NOSONAR
			int[] arr = SortHelper.getInstance().generateRandomIntArray(i, i);
			// SortHelper.getInstance().printArray(arr);
			long now = System.nanoTime();
			sort.sort(arr);
			consumed = System.nanoTime() - now;
			resultSet.add(SortHelper.getInstance().validateSort(arr));
		}
		assertTrue(resultSet.contains(SortHelper.Order.ASCENDING));
		assertTrue(resultSet.contains(SortHelper.Order.BOTH));
		assertEquals(2, resultSet.size());
		System.out.println(
				"sort: " + sort.getClass().getSimpleName() + ", time consumed: " + consumed + " nano seconds...");
	}

	// @Test
	public void testQuickSort() {
		// TODO 三个数重复就会发生死循环
		Sort quickSort = new QuickSort();
		doTest(quickSort, 1000);
	}

	@Test
	public void testBubbleSort() {
		Sort bubbleSort = new BubbleSort();
		doTest(bubbleSort, 1000);
	}

	@Test
	public void testSelectionSort() {
		Sort bubbleSort = new SelectionSort();
		doTest(bubbleSort, 1000);
	}

	@Test
	public void testInsertionSort() {
		Sort bubbleSort = new InsertionSort();
		doTest(bubbleSort, 1000);
	}

	@Test
	public void testMergeSort() {
		Sort bubbleSort = new MergeSort();
		doTest(bubbleSort, 1000);
	}
}
