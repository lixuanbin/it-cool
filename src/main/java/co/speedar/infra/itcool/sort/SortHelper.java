package co.speedar.infra.itcool.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class SortHelper {
	private SortHelper() {
	}

	private static SortHelper instance = new SortHelper();

	public static SortHelper getInstance() {
		return instance;
	}

	public Order validateSort(int[] arr) {
		if (arr == null) {
			return Order.NONE;
		}
		if (arr.length == 1) {
			return Order.BOTH;
		}
		if (arr[0] <= arr[1]) {
			int inOrdered = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] <= arr[i + 1]) {
					inOrdered++;
				} else {
					break;
				}
			}
			if (inOrdered == arr.length - 1) {
				return Order.ASCENDING;
			}
		}
		if (arr[0] >= arr[1]) {
			int inOrdered = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] >= arr[i + 1]) {
					inOrdered++;
				} else {
					break;
				}
			}
			if (inOrdered == arr.length - 1) {
				return Order.DESCENDING;
			}
		}
		return Order.UNORDERED;
	}

	public int[] generateRandomIntArray(int size, int bound) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = ThreadLocalRandom.current().nextInt(bound);
		}
		return arr;
	}

	public int[] generateRandomIntArray() {
		return generateRandomIntArray(100, 1000);
	}

	public final void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr)); // NOSONAR
	}

	public enum Order {
		ASCENDING, DESCENDING, UNORDERED, NONE, BOTH
	}
}