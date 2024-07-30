package leetcode;

class MinimumDeletionsToMakeStringBalanced_1653 {
    public int minimumDeletions(String s) {
        char[] chars = s.toCharArray();
        int[][] arr = new int[chars.length][2];

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            arr[i][1] = cnt;
            if (chars[i] == 'b') {
                cnt++;
            }
        }

        cnt = 0;
        for (int i = s.length() - 1; 0 <= i; i--) {
            arr[i][0] = cnt;
            if (chars[i] == 'a') {
                cnt++;
            }
        }

        int min = s.length();
        for (int i = 0; i < s.length(); i++) {
            min = Math.min(min, arr[i][0] + arr[i][1]);
        }
        return min;
    }
}