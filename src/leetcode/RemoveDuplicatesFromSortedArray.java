package leetcode;

import java.util.*;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        List<Integer> numArray = new ArrayList<>(set);
        Collections.sort(numArray);

        for (int i = 0; i < set.size(); i++) {
            nums[i] = numArray.get(i);
        }
        return set.size();
    }


    public int removeDuplicates2(int[] nums) {
        int hold = 1;
        for(int i=1;i<nums.length;i++){
            if (nums[i - 1] != nums[i]) {
                nums[hold] = nums[i];
                hold++;
            }
        }
        return hold;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1, 1, 1, 2, 3, 4}));
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1, 2, 1, 2, 3, 4}));
    }
}
