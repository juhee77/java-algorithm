package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_6118_숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graphs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graphs.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            graphs.get(a).add(b);
            graphs.get(b).add(a);
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;

        //가장 작은 헛간 번호, 헛간까ㅣㅈ의 거리, 헛간의 개수
        int last = 0; //헛간 번호
        int depth = 0; //거리
        int cnt = 0; //헛간 개수

        for (Integer integer : graphs.get(0)) {
            q.add(integer);
            visited[integer] = true;
        }

        while (!q.isEmpty()) {
            last = Integer.MAX_VALUE;
            depth++;
            cnt = q.size();

            for (int i = 0; i < cnt; i++) {
                int po = q.poll();
                last = Math.min(last, po);

                for (Integer integer : graphs.get(po)) {
                    if (!visited[integer]) {
                        q.add(integer);
                        visited[integer] = true;
                    }

                }
            }
        }

        System.out.println((last + 1) + " " + depth + " " + cnt);

    }
}
