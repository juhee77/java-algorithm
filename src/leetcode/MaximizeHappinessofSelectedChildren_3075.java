package leetcode;

import java.util.*;

class MaximizeHappinessofSelectedChildren_3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        Queue<Integer> integers = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : happiness) {
            integers.add(i);
        }

        int day =0;
        long sum = 0;
        while (!integers.isEmpty() && integers.peek() >= day) {
            Integer poll = integers.poll();
            sum+=(poll-day);
            day++;
            if(day==k) break;
        }
        return sum;
    }
}