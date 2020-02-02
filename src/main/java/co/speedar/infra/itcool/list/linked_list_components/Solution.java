package co.speedar.infra.itcool.list.linked_list_components;

import co.speedar.infra.itcool.list.ListNode;

import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public int numComponents(ListNode head, int[] G) {
		if (head == null) {
			return 0;
		}
		java.util.Set<Integer> set = new HashSet<>();
		for (int i : G) {
			set.add(i);
		}
		int num = 0;
		boolean isContinued = false;
		while (head != null) {
			if (set.contains(head.val) && !isContinued) {
				isContinued = true;
				num++;
			}
			if (!set.contains(head.val) && isContinued) {
				isContinued = false;
			}
			head = head.next;
		}
		int[] a = {1};
		return num;
	}
}