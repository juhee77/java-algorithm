package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13549_숨바꼭질3 {
    private static Queue<Integer> queue = new LinkedList<>();

    private static void check(int i, int visited[], int cnt) {
        if (i < 0 || 100000 < i || visited[i] != 0) return;
        visited[i] = cnt + 1;
        queue.add(i);

    }

    private static int bfs(int me, int goal) {
        queue.add(me);
        int visited[] = new int[100001];
        visited[me] = 1;
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            int cnt = visited[temp];

            if (temp == goal)
                break;

            check(temp * 2, visited, cnt-1);
            check(temp + 1, visited, cnt);
            check(temp - 1, visited, cnt);



        }

        return visited[goal] - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int me = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        //bfs
        int cnt = bfs(me, goal);
        System.out.println(cnt);

    }
}



