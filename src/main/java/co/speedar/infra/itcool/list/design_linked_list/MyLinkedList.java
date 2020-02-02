package co.speedar.infra.itcool.list.design_linked_list;

class MyLinkedList {
	private ListNode head;

	/** Initialize your data structure here. */
	public MyLinkedList() {
		head = new ListNode(-1);
	}

	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index) {
		if (index < 0) {
			return -1;
		}
		ListNode p = head.next;
		for (int i = 0; i < index; i++) {
			if (p == null) {
				return -1;
			}
			p = p.next;
		}
		if (p != null) {
			return p.val;
		} else {
			return -1;
		}
	}

	/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	public void addAtHead(int val) {
		ListNode originNext = head.next;
		ListNode newRealHead = new ListNode(val);
		head.next = newRealHead;
		newRealHead.next = originNext;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		ListNode p = head;
		while (p.next != null) {
			p = p.next;
		}
		ListNode newTail = new ListNode(val);
		p.next = newTail;
	}

	/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	public void addAtIndex(int index, int val) {
		if (index < 0) {
			return;
		} else if (index == 0) {
			addAtHead(val);
		} else {
			ListNode p = head;
			for (int i = 0; i < index; i++) {
				if (p == null) {
					return;
				}
				p = p.next;
			}
			ListNode originNext = p.next;
			ListNode newNext = new ListNode(val);
			p.next = newNext;
			newNext.next = originNext;
		}
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (index < 0) {
			return;
		}
		ListNode p = head;
		for (int i = 0; i < index; i++) {
			if (p == null) {
				return;
			}
			p = p.next;
		}
		if (p != null && p.next != null) {
			p.next = p.next.next;
		}
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */