package accepted.Q371_Q380;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * <p>
 * Define a pair (u,v) which consists of one element from the first array and one element from
 * the second array.
 * <p>
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * <p>
 * Example 1:
 * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 * <p>
 * Return: [1,2],[1,4],[1,6]
 * <p>
 * The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 * Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 * <p>
 * Return: [1,1],[1,1]
 * <p>
 * The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 * Given nums1 = [1,2], nums2 = [3],  k = 3
 * <p>
 * Return: [1,3],[2,3]
 * <p>
 * All possible pairs are returned from the sequence:
 * [1,3],[2,3]
 */
public class Q373 {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return res;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a1, a2) -> (a1.nums[0] + a1.nums[1] - a2.nums[0] - a2.nums[1]));
        for (int i = 0; i < k && i < nums1.length; i++) {
            pq.offer(new Pair(0, new int[]{nums1[i], nums2[0]}));
        }

        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            Pair p = pq.poll();
            res.add(p.nums);

            int nextIdx = p.idx + 1;
            if (nextIdx < nums2.length) {
                pq.offer(new Pair(nextIdx, new int[]{p.nums[0], nums2[nextIdx]}));
            }
        }

        return res;
    }

    private class Pair {
        int idx;
        int[] nums;

        Pair(int idx, int[] nums) {
            this.idx = idx;
            this.nums = nums;
        }
    }
}
