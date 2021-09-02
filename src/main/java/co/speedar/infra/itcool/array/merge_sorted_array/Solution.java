package co.speedar.infra.itcool.array.merge_sorted_array;

import java.util.Arrays;

class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n <= 0) {
			return;
		}
		if (m <= 0) {
			System.arraycopy(nums2, 0, nums1, 0, n);
			return;
		}
		// 把nums1原来到拷贝到后半截，腾出空间用来合并
		System.arraycopy(nums1, 0, nums1, n, m);
		int i = n, j = 0, k = 0;
		while (i < n + m && j < n) {
			if (nums1[i] <= nums2[j]) {
				nums1[k++] = nums1[i];
				i++;
			} else {
				nums1[k++] = nums2[j++];
			}
		}
		// 处理左右两边可能的剩余数据
		if (i < n + m) {
			System.arraycopy(nums1, i, nums1, k, n + m - i);
		}
		if (j < n) {
			System.arraycopy(nums2, j, nums1, k, n - j);
		}
		// 引申问题：k路合并时候的处理和时间复杂度推导
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