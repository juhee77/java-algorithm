package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatedsInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        int[] hold = new int[nums.length + 1];
        List<Integer> arr = new ArrayList<>();

        for (int num : nums) {
            hold[num]++;
            if (hold[num] == 2) arr.add(num);
        }
        return arr;
    }
}
