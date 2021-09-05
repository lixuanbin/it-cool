package co.speedar.infra.itcool.sort;

public class InsertionSort {
	public void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i;
			while (j > 0 && temp < arr[j - 1]) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
	}

	public static void main(String[] args) {
		// int[] arr = {1, 4, 2, 6, 3};
		int[] arr = SortHelper.getInstance().generateRandomIntArray();
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.sort(arr);
		System.out.println(SortHelper.getInstance().validateSort(arr));
        /*for (int i : arr) {
            System.out.println(i);
        }*/
	}
}