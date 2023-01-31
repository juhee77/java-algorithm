package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class M_그래프최단거리_BFS {
    static int vertex;
    static int[] ans;
    private static final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
        }

        Queue<Integer> q = new LinkedList<>();
        ans = new int[vertex];
        q.add(0);
        ans[0] = 1;
        int ch = 0;
        while (!q.isEmpty()) {
            Integer now = q.poll(); //메모리에 저장해가면서 탐색하는 방법
            for (Integer next : graph.get(now)) {
                ch++;
                if (ans[next] == 0) {
                    ans[next] = ans[now] + 1;
                    q.add(next);
                }
            }
        }
        System.out.println(ch + "번 돌았다");

        System.out.println("====== solution 1 ======");
        for (int i = 1; i < vertex; i++) {
            // vistit 배열을 만들지 않고 ans를 대신 이용함 대신에 처음 시작점이 0인 것을 1부터 시작하는것으로 하여서 -1하여 출력하면서 진행한다
            System.out.println((i + 1) + " : " + (ans[i] - 1));
        }
        System.out.println("=======================");


        q.clear();
        q.add(0);
        ans = new int[vertex];
        ans[0] = 1;
        int distance = 1;
        ch = 0;
        while (!q.isEmpty()) {
            int qSize = q.size(); //깊이별로 탐색하는 방법
            for (int i = 0; i < qSize; i++) {
                Integer now = q.poll();
                for (Integer next : graph.get(now)) {
                    ch++;
                    if (ans[next] == 0) {
                        ans[next] = distance;
                        q.add(next);
                    }
                }
            }
            distance++;
        }
        System.out.println(ch + "번 돌았다");

        System.out.println("====== solution 2 ======");
        for (int i = 1; i < vertex; i++) {
            System.out.println((i + 1) + " : " + ans[i]);
        }
        System.out.println("=======================");
    }

}
