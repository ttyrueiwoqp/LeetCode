package qns;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

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

		int[] c = { 2, 3, 6, 7 };
		Node head = new Node(7, 7, new ArrayList<Integer>());
		expand(head, c, null);

		System.out.println(head);

	}

}
