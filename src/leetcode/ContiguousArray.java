package leetcode;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int[] zero = new int[nums.length + 1];
        int[] one = new int[nums.length + 1];

        if (nums[0] == 0)
            zero[1] = 1;
        else
            one[1] = 1;

        for (int i = 1; i < nums.length; i++) {
            zero[i + 1] = (nums[i] == 0) ? zero[i] + 1 : zero[i];
            one[i + 1] = (nums[i] == 1) ? one[i] + 1 : one[i];
        }

        for (int i = nums.length; 0 < i; i--) {
            for (int j = (i % 2) + 1; j < i; j += 2) {
                if ((i - j + 1) < max)
                    break;

                if (zero[i] - zero[j - 1] == one[i] - one[j - 1]) {
                    max = Math.max(max, (i - j + 1));
                    break;
                }
            }
        }

        return max;
    }
}
