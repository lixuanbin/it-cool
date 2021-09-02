package co.speedar.infra.itcool.dsaa.ch01;

public class PrintDigit {
	public int printDigits(int n) {
		if (n % 2 == 0) {
			return 1;
		} else {
			if (n == 1) {
				return 1;
			} else {
				return printDigits(n / 2) + 1;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new PrintDigit().printDigits(31));
	}
}
