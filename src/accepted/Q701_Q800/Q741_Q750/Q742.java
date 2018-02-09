package accepted.Q701_Q800.Q741_Q750;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.
 * <p>
 * Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.
 * <p>
 * In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * root = [1, 3, 2], k = 1
 * Diagram of binary tree:
 * 1
 * / \
 * 3   2
 * <p>
 * Output: 2 (or 3)
 * <p>
 * Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
 * Example 2:
 * <p>
 * Input:
 * root = [1], k = 1
 * Output: 1
 * <p>
 * Explanation: The nearest leaf node is the root node itself.
 * Example 3:
 * <p>
 * Input:
 * root = [1,2,3,4,null,null,null,5,null,6], k = 2
 * Diagram of binary tree:
 * 1
 * / \
 * 2   3
 * /
 * 4
 * /
 * 5
 * /
 * 6
 * <p>
 * Output: 3
 * Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.
 * Note:
 * root represents a binary tree with at least 1 node and at most 1000 nodes.
 * Every node has a unique node.val in range [1, 1000].
 * There exists some node in the given binary tree for which node.val == k.
 */
public class Q742 {

    public int findClosestLeaf(TreeNode root, int k) {

        List<TreeNode> kNode = new ArrayList<>();
        Map<TreeNode, List<TreeNode>> m = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        dfs(root, k, kNode, null, m);

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(kNode.get(0));

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            visited.add(curr);
            if (curr.left == null && curr.right == null) {
                return curr.val;
            }
            for (TreeNode t : m.get(curr)) {
                if (!visited.contains(t)) {
                    q.offer(t);
                }
            }
        }

        return -1;
    }

    private void dfs(TreeNode node, int k, List<TreeNode> kNode, TreeNode p, Map<TreeNode, List<TreeNode>> m) {
        if (node == null) {
            return;
        }

        if (node.val == k) {
            kNode.add(node);
        }

        List<TreeNode> list = new ArrayList<>();
        if (p != null) {
            list.add(p);
        }
        if (node.left != null) {
            list.add(node.left);
        }
        if (node.right != null) {
            list.add(node.right);
        }
        m.put(node, list);

        dfs(node.left, k, kNode, node, m);
        dfs(node.right, k, kNode, node, m);
    }
}
