package leetcode;

import java.util.*;

class TheNumberofBeautifulSubsets_2597 {
    int ans =0 ;
    public int beautifulSubsets(int[] nums, int k) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int num : nums) {
            integers.add(num);
        }
        Collections.sort(integers);
        findAns(0, new HashSet<>(), k,integers);
        return ans;
    }

    private void findAns(int depth, HashSet<Integer> numSet, int k, List<Integer> nums) {
        if (depth == nums.size()) {
            if (numSet.size() >= 1) {
                ans++;
            }
            return;
        }

        findAns(depth + 1, numSet, k, nums);
        if (!numSet.contains(nums.get(depth) - k)) {
            numSet.add(nums.get(depth));
            findAns(depth + 1, numSet, k, nums);
            numSet.remove(nums.get(depth));
        }

    }
}