package co.speedar.infra.itcool.list.odd_even_linked_list;

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
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		ListNode oddHead = head;
		ListNode evenHead = head.next;
		ListNode even = evenHead;
		while (oddHead != null && oddHead.next != null && oddHead.next.next != null) {
			ListNode originOddNext = oddHead.next.next;
			oddHead.next = oddHead.next.next;
			ListNode originEvenNext = null;
			if (evenHead != null && evenHead.next != null) {
				if (evenHead.next.next != null) {
					originEvenNext = evenHead.next.next;
					evenHead.next = evenHead.next.next;
				} else {
					evenHead.next = null;
				}
			}
			oddHead = originOddNext;
			evenHead = originEvenNext;
		}
		oddHead.next = even;
		if (evenHead != null) {
			evenHead.next = null;
		}
		return head;
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
		//		n = new ListNode(5);
		//		p.next = n;
		//		p = p.next;
		head = new Solution().oddEvenList(head);
		head.printList();
	}
}