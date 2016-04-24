package accepted.Q251_Q260;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 * <p>
 * You may assume each number in the sequence is unique.
 * <p>
 * Follow up:
 * Could you do it using only constant space complexity?
 */
public class Q255 {

    public boolean verifyPreorder(int[] preorder) {

        int min = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int p : preorder) {
            if (p < min) {
                return false;
            }
            while (!stack.isEmpty() && p > stack.peek()) {
                min = stack.pop();
            }
            stack.push(p);
        }

        return true;
    }


    public boolean sln1(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack();
        for (int p : preorder) {
            if (p < low)
                return false;
            while (!path.empty() && p > path.peek())
                low = path.pop();
            path.push(p);
        }
        return true;
    }

    public boolean sln2(int[] preorder) {
        int low = Integer.MIN_VALUE, i = -1;
        for (int p : preorder) {
            if (p < low)
                return false;
            while (i >= 0 && p > preorder[i])
                low = preorder[i--];
            preorder[++i] = p;
        }
        return true;
    }

}
