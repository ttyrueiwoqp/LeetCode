package accepted.Q701_Q800.Q711_Q720;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.TreeMap;

/**
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
 * Example 1:
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 * Note:
 * -1e7 <= x <= 1e7
 * Number of operations won't exceed 10000.
 * The last four operations won't be called when stack is empty.
 */
public class Q716 {

    private int i;
    private List<Integer> stack;
    private List<Boolean> deleted;
    private TreeMap<Integer, Deque<Integer>> m;

    /**
     * initialize your data structure here.
     */
    public Q716() {
        i = -1;
        stack = new ArrayList<>();
        deleted = new ArrayList<>();
        m = new TreeMap<>();
    }

    public void push(int x) {
        i++;
        stack.add(x);
        deleted.add(false);
        Deque<Integer> indexes = m.computeIfAbsent(x, k -> new ArrayDeque<>());
        indexes.push(i);
    }

    public int pop() {
        int x = stack.get(i);
        removeElem(x);
        return x;
    }

    public int top() {
        return stack.get(i);
    }

    public int peekMax() {
        return m.lastKey();
    }

    public int popMax() {
        int x = m.lastKey();
        removeElem(x);
        return x;
    }

    private void removeElem(int key) {

        Deque<Integer> indexes = m.get(key);
        int index = indexes.pop();
        if (indexes.isEmpty()) {
            m.remove(key);
        }

        deleted.set(index, true);
        cleanup();
    }

    // Avoid this by using double linked list
    private void cleanup() {
        while (i >= 0 && deleted.get(i)) {
            stack.remove(i);
            deleted.remove(i);
            i--;
        }
    }

}
