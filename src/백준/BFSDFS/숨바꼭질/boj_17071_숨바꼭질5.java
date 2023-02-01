package 백준.BFSDFS.숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17071_숨바꼭질5 {
    static boolean[][] visited = new boolean[2][500001];
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(bfs(n, k));
    }

    private static int bfs(int n, int k) {
        if (n == k) return 0;

        visited[0][n] = true;
        queue.add(n);
        int t = 1;
        //ex) 홀수 번째에 방문한 경우 이후 홀수번째에도 방문가능함 -> 즉 만약 움직인 위치가 홀수 타임이라면 과거에 그 위치에 홀수번째 타임에 방문한 경우 그때 잡을 수 있음
        int nowSister = k;

        while (!queue.isEmpty()) {
            int nowTimeSize = queue.size();
            nowSister += t;
            if (500_000 < nowSister) return -1;
            //System.out.println(nowSister);

            for (int i = 0; i < nowTimeSize; i++) {
                Integer now = queue.poll();

                checkAndAdd(now + 1, t);
                checkAndAdd(now - 1, t);
                checkAndAdd(now * 2, t);

                if (visited[t % 2][nowSister]) return t;
            }
            t++;
        }
        return -1;
    }

    private static void checkAndAdd(int nowMy, Integer beforeTime) {
        if (nowMy < 0 || 500_000 < nowMy) return;
        if (visited[beforeTime % 2][nowMy]) return;
        //System.out.println("moved = " + nowMy);
        queue.add(nowMy);
        visited[beforeTime % 2][nowMy] = true;
    }
}
