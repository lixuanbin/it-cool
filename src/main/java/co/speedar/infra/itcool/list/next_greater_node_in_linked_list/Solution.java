package co.speedar.infra.itcool.list.next_greater_node_in_linked_list;

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
	public int[] nextLargerNodes(ListNode head) {
		if (head == null) {
			return new int[0];
		}
		if (head.next == null) {
			return new int[]{0};
		}
		ListNode resultHead = new ListNode(-1);
		ListNode result = resultHead;
		ListNode p0 = head;
		int length = 0;
		while (p0 != null) {
			ListNode p1 = p0.next;
			while (p1 != null) {
				if (p1.val > p0.val) {
					break;
				}
				p1 = p1.next;
			}
			if (p1 != null) {
				result.next = new ListNode(p1.val);
			} else {
				result.next = new ListNode(0);
			}
			length++;
			p0 = p0.next;
			result = result.next;
		}
		int[] a = new int[length];
		ListNode r = resultHead.next;
		for (int i = 0; i < length; i++) {
			a[i] = r.val;
			r = r.next;
		}
		return a;
	}
}