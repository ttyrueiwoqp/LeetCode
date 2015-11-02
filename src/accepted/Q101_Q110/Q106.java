package accepted.Q101_Q110;

import org.junit.Test;
import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LU-PC on 11/2/2015.
 * <p>
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class Q106 {

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		Map<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < postorder.length; i++) {
			inMap.put(inorder[i], i);
		}

		return build(postorder, inMap, 0, 0, postorder.length);
	}

	private TreeNode build(int[] postorder, Map<Integer, Integer> inMap,
	                       int postSt, int inSt, int len) {
		if (len == 0) {
			return null;
		}

		int nodeVal = postorder[postSt + len - 1];
		TreeNode node = new TreeNode(nodeVal);
		if (len > 1) {
			int inIdx = inMap.get(nodeVal);
			node.left = build(postorder, inMap, postSt, inSt, inIdx - inSt);
			node.right = build(postorder, inMap, postSt + inIdx - inSt, inIdx + 1, inSt + len - inIdx - 1);
		}
		return node;
	}

	@Test
	public void test1() {
		int[] inorder = {1, 2};
		int[] postorder = {1, 2};
		System.out.println(buildTree(postorder, inorder));
	}
}
