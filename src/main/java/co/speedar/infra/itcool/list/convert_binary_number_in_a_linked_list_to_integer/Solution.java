package co.speedar.infra.itcool.list.convert_binary_number_in_a_linked_list_to_integer;

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
    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return head.val;
        }
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        int result = 0;
        while (head != null) {
            n--;
            if (head.val == 1) {
                result += (int) java.lang.Math.pow(2, n);
            }
            head = head.next;
        }
        return result;
    }
}