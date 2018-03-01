package accepted.Q701_Q800.Q731_Q740;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 * <p>
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * <p>
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * <p>
 * Example 1:
 * Input:
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation:
 * The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 * Example 2:
 * Input:
 * asteroids = [8, -8]
 * Output: []
 * Explanation:
 * The 8 and -8 collide exploding each other.
 * Example 3:
 * Input:
 * asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation:
 * The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
 * Example 4:
 * Input:
 * asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation:
 * The -2 and -1 are moving left, while the 1 and 2 are moving right.
 * Asteroids moving the same direction never meet, so no asteroids will meet each other.
 * Note:
 * <p>
 * The length of asteroids will be at most 10000.
 * Each asteroid will be a non-zero integer in the range [-1000, 1000]..
 */
public class Q735 {

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length == 0) {
            return new int[0];
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];

            boolean disappear = false;
            while (!stack.isEmpty()
                    && asteroid < 0 && stack.peek() >= 0) {

                if (-asteroid > stack.peek()) {
                    stack.pop();
                } else if (-asteroid == stack.peek()) {
                    stack.pop();
                    disappear = true;
                    break;
                } else {
                    disappear = true;
                    break;
                }
            }

            if (!disappear) {
                stack.push(asteroid);
            }
        }

        int[] res = new int[stack.size()];
        Iterator<Integer> it = stack.descendingIterator();
        for (int i = 0; i < res.length ; i++) {
            res[i] = it.next();
        }

        return res;
    }
}
