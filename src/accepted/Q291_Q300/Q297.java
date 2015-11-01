package accepted.Q291_Q300;

import org.junit.Test;
import util.TreeNode;

import java.util.*;

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

		if (root == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		Deque<TreeNode> queue = new ArrayDeque<>();
		Deque<Boolean> nullQueue = new ArrayDeque<>();
		addQueue(root, queue, nullQueue);

		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			Boolean isNull = nullQueue.remove();

			write(temp, node, isNull);
			if (!isNull) {
				addQueue(node.left, queue, nullQueue);
				addQueue(node.right, queue, nullQueue);
				sb.append(temp);
				temp.setLength(0);
			}
		}

		return sb.deleteCharAt(sb.length() - 1).toString();
	}

	private void addQueue(TreeNode node, Deque<TreeNode> queue, Deque<Boolean> nullQueue) {
		if (node == null) {
			queue.add(new TreeNode(0));
			nullQueue.add(true);
		} else {
			queue.add(node);
			nullQueue.add(false);
		}
	}

	private void write(StringBuilder sb, TreeNode node, Boolean isNull) {
		if (isNull) {
			sb.append("null,");
		} else {
			sb.append(node.val).append(",");
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {

		String[] arr = data.split(",");

		TreeNode[] nodes = new TreeNode[arr.length];
		Boolean[] nulls = new Boolean[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("null")) {
				nodes[i] = new TreeNode(0);
				nulls[i] = true;
			} else {
				nodes[i] = new TreeNode(Integer.parseInt(arr[i]));
				nulls[i] = false;
			}
		}

		int parentIdx = 0;
		int childIdx = 0;
		while (childIdx < arr.length) {
			while (parentIdx < arr.length && nulls[parentIdx]) {
				parentIdx++;
			}
			if (parentIdx >= arr.length) {
				break;
			}

			TreeNode parent = nodes[parentIdx];
			childIdx++;
			parent.left = (childIdx >= arr.length || nulls[childIdx]) ? null : nodes[childIdx];
			childIdx++;
			parent.right = (childIdx >= arr.length || nulls[childIdx]) ? null : nodes[childIdx];

			parentIdx++;
		}

		return nulls[0] ? null : nodes[0];
	}

	@Test
	public void test() {
		TreeNode[] ts = new TreeNode[7];
		for (int i = 1; i < ts.length; i++) {
			ts[i] = new TreeNode(i);
		}
		ts[1].left = ts[2];
		ts[2].left = ts[3];
		ts[3].left = ts[4];
//		ts[3].right = ts[5];
//		ts[5].right = ts[6];

		// 1,2,3,null,null,4,5,null,6
		String s = serialize(null);
		System.out.println(s);
		TreeNode t = deserialize("null");
		System.out.println(t);

	}

}
