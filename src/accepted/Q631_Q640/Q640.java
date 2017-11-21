package accepted.Q631_Q640;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Q640 {

    public String solveEquation(String equation) {
        String[] sides = equation.split("=");
        Side left = computeSide(sides[0]);
        Side right = computeSide(sides[1]);

        int xCountDiff = left.xCount - right.xCount;
        int valDiff = right.val - left.val;

        if (xCountDiff == 0) {
            return valDiff == 0 ? "Infinite solutions" : "No solution";
        }

        return String.valueOf((right.val - left.val) / (left.xCount - right.xCount));
    }

    private Side computeSide(String s) {
        Side side = new Side(0, 0);

        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            while ((j < s.length() && s.charAt(j) != '+' && s.charAt(j) != '-') || j == 0) {
                j++;
            }

            String substr = s.substring(i, j);
            if (s.charAt(j - 1) == 'x') {
                switch (substr) {
                    case "x":
                    case "+x":
                        side.xCount++;
                        break;
                    case "-x":
                        side.xCount--;
                        break;
                    default:
                        side.xCount += Integer.parseInt(substr.substring(0, substr.length() - 1));
                        break;
                }
            } else {
                side.val += Integer.parseInt(substr);
            }

            i = j;
            j++;
        }

        return side;
    }

    @Test
    public void test() {
        assertThat("2", is(solveEquation("x+5-3+x=6+x-2")));
    }
}

class Side {

    int xCount;
    int val;

    public Side(int xCount, int val) {
        this.xCount = xCount;
        this.val = val;
    }
}