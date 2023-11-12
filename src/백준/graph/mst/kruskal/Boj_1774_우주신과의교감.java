package 백준.graph.mst.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1774_우주신과의교감 {
    private static int[] parents;

    private static class Distance implements Comparable<Distance> {
        double d;
        int node1;
        int node2;

        @Override
        public int compareTo(Distance o) {
            return Double.compare(d, o.d);
        }

        public Distance(int node1, int node2, double d) {
            this.d = d;
            this.node1 = node1;
            this.node2 = node2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //신들의 위치
        int r = Integer.parseInt(st.nextToken()); //이미 연결된 통로(신들의 위치)

        int[][] people = new int[n][2];
        PriorityQueue<Distance> distances = new PriorityQueue<>();
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < i; j++) {
                distances.add(new Distance(i, j, getDistance(people[i], people[j])));
            }
        }

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            union(a, b);
        }

        //크루스칼
        double ans = 0;

        while (!distances.isEmpty()) {
            Distance poll = distances.poll();

            if (union(poll.node1, poll.node2)) {
                ans += poll.d;
            }
        }

        System.out.printf("%.2f", ans);
    }


    private static boolean union(int a, int b) {
        a = findParents(a);
        b = findParents(b);

        if (a != b) {
            if (a < b) parents[b] = a;
            else parents[a] = b;

            return true;
        }
        return false;
    }

    private static int findParents(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = findParents(parents[x]);
    }

    private static Double getDistance(int[] person, int[] person1) {
        double a = Math.pow(person[0] - person1[0], 2);
        double b = Math.pow(person[1] - person1[1], 2);
        return Math.sqrt(a + b);
    }
}
