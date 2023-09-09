package 백준.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1781_컵라면 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<List<Integer>> arrs = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            arrs.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int noodleCnt = Integer.parseInt(st.nextToken());

            arrs.get(day).add(noodleCnt);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long noodleCnt = 0;
        for (int i = n; 0 < i; i--) {
            pq.addAll(arrs.get(i));
            if (!pq.isEmpty()) {
                noodleCnt += pq.poll();
            }
        }

        System.out.println(noodleCnt);

    }
}
