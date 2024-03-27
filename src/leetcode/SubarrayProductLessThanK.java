package leetcode;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            long temp = 1;
            int hold = i;
            while (hold < nums.length) {
                temp *= nums[hold];
                if (temp < k)
                    hold++;
                else
                    break;
            }
            ans += (hold - i);
        }
        return ans;
    }
}
