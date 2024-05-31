package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SingleNumberIII_260 {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, false);
            } else {
                map.put(num, true);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key)) {
                ans.add(key);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}