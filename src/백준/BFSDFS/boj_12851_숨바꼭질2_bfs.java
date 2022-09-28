package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_12851_숨바꼭질2_bfs {
    private static int atime = Integer.MAX_VALUE;
    private static int acnt = 0;

    private static void bfs(int n, int m) {
        if (m <= n) {
            atime = (m < n) ? n - m : 0;
            acnt = 1;
            return;
        }

        boolean visit[] = new boolean[100001];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});
        visit[n] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            //System.out.println("Arrays.toString(tmp) = " + Arrays.toString(tmp));
            int time = tmp[1] + 1;
            int now = tmp[0];
            visit[now] = true;

            if (now == m && atime == Integer.MAX_VALUE) {
                atime = time - 1;
                acnt++;
                continue;
            }
            if (now == m && atime == time - 1) {
                acnt++;
                continue;
            }

            if (atime < time) continue;
            //if (atime < time-1) return;
            if (now * 2 < 100001 && !visit[now * 2]) q.add(new int[]{now * 2, time});
            if (now + 1 < 100001 && !visit[now + 1]) q.add(new int[]{now + 1, time});
            if (0 <= now - 1 && !visit[now - 1]) q.add(new int[]{now - 1, time});

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        bfs(n, m);
        System.out.println(atime + "\n" + acnt);
    }
}
