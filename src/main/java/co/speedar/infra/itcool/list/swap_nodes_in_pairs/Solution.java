package co.speedar.infra.itcool.list.swap_nodes_in_pairs;

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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode lastTail = null;
        while (head != null && head.next != null) {
            ListNode p0 = head;
            ListNode p1 = head.next;
            ListNode p1OriginNext = p1.next;
            p1.next = p0;
            p0.next = p1OriginNext;
            if (lastTail == null) {
                lastTail = p0;
            } else {
                lastTail.next = p1;
                lastTail = p0;
            }
            head = p1OriginNext;
        }
        return newHead;
    }
}