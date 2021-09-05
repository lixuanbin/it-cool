package co.speedar.infra.itcool.sort;

// untested
public class QuickSort {
	// 算法过程：
	// 选择pivot
	// 然后递归地对左右两边调用qsort

	public void qsort(int[] array, int start, int end) {
		if (start < end) {
			int pivot = partition(array, 0, array.length - 1);
			qsort(array, 0, pivot - 1);
			qsort(array, pivot + 1, end);
		}
	}

	public int partition(int[] array, int start, int end) {
		int pivot = array[end];
		int left = start - 1; // 左边
		// 选择最后一个做主元，从0到end-1跟主元比，小的放左边，大的放右边，最后再把主元放回中间
		for (int right = 0; right < end; right++) {
			if (array[right] < pivot) {
				left++;
				swap(array, left, right);
			}
		}
		swap(array, left + 1, end);
		return left + 1;
	}

	private void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	public static void main(String[] args) {

	}
}
