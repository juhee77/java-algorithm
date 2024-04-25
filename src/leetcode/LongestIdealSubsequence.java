package leetcode;

/**
 * https://leetcode.com/problems/longest-ideal-subsequence/description/
 */
class LongestIdealSubsequence {
    public int longestIdealString(String s, int k) {
        int[] colMax = new int[26];
        
        int max = 0;
        for(int i=1;i<=s.length();i++){
            int temp = s.charAt(i-1)-'a';
            int hold = colMax[temp];
            for(int j=0;j<26;j++){
                if(Math.abs(temp-j) <= k ){
                    colMax[j] = Math.max(colMax[j],hold+1);
                }
            }
            //System.out.println(Arrays.toString(dp[i]));
        }

        for(int i=0;i<26;i++){
            max = Math.max(max,colMax[i]);
        }

        return max;
    }
}