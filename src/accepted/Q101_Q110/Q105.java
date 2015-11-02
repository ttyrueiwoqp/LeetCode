package accepted.Q101_Q110;

import org.junit.Test;
import util.TreeNode;

import java.util.*;

/**
 * Created by LU-PC on 6/17/2015.
 * <p>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class Q105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		if (preorder.length == 0) {
			return null;
		}

		Map<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < preorder.length; i++) {
			inMap.put(inorder[i], i);
		}

		return build(preorder, inMap, 0, 0, preorder.length);
	}

	private TreeNode build(int[] preorder, Map<Integer, Integer> inMap,
	                       int preSt, int inSt, int len) {
		if (len == 0) {
			return null;
		}

		int nodeVal = preorder[preSt];
		TreeNode node = new TreeNode(nodeVal);
		if (len > 1) {
			int inIdx = inMap.get(nodeVal);
			node.left = build(preorder, inMap, preSt + 1, inSt, inIdx - inSt);
			node.right = build(preorder, inMap, preSt + 1 + inIdx - inSt, inIdx + 1, inSt + len - inIdx - 1);
		}
		return node;
	}


	@Test
	public void test1() {
		int[] preorder = {1, 2};
		int[] inorder = {1, 2};
		System.out.println(buildTree(preorder, inorder));
	}

}
