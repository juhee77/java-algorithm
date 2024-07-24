package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SorttheJumbledNumbers_2191 {
    private static class Number implements Comparable<Number> {
        long original;
        long changed;

        public Number(long original, long changed) {
            this.original = original;
            this.changed = changed;
        }

        @Override
        public int compareTo(Number o) {
            return Long.compare(changed, o.changed);
        }
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Number> numbers = new ArrayList<>();
        for (int num : nums) {
            long changed = 0;
            String s = Integer.toString(num);
            for (char c : s.toCharArray()) {
                changed += mapping[c - '0'];
                changed *= 10;
            }

            numbers.add(new Number(num, changed));
        }

        Collections.sort(numbers);
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) numbers.get(i).original;
        }
        return ans;
    }
}