package leetcode;

class ReverseInteger {
    public int reverse(int x) {
        int sum = 0;
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = Math.abs(x);
        }
        
        int hold = Integer.MAX_VALUE / 10;
        while (x > 0) {
            if (sum > hold)
                return 0;

            sum = sum * 10 + x % 10;
            x /= 10;
        }

        return (flag) ? -sum : sum;
    }
}