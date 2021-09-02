package co.speedar.infra.itcool.hw.reverse_string;

import java.util.Stack;

public class Main {
	public static String reverse(String s) {
		if (s == null || "".equals(s)) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(s.charAt(i));
			} else {
				stack.push(s.charAt(i));
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String a = "abc";
		System.out.println(a); // NOSONAR
		System.out.println(reverse(a)); // NOSONAR
		a = "Java No.1";
		System.out.println(a); // NOSONAR
		System.out.println(reverse(a)); // NOSONAR
		a = "Hua   Wei No.1";
		System.out.println(a); // NOSONAR
		System.out.println(reverse(a)); // NOSONAR
		a = "  solo ohh  ";
		System.out.println(a); // NOSONAR
		System.out.println(reverse(a)); // NOSONAR

	}
}
