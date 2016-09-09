package accepted.Q390_Q400;

/**
 * Created by LU-PC on 9/9/2016.
 * <p>
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 * <p>
 * For 1-byte character, the first bit is a 0, followed by its unicode code.
 * For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
 * This is how the UTF-8 encoding would work:
 * <p>
 * Char. number range  |        UTF-8 octet sequence
 * (hexadecimal)    |              (binary)
 * --------------------+---------------------------------------------
 * 0000 0000-0000 007F | 0xxxxxxx
 * 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 * 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 * 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
 * <p>
 * Note:
 * The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.
 * <p>
 * Example 1:
 * <p>
 * data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.
 * <p>
 * Return true.
 * It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
 * Example 2:
 * <p>
 * data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.
 * <p>
 * Return false.
 * The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
 * The next byte is a continuation byte which starts with 10 and that's correct.
 * But the second continuation byte does not start with 10, so it is invalid.
 */
public class Q393 {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            int d = data[i] >> 7 & 1;

            if (d == 0) {
                i++;
            } else {
                int cnt = 0;
                d = data[i];

                while ((d << 24 & 0x80000000) == 0x80000000 && cnt < 8) {
                    d = d << 1;
                    cnt++;
                }
                if (cnt < 2 || cnt == 8 || i + cnt - 1 >= data.length) {
                    return false;
                }

                for (int j = i + 1; j < i + cnt; j++) {
                    if ((data[j] >> 6 & 0b11) != 0b10) {
                        return false;
                    }
                }

                i += cnt;
            }
        }
        return true;
    }

}
