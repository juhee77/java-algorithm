package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1015_수열정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];

        //숫자, 위치
        PriorityQueue<int[]> arr = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr.add(new int[]{num, i});
        }


        int cnt = 0;
        while (!arr.isEmpty()) {
            int[] poll = arr.poll();
            p[poll[1]] = cnt++;
        }

        for (int temp : p) {
            sb.append(temp).append(" ");
        }

        System.out.println(sb);

    }
}
