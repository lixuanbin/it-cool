package co.speedar.infra.itcool.stack.basic_caculator;

import java.util.LinkedList;
import java.util.Stack;

class Solution {
	public int calculate(String s) {
		s = s.replace(" ", "");
		if (s.indexOf("(") >= 0) {
			Stack<String> parentheses = new Stack<>();
			StringBuilder operand = new StringBuilder();
			StringBuilder expression = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == ' ') {
					continue;
				}
				if (c == '(') {
					parentheses.push(c + "");
				} else if (c == ')') {
					parentheses.push(operand.toString());
					operand = new StringBuilder();
					String temp = parentheses.pop();
					LinkedList<String> list = new LinkedList<>();
					while (!temp.equals("(")) {
						list.addFirst(temp);
						temp = parentheses.pop();
					}
					StringBuilder ss = new StringBuilder();
					for (String tt : list) {
						ss.append(tt);
					}
					String sss = String.valueOf(calculateInternal(ss.toString()));
					if (parentheses.isEmpty()) {
						expression.append(sss);
					} else {
						parentheses.push(sss);
					}
				} else if (c == '+' || c == '-') {
					String temp = operand.toString();
					operand = new StringBuilder();
					if (parentheses.isEmpty()) {
						expression.append(temp);
						expression.append(c);
					} else {
						parentheses.push(temp);
						parentheses.push(c + "");
					}
				} else if (i == s.length() - 1) {
					operand.append(c);
					expression.append(operand.toString());
				} else {
					operand.append(c);
				}
			}
			return calculateInternal(expression.toString());
		} else {
			return calculateInternal(s);
		}
	}

	private int calculateInternal(String expression) {
		expression = expression.replace(" ", "");
		LinkedList<Integer> operands = new LinkedList<>();
		LinkedList<Character> operators = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == '+' || c == '-') {
				if (i > 0 && expression.charAt(i - 1) != '+' && expression.charAt(i - 1) != '-') {
					// is operator
					operators.add(c);
					operands.add(Integer.parseInt(sb.toString()));
					sb = new StringBuilder();
				} else {
					// is positive or negative sign
					sb.append(c);
				}
			} else if (i == expression.length() - 1) {
				sb.append(c);
				operands.add(Integer.parseInt(sb.toString()));
			} else {
				sb.append(c);
			}
		}
		while (!operators.isEmpty()) {
			char operator = operators.poll();
			Integer left = operands.removeFirst();
			Integer right = operands.removeFirst();
			if (operator == '+') {
				operands.addFirst(left + right);
			} else {
				operands.addFirst(left - right);
			}
		}
		return operands.removeFirst();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		//		System.out.println(solution.calculateInternal("1+1"));
		//		System.out.println(solution.calculateInternal("1 + 1"));
		//		System.out.println(solution.calculateInternal(" 1 + 2+3 -5"));
		//		System.out.println(solution.calculate(" 1 - (2+3) +7"));
		//		System.out.println(solution.calculate("(1+(4+5+ 2)-3 )+(6+8)"));
		System.out.println(solution.calculate("2-(5-6)"));
	}
}