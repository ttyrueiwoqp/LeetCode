package accepted.Q201_Q210;

import org.junit.Test;
import util.TrieNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by LU-PC on 7/3/2015.
 * <p>
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

public class Q208 {

	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			TrieNode curr = root;
			int i = 0;
			while (i < word.length() && curr.m.containsKey(word.charAt(i))) {
				curr = curr.m.get(word.charAt(i));
				i++;
			}
			while (i < word.length()) {
				TrieNode temp = new TrieNode();
				curr.m.put(word.charAt(i), temp);
				curr = temp;
				i++;
			}
			curr.val = 1;
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			TrieNode curr = root;
			for (int i = 0; i < word.length(); i++) {
				curr = curr.m.get(word.charAt(i));
				if (curr == null) {
					return false;
				}
			}
			return curr.val == 1;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			TrieNode curr = root;
			for (int i = 0; i < prefix.length(); i++) {
				curr = curr.m.get(prefix.charAt(i));
				if (curr == null) {
					return false;
				}
			}
			return true;
		}
	}

	@Test
	public void test() {
		Trie trie = new Trie();
		trie.insert("abc");
		System.out.println(trie.search("abc"));
		System.out.println(trie.search("ab"));
		trie.insert("ab");
		System.out.println(trie.search("ab"));
		trie.insert("ab");
		System.out.println(trie.search("ab"));
//		trie.startsWith("a");
	}

}
