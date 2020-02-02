package co.speedar.infra.itcool.list.flatten_a_multilevel_doubly_linked_list;

// Definition for a Node.
class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;
};

public class Solution {
	public Node flatten(Node head) {
		if (isFlattened(head)) {
			return head;
		}
		Node p = head;
		Node originNext = p.next;
		if (p.child != null) {
			Node originChild = p.child;
			p.child = null;
			Node newNext = flatten(originChild);
			p.next = newNext;
			if (newNext != null) {
				newNext.prev = p;
				while (newNext.next != null) {
					newNext = newNext.next;
				}
				newNext.next = originNext;
				if (originNext != null) {
					originNext.prev = newNext;
				}
			}

		}
		if (originNext != null) {
			flatten(originNext);
		}
		return head;
	}

	private boolean isFlattened(Node head) {
		while (head != null) {
			if (head.child != null) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
}