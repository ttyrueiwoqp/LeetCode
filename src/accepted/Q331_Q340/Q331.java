package accepted.Q331_Q340;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by FJ on 3/5/2016.
 * <p/>
 * One way to serialize a binary tree is to use pre-order traversal.
 * When we encounter a non-null node, we record the node's value.
 * If it is a null node, we record using a sentinel value such as #.
 * <p/>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#",
 * where # represents a null node.
 * <p/>
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization
 * of a binary tree. Find an algorithm without reconstructing the tree.
 * <p/>
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * <p/>
 * You may assume that the input format is always valid,
 * for example it could never contain two consecutive commas such as "1,,3".
 * <p/>
 * Example 1:
 * "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Return true
 * <p/>
 * Example 2:
 * "1,#"
 * Return false
 * <p/>
 * Example 3:
 * "9,#,#,1"
 * Return false
 */
public class Q331 {

	public boolean isValidSerialization(String preorder) {

		String[] nodes = preorder.split(",");
		Deque<String> stack = new ArrayDeque<>();
		int i = 0;
		stack.push("#");
		while (i < nodes.length && !stack.isEmpty()) {
			if (nodes[i].equals("#")) {
				stack.pop();
			} else {
				stack.push(nodes[i]);
			}
			i++;
		}

		return stack.isEmpty() && i == nodes.length;
	}

	@Test
	public void test() {
		System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
		System.out.println(isValidSerialization("1,#"));
		System.out.println(isValidSerialization("9,#,#,1"));
	}
}
