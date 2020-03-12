package co.speedar.infra.itcool.stack.next_greater_element_i;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution2 {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>();
		int[] result = new int[nums1.length];
		for (int i = 0; i < nums2.length; i++) {
			while (!stack.isEmpty() && stack.peek() < nums2[i]) {
				map.put(stack.pop(), nums2[i]);
			}
			stack.push(nums2[i]);
		}
		while (!stack.isEmpty()) {
			map.put(stack.pop(), -1);
		}
		for (int i = 0; i < nums1.length; i++) {
			result[i] = map.get(nums1[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums1 = {4, 1, 2};
		int[] nums2 = {1, 3, 4, 2};
		System.out.println(Arrays.toString(new Solution2().nextGreaterElement(nums1, nums2)));
	}
}
