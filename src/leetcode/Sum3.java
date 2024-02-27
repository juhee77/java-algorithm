package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] == target) {
                    set.add(List.of(nums[i], nums[left], nums[right]));
                    right--;
                    left++;
                } else {
                    right--;
                }
            }

        }

        System.out.println(set.size());
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        System.out.println(new Sum3().threeSum(new int[]{1, 2, 3, 0, -1, -2, - 3}));
    }
}
