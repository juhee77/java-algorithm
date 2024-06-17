package leetcode;

class SumOfSquareNumbers_633 {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.pow(c, 0.5) + 1;

        while (left <= right) {
            long hold = (long) left * left + (long) right * right;
            if (hold < c) {
                left++;
            } else if (hold == c) {
                return true;
            } else {
                right--;
            }
        }

        return false;
    }

    public boolean judgeSquareSum2(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}