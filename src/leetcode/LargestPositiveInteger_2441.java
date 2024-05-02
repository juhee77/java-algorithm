package leetcode;

class LargestPositiveInteger_2441 {
    public int findMaxK(int[] nums) {
        int[] hold = new int[1001];
        int max = -1;
        for (int num : nums) {
            if (num < 0) {
                if (hold[-num] == 1)
                    max = Math.max(max, -num);
                else
                    hold[-num] = -1;
            } else {
                if (hold[num] == -1)
                    max = Math.max(max, num);
                else
                    hold[num] = 1;
            }
        }
        return max;
    }
}