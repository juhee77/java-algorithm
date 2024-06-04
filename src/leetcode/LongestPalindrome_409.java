package leetcode;

class LongestPalindrome_409 {
    public int longestPalindrome(String s) {
        int[] check = new int[100];
        char[] arrys = s.toCharArray();

        for (char temp : arrys) {
            check[temp - 'A']++;
        }

        boolean oddPresent = false;
        int cnt = 0;
        for (int j : check) {
            if (j % 2 == 1) {
                cnt += (j - 1);
                oddPresent = true;
            } else
                cnt += j;
        }
        return cnt + (oddPresent ? 1 : 0);
    }
}