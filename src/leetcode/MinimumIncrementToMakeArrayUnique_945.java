package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class MinimumIncrementToMakeArrayUnique_945 {
    public int minIncrementForUnique(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> arrs = new ArrayList<>();

        for (int num : nums) {
            if (set.contains(num)) {
                arrs.add(num);
            }
            set.add(num);
        }

        Collections.sort(arrs);

        int cnt =0;
        int hold =0;
        for (Integer arr : arrs) {
            hold = Math.max(arr,hold);
            while(true){
                hold++;
                if (!set.contains(hold)) {
                    set.add(hold);
                    cnt += (hold-arr);
                    break;
                }
            }
            // System.out.println(arr +" "+cnt+" "+hold);
        }
        System.out.println(set);
        return cnt;
    }
}