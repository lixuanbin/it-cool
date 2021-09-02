package co.speedar.infra.itcool.hash.lru_cache;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<Integer, Integer> {
	private int capacity;

	public LRUCache(int capacity) {
		super(capacity, 1, true);
		this.capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}

	public int get(int key) {
		return getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		super.put(key, value);
	}

}