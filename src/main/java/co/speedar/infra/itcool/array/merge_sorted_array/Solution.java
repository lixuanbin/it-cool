package co.speedar.infra.itcool.array.merge_sorted_array;

import java.util.Arrays;

class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] twin1 = new int[m];
		System.arraycopy(nums1, 0, twin1, 0, m);
		int i = 0, j = 0, k = 0;
		while (i < m && j < n) {
			if (twin1[i] < nums2[j]) {
				nums1[k++] = twin1[i++];
			} else {
				nums1[k++] = nums2[j++];
			}
		}
		if (j < n) {
			System.arraycopy(nums2, j, nums1, k, m + n - k);
		}
		if (i < m) {
			System.arraycopy(twin1, i, nums1, k, m + n - k);
		}
	}

	public static void main(String[] args) {
		int[] nums1 = {4, 0, 0, 0, 0, 0};
		int[] nums2 = {1, 2, 3, 5, 6};
		new Solution().merge(nums1, 1, nums2, 5);
		System.out.println(Arrays.toString(nums1));
		nums1 = new int[]{2, 0};
		nums2 = new int[]{1};
		new Solution().merge(nums1, 1, nums2, 1);
		System.out.println(Arrays.toString(nums1));
	}
}