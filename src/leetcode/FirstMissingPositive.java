package leetcode;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        boolean[] present = new boolean[nums.length + 1];

        for (int num : nums) {
            if (num >= 1 && num <= nums.length) {
                present[num] = true;
            }
        }

        for (int i = 1; i < present.length; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return nums.length + 1;
    }
}
