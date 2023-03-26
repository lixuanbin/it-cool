package co.speedar.infra.itcool.sort;

public class QuickSort implements Sort {
	public void sort(int[] arr) {
		qsort(arr, 0, arr.length - 1);
	}

	public void qsort(int[] arr, int l, int r) {
		if (l < r) {
			int pivot = partition(arr, l, r);
			qsort(arr, l, pivot - 1);
			qsort(arr, pivot, r);
		}
	}

	public int partition(int[] arr, int l, int r) {
		// 三数取中值，尽量避免最坏情况
		int m = (l + r) / 2;
		if (arr[l] > arr[m]) {
			SortHelper.getInstance().swap(arr, l, m);
		}
		if (arr[m] > arr[r]) {
			SortHelper.getInstance().swap(arr, m, r);
		}
		if (arr[l] > arr[r]) {
			SortHelper.getInstance().swap(arr, l, r);
		}
		// 把主元放回最左边
		SortHelper.getInstance().swap(arr, l, m);
		int i = l + 1;
		int j = r;
		int middle = arr[l];
		while (i < j) {
			while (arr[j] > middle && j > i) {
				j--;
			}
			while (arr[i] < middle && i < j) {
				i++;
			}
			SortHelper.getInstance().swap(arr, i, j);
		}
		if (arr[l] > arr[i]) {
			SortHelper.getInstance().swap(arr, l, i);
		}
		return i;
	}

	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] arr = SortHelper.getInstance().generateRandomIntArray(9, 9);
		SortHelper.getInstance().printArray(arr);
        /*int pivot = quickSort.partition(arr, 0, arr.length - 1);
        System.out.println("pivot: " + pivot);
        SortHelper.getInstance().printArray(arr);*/
		quickSort.sort(arr);
		SortHelper.getInstance().printArray(arr);
		System.out.println(SortHelper.getInstance().validateSort(arr));
	}
}