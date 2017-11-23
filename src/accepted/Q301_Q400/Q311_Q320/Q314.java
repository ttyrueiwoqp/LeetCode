package accepted.Q301_Q400.Q311_Q320;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * <p>
 * If two nodes are in the same row and column, the order should be from left to right.
 * <p>
 * Examples:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its vertical order traversal as:
 * [
 * [9],
 * [3,15],
 * [20],
 * [7]
 * ]
 * Given binary tree [3,9,20,4,5,2,7],
 * _3_
 * /   \
 * 9    20
 * / \   / \
 * 4   5 2   7
 * return its vertical order traversal as:
 * [
 * [4],
 * [9],
 * [3,5,2],
 * [20],
 * [7]
 * ]
 */
public class Q314 {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Map<Integer, List<Integer>> m = new TreeMap<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<Integer> cols = new ArrayDeque<>();
        queue.addLast(root);
        cols.addLast(0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = cols.poll();

            List<Integer> t = m.get(col);
            if (t == null) {
                t = new ArrayList<>();
                m.put(col, t);
            }
            t.add(node.val);

            if (node.left != null) {
                queue.addLast(node.left);
                cols.addLast(col - 1);
            }
            if (node.right != null) {
                queue.addLast(node.right);
                cols.addLast(col + 1);
            }
        }

        res.addAll(m.values());
        return res;
    }

    public List<List<Integer>> sln(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        q.add(root);
        cols.add(0);

        int min = 0, max = 0;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = cols.poll();
            if(!map.containsKey(col)) map.put(col, new ArrayList<Integer>());
            map.get(col).add(node.val);

            if(node.left != null) {
                q.add(node.left);
                cols.add(col - 1);
                if(col <= min) min = col - 1;
            }
            if(node.right != null) {
                q.add(node.right);
                cols.add(col + 1);
                if(col >= max) max = col + 1;
            }
        }

        for(int i = min; i <= max; i++) {
            res.add(map.get(i));
        }

        return res;
    }
}
