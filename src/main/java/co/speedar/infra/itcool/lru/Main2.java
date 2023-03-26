package co.speedar.infra.itcool.lru;

import java.util.*;

public class Main2 {
	public static void main(String[] args) {
		/*LRUCache cache = new LRUCache(2);
		cache.put("1", "a");
		cache.put("2", "b");
		System.out.println(cache.size());
		cache.put("3", "c");
		System.out.println(cache.size());
		System.out.println(cache.get("1"));
		System.out.println(cache.get("2"));
		System.out.println(cache.get("3"));*/
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(nums));
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,7,8,9,10));
		int i = Collections.binarySearch(list, 6);
		System.out.println(i);
		if (i < 0) {
			i = -i - 1;
		}
		list.add(i, 6);
		System.out.println(list);
	}

	public static int lengthOfLIS(int[] nums) {
		List<Integer> resultList = new ArrayList<>(nums.length);
		resultList.add(1);
		for (int i = 1; i < nums.length; i++) {
			List<Integer> list = new ArrayList<>(i - 1);
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					list.add(resultList.get(j) + 1);
				}
			}
			resultList.add(!list.isEmpty() ? Collections.max(list) : 1);
		}
		return Collections.max(resultList);
	}

	static class LRUCache {
		int capacity;
		Map cache;
		TreeSet<Node> accessQueue;

		public LRUCache(int c) {
			this.capacity = c;
			this.cache = new HashMap();
			this.accessQueue = new TreeSet<>();
		}

		public Object get(Object key) {
			ensureOrder(key);
			return cache.get(key);
		}

		public Object put(Object key, Object value) {
			if (cache.size() >= capacity) {
				Node f = accessQueue.first();
				accessQueue.remove(f);
				cache.remove(f.key);
			}
			Object ret = cache.put(key, value);
			ensureOrder(key);
			return ret;
		}

		public int size() {
			return cache.size();
		}

		private void ensureOrder(Object key) {
			accessQueue.add(new Node(key, System.currentTimeMillis()));
		}
	}

	static class Node implements Comparable<Node> {
		Object key;
		Long time;

		public Node(Object k, Long t) {
			this.key = k;
			this.time = t;
		}

		@Override
		public int compareTo(Node o) {
			return this.time.compareTo(o.time);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Node node = (Node) o;
			return Objects.equals(key, node.key);
		}

		@Override
		public int hashCode() {
			return Objects.hash(key);
		}
	}
}
