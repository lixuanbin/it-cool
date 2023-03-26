//package co.speedar.infra.itcool.stack.basic_caculator;
//
//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.LinkedList;
//import java.util.Stack;
//
//class Solution2 {
//	public int calculate(String s) {
//		return 0;
//	}
//
//	private Deque infixToPostfix(String s) {
//		s = s.replaceAll("\\s", "");
//		Deque postfixDeque = new ArrayDeque();
//		Stack<Character> operators = new Stack<>();
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//			if ((c >= '0' && c <= '9') || ((c == '-' || c == '+') && sb.length() == 0)) {
//				sb.append(c);
//			} else {
//				int operand = Integer.parseInt(sb.toString());
//				sb.setLength(0);
//				if (operators.isEmpty()) {
//					postfixDeque.offer(operand);
//					operators.push(c);
//				} else {
//
//				}
//			}
//		}
//	}
//
//	// + - * / ( )
//	private int comparePriority(char c1, char c2) {
//		switch (c1) {
//			case '+':
//			case '-':
//				if (c2 == '+' || c2 == '-') {
//					return 0;
//				} else {
//					return -1;
//				}
//			case '*':
//			case '/':
//				if (c2 == '*' || c2 == '/') {
//					return 0;
//				} else if (c2 == '(') {
//					return -1;
//				} else {
//					return 1;
//				}
//			case '(':
//				if (c2 == '(') {
//					return -1;
//				} else {
//					return 1;
//				}
//			default:
//				throw new IllegalArgumentException("unsupported operator: " + c1);
//		}
//	}
//
//	public static void main(String[] args) {
//		Solution2 solution = new Solution2();
//		//		System.out.println(solution.calculateInternal("1+1"));
//		//		System.out.println(solution.calculateInternal("1 + 1"));
//		//		System.out.println(solution.calculateInternal(" 1 + 2+3 -5"));
//		//		System.out.println(solution.calculate(" 1 - (2+3) +7"));
//		//		System.out.println(solution.calculate("(1+(4+5+ 2)-3 )+(6+8)"));
//		System.out.println(solution.calculate("2-(5-6)"));
//	}
//}