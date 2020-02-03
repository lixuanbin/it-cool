package co.speedar.infra.itcool.array.container_with_most_water;

class Solution {
	public int maxArea(int[] height) {
		// O(n^2)，还有无更优解法？
		int maxArea = 0;
		for (int i = height.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				int tmpArea = calculateArea(height[i], height[j], i - j);
				if (tmpArea > maxArea) {
					maxArea = tmpArea;
				}
			}
		}
		return maxArea;
	}

	private int calculateArea(int start, int end, int length) {
		return length * (start < end ? start : end);
	}
}