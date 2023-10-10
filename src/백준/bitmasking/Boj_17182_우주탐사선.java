package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_17182_우주탐사선 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int city = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        int[][] arr = new int[city][city];
        for (int i = 0; i < city; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < city; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int now = 1 << start;
        int max = (1 << (city)) - 1;
        int[][] distances = new int[city][max + 1]; //현재 x의 위치에서 y의 방문싱테

        for (int i = 0; i < city; i++) {
            Arrays.fill(distances[i], (int)1e6);
        }

        PriorityQueue<Distance> pq = new PriorityQueue<>();
        pq.add(new Distance(0, start, now));
        distances[start][now] = 0;

        int min = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Distance nowD = pq.poll();
            if (min < nowD.cost) continue;

            for (int i = 0; i < city; i++) {
                if (i == nowD.place) continue;//본인은 무시
                int temp = nowD.visited | (1 << i);

                if (distances[i][temp] > nowD.cost + arr[nowD.place][i]) { //다음 탐색 점까지의거리
                    distances[i][temp] = nowD.cost + arr[nowD.place][i];
                    if (temp == max) { //모두 방문한 경우
                        min = Math.min(min, distances[i][temp]);
                        continue;
                    }
                    pq.add(new Distance(distances[i][temp], i, temp));
                }
            }
        }

        System.out.println(min);
    }

    private static class Distance implements Comparable<Distance> {
        int cost;
        int place;
        int visited; //bit

        public Distance(int cost, int place, int visited) {
            this.cost = cost;
            this.place = place;
            this.visited = visited;
        }

        @Override
        public int compareTo(Distance o) {
            return cost - o.cost;
        }
    }
}
