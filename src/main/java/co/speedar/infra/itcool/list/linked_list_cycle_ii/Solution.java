package co.speedar.infra.itcool.list.linked_list_cycle_ii;

import co.speedar.infra.itcool.list.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		java.util.Map<ListNode, Integer> map = new java.util.HashMap<>();
		ListNode cur = head;
		while (cur != null) {
			if (map.containsKey(cur)) {
				return cur;
			}
			map.put(cur, cur.val);
			cur = cur.next;
		}
		return null;
	}
}