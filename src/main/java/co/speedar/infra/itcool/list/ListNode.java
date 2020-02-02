package co.speedar.infra.itcool.list;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		val = x;
	}
	public void printList() {
		ListNode tmp = this;
		while (tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}
}