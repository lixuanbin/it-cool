package co.speedar.infra.itcool.dsaa.ch01;

public class Permute {
	public void permute(String str) {
		int low = 0;
		int high = str.length() - 1;
		char[] chars = str.toCharArray();
		permute(chars, low, high);
	}

	/**
	 * 使用递归打印排列
	 */
	private void permute(char[] str, int low, int high) {
		if (low == high) {
			System.out.print(str[low]);
		} else {
			System.out.print(str[low]);
			permute(str, low + 1, high);
			System.out.println();
			permute(str, low + 1, high);
			System.out.print(str[low]);
			System.out.println();
		}
	}

	public void permuteNonRecursive(String str) {
		if (str == null || str.length() == 0) {
			return;
		}
		int size = str.length();
		for (int i = 0; i < size; i++) {
			System.out.print(str.charAt(i));

		}
	}

	public static void main(String[] args) {
		new Permute().permute("abcd");
	}
}
