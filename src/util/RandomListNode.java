package util;

/**
 * Created by LU-PC on 6/10/2015.
 * <p>
 * Definition for singly-linked list with a random pointer.
 */

public class RandomListNode {
	public int label;
	public RandomListNode next, random;

	public RandomListNode(int x) {
		this.label = x;
	}

	@Override
	public String toString() {
		return "{" +
				label +
				"," + (next == null ? "null" : next.label) +
				"," + (random == null ? "null" : random.label) +
				'}';
	}
}

