package accepted.Q331_Q340;

import java.util.List;

/**
 * Created by lvfan on 3/31/2016.
 * <p>
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 * <p>
 * Example 2:
 * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 */
public class Q339 {

    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    private int depthSum(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                sum += i.getInteger() * level;
            } else {
                sum += depthSum(i.getList(), level + 1);
            }
        }
        return sum;
    }
}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {// @return true if this NestedInteger holds a single integer, rather than a nested list.

    public boolean isInteger();// @return the single integer that this NestedInteger holds, if it holds a single integer

    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();// @return the nested list that this NestedInteger holds, if it holds a nested list

    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
