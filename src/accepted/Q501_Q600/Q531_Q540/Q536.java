package accepted.Q501_Q600.Q531_Q540;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 * <p>
 * The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
 * <p>
 * You always start to construct the left child node of the parent first if it exists.
 * <p>
 * Example:
 * Input: "4(2(3)(1))(6(5))"
 * Output: return the tree root node representing the following tree:
 * <p>
 * 4
 * /   \
 * 2     6
 * / \   /
 * 3   1 5
 * Note:
 * There will only be '(', ')', '-' and '0' ~ '9' in the input string.
 * An empty tree is represented by "" instead of "()".
 */
public class Q536 {

    public TreeNode str2tree(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        int i = 0, j = 0;
        while (j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == '-')) {
            j++;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(i, j)));
        TreeNode curr = root;
        stack.push(root);

        boolean isLeft = true;
        while (j < s.length()) {
            char c = s.charAt(j);
            switch (c) {
                case '(':
                    j++;
                    i = j;
                    while (j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == '-')) {
                        j++;
                    }
                    TreeNode node = new TreeNode(Integer.parseInt(s.substring(i, j)));
                    if (isLeft) {
                        curr.left = node;
                    } else {
                        curr.right = node;
                    }
                    curr = node;
                    stack.push(node);
                    isLeft = true;
                    break;
                case ')':
                    stack.pop();
                    curr = stack.peek();
                    isLeft = false;
                    j++;
                    break;
                default:
                    j++;
                    break;
            }

        }

        return root;
    }

}
