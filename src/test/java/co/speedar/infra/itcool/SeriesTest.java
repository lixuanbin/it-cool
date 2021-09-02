package co.speedar.infra.itcool;

public class SeriesTest {
	public static void main(String[] args) {
		double result = 0.0;
		for (int i = 0; i < 100; i++) {
			result += 1 / Math.pow(4, i);
		}
		System.out.println(result);
		System.out.println(4/3.0);

		for (int i = 0; i < 100; i++) {
			result += i / Math.pow(4, i);
		}
		System.out.println(result);
		System.out.println(4/9.0);

		for (int i = 0; i < 100; i++) {
			result += i * i / Math.pow(4, i);
		}
		System.out.println(result);
	}
}
