package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SortArraybyIncreasingFrequency_1636 {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> ent : map.entrySet()) {
            ans.add(new int[]{ent.getKey(), ent.getValue()});
        }

        ans.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });

        int idx = 0;
        for (int[] an : ans) {
            int hold = an[1];
            while (hold-- > 0) {
                nums[idx++] = an[0];
            }
        }
        return nums;
    }
}