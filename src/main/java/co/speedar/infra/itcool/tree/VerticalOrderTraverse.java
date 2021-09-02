package co.speedar.infra.itcool.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerticalOrderTraverse {
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		if (root == null) {
			return null;
		}
		List<VertOrder> list = new ArrayList<>();
		buildVertOrder(list, 0, 0, root);
		Collections.sort(list);
		System.out.println(list);
		List<List<Integer>> result = new ArrayList<>();
		int i = 0;
		while (i < list.size()) {
			List<Integer> temp = new ArrayList<>();
			int j = i;
			while (j < list.size()) {
				if (list.get(i).y == list.get(j).y) {
					temp.add(list.get(j).val);
					j++;
					continue;
				} else {
					i = j;
					result.add(temp);
					break;
				}
			}
			if (j == list.size()) {
				result.add(temp);
				break;
			}
		}
		list.clear();
		return result;
	}

	private void buildVertOrder(List<VertOrder> list, int x, int y, TreeNode cur) {
		if (cur == null) {
			return;
		}
		VertOrder vert = new VertOrder(x, y, cur.val);
		list.add(vert);
		buildVertOrder(list, x + 1, y - 1, cur.left);
		buildVertOrder(list, x + 1, y + 1, cur.right);
	}

	public static void main(String[] args) {
		// root = [3,9,20,null,null,15,7]
		TreeNode root = new TreeNode(3);
		TreeNode temp = new TreeNode(9);
		root.left = temp;
		temp = new TreeNode(20);
		root.right = temp;
		TreeNode temp1 = new TreeNode(15);
		temp.left = temp1;
		temp1 = new TreeNode(7);
		temp.right = temp1;
		System.out.println(new VerticalOrderTraverse().verticalTraversal(root));
	}

	static class VertOrder implements Comparable {
		int x;
		int y;
		int val;

		public VertOrder(int xx, int yy, int vv) {
			this.x = xx;
			this.y = yy;
			this.val = vv;
		}

		@Override
		public int compareTo(Object other) {
			VertOrder o = (VertOrder) other;
			if (this.y < o.y) {
				return -1;
			} else if (this.y > o.y) {
				return 1;
			} else {
				if (this.x < o.x) {
					return -1;
				} else if (this.x > o.x) {
					return 1;
				} else {
					return Integer.compare(this.val, o.val);
				}
			}
		}

		public String toString() {
			return "{(" + x + "," + y + ")" + val + "}";
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
