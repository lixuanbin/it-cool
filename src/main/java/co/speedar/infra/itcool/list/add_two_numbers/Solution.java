package co.speedar.infra.itcool.list.add_two_numbers;

import co.speedar.infra.itcool.list.ListNode;

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode head = result;
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		int carrier = 0;
		while ((l1 != null && l2 != null) || (l1 != null && carrier > 0) || (l2 != null && carrier > 0)) {
			int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carrier;
			result.val = sum % 10;
			carrier = sum / 10;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
			if ((l1 != null && l2 != null) || (l1 != null && carrier > 0) || (l2 != null && carrier > 0)) {
				ListNode nx = new ListNode(0);
				result.next = nx;
				result = nx;
			}
		}
		if (l1 != null) {
			result.next = l1;
		}
		if (l2 != null) {
			result.next = l2;
		}
		if (carrier > 0) {
			ListNode c = new ListNode(carrier);
			result.next = c;
		}
		return head;
	}
}