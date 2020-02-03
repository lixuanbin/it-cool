package co.speedar.infra.itcool.array.remove_element;

class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int i = 0;
        while (i < length && length > 0) {
            if (nums[i] == val) {
                if (i < length - 1) {
                    int tmp = nums[length - 1];
                    nums[length - 1] = nums[i];
                    nums[i] = tmp;
                    length--;
                } else {
                    return --length;
                }
            } else {
                i++;
            }
        }
        return length;
    }
}