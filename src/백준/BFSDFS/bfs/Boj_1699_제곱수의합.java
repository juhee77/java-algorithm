package 백준.BFSDFS.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Boj_1699_제곱수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n + 1];
        int tc = 0;
        int ans = -1;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        visited[n] = true;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int now = q.poll();

                if (now == 0) {
                    //끝났으면
                    ans = tc;
                    break;
                }

                int k = (int) Math.sqrt(now);
                for (int j = 1; j <= k; j++) {
                    int temp = now - j * j;
                    if (!visited[temp]) {
                        q.add(temp);
                        visited[temp] = true;
                    }
                }
            }

            if (ans != -1) break;
            tc++;
        }

        System.out.println(tc);

    }
}
