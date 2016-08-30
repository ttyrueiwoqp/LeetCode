package accepted.Q371_Q380;

/**
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * <p>
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * <p>
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * Example:
 * n = 10, I pick 6.
 * <p>
 * Return 6.
 */

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Q374 {
    public int guessNumber(int n) {
        int st = 1, end = n, mid = 0, res = 1;

        while (res != 0) {
            mid = (st + end) / 2;
            res = guess(mid);

            if (res == -1) {
                end = mid - 1;
            } else if (res == 1) {
                st = mid + 1;
            }
        }

        return mid;
    }

    private int guess(int mid) {
        return 0;
    }
}
