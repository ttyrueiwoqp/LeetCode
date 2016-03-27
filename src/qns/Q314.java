package qns;

import util.TreeNode;

import java.util.*;

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

        return null;
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
