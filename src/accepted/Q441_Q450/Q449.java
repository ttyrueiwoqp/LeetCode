package accepted.Q441_Q450;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
 * in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or
 * another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized
 * to a string and this string can be deserialized to the original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * <p>
 * Note: Do not use class member/global/static variables to store states.
 * Your serialize and deserialize algorithms should be stateless.
 */
public class Q449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<Boolean> nullQueue = new ArrayDeque<>();

        addQueue(root, queue, nullQueue);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Boolean nullNode = nullQueue.poll();

            if (!nullNode) {
                sb.append(node.val);
                addQueue(node.left, queue, nullQueue);
                addQueue(node.right, queue, nullQueue);
            }
            sb.append(",");
        }

        return sb.toString();
    }

    private void addQueue(TreeNode node, Deque<TreeNode> queue, Deque<Boolean> nullQueue) {
        queue.offer(node == null ? new TreeNode(0) : node);
        nullQueue.offer(node == null);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        if (vals.length == 0 || vals[0].isEmpty()) {
            return null;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<Boolean> nullQueue = new ArrayDeque<>();

        int i = 0;
        TreeNode root = parseTreeNode(vals[i]);
        i++;
        addQueue(root, queue, nullQueue);

        while (!queue.isEmpty() && i < vals.length) {
            TreeNode node = queue.poll();
            Boolean nullNode = nullQueue.poll();

            if (!nullNode) {
                node.left = parseTreeNode(vals[i]);
                i++;
                addQueue(node.left, queue, nullQueue);

                if (i < vals.length) {
                    node.right = parseTreeNode(vals[i]);
                    i++;
                    addQueue(node.right, queue, nullQueue);
                }
            }
        }

        return root;
    }

    private TreeNode parseTreeNode(String val) {
        return val.isEmpty() ? null : new TreeNode(Integer.parseInt(val));
    }
}
