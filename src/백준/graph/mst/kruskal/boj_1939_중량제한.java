package 백준.graph.mst.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_1939_중량제한 {
    private static final ArrayList<Bridge> bridges = new ArrayList<>();
    private static int[] parents;

    private static class Bridge implements Comparable<Bridge> {
        int start;
        int end;
        int weight;

        public Bridge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Bridge o) {
            return o.weight - weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int bridgeCnt = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());


        while (line-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            bridges.add(new Bridge(start, end, weight));
        }
        st = new StringTokenizer(br.readLine());

        parents = new int[bridgeCnt];
        for (int i = 0; i < bridgeCnt; i++) {
            parents[i] = i;
        }
        System.out.println(findMaxWeight(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1));
    }

    private static int findMaxWeight(int start, int end) {
        //가장 많이 나를수 있는 다리부터 정렬
        Collections.sort(bridges);

        for (Bridge bridge : bridges) {
            int a = findParent(bridge.start);
            int b = findParent(bridge.end);

            if (a != b) {
                //서로 하나의 동선이 아닌경우에만 넣는다.
                unionParents(bridge.start, bridge.end);
            }

            if (findParent(start) == findParent(end)) {
                return bridge.weight;
            }
        }
        return 0;
    }

    private static void unionParents(int a, int b) {
        if (a < b) parents[b] = a;
        else parents[a] = b;
    }

    private static int findParent(int a) {
        if (parents[a] == a) return a;
        return parents[a] = findParent(parents[a]);
    }

}
