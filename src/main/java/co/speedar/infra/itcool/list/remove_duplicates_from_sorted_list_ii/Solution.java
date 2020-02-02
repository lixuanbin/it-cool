package co.speedar.infra.itcool.list.remove_duplicates_from_sorted_list_ii;

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
        while (head != null && head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            head = head.next;
        }
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }
}