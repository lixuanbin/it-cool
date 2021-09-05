package co.speedar.infra.itcool.calculator;

import java.util.Stack;

public class MyCalculator {
	// 1+2*4/2-2
	public int calculator(String exp) {
		int result = -1;
		// 读取并转换成逆波兰表达式
		// 符号栈
		Stack<Character> operandStack = new Stack<>();
		// 操作数栈
		Stack<Integer> operatorStack = new Stack<>();
		// 读数字
		// 读符号
		while(!operandStack.isEmpty()) {
			// char op =
		}
		return result;
	}

}
