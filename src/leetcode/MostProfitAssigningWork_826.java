package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MostProfitAssigningWork_826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //어려움 순으로 정렬한다
        PriorityQueue<int[]> arrs = new PriorityQueue<>(
                Comparator.comparingInt(o -> o[0])
        );

        for (int i = 0; i < difficulty.length; i++) {
            arrs.add(new int[]{difficulty[i], profit[i]});
        }

        Arrays.sort(worker);
        int max = 0;
        int sum = 0;

        for (int temp : worker) {
            while (!arrs.isEmpty() && arrs.peek()[0] <= temp) {
                max= Math.max(max,arrs.poll()[1]);
            }
            sum+= max;
        }

        return sum;
    }
}