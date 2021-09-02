package co.speedar.infra.itcool.hw.swap_equals;

public class Main {
	public static boolean swapEquals(String a, String b) {
		if (isBlank(a) || isBlank(b) || a.length() != b.length() || a.length() < 2) {
			return false;
		}
		for (int i = 0; i <= a.length() - 2; i++) {
			for (int j = 1; j <= a.length() - 1; j++) {
				char[] charsA = a.toCharArray();
				swapChars(charsA, i, j);
				if (b.equals(new String(charsA))) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean isBlank(String a) {
		return a == null || "".equals(a);
	}

	private static void swapChars(char[] a, int i, int j) {
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) {
		String a = "ab";
		String b = "ba";
		System.out.println(swapEquals(a, b)); // NOSONAR
		b = "ab";
		System.out.println(swapEquals(a, b)); // NOSONAR
		a = "aaaabc";
		b = "aaaacb";
		System.out.println(swapEquals(a, b)); // NOSONAR
		a = "aa";
		b = "aa";
		System.out.println(swapEquals(a, b)); // NOSONAR
		a = "";
		b = "aa";
		System.out.println(swapEquals(a, b)); // NOSONAR
	}
}
