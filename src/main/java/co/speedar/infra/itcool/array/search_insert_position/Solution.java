package co.speedar.infra.itcool.array.search_insert_position;

class Solution {
	public int searchInsert(int[] nums, int target) {
		int index = 0;
		int start = 0, end = nums.length - 1, mid = nums.length / 2;
		while (start != end) {
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				start = mid;
				mid = start + (end - start) / 2 + 1;
			} else {
				if (start + 1 == end && nums[start] < target && nums[end] > target) {
					return end;
				}
				end = mid;
				mid = start + (end - start) / 2;
			}
		}
		if (start == nums.length - 1 && nums[end] < target) {
			index = nums.length;
		}
		return index;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 3, 5, 6};
		Solution solution = new Solution();
		System.out.println(solution.searchInsert(arr, 2));
		System.out.println(solution.searchInsert(arr, 5));
		System.out.println(solution.searchInsert(arr, 6));
		System.out.println(solution.searchInsert(arr, 0));

	}
}