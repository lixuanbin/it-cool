package co.speedar.infra.itcool.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
		//int a = in.nextInt();
		//System.out.println(a);
		// System.out.println("Hello World!");
		LRUCache cache = new LRUCache(2);
		cache.put("1", "1");
		cache.put("2", "2");
		System.out.println(cache.get("1"));
		System.out.println(cache.size());
		cache.put(3, 3);
		System.out.println(cache.size());
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
	}

	static class LRUCache extends LinkedHashMap {
		private static final int DEFAULT_CAPACITY = 16;
		private int capacity;

		public LRUCache(int c) {
			super(c, 0.75f, true);
			this.capacity = c;
		}

		public LRUCache() {
			super(DEFAULT_CAPACITY, 0.75f, true);
			this.capacity = DEFAULT_CAPACITY;
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry eldest) {
			return size() >= capacity;
		}

		public Object get(Object key) {
			return super.get(key);
		}

		public Object put(Object key, Object value) {
			return super.put(key, value);
		}
	}
}