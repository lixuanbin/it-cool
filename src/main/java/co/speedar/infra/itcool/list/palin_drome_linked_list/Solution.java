package co.speedar.infra.itcool.list.palin_drome_linked_list;

import co.speedar.infra.itcool.list.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        java.util.Stack<ListNode> stack = new java.util.Stack<>();
        ListNode tmpHead = head;
        while (tmpHead != null) {
            stack.push(tmpHead);
            tmpHead = tmpHead.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}