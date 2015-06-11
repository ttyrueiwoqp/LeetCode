package accepted.Q091_Q100;

import org.junit.Test;

import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU-PC on 6/11/2015.
 * <p>
 * Given n, how many structurally unique BST's (binary search trees)
 * that store values 1...n?
 * <p>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class Q096 {
	public int numTrees(int n) {
		long res = 1L, i;
		for (i = 1; i <= n; i++) {
			res = res * (i + n) / i;
		}
		return (int) (res / i);
	}

	@Test
	public void test() {

		System.out.println(numTrees(3));

	}
}

