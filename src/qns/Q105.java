package qns;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LU-PC on 6/17/2015.
 * <p/>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p/>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class Q105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		if (preorder.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[0]);
		List<Integer> leftPre = new ArrayList<>();
		List<Integer> rightPre = new ArrayList<>();
		List<Integer> leftIn = new ArrayList<>();
		List<Integer> rightIn = new ArrayList<>();

		int rootPassed = -1;
		for (int i = 0; i < inorder.length; i++) {
			if (root.val == inorder[i]) {
				rootPassed = i;
			} else if (rootPassed < 0) {
				leftPre.add(preorder[i+1]);
				leftIn.add(inorder[i]);
			} else {
				rightPre.add(preorder[i]);
				rightIn.add(inorder[i]);
			}
		}



		return null;
	}


	@Test
	public void test() {
	}
}
