package co.speedar.infra.itcool.sort;

public class MergeSort implements Sort {
	public void sort(int[] a) {
		mergeSort(a, new int[a.length], 0, a.length - 1);
	}

	public void mergeSort(int[] a, int[] temp, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(a, temp, l, m);
			mergeSort(a, temp, m + 1, r);
			merge(a, temp, l, m, r);
		}
	}

	public void merge(int[] a, int[] temp, int l, int m, int r) {
		// [l, m], [m+1, r]
		int ls = l;
		int rs = m + 1;
		int i = l;
		while (ls <= m && rs <= r) {
			if (a[ls] <= a[rs]) {
				temp[i++] = a[ls++];
			} else {
				temp[i++] = a[rs++];
			}
		}
		while (ls <= m) {
			temp[i++] = a[ls++];
		}
		while (rs <= r) {
			temp[i++] = a[rs++];
		}
		if (r + 1 - l >= 0) {
			System.arraycopy(temp, l, a, l, r + 1 - l);
		}
	}

	public static void main(String[] args) {
		// int[] a = {1, 3, 5, 4, 6, 2};
		int[] a = SortHelper.getInstance().generateRandomIntArray();
		new MergeSort().sort(a);
		/*for (int i : a) {
			System.out.println(i);
		}*/
		System.out.println(SortHelper.getInstance().validateSort(a));
	}
}
