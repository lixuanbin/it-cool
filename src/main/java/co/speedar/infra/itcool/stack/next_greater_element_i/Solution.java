package co.speedar.infra.itcool.stack.next_greater_element_i;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            int find = -1;
            for (int j = nums2.length - 1; j >=0; j--) {
                if (nums2[j] == nums1[i]) {
                    break;
                }
                if (nums2[j] > nums1[i]) {
                    stack.push(nums2[j]);
                }
            }
            if (!stack.isEmpty()) {
                find = stack.pop();
                stack.clear();
            }
            result[i] = find;
        }
        return result;
    }
}