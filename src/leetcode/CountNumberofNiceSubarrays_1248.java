package leetcode;

public class CountNumberofNiceSubarrays_1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] oddNumsSet = new int[nums.length + 1];
        int cnt = 0;
        int j = 1;
        for (int i = 1; i <= nums.length; i++) {
            oddNumsSet[i] = (nums[i - 1] % 2 == 0) ? oddNumsSet[i - 1] : oddNumsSet[i - 1] + 1;

            while (j <= i && oddNumsSet[i] - oddNumsSet[j - 1] > k) {
                j++;
            }

            int hold = j - 1;
            while (hold <= i && oddNumsSet[i] - oddNumsSet[hold] == k) {
                cnt++;
                hold++;
            }
        }
        return cnt;
    }
}
