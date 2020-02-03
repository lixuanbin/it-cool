package co.speedar.infra.itcool.array.remove_duplicates_from_sorted_array;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int length = nums.length;
        int i = 0;
        while (i < length - 1) {
            if (nums[i] == nums[i + 1]) {
                deleteAtIndex(nums, i + 1);
                length--;
            } else {
                i++;
            }
        }
        return length;
    }
    private void deleteAtIndex(int[] nums, int i) {
        for (int j = i; j < nums.length - 1; j++) {
            nums[j] = nums[j + 1];
        }
    }
}