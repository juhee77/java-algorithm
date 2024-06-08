package leetcode;

import java.util.HashMap;

class ContinuousSubarraySum_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int hold = 0;
        for (int i = 0; i < nums.length; i++) {
            hold = (hold + nums[i] % k) % k;
            if (!map.containsKey(hold)) map.put(hold, i);

//            if (i >= 2 && hold % k == 0) return true;

            if (map.containsKey(hold)) {
                Integer tempIndex = map.get(hold);
                if (i - tempIndex >= 2) return true;
            }
        }
        return false;
    }

}