package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class boj_17142_연구소3_2 {
    public static final int WALL = 1;
    public static final int BLANK = 0;
    public static final int VIRUS = 2;
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int[][] map;
    private static final List<int[]> virus = new ArrayList<>();
    private static int[][] nowVirus;
    private static int totalBlank = 0;
    private static int n, m;
    private static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //input
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == VIRUS) virus.add(new int[]{i, j});
                if (map[i][j] == BLANK) totalBlank++;
            }
        }

        if (totalBlank == 0) {
            System.out.println(0);
        } else {        //바이러스를 놓이게 할 수 있는 경우에 따라
            nowVirus = new int[m][2];
            findAbleVirusPlace(0, 0);

            if (min == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(min);
        }
    }

    private static void findAbleVirusPlace(int nowD, int start) {
        //dfs
        if (nowD == m) {
            findMin();
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            int[] now = virus.get(i);
            nowVirus[nowD] = now.clone();
            findAbleVirusPlace(nowD + 1, i + 1);
        }
    }

    private static void findMin() {
        //bfs
        Queue<int[]> queue = Arrays.stream(nowVirus).map(o -> new int[]{o[0], o[1]}).collect(Collectors.toCollection(LinkedList::new));
        boolean[][] visit = new boolean[n][n];

        int colored = 0;
        int time = 0;
        loop1:
        while (!queue.isEmpty()) {
            time++;
            int nowSize = queue.size();

            for (int i = 0; i < nowSize; i++) {
                int[] now = queue.poll();

                for (int[] dir : dirs) {
                    int movedX = now[0] + dir[0];
                    int movedY = now[1] + dir[1];
                    if (movedX < 0 || movedY < 0 || n <= movedX || n <= movedY || visit[movedX][movedY] || map[movedX][movedY] == WALL) {
                        continue;
                    }

                    if (map[movedX][movedY] == BLANK) colored++;
                    if (totalBlank == colored) break loop1;
                    queue.add(new int[]{movedX, movedY});
                    visit[movedX][movedY] = true;
                }
            }
        }

        if (colored == totalBlank) {
            min = Math.min(min, time);
        }
    }
}