package co.speedar.infra.itcool.array._3sum_closest;


// https://leetcode-cn.com/problems/3sum-closest/
class Solution {
	public int threeSumClosest(int[] nums, int target) {
		int sum = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int tmp = nums[i] + nums[j] + nums[k];
					if (isCloser(sum, tmp, target)) {
						sum = tmp;
					}
				}
			}
		}
		return sum;
	}

	private boolean isCloser(int previous, int candidate, int target) {
		boolean closer = false;
		if (previous == Integer.MAX_VALUE || Math.abs(previous - target) > Math.abs(candidate - target)) {
			closer = true;
		}
		return closer;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().threeSumClosest(new int[]{1, 1, -1, -1, 3}, 3));
	}
}