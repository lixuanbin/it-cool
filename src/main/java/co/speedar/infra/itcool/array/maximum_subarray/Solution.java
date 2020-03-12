package co.speedar.infra.itcool.array.maximum_subarray;

import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode-cn.com/problems/maximum-subarray/
class Solution {
	public int maxSubArray(int[] nums) {
		int i = 0;
		int sum = nums[i++];
		// start from the first positive
		if (sum < 0) {
			while (i < nums.length && nums[i] < 0) {
				if (nums[i] > sum) {
					sum = nums[i];
				}
				i++;
			}
			if (i < nums.length && nums[i] > sum) {
				sum = nums[i];
				i++;
			}
		}
		int tmpSum = sum;
		Queue<Integer> positiveIndex = new ArrayDeque<>(nums.length);
		while (i < nums.length) {
			tmpSum += nums[i];
			if (nums[i] > 0) {
				positiveIndex.offer(i);
			}
			if (tmpSum > sum) {
				sum = tmpSum;
			}
			if (i < nums.length - 1 && nums[i] < 0 && tmpSum < 0 && nums[i + 1] > tmpSum) {
				tmpSum = nums[i + 1];
				if (tmpSum > sum) {
					sum = tmpSum;
				}
				if (!positiveIndex.isEmpty()) {
					i = positiveIndex.poll();
					positiveIndex.clear();
					continue;
				} else {
					i++;
				}
			}
			i++;
		}
		return sum;
	}

	public static void main(String[] args) {
		// System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
		// System.out.println(new Solution().maxSubArray(new int[]{1}));
		// System.out.println(new Solution().maxSubArray(new int[]{1, 2}));
		// System.out.println(new Solution().maxSubArray(new int[]{8, -19, 5, -4, 20}));
		System.out.println(new Solution().maxSubArray(new int[]{-1, 6, 7, -7, -2, -6, -1, 3, 4, 2, 6, -3, -8, -1, 7}));
	}
}