package leetcode;

public class MaximumOddBinaryNumber {
    private static final String ONE = "1";
    private static final String ZERO = "0";

    public String maximumOddBinaryNumber(String s) {
        int zeroCnt = 0;
        int oneCnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeroCnt++;
            } else {
                oneCnt++;
            }
        }

        if (zeroCnt == 0)
            return ZERO.repeat(zeroCnt) + ONE.repeat(oneCnt);
        return ONE.repeat(oneCnt - 1) + ZERO.repeat(zeroCnt) + ONE;
    }

    public static void main(String[] args) {
        MaximumOddBinaryNumber x = new MaximumOddBinaryNumber();
        System.out.println(x.maximumOddBinaryNumber("010"));
        System.out.println(x.maximumOddBinaryNumber("0011"));

    }
}
