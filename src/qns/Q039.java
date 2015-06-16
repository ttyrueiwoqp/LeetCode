package qns;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ? a2 ? … ? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */
public class Q039 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		return null;
	}

	public void expand(Node node, int[] candidates, List<List<Integer>> res) {

		for (int i = 0; i < candidates.length; i++) {
			int val = candidates[i];
			int remain = node.remain - val;
			if (remain >= 0) {
				Node newNode = new Node(val, remain, node.vals);
				node.nodes.add(newNode);
				expand(newNode, candidates, res);
			}
		}
	}

	public class Node {
		int val;
		int remain;
		List<Integer> vals;
		List<Node> nodes;

		public Node(int val, int remain, List<Integer> vals) {
			this.val = val;
			this.remain = remain;
			this.vals = vals;
			this.nodes = new ArrayList<Node>();
		}

		@Override
		public String toString() {
			return "[" + val + "," + remain + "," + nodes + "]";
		}

	}

	public List<List<Integer>> solve(int[] candidates, int target) {

		return null;
	}

	@Test
	public void test() {

		int[] c = {2, 3, 6, 7};
		Node head = new Node(7, 7, new ArrayList<Integer>());
		expand(head, c, null);

		System.out.println(head);

	}

}
