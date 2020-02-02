package co.speedar.infra.itcool.list.rotate_list;

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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tmp = head;
        ListNode newHead = null;
        int size = 1;
        java.util.Stack<ListNode> stack = new java.util.Stack<ListNode>();
        while (tmp.next != null) {
            stack.push(tmp);
            size++;
            tmp = tmp.next;
        }
        if (k % size == 0) {
            return head;
        }
        stack.push(tmp);
        tmp.next = head;
        if (k > size) {
            k %= size;
        }
        for (int i = 0; i < k; i++) {
            newHead = stack.pop();
        }
        while (head.next != newHead) {
            head = head.next;
        }
        head.next = null;
        return newHead;
    }
}