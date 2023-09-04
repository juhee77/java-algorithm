package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_5214_환승 {
    private static List<List<int[]>> graphs = new ArrayList<>();
    private static int m,n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            graphs.add(new ArrayList<>());
        }

        for (int j = 1; j <= m; j++) {
            st = new StringTokenizer(br.readLine());

            int last = Integer.parseInt(st.nextToken()) - 1;
            for (int i = 1; i < k; i++) {
                int temp = Integer.parseInt(st.nextToken()) - 1;
                graphs.get(last).add(new int[]{temp, j});
                graphs.get(temp).add(new int[]{last, j});
                last = temp;
            }
        }

        System.out.println(getMinCity());
    }

    private static int getMinCity() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[2])));

        pq.add(new int[]{0, 0, 1}); //nowNode, nowLine, stationCnt
        boolean[][] visited = new boolean[m+1][n]; //line, station

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
//            System.out.println(Arrays.toString(poll));
            visited[poll[1]][poll[0]] = true;
            if (poll[0] == n - 1) {
                return poll[2];
            }
            int nowLine = poll[1];

            for (int[] nextNode : graphs.get(poll[0])) {
                if (visited[nextNode[1]][nextNode[0]]) {
                    continue;
                }

                if (nowLine == nextNode[1]) {
                    pq.add(new int[]{nextNode[0], nextNode[1], poll[2]});
                }else {
                    pq.add(new int[]{nextNode[0], nextNode[1], poll[2]+1});
                }
            }
        }
        return -1; // 목적지에 도달할 수 없는 경우
    }
}
/*
//같은 역에 있어도 있는 호선이 다를 수 있다!!
9 5 2
7 1 2 3 9
2 3 1 2 5
 */
