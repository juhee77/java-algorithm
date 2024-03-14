package leetcode;

public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp == goal) {
                    cnt++;
                } else if (temp > goal) {
                    break;
                }
            }
        }
        return cnt;
    }
}
