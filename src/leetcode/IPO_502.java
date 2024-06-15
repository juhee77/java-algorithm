package leetcode;

import java.util.*;

class IPO_502 {
    private static class Capital {
        int profit;
        int capital;

        public Capital(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Capital> capitals = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            capitals.add(new Capital(profits[i], capital[i]));
        }

        capitals.sort(Comparator.comparingInt(o -> o.capital));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int hold = 0;
        for (int i = 0; i < k; i++) {
            while (hold < capital.length && capitals.get(hold).capital <= w) {
                queue.add(capitals.get(hold++).profit);
            }

            if (!queue.isEmpty()) {
                w += queue.poll();
            }else{
                break;
            }
        }

        return w;

    }
}