package leetcode;

class StringToInteger_8 {
    public int myAtoi(String s) {
        String temp = s.trim();
        if (temp.equals("")) return 0;
        char[] arr = temp.toCharArray();
        long ans = 0;
        boolean minus = false;

        int i = 0;
        if (arr[0] == '-') {
            minus = true;
            i = 1;
        } else if (arr[0] == '+')
            i = 1;


        while (i < arr.length) {
            if (Character.isDigit(arr[i])) {
                ans *= 10;
                ans += arr[i] - '0';
                if (ans > Integer.MAX_VALUE) break;
            } else
                break;
            i++;
        }

        if (ans > Integer.MAX_VALUE) ans = minus ? Integer.MAX_VALUE + 1 : Integer.MAX_VALUE;
        return minus ? -(int) ans : (int) ans;
    }
}