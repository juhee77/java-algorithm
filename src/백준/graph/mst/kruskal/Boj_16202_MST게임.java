package 백준.graph.mst.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_16202_MST게임 {

    private static int[] parents;
    private static List<int[]> graphs = new ArrayList<>();
    private static int vertexCnt, edgesCnt, turnCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        vertexCnt = Integer.parseInt(st.nextToken());
        edgesCnt = Integer.parseInt(st.nextToken());
        turnCnt = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= edgesCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graphs.add(new int[]{a, b});
        }

        boolean isFinished = false;
        for (int turn = 0; turn < turnCnt; turn++) {
            if (isFinished || graphs.size() < vertexCnt - 1) {
                sb.append("0 ");
            } else {
                int mstCost = kruskal(turn);

                if (mstCost == -1) {
                    sb.append("0 ");
                    isFinished = true;
                } else
                    sb.append(mstCost).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static int kruskal(int start) {
        parents = new int[vertexCnt];
        for (int i = 0; i < vertexCnt; i++) {
            parents[i] = i;
        }

        int edgeCount = 0, mstCost = 0;

        for (int index = start; index < graphs.size(); index++) {
            int[] node = graphs.get(index);
            int a = findParents(node[0]);
            int b = findParents(node[1]);

            if (a != b) {
                union(a, b);
                mstCost += index + 1;
                edgeCount++;

                if (edgeCount == vertexCnt - 1) {
                    return mstCost;
                }
            }
        }
        return -1;
    }

    private static int findParents(int x) {
        if (parents[x] == x) return x;
        return parents[x] = findParents(parents[x]);
    }

    private static void union(int a, int b) {
        a = findParents(a);
        b = findParents(b);

        if (a != b) {
            if (a < b) parents[b] = a;
            else parents[a] = b;
        }
    }
}
