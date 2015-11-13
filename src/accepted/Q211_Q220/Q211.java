package accepted.Q211_Q220;

import org.junit.Test;
import util.TrieNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LU-PC on 7/6/2015.
 * <p/>
 * Design a data structure that supports the following two operations:
 * <p/>
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * <p/>
 * For example:
 * <p/>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * <p/>
 * click to show hint.
 * <p/>
 * You should be familiar with how a Trie works.
 * If not, please work on this problem: Implement Trie (Prefix Tree) first.
 */
public class Q211 {

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
	public class WordDictionary {

		private TrieNode root = new TrieNode();

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

			Deque<TrieNode> stack = new ArrayDeque<>();
			Deque<Integer> idxs = new ArrayDeque<>();
			stack.push(root);
			idxs.push(0);

			while(!stack.isEmpty()) {
				TrieNode node = stack.pop();
				int idx = idxs.pop();
				Character c = word.charAt(idx);

				if (c == '.') {
					for (Character k : node.m.keySet()) {
						if (idx == word.length() - 1) {
							if (node.m.get(k).val == 1) {
								return true;
							}
						} else {
							stack.push(node.m.get(k));
							idxs.push(idx + 1);
						}
					}
				} else if (node.m.containsKey(c)) {
					if (idx == word.length() - 1) {
						if (node.m.get(c).val == 1) {
							return true;
						}
					} else {
						stack.push(node.m.get(c));
						idxs.push(idx + 1);
					}
				}
			}

			return false;
		}
	}

	@Test
	public void test() {

//		WordDictionary wordDictionary = new WordDictionary();
//		wordDictionary.addWord("bad");
//		wordDictionary.addWord("dad");
//		wordDictionary.addWord("mad");
//		System.out.println(wordDictionary.search("pad"));
//		System.out.println(wordDictionary.search("bad"));
//		System.out.println(wordDictionary.search(".ad"));
//		System.out.println(wordDictionary.search("b.."));
//		System.out.println(wordDictionary.search("p.."));

		WordDictionary w = new WordDictionary();
//		w.addWord("at");
//		w.addWord("and");
//		w.addWord("an");
//		w.addWord("add");
//		System.out.println(w.search("a"));
//		System.out.println(w.search(".at"));
//
//		w.addWord("bat");
//		System.out.println(w.search(".at"));
//		System.out.println(w.search("an."));
//		System.out.println(w.search("a.d."));
//		System.out.println(w.search("b."));
//		System.out.println(w.search("a.d"));
//		System.out.println(w.search("."));

		w.addWord("ran");
		w.addWord("rune");
		w.addWord("runner");
		w.addWord("runs");
		w.addWord("add");
		w.addWord("adds");
		w.addWord("adder");
		w.addWord("addee");
		System.out.println(w.search("r.n"));
	}
}
