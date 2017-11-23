package accepted.Q101_Q200.Q111_Q120;

import org.junit.Test;
import util.TreeLinkNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU-PC on 6/12/2015.
 * <p>
 * Given a binary tree
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 */
public class Q116 {
	public void connect(TreeLinkNode root) {
		List<TreeLinkNode> nodeList = new ArrayList<>();
		traverse(root, nodeList, 0);
	}

	public void traverse(TreeLinkNode node, List<TreeLinkNode> nodeList, int level) {
		if (node == null) {
			return;
		}

		if (nodeList.size() <= level) {
			nodeList.add(node);
		} else {
			nodeList.get(level).next = node;
			nodeList.set(level, node);
		}

		traverse(node.left, nodeList, level + 1);
		traverse(node.right, nodeList, level + 1);
	}

	@Test
	public void test() {
		TreeLinkNode[] nodes = new TreeLinkNode[8];

		for (int i = 1; i <= 7; i++) {
			nodes[i] = new TreeLinkNode(i);
		}

		nodes[1].left = nodes[2];
		nodes[2].left = nodes[4];
		nodes[3].left = nodes[6];
		nodes[1].right = nodes[3];
		nodes[2].right = nodes[5];
		nodes[3].right = nodes[7];

		connect(nodes[1]);
		for (int i = 1; i <= 7; i++) {
			System.out.println(nodes[i].next);
		}
	}
}
