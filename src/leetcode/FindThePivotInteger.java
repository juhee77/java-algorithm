package leetcode;

public class FindThePivotInteger {
    public int pivotInteger(int n) {

        int halfSum = (n + 1) * (n) / 2;
        int tempSum = 0;
        for (int i = 1; i <= n; i++) {
            if (tempSum + i == halfSum - tempSum) {
                return i;
            }
            tempSum += i;
        }
        return -1;
    }
}
