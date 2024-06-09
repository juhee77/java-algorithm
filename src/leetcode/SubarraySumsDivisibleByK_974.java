package leetcode;

import java.util.HashMap;

class SubarraySumsDivisibleByK_974 {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> dict = new HashMap<>();

        int hold = 0;
        int cnt = 0;

        dict.put(0, 1);
        for (int num : nums) {
            hold = (hold + num % k) % k;
            if (hold < 0)
                hold += k;

            if (dict.containsKey(hold)) {
                cnt += dict.get(hold);
            }

            dict.put(hold, dict.getOrDefault(hold, 0) + 1);
        }
        return cnt;
    }
}