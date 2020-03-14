package co.speedar.infra.itcool.singleton;

public class Singleton {
	private Singleton() {
	}

	private static volatile Singleton SINGLETON;

	public static Singleton getInstance() {
		if (SINGLETON == null) {
			synchronized (Singleton.class) {
				if (SINGLETON == null) {
					SINGLETON = new Singleton();
				}
			}
		}
		return SINGLETON;
	}
}
