package co.speedar.infra.itcool.list.remove_zero_sum_consecutive_nodes_from_linked_list;

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
	public ListNode removeZeroSumSublists(ListNode head) {
		if (head == null || (head.next == null && head.val == 0)) {
			return null;
		}
		ListNode pre = new ListNode(-1);
		pre.next = head;
		ListNode p0 = pre;
		ListNode p1 = pre.next;
		out:
		while (p1 != null) {
			int sum = 0;
			ListNode pn = p1;
			while (pn != null) {
				sum += pn.val;
				if (sum == 0) {
					// delete p1 to pn
					p0.next = pn.next;
					p1 = pn.next;
					continue out;
				}
				pn = pn.next;
			}
			p0 = p0.next;
			p1 = p1.next;
		}
		return pre.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		new Solution().removeZeroSumSublists(head);
	}
}