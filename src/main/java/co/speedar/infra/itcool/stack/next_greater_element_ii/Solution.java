package co.speedar.infra.itcool.stack.next_greater_element_ii;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
	public int[] nextGreaterElements(int[] nums) {
		int[] result = new int[nums.length];
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(i, -1);
		}
		for (int i = 0; i < nums.length * 2; i++) {
			while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek() % nums.length]) {
				map.put(stack.pop() % nums.length, i % nums.length);
			}
			stack.push(i);
		}
		for (int i = 0; i < nums.length; i++) {
			result[i] = map.get(i) != -1 ? nums[map.get(i)] : -1;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 1};
		System.out.println(Arrays.toString(new Solution().nextGreaterElements(nums)));
	}
}