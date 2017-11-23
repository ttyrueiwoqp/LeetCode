package accepted.Q301_Q400.Q301_Q310;

import org.junit.Test;

/**
 * Created by FJ on 1/24/2016.
 * <p/>
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p/>
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 * <p/>
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class Q307 {

	@Test
	public void test() {
		int[] nums = new int[]{1, 3, 5};
		NumArray numArray = new NumArray(nums);
		System.out.println(numArray.sumRange(0, 2));
		numArray.update(1, 2);
		System.out.println(numArray.sumRange(0, 2));
	}

}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
class NumArray {

	private int tree[];

	public NumArray(int[] nums) {
		tree = new int[nums.length + 1];
		for (int i = 1; i < tree.length; i++) {
			addValue(i, nums[i - 1]);
		}
	}

	void update(int i, int val) {
		i++;
		int diff = val - (read(i) - read(i - 1));
		addValue(i, diff);
	}

	private void addValue(int i, int val) {
		while (i < tree.length){
			tree[i] += val;
			i += (i & -i);
		}
	}

	public int sumRange(int i, int j) {
		return read(j + 1) - read(i);
	}

	private int read(int idx){
		int sum = 0;
		while (idx > 0){
			sum += tree[idx];
			idx -= (idx & -idx);
		}
		return sum;
	}

}





