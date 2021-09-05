package co.speedar.infra.itcool.sort;

public class BubbleSort {
	public void sort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		// int[] arr = {1, 4, 3, 2, 5};
		int[] arr = SortHelper.getInstance().generateRandomIntArray();
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(arr);
		System.out.println(SortHelper.getInstance().validateSort(arr));
        /*for (int i : arr) {
            System.out.println(i);
        }*/
	}
}