package accepted;

public class Q066 {

	public int[] plusOne(int[] digits) {
        int temp = 1;
        int[] result = new int[digits.length];
        int[] result2 = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + temp;
            if (sum == 10) {
                result[i] = 0;
                result2[i + 1] = 0;
                temp = 1;
            } else if (sum < 10) {
                result[i] = sum;
                result2[i + 1] = sum;
                temp = 0;
            }
        }
        if (temp == 1) {
            result2[0] = temp;
            return result2;
        } else {
            return result;
        }
    }
	
}
