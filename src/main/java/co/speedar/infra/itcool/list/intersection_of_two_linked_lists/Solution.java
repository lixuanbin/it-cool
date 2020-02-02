package co.speedar.infra.itcool.list.intersection_of_two_linked_lists;

import co.speedar.infra.itcool.list.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        int l1 = getLength(head1);
		int l2 = getLength(head2);
		int delta = l1 - l2;
		if (delta >= 0) {
			head1 = forwardNStep(head1, delta);
		} else {
			head2 = forwardNStep(head2, -delta);
		}
		int l = l1 - delta;
		for (int i = 0; i < l; i++) {
			if (head1 == head2) {
				return head1;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return null;
    }

    private ListNode forwardNStep(ListNode head, int n) {
		for (int i = 0; i < n; i++) {
			head = head.next;
		}
		return head;
	}

	private int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}
}