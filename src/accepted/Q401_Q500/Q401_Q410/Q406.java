package accepted.Q401_Q500.Q401_Q410;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people
 * in front of this person who have a height greater than or equal to h.
 * Write an algorithm to reconstruct the queue.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 * <p>
 * Example
 * <p>
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Q406 {

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (t1, t2) -> (t2[0] - t1[0] != 0 ? t2[0] - t1[0] : t1[1] - t2[1]));

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] t : people) {
            list.add(t[1], t);
        }

        return list.toArray(new int[people.length][]);
    }
}
