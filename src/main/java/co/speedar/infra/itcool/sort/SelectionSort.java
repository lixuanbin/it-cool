package co.speedar.infra.itcool.sort;

public class SelectionSort {
	public void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = arr[i];
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {1, 3, 9, 6, 7};
		SelectionSort sort = new SelectionSort();
		sort.sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
