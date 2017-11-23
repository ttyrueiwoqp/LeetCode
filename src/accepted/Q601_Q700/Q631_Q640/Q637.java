package accepted.Q601_Q700.Q631_Q640;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * <p>
 * Example 1:
 * Input:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 */
public class Q637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> nodeQ = new ArrayDeque<>();
        Deque<Integer> levelQ = new ArrayDeque<>();
        nodeQ.offer(root);
        levelQ.offer(1);

        int curr = 1;
        while (!levelQ.isEmpty()) {
            long sum = 0L;
            int count = 0;
            while (!levelQ.isEmpty() && levelQ.peek() == curr) {
                TreeNode node = nodeQ.poll();
                levelQ.poll();
                sum += node.val;
                count++;

                if (node.left != null) {
                    nodeQ.offer(node.left);
                    levelQ.offer(curr + 1);
                }
                if (node.right != null) {
                    nodeQ.offer(node.right);
                    levelQ.offer(curr + 1);
                }
            }
            res.add(1.0 * sum / count);
            curr++;
        }

        return res;
    }
}
