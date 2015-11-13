package util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FJ on 11/13/2015.
 */
public class TrieNode {

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
