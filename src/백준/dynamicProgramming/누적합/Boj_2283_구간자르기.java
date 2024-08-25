package 백준.dynamicProgramming.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_2283_구간자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            max = Math.max(max, end);
            pq.add(new int[]{start, 1});
            pq.add(new int[]{end, -1});
        }

        int before = 0;
        int[] subSum = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            int nowCnt = before;
            while (!pq.isEmpty() && pq.peek()[0] == i) {
                int[] poll = pq.poll();
                if (poll[1] == 1) nowCnt++;
                else nowCnt--;
            }
            subSum[i] = nowCnt + ((i == 0) ? 0 : subSum[i - 1]);
            before = nowCnt;
        }

        int left = 0, right = 1;
        while (right <= max) {
            int now = subSum[right - 1] - ((left == 0) ? 0 : subSum[left - 1]);
            if (now == k) {
                System.out.println(left + " " + right);
                return;
            }

            if (now < k) right++;
            if (k < now) left++;
        }

        System.out.println("0 0");
    }
}
