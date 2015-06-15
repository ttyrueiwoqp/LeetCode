package accepted.Q111_Q120;

import util.TreeLinkNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU-PC on 6/15/2015.
 *
 * Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree?
 Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
 1
 /  \
 2    3
 / \    \
 4   5    7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL
 */
public class Q117 {
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
}
