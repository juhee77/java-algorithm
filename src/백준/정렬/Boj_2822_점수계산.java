package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2822_점수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);//prob num , score

        for (int i = 0; i < 8; i++) {
            pq.add(new int[]{i, Integer.parseInt(br.readLine())});
        }

        List<Integer> solvedNums = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int[] poll = pq.poll();
            solvedNums.add(poll[0]);
            sum += poll[1];
        }

        sb.append(sum).append("\n");
        Collections.sort(solvedNums);
        for (Integer probNum : solvedNums) {
            sb.append(probNum+1).append(" ");
        }

        System.out.println(sb);
    }
}
