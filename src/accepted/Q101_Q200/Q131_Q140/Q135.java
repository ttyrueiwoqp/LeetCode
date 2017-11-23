package accepted.Q101_Q200.Q131_Q140;

import org.junit.Test;

/**
 * Created by FJ on 3/9/2016.
 * <p/>
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p/>
 * You are giving candies to these children subjected to the following requirements:
 * <p/>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Q135 {

	public int candy(int[] ratings) {

		int len = ratings.length;
		if (len == 0) {
			return 0;
		}

		int[] a = new int[len];
		a[0] = 1;

		int i = 1, cnt = 1;
		while (i < len) {
			if (ratings[i] > ratings[i - 1]) {
				cnt++;
			} else {
				cnt = 1;
			}
			a[i] = cnt;
			i++;
		}

		i = len - 2;
		cnt = 1;
		while (i >= 0) {
			if (ratings[i] > ratings[i + 1]) {
				cnt++;
			} else {
				cnt = 1;
			}
			a[i] = Math.max(a[i], cnt);
			i--;
		}

		int res = 0;
		i = 0;
		while (i < len) {
			res += a[i];
			i++;
		}

		return res;
	}

	@Test
	public void test() {
		int[] a = {1, 2, 2};
		System.out.println(candy(a));
	}
}
