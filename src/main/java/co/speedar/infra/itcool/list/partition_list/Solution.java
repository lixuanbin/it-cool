package co.speedar.infra.itcool.list.partition_list;

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
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode thead = new ListNode(-1);
		thead.next = head;
		ListNode sentinel = null;
		ListNode gap = null;
		ListNode pre = thead;
		ListNode cur = head;
		while (cur != null) {
			if (cur.val >= x && sentinel == null) {
				sentinel = pre;
				gap = cur;
			}
			if (cur.val < x && sentinel != null) {
				// 需要挪动到sentinel的左边
				sentinel.next = cur;
				pre.next = cur.next;
				sentinel = cur;
				cur.next = gap;
				cur = pre.next;
			}
			if ((cur != null && cur.val >= x && sentinel != null) || (cur != null && cur.val < x && sentinel == null)) {
				pre = pre.next;
				cur = cur.next;
			}
		}
		if (sentinel != null) {
			sentinel.next = gap;
		}
		return thead.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode p = head;
		ListNode n = new ListNode(4);
		p.next = n;
		p = p.next;
		n = new ListNode(3);
		p.next = n;
		p = p.next;
		n = new ListNode(2);
		p.next = n;
		p = p.next;
		n = new ListNode(5);
		p.next = n;
		p = p.next;
		n = new ListNode(2);
		p.next = n;
		p = p.next;
		new Solution().partition(head, 3);
	}
}