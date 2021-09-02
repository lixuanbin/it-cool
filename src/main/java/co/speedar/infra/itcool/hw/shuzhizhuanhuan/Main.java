package co.speedar.infra.itcool.hw.shuzhizhuanhuan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String line = scanner.nextLine();
//		String[] array = line.split("\\s");
//		for (String arr : array) {
//			printHex(arr);
//		}
//		printHex("0xa");
//		printHex("0");
		printHex("0xA1");
//		printHex("1");
	}

	public static void printHex(String hex) {
		if (hex != null && hex.startsWith("0x") || hex.startsWith("0X")) {
			hex = hex.substring(2);
		}
		if (hex == null || "".equals(hex.trim())) {
			System.out.println(0);
			return;
		}
		Map<Character, Integer> map = new HashMap<>();
		map.put('a', 10);
		map.put('A', 10);
		map.put('b', 11);
		map.put('B', 11);
		map.put('c', 12);
		map.put('C', 12);
		map.put('d', 13);
		map.put('D', 13);
		map.put('e', 14);
		map.put('E', 14);
		map.put('f', 15);
		map.put('F', 15);
		map.put('0', 0);
		map.put('1', 1);
		map.put('2', 2);
		map.put('3', 3);
		map.put('4', 4);
		map.put('5', 5);
		map.put('6', 6);
		map.put('7', 7);
		map.put('8', 8);
		map.put('9', 9);
		int result = 0;
		int r = 0;
		for (int i = hex.length() - 1; i >= 0; i--) {
			result += map.get(hex.charAt(i)) * (Math.pow(16, r++));
		}
		System.out.println(result);
	}
}