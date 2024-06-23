package leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEequalToLimit_1438 {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> maxq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        PriorityQueue<int[]> minq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        int ans = 0;
        int hold = 0;
        for (int i = 0; i < nums.length; i++) {
            maxq.add(new int[]{i, nums[i]});
            minq.add(new int[]{i, nums[i]});

            //큰값을 뺄때까지 빼버린다. (즉 limit보다 작아질때 까지 )
            while (maxq.peek()[1] - minq.peek()[1] > limit) {
                //여기까지 뺸다.
                hold = Math.min(maxq.peek()[0], minq.peek()[0]) + 1;

                while (maxq.peek()[0] < hold) maxq.poll();
                while (minq.peek()[0] < hold) minq.poll();
            }

            ans = Math.max(ans, i - hold + 1);
        }
        return ans;

    }
}