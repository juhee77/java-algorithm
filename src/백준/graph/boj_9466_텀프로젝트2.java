package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_9466_텀프로젝트2 {
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<ArrayList<Integer>> graphs = new ArrayList<>();
    private static int indegree[];

    private static int toopologySort() {
        int cnt =0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0){
                queue.add(i);
                cnt++;
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graphs.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    cnt++;
                    queue.add(next);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            graphs.clear();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            indegree = new int[n];
            for (int i = 0; i < n; i++) graphs.add(new ArrayList<Integer>());
            for (int i = 0; i < n; i++) {
                int s = i;
                int e =Integer.parseInt(st.nextToken()) - 1;
                indegree[e]++;
                graphs.get(s).add(e);
            }
            sb.append(toopologySort()).append("\n");
        }
        System.out.println(sb);
    }

}
/*
8
6
2 3 4 5 6 2
5
2 5 4 5 2
6
1 3 4 3 2 6
13
2 4 5 2 4 1 8 9 10 11 9 10 10
10
2 5 7 1 6 8 8 3 5 10
10
2 7 10 5 3 3 9 10 6 3
6
2 1 1 2 6 3
3
2 3 2
 */
