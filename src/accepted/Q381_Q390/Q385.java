package accepted.Q381_Q390;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Note: You may assume that the string is well-formed:
 * <p>
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * Example 1:
 * <p>
 * Given s = "324",
 * <p>
 * You should return a NestedInteger object which contains a single integer 324.
 * Example 2:
 * <p>
 * Given s = "[123,[456,[789]]]",
 * <p>
 * Return a NestedInteger object containing a nested list with 2 elements:
 * <p>
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 * i.  An integer containing value 456.
 * ii. A nested list with one element:
 * a. An integer containing value 789.
 */

public class Q385 {
    public NestedInteger deserialize(String s) {

        if (s == null || s.isEmpty()) {
            return null;
        }

        Deque<NestedInteger> stack = new ArrayDeque<NestedInteger>();
        NestedInteger curr = new NestedInteger();
        StringBuilder sb = new StringBuilder();
        int value;

        for (char c : s.toCharArray()) {
            switch (c) {
                case '[':
                    stack.push(curr);
                    curr = new NestedInteger();
                    break;

                case ']':
                    if (sb.length() > 0) {
                        value = Integer.parseInt(sb.toString());
                        curr.add(new NestedInteger(value));
                        sb.setLength(0);
                    }

                    NestedInteger prev = stack.pop();
                    prev.add(curr);
                    curr = prev;
                    break;

                case ',':
                    if (sb.length() > 0) {
                        value = Integer.parseInt(sb.toString());
                        curr.add(new NestedInteger(value));
                        sb.setLength(0);
                    }
                    break;

                default:
                    sb.append(c);
                    break;
            }
        }

        if (sb.length() > 0) {
            // No , or ] implies only integer
            value = Integer.parseInt(sb.toString());
            return new NestedInteger(value);
        }

        return curr.getList().get(0);
    }
}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedIntegerI {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedInteger implements NestedIntegerI {

    // Constructor initializes an empty nested list.
    public NestedInteger() {}

    // Constructor initializes a single integer.
    public NestedInteger(int value) {}

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return null;
    }

    @Override
    public void setInteger(int value) {

    }

    @Override
    public void add(NestedInteger ni) {

    }

    @Override
    public List<NestedInteger> getList() {
        return null;
    }
}
