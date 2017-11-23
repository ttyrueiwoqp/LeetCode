package accepted.Q101_Q200.Q151_Q160;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * <p>
 * The return value is the actual number of characters read.
 * For example, it returns 3 if there is only 3 characters left in the file.
 * <p>
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 * <p>
 * Note:
 * The read function may be called multiple times.
 */
public class Q158 {

    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

    private Deque<Character> queue = new ArrayDeque<>();

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {

        if (queue.size() == 0) {
            return helper(buf, 0, n);
        }

        int i = 0;
        while (i < n && !queue.isEmpty()) {
            buf[i] = queue.poll();
            i++;
        }

        if (queue.isEmpty() && i < n) {
            return helper(buf, i, n);
        }

        return i;
    }

    private int helper(char[] buf, int sum, int n) {
        char[] buffer = new char[4];
        int a = 4;
        while (sum < n && a == 4) {
            a = read4(buffer);

            if (a > n - sum) {
                for (int i = n - sum; i < a; i++) {
                    queue.addLast(buffer[i]);
                }
                a = n - sum;
            }

            System.arraycopy(buffer, 0, buf, sum, a);
            sum += a;
        }

        return sum;
    }

    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];

    public int sln(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (buffPtr == 0) {
                buffCnt = read4(buff);
            }
            if (buffCnt == 0) break;
            while (ptr < n && buffPtr < buffCnt) {
                buf[ptr++] = buff[buffPtr++];
            }
            if (buffPtr >= buffCnt) buffPtr = 0;
        }
        return ptr;
    }

    private int read4(char[] buff) {
        return 0;
    }
}
