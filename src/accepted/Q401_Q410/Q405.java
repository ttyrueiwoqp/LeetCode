package accepted.Q401_Q410;

/**
 * Given an integer, write an algorithm to convert it to hexadecimal.
 * For negative integer, two’s complement method is used.
 * <p>
 * Note:
 * <p>
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero,
 * it is represented by a single zero character '0'; otherwise,
 * the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * Example 1:
 * <p>
 * Input:
 * 26
 * <p>
 * Output:
 * "1a"
 * Example 2:
 * <p>
 * Input:
 * -1
 * <p>
 * Output:
 * "ffffffff"
 */
public class Q405 {

    public String toHex(int num) {
        char[] digits = {'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();

        if (num == 0) {
            sb.append(0);

        } else if (num > 0) {
            while (num > 0) {
                int r = num % 16;
                sb.insert(0, r < 10 ? (char)(r + '0') : digits[r - 10]);
                num /= 16;
            }

        } else {
            String s = toHex(num ^ 0x80000000);
            if (s.length() == 8) {
                int first = s.charAt(0) - '0' + 8;
                sb.append(first < 10 ? (char)(first + '0') : digits[first - 10]).append(s.substring(1));
            } else {
                sb.append('8');
                for (int i = 6; i >= s.length(); i--) {
                    sb.append('0');
                }
                sb.append(s);
            }
        }

        return sb.toString();
    }
}
