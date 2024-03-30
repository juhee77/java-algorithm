package leetcode;

import java.util.Arrays;

public class CountSubarraysWhereMaxElement {
    public long countSubarrays(int[] nums, int k) {
        int[] save = new int[nums.length + 1];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            save[i + 1] = save[i];
            if (nums[i] == max)
                save[i + 1]++;

            if (max < nums[i]) {
                max = Math.max(max, nums[i]);
                Arrays.fill(save, 0);
                save[i + 1] = 1;
            }

        }

        int left = 1;
        int right = 1;
        long ans = 0;

        // for(int i=nums.length;1<=i;i--){
        // if(save[i]<k) continue;
        // for(int j=1;j<=i;j++){
        // if(save[i]-save[j-1]>=k) ans++;
        // }
        // }

        while (left <= right && right <= nums.length) {
            while (save[right] - save[left - 1] >= k) {
                ans += nums.length + 1 - right;
                left++;
            }
            right++;
        }

        return ans;
    }
}
