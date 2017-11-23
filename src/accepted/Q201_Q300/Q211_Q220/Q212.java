package accepted.Q201_Q300.Q211_Q220;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by FJ on 3/15/2016.
 * <p/>
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p/>
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 * <p/>
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 * <p/>
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * Return ["eat","oath"].
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * <p/>
 * click to show hint.
 * <p/>
 * You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?
 * <p/>
 * If the current candidate does not exist in all words' prefix, you could stop backtracking immediately.
 * What kind of data structure could answer such query efficiently?
 * Does a hash table work? Why or why not? How about a Trie?
 * If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
 */
public class Q212 {

	public List<String> findWords(char[][] board, String[] words) {

		Set<String> res = new HashSet<>();
		int m = board.length;
		if (m == 0) {
			return new ArrayList<>(res);
		}
		int n = board[0].length;
		if (n == 0) {
			return new ArrayList<>(res);
		}

		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		int[][] visited = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				search(board, visited, i, j, trie, res, "");
			}
		}

		return new ArrayList<>(res);
	}

	private void search(char[][] board, int[][] visited, int i, int j, Trie trie, Set<String> res, String s) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return;
		}
		if (visited[i][j] == 1) {
			return;
		}

		s += board[i][j];
		if (!trie.startsWith(s)) {
			return;
		}
		if (trie.search(s)) {
			res.add(s);
		}

		visited[i][j] = 1;
		search(board, visited, i - 1, j, trie, res, s);
		search(board, visited, i + 1, j, trie, res, s);
		search(board, visited, i, j - 1, trie, res, s);
		search(board, visited, i, j + 1, trie, res, s);
		visited[i][j] = 0;
	}

	private class TrieNode {

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

	private class Trie {
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
		char[][] board = {
				{'o', 'a', 'a', 'n'},
				{'e', 't', 'a', 'e'},
				{'i', 'h', 'k', 'r'},
				{'i', 'f', 'l', 'v'}
		};
		String[] words = {"oath", "pea", "eat", "rain"};

		System.out.println(findWords(board, words));

	}
}
