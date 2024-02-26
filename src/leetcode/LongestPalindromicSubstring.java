package leetcode;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len + 2][len + 2];
        char[] charArray = s.toCharArray();
        int maxLen = 0;

        for (int i = 1; i <= len; i++) {
            for (int j = i; 1 <= j; j--) {
                if (j - i == 0)
                    dp[j][i] = 1;
                else if (charArray[i - 1] == charArray[j - 1])
                    if (i - j == 1)
                        dp[j][i] = 2;
                    else if (dp[j + 1][i - 1] >= 1)
                        dp[j][i] = dp[j + 1][i - 1] + 2;

                maxLen = Math.max(maxLen, dp[j][i]);
            }
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (dp[i][j] == maxLen) {
                    return s.substring(i - 1, j);
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        System.out.println(solution.longestPalindrome("aba"));
        System.out.println(solution.longestPalindrome("aaa"));
        System.out.println(solution.longestPalindrome("abcdc"));

    }
}