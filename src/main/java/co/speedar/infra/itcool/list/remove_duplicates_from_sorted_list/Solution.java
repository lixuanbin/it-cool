package co.speedar.infra.itcool.list.remove_duplicates_from_sorted_list;

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p0 = head;
        ListNode p1 = head.next;
        while (p0 != null) {
            while (p1 != null && p0.val == p1.val) {
                p1 = p1.next;
                p0.next = p1;
            }
            p0 = p0.next;
        }
        return head;
    }
}