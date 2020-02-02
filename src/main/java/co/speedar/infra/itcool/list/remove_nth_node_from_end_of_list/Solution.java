package co.speedar.infra.itcool.list.remove_nth_node_from_end_of_list;

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
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head.next == null) {
			return null;
		}
		ListNode p0 = head;
		ListNode pn = null;
		ListNode prePn = null;
		int i = 1;
		int length = 1;
		while (p0.next != null) {
			p0 = p0.next;
			i++;
			if ((n == 1 && i == 2) || i == n) {
				pn = head;
			}
			if (i == n + 1 && n != 1) {
				prePn = head;
			}
			if ((i >= n + 1 && n != 1) || (n == 1 && i > 2)) {
				pn = pn.next;
				if (prePn != null && i > n + 1 && n != 1) {
					prePn = prePn.next;
				}
			}
			if (p0.next == null) {
				if (n == 1) {
					pn.next = null;
				} else if (length == n) {
					head = head.next;
				} else {
					prePn.next = pn.next;
				}
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode p = head;
		ListNode next = new ListNode(2);
		p.next = next;
		p = p.next;
		next = new ListNode(3);
		p.next = next;
		p = p.next;
		next = new ListNode(4);
		p.next = next;
		p = p.next;
		next = new ListNode(5);
		p.next = next;
		p = p.next;
		head.printList();
		head = removeNthFromEnd(head, 2);
		head.printList();
	}
}