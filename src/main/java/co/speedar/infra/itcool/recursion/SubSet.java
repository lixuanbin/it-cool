package co.speedar.infra.itcool.recursion;

import java.util.*;

public class SubSet {
	// 当前索引，需要取几个元素，当前取了几个，结果集，原始数组
	private static void findSubSets(int index, int needed, LinkedList<Integer> selected, List<List<Integer>> results,
			int[] nums) {
		if (selected.size() == needed) {
			results.add(new ArrayList<>(selected));
			return;
		}
		if (index >= nums.length) {
			return;
		}
		selected.addLast(nums[index]);
		findSubSets(index + 1, needed, selected, results, nums);
		selected.removeLast();
		findSubSets(index + 1, needed, selected, results, nums);
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> results = new ArrayList<>();
		findSubSets(0, 1, new LinkedList<>(), results, nums);
		System.out.println(results);
	}
}
