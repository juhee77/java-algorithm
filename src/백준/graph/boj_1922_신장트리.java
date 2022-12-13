package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1922_신장트리 {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int node = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> lines = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        while (line-- > 0) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            lines.add(new int[]{first, second, cost});
        }

        parents = new int[node];
        for (int i = 0; i < node; i++) {
            parents[i] = i;
        }

        int sum = 0;
        while (!lines.isEmpty()) {
            int[] nowLine = lines.poll();

            if (findParents(nowLine[1]) != findParents(nowLine[0])) {
                sum += nowLine[2];
                unionParents(nowLine[1], nowLine[0]);
            }
        }

        System.out.println(sum);
    }

    private static void unionParents(int a, int b) {
        a = findParents(a);
        b = findParents(b);
        if (a < b) { //a의 부모가 더 위에있음
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    private static int findParents(int i) {
        if (parents[i] == i) return i;
        return parents[i] = findParents(parents[i]);
    }
}
