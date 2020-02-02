package co.speedar.infra.itcool.list.insertion_sort_list;

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
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode sortedHead = null;
		while (head != null) {
			ListNode originNext = head.next;
			if (sortedHead == null) {
				sortedHead = head;
				sortedHead.next = null;
			} else if (head.val < sortedHead.val) {
				ListNode tmp = sortedHead;
				sortedHead = head;
				sortedHead.next = tmp;
			} else {
				ListNode pre = sortedHead;
				ListNode cur = sortedHead.next;
				while (pre.val < head.val && cur != null) {
					if (cur.val >= head.val) {
						break;
					}
					pre = pre.next;
					cur = cur.next;
				}
				pre.next = head;
				head.next = cur;
			}
			head = originNext;
		}
		return sortedHead;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		ListNode p = head;
		ListNode n = new ListNode(2);
		p.next = n;
		p = p.next;
		n = new ListNode(1);
		p.next = n;
		p = p.next;
		n = new ListNode(3);
		p.next = n;
		p = p.next;
		head = new co.speedar.infra.itcool.list.insertion_sort_list.Solution().insertionSortList(head);
		head.printList();
	}
}