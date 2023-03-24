package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj_1715_카드정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        //묶음이 한 개인 경우에는 비교하지 않아도 된다.
        long allSum = 0;
        while (pq.size() > 1) {
            long now = pq.poll();
            long next = pq.poll();
            pq.add(now + next);
            allSum += (now + next);
        }
        System.out.println(allSum);

    }
}
