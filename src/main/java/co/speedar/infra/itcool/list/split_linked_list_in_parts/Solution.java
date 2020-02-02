package co.speedar.infra.itcool.list.split_linked_list_in_parts;

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
	public ListNode[] splitListToParts(ListNode root, int k) {
		// 遍历一次得到长度，然后除以k以及模k得到每段长度
		if (k <= 0) {
			return null;
		}
		int length = getLength(root);
		int slice = length / k;
		int mod = length % k;
		ListNode[] array = new ListNode[k];
		for (int i = 0; i < k; i++) {
			ListNode cur = new ListNode(-1);
			ListNode pre = new ListNode(-1);
			pre.next = cur;
			ListNode head = pre;
			for (int j = 0; j < slice; j++) {
				if (root != null) {
					cur.val = root.val;
					cur.next = new ListNode(-1);
					cur = cur.next;
					pre = pre.next;
					root = root.next;
				} else {
					cur = null;
					pre.next = null;
				}
			}
			if (cur != null && cur.val == -1 && (slice > 0 || mod <= 0)) {
				cur = null;
				pre.next = null;
			}
			if (cur != null && cur.next != null && cur.next.val == -1) {
				cur.next = null;
			}
			if (mod > 0) {
				mod--;
				if (root != null) {
					if (slice > 0) {
						if (cur == null) {
							pre.next = new ListNode(root.val);
						} else {
							cur.next = new ListNode(root.val);
						}
					} else {
						if (cur == null) {
							cur = new ListNode(-1);
							pre.next = cur;
						}
						cur.val = root.val;
					}
					root = root.next;
				}
			}
			array[i] = head.next;
		}
		return array;
	}

	private int getLength(ListNode head) {
		ListNode pre = new ListNode(-1);
		pre.next = head;
		int length = 0;
		while (pre.next != null) {
			length++;
			pre = pre.next;
		}
		return length;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode p = head;
		ListNode n = new ListNode(2);
		p.next = n;
		p = p.next;
		n = new ListNode(3);
		p.next = n;
		p = p.next;
		n = new ListNode(4);
		p.next = n;
		p = p.next;
		n = new ListNode(5);
		p.next = n;
		p = p.next;
		n = new ListNode(6);
		p.next = n;
		p = p.next;
		n = new ListNode(7);
		p.next = n;
		p = p.next;
		new Solution().splitListToParts(head, 3);
	}
}