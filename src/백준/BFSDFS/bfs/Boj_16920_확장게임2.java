package 백준.BFSDFS.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.*;

public class Boj_16920_확장게임2 {
    private static int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int player = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        int[] ans = new int[player];
        int[] ableCnt = new int[player];

        ArrayList<Queue<Point>> castles = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < player; i++) {
            castles.add(new ArrayDeque<>());
            ableCnt[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            char[] inputs = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = inputs[j];
                if (Character.isDigit(inputs[j])) {
                    int index = inputs[j] - '1';
                    castles.get(index).add(new Point(i, j));
                    ans[index]++;
                }
            }
        }

        //각자 얻는 성의 수
        boolean flag = true;

        //...

        while (flag) {
            flag = false;
            for (int i = 0; i < player; i++) {
                int size = castles.get(i).size();
                boolean[][] visited = new boolean[n][m];
                HashSet<Point> expanding = new HashSet<>();  // 현재 확장 중인 성의 위치를 기록

                for (int j = 0; j < size; j++) {
                    Point castle = castles.get(i).poll();
                    Queue<Point> next = new ArrayDeque<>();
                    next.add(castle);

                    for (int p = 0; p < ableCnt[i] && !next.isEmpty(); p++) {
                        int nowSize = Math.min(next.size(), 1000);

                        for (int k = 0; k < nowSize; k++) {
                            Point poll = next.poll();

                            for (int[] dir : dirs) {
                                int mvx = dir[0] + poll.x;
                                int mvy = dir[1] + poll.y;

                                if (mvx >= 0 && mvx < n && mvy >= 0 && mvy < m && !visited[mvx][mvy] && !expanding.contains(new Point(mvx, mvy))) {
                                    visited[mvx][mvy] = true;

                                    if (map[mvx][mvy] == '.') {
                                        next.add(new Point(mvx, mvy));
                                        castles.get(i).add(new Point(mvx, mvy));
                                        expanding.add(new Point(mvx, mvy));  // 현재 확장 중인 위치 기록
                                        map[mvx][mvy] = (char) (i + '1');
                                        ans[i]++;
                                        flag = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

//...


//...


        for (int an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb);
        /*
// 반례2

3 4 2
2 1
1...
1..2
....


         */
    }
}