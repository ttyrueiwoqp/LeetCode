package qns;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by FJ on 11/1/2015.
 * <p/>
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection
 * link to be reconstructed later in the same or another computer environment.
 * <p/>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on
 * how your serialization/deserialization algorithm should work. You just need to ensure that
 * a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p/>
 * For example, you may serialize the following tree
 * <p/>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree.
 * You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * Note: Do not use class member/global/static variables to store states.
 * Your serialize and deserialize algorithms should be stateless.
 */
public class Q297 {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {

		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.addLast(root);


		return null;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		return null;
	}
}
