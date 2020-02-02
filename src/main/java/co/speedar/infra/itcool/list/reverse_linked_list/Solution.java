package co.speedar.infra.itcool.list.reverse_linked_list;

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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        java.util.Stack<ListNode> stack = new java.util.Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode newHead = stack.pop();
        ListNode tmpHead = newHead;
        while (!stack.isEmpty()) {
            tmpHead.next = stack.pop();
            tmpHead = tmpHead.next;
        }
		tmpHead.next = null;
        return newHead;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode head = new ListNode(1);
		ListNode tmp = head;
		ListNode p = new ListNode(2);
		tmp.next = p;
		tmp = tmp.next;
		p = new ListNode(3);
		tmp.next = p;
		tmp = tmp.next;
		p = new ListNode(4);
		tmp.next = p;
		tmp = tmp.next;
		p = new ListNode(5);
		tmp.next = p;
		tmp = tmp.next;
		head.printList();
		head = s.reverseList(head);
		head.printList();
	}
}