package 백준.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Pizza {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] ans = new int[n];

        Queue<int[]> q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            q.add(new int[]{i, now});
        }


        int time = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            time++;
            if (poll[1] == 1) {
                ans[poll[0]] = time;
            } else {
                q.add(new int[]{poll[0], poll[1] - 1});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int an : ans) {
            sb.append(an).append(" ");
        }

        System.out.println(sb);


    }
}
