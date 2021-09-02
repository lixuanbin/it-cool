package co.speedar.infra.itcool;

public class TreadMillTest {
	public static void testBusy() {
		long c = 0;
		while (0 < 1) {
			if (System.currentTimeMillis() % 2 == 0) {
				c++;
			} else {
				c--;
			}
		}
	}
	public static void main(String[] args) {
		testBusy();
	}
}
