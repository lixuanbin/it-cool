package co.speedar.infra.itcool.list.merge_two_sorted_lists;

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head;
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        if(l1.val <= l2.val) {
            head = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            head = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ListNode t = new ListNode(l1.val);
                temp.next = t;
                temp = temp.next;
                l1 = l1.next;
            } else {
                ListNode t = new ListNode(l2.val);
                temp.next = t;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }
        return head;
    }
}