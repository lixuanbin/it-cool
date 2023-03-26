package co.speedar.infra.itcool.love;

public class LoveXiaominMoreEveryDay {
	public static void main(String[] args) {
		Runnable loveXiaominMoreEveryDay = () -> {
			int theDayWeMet = 18126;
			int myLoveToYou = 10;
			int endOfWorld = Integer.MAX_VALUE;
			for (int day = theDayWeMet; day < endOfWorld; day++) {
				myLoveToYou++;
			}
		};
		Thread t = new Thread(loveXiaominMoreEveryDay, "Xuanbin");
		t.start();
	}
}