package 백준.graph.topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2637_장난감조립 {
    private static final List<List<int[]>> outGraph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        //x 를 만들기위해 y가 k개 필요하다.

        int[] inDegree = new int[n + 1];
        int[][] needBlock = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            outGraph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int block = Integer.parseInt(st.nextToken());
            int need = Integer.parseInt(st.nextToken());

            outGraph.get(block).add(new int[]{target, need});
            inDegree[target]++;
        }


        //완제품 n번을 만들기 위한
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                needBlock[i][i] = 1;
            }
        }


        while (!q.isEmpty()) {
            Integer now = q.poll();
            for (int[] need : outGraph.get(now)) {
                for (int i = 1; i < n + 1; i++) {
                    if (needBlock[now][i] != 0) {
                        needBlock[need[0]][i] += needBlock[now][i] * need[1];
                    }
                }

                inDegree[need[0]]--;
                if (inDegree[need[0]] == 0) {
                    q.add(need[0]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (needBlock[n][i] != 0) {
                sb.append(i).append(" ").append(needBlock[n][i]).append("\n");
            }
        }
        System.out.println(sb);

    }
}
