package 백준.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_9370_미확인도착지3 {

    public static final int MAX = 2_000_001;

    private static class Point implements Comparable<Point> {
        int next;
        double cost;

        @Override
        public int compareTo(Point other) {
            if (this.cost > other.cost)
                return 1;
            else return -1;
        }

        public Point(int next, double cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    private static final List<List<Point>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {

            st = new StringTokenizer(br.readLine());
            int city = Integer.parseInt(st.nextToken());
            int road = Integer.parseInt(st.nextToken());
            int targetCnt = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int g = Integer.parseInt(st.nextToken()) - 1;
            int h = Integer.parseInt(st.nextToken()) - 1;

            double[] distance = new double[city];
            Arrays.fill(distance, MAX); //배열 초기화
            graph.clear();

            for (int i = 0; i < city; i++) {
                graph.add(new ArrayList<>());
            }

            while (road-- > 0) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                double cost = Integer.parseInt(st.nextToken());

                if ((start == g && end == h) || (start == h && end == g)) {
                    cost -= 0.1;
                }
                graph.get(start).add(new Point(end, cost));
                graph.get(end).add(new Point(start, cost));
            }

            //경로를 저장하며 데이크스트라
            PriorityQueue<Point> queue = new PriorityQueue<>();
            queue.add(new Point(s, 0));
            distance[s] = 0;
            while (!queue.isEmpty()) {
                Point now = queue.poll();
                List<Point> nextPoints = graph.get(now.next);
                Collections.sort(nextPoints);
                if (distance[now.next] < now.cost) continue;

                for (Point nextPoint : nextPoints) {
                    if (distance[nextPoint.next] > now.cost + nextPoint.cost) {
                        queue.add(new Point(nextPoint.next, now.cost + nextPoint.cost));
                        distance[nextPoint.next] = now.cost + nextPoint.cost;
                    }
                }
            }

            List<Integer> ans = new ArrayList<>();

            while (targetCnt-- > 0) {
                int target = Integer.parseInt(br.readLine()) - 1;
                if (distance[target] % 1 != 0) ans.add(target + 1);
            }

            Collections.sort(ans);
            for (Integer c : ans) {
                sb.append(c).append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
