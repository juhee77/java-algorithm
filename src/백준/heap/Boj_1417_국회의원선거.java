package 백준.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Boj_1417_국회의원선거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int me = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (n-- > 1) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        while (!pq.isEmpty() && pq.peek() >= me) {
            cnt++;
            me++;
            pq.offer(pq.poll() - 1);
        }
        System.out.println(cnt);
    }
}
