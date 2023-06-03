package 백준.graph.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_4803_트리 {
    private static int[] parents;
    private static boolean[] cycle;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        for (int tc = 1; ; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break; //종료조건

            parents = new int[n];
            cycle = new boolean[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }


            //그래프 연결
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;

                union(a, b);
            }

            //그래프 탐색
            //사이클
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (parents[i] == i && !cycle[i]) { //나의 부모가 나인지(그래프의 시작점만 센다), 그래프의 시작점이 사이클에 해당하는지
                    cnt++;
                }
            }

            sb.append("Case ").append(tc).append(": ");
            if (cnt == 0) {
                sb.append("No trees.");
            } else if (cnt == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("A forest of ").append(cnt).append(" trees.");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a == b) cycle[a] = true; //사이클인 경우
        else if (a < b) parents[b] = a;
        else parents[a] = b;

        if (cycle[b] || cycle[a]) { //사이클 전파
            cycle[a] = cycle[b] = true;
        }
    }

    private static int findParent(int a) {
        if (a == parents[a]) return a;
        return parents[a] = findParent(parents[a]);
    }
}
