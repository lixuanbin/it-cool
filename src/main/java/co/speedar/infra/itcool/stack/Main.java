package co.speedar.infra.itcool.stack;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//int a = in.nextInt();
		//System.out.println(a);
		// System.out.println("Hello World!");
		while (in.hasNext()) {
			String input = in.nextLine();
			System.out.println(isValidBracket(input));
		}
	}

	private static boolean isValidBracket(String s) {
		Stack<Character> curly = new Stack<>();
		Stack<Character> square = new Stack<>();
		Stack<Character> round = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '{') {
				curly.push(c);
			} else if (c == '[') {
				square.push(c);
			} else if (c == '(') {
				round.push(c);
			} else if (c == '}') {
				if (!curly.isEmpty()) {
					curly.pop();
				} else {
					return false;
				}
			} else if (c == ']') {
				if (!square.isEmpty()) {
					square.pop();
				} else {
					return false;
				}
			} else if (c == ')') {
				if (!round.isEmpty()) {
					round.pop();
				} else {
					return false;
				}
			}
		}
		return curly.isEmpty() && square.isEmpty() && round.isEmpty();
	}
}