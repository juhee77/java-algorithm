package leetcode;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        boolean[] hold = new boolean[nums.length];
        for (int num : nums) {
            if (hold[num]) return num;
            hold[num] = true;
        }
        return 0;
    }
}
