package 프로그래머스.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Programmers_389479_서버증설횟수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Programmers_389479_서버증설횟수 programmers389479_서버증설횟수 = new Programmers_389479_서버증설횟수();
        System.out.println(programmers389479_서버증설횟수.solution(new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5}, 3, 5));
        System.out.println(programmers389479_서버증설횟수.solution(new int[]{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0}, 5, 1));
        System.out.println(programmers389479_서버증설횟수.solution(new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1}, 1, 1));
    }

    public int solution(int[] players, int m, int k) {
        int servers = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 24; i++) {
            while (!pq.isEmpty() && pq.peek() <= i) {
                Integer poll = pq.poll();
                //System.out.println(poll + " 반납");
            }

            int needServers = players[i] / m;
            if (pq.size() < needServers) {
                for (int j = pq.size(); j < needServers; j++) {
                    //System.out.println(i+" 생성");
                    pq.add(i + k);
                    servers++;
                }
            }
        }
        return servers;
    }
}
