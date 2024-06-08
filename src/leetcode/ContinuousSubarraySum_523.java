package leetcode;

import java.util.HashMap;

class ContinuousSubarraySum_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int hold = 0;
        for (int i = 0; i < nums.length; i++) {
            hold = (hold + nums[i] % k) % k;
            if (!map.containsKey(hold)) map.put(hold, i);
            if (i >= 1 && hold % k == 0) return true;

            if (map.containsKey(hold)) {
                Integer tempIndex = map.get(hold);
                if (i - tempIndex >= 1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum_523 continuousSubarraySum523 = new ContinuousSubarraySum_523();
        System.out.println(continuousSubarraySum523.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(continuousSubarraySum523.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(continuousSubarraySum523.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
        System.out.println( continuousSubarraySum523.checkSubarraySum(new int[]{23,2,4,6,6}, 7));
        System.out.println( continuousSubarraySum523.checkSubarraySum(new int[]{0}, 1));
    }
}