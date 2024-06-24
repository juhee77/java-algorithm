package leetcode;

class MinimumNumberOfKConsecutiveBitFilps_995 {
    public int minKBitFlips(int[] nums, int k) {
        //앞에서 부터 맞춰나가보자
        int hold = 0;
        for (int i = 0; i < nums.length-k; i++) {
            if (nums[i] == 0) {
                hold++;
                for (int j = i; j < i + k; j++) {
                    nums[i] = 1 - nums[i];
                }
            }
        }


        for (int i = nums.length - k; i < nums.length; i++) {
            if(nums[i] == 0) return -1;
        }
        return hold;

    }
}