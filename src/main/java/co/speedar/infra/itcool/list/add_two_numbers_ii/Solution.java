package co.speedar.infra.itcool.list.add_two_numbers_ii;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1.用栈；2.递归处理；3.翻转链表用add two numbers处理然后再翻转回来；
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        java.util.Stack<ListNode> s1 = new java.util.Stack<>();
        java.util.Stack<ListNode> s2 = new java.util.Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        java.util.Stack<Integer> s = new java.util.Stack<>();
        int carrier = 0;
        while ((!s1.isEmpty() && !s2.isEmpty()) || 
            (!s1.isEmpty() && carrier > 0) || (!s2.isEmpty() && carrier > 0)) {
                int sum = (!s1.isEmpty() ? s1.pop().val : 0) + (!s2.isEmpty() ? s2.pop().val : 0)
                    + carrier;
                carrier = sum / 10;
                s.push(sum % 10);
        }
        while (!s1.isEmpty()) {
            s.push(s1.pop().val);
        }
        while (!s2.isEmpty()) {
            s.push(s2.pop().val);
        }
        if (carrier > 0) {
            s.push(carrier);
        }
        ListNode result = new ListNode(-1);
        ListNode p = result;
        while (!s.isEmpty()) {
            p.next = new ListNode(s.pop());
            p = p.next;
        }
        return result.next;
    }
}