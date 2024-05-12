package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class MinimumCosttoHireKWorkers_857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double[n][2];

        for (int i = 0; i < n; i++) {
            workers[i] = new double[]{quality[i], (double) wage[i] / quality[i]};
        }

        Arrays.sort(workers, (a, b) -> Double.compare(a[1], b[1]));

        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double minCost = Double.MAX_VALUE;
        double sumQuality = 0;

        for (double[] worker : workers) {
            //가장 저렴한 사람을 기준으로 퀄리티의 합을 구한다.
            sumQuality += worker[0];
            maxHeap.offer(worker[0]);

            if (maxHeap.size() > k) {
                sumQuality -= maxHeap.poll();
            }

            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, sumQuality * worker[1]);
            }
        }

        return minCost;
    }
}
