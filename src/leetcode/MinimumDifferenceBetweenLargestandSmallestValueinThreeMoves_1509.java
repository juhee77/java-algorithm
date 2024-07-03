package leetcode;

import java.util.Arrays;

class MinimumDifferenceBetweenLargestandSmallestValueinThreeMoves_1509 {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }

        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, Math.abs(nums[nums.length-4+i] - nums[i]));
            ans = Math.min(ans, Math.abs(nums[nums.length-1] - nums[3-i]));
        }
        return ans;
    }
}