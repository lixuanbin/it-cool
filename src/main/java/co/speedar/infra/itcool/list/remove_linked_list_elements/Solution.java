package co.speedar.infra.itcool.list.remove_linked_list_elements;

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
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode p0 = head;
        while (p0 != null && p0.next != null) {
            ListNode p1 = p0.next;
            while (p1 != null && p1.val == val) {
                p0.next = p1.next;
                p1 = p1.next;
            }
            p0 = p0.next;
        }
        return head;
    }
}