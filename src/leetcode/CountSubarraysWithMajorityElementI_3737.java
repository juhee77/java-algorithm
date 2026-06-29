package leetcode;

public class CountSubarraysWithMajorityElementI_3737 {
    public int countMajoritySubarrays(int[] nums, int target) {
        int len = nums.length + 1;
        int[] subset = new int[len];
        for (int i = 1; i < len; i++) {
            if (target == nums[i - 1]) {
                subset[i] = subset[i - 1] + 1;
            } else {
                subset[i] = subset[i - 1];
            }
        }
        // System.out.println(Arrays.toString(subset));

        int ans = 0;
        for (int i = 1; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (subset[j] - subset[i - 1] > (j - i + 1) / 2) {
                    // System.out.println(i+" "+(j-1));
                    ans++;
                }
            }
        }
        return ans;
    }
}
