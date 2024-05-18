package leetcode;

class SmallestRange_908 {
    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min + k > max - k) {
            return 0;
        } else {
            return max - min - k - k;
        }

    }
}