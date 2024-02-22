package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TwoPoint_4Num {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {

                int left = j + 1;
                int right = nums.length - 1;

                long goal = (long) target - nums[i] - nums[j];
                while (left < right) {
                    long sum = nums[left] + nums[right];
                    if (sum < goal) {
                        left++;
                    } else if (sum == goal) {
                        ArrayList<Integer> list = new ArrayList<>();
                        set.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else {
                        right--;
                    }
                }
            }
        }
        // System.out.println(set.size());
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> temp : set) {
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        TwoPoint_4Num twoPoint4Num = new TwoPoint_4Num();
        System.out.println(twoPoint4Num.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }
}
