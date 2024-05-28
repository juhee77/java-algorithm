package leetcode;

class GetEqualSubstringsWithinBudget_1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] temp1 = s.toCharArray();
        char[] temp2 = t.toCharArray();

        int[] set = new int[temp1.length + 1];
        int maxLen = 0;
        int left = 0;
        set[0] = 0;

        for (int i = 1; i <= temp1.length; i++) {
            set[i] = Math.abs(temp1[i - 1] - temp2[i - 1]) + set[i - 1];
            //System.out.println(Arrays.toString(set));
            for (; left < i; left++) {
                int temp = set[i] - set[left];
                if (maxCost >= temp) {
                    maxLen = Math.max(maxLen, i - left);
                    break;
                }
            }
        }
        return maxLen;
    }
}