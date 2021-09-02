package co.speedar.infra.itcool.tree.implement_trie_prefix_tree;

import java.util.SortedSet;
import java.util.TreeSet;

class Trie {
	private TreeSet<String> trie;
	private static final char end = '{';

	/** Initialize your data structure here. */
	public Trie() {
		trie = new TreeSet<>();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		trie.add(word);
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		return trie.contains(word);
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		SortedSet<String> tail = trie.subSet(prefix, prefix + end);
		return !tail.isEmpty();
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("app");
		trie.insert("apple");
		trie.insert("beer");
		trie.insert("add");
		trie.insert("jam");
		trie.insert("rental");
		trie.insert("apps");
		trie.insert("ad");
		trie.insert("applepie");
		trie.insert("rest");
		System.out.println(trie.startsWith("beer"));
		System.out.println(trie.startsWith("rest"));
		System.out.println(trie.startsWith("jam"));
	}
}

/**
 * ["Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
 * [[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */