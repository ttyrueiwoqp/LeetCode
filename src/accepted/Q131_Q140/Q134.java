package accepted.Q131_Q140;

import org.junit.Test;

public class Q134 {

	public int canCompleteCircuit(int[] gas, int[] cost) {

		int len = gas.length;

		int stIdx = 0;
		int sum = 0, subSum = 0;
	
		for (int i = 0; i < len; i++) {
			int diff = gas[i] - cost[i];
			sum += diff;
			subSum += diff;
			if (subSum < 0) {
				subSum = 0;
				stIdx = i + 1;
			}
		}
		
		if (sum < 0) {
			return -1;
		}

		return stIdx;
	}
	
	public int canCompleteCircuit2(int[] gas, int[] cost) {

		int len = gas.length;

		int res = 0, stIdx = 0;
		int sum = 0, subSum = 0, maxSubSum = 0;
	
		boolean isPrevNeg = true;
		for (int i = 0; i < len; i++) {
			int diff = gas[i] - cost[i];
			sum += diff;
			if (diff > 0) {
				if (isPrevNeg) {
					isPrevNeg = false;
					if (subSum > maxSubSum) {
						maxSubSum = subSum;
						res = stIdx;
					}
					subSum = 0;
					stIdx = i;
				}
			} else {
				isPrevNeg = true;
			}
			subSum += diff;
		}
		
		if (sum < 0) {
			return -1;
		}
		if (subSum > maxSubSum) {
			res = stIdx;
		}

		return res;
	}

	@Test
	public void test() {
		int[] gas2 = {3,0,2,0,3};
		int[] cost2 = {0,7,0,1,0};
		System.out.println(canCompleteCircuit(gas2, cost2));
		
		int[] gas = {0, 2, 0};
		int[] cost = {1, 0, 1};
		System.out.println(canCompleteCircuit(gas, cost));
		
		int[] gas1 = {2,0,3,6,0,0,10,1,0,5};
		int[] cost1 = {0,5,0,0,9,8,0,0,2,0};
		System.out.println(canCompleteCircuit(gas1, cost1));
	}

}
