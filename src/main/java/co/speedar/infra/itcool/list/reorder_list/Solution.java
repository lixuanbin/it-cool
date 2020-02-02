package co.speedar.infra.itcool.list.reorder_list;

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
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode middle = slow;
		if (fast != null) {
			slow = slow.next;
		}
		java.util.Stack<ListNode> stack = new java.util.Stack<>();
		while (slow != null) {
			stack.push(slow);
			slow = slow.next;
		}
		while (head != null) {
			ListNode p = head;
			ListNode oldNext = p.next;
			if (!stack.isEmpty()) {
				ListNode latter = stack.pop();
				p.next = latter;
				latter.next = oldNext;
			} else {
				p.next = null;
				break;
			}
			head = oldNext;
		}
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
		new Solution().reorderList(head);
		head.printList();
	}
}