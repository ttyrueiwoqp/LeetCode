package qns;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LU-PC on 7/6/2015.
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * <p>
 * For example:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * <p>
 * click to show hint.
 * <p>
 * You should be familiar with how a Trie works.
 * If not, please work on this problem: Implement Trie (Prefix Tree) first.
 */
public class Q211 {

	class TrieNode {
		// Initialize your data structure here.
		public int val;
		public Map<Character, TrieNode> m;

		public TrieNode() {
			val = 0;
			m = new HashMap<>();
		}

		public TrieNode(int val) {
			this.val = val;
			m = new HashMap<>();
		}
	}

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
	public class WordDictionary {

		private TrieNode root;

		public WordDictionary() {
			root = new TrieNode();
		}

		// Adds a word into the data structure.
		public void addWord(String word) {
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

		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
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
	}

	@Test
	public void test() {

		String a = null;
		String b = "fds";
		if (a != b) {
			System.out.println(123);
		}

//		String body = "TESTTEST{Link}";
//		body=body.replace("{Link}", " link ");
//		System.out.println(body);
//
//		WordDictionary wordDictionary = new WordDictionary();
//		wordDictionary.addWord("bad");
//		wordDictionary.addWord("dad");
//		wordDictionary.addWord("mad");
//		System.out.println(wordDictionary.search("pad"));
//		System.out.println(wordDictionary.search("bad"));
//		System.out.println(wordDictionary.search(".ad"));
//		System.out.println(wordDictionary.search("p.."));
	}
}
