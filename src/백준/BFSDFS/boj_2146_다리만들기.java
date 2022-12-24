package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2146_다리만들기 {
    private static boolean[][] map;
    private static boolean[][] visited;
    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int min = Integer.MAX_VALUE;
    private static int sz;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sz = Integer.parseInt(br.readLine());
        map = new boolean[sz][sz];
        visited = new boolean[sz][sz];
        for (int i = 0; i < sz; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < sz; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                if (map[i][j] && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(min);

    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y]=true;

        int[][] distance = new int[sz][sz]; // 각 랜드 별로의 최단거리
        HashSet<List<Integer>> edgeLands = new HashSet<>();

        for (int i = 0; i < sz; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int[] d : dir) {
                int mvx = d[0] + now[0];
                int mvy = d[1] + now[1];

                if (mvx < 0 || mvy < 0 || sz <= mvx || sz <= mvy) continue;
                if (visited[mvx][mvy]) continue;
                if (!map[mvx][mvy]) {
                    //만약 이동 칸이 물이면
                    edgeLands.add(List.of(now[0], now[1]));
                } else {
                    //이동칸이 땅이면
                    q.add(new int[]{mvx, mvy});
                    visited[mvx][mvy] = true;
                }
            }
        }

        for (List<Integer> edge : edgeLands) {
            min = Math.min(min, findDistance(distance, edge.get(0), edge.get(1)));
        }

    }

    private static int findDistance(int[][] distance, int x, int y) {
        //땅의 시작점 위치임
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y,0});

        int maxDistance = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (distance[now[0]][now[1]] < now[2]) continue; //다른 다리의 길이가 더 짤읍 경우

            for (int[] d : dir) {
                int mvx = d[0] + now[0];
                int mvy = d[1] + now[1];

                if (mvx < 0 || mvy < 0 || sz <= mvx || sz <= mvy) continue;
                if (!visited[mvx][mvy] && map[mvx][mvy]) {
                    //새로 발견된 땅인 경우
                    maxDistance = Math.min(maxDistance, now[2]);
                } else if (!map[mvx][mvy]) {
                    //물인 경우
                    if (distance[mvx][mvy] > now[2] + 1) {
                        q.add(new int[]{mvx, mvy, now[2] + 1});
                        distance[mvx][mvy] = now[2] + 1;
                    }
                }
            }
        }
        return maxDistance;
    }
}


//메모리 초과가 난다? -> 방문 처리 다시 보기..
//64프로 에서 틀린다? -> 그냥 max 초기화는 integerMax로 하자..
/*
5
1 1 0 0 1
1 1 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 1
 */
