package util;

/**
 * Created by LU-PC on 6/12/2015.
 *
 * Definition for binary tree with next pointer.
 */
public class TreeLinkNode {
	public int val;
	public TreeLinkNode left, right, next;

	public TreeLinkNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "{" +
				val +
				", " + left +
				", " + right +
				", " + next +
				'}';
	}
}
