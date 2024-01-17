package 백준.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16920_확장게임 {
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

        int total = 0;
        int goal = n * m;
        for (int i = 0; i < n; i++) {
            char[] inputs = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = inputs[j];
                if (Character.isDigit(inputs[j])) {
                    int index = inputs[j] - '1';
                    castles.get(index).add(new Point(i, j));
                    ans[index]++;
                    total++;
                }
                if (inputs[j] == '#') {
                    goal--;
                }
            }
        }

//        System.out.println("ABLE CNT" + Arrays.toString(ableCnt));
//        System.out.println("ANS" + Arrays.toString(ans));


        //각자 얻는 성의 수
        boolean[][] isExpended = new boolean[n][m];
        while (true) {
            for (int i = 0; i < player; i++) {
                //한 플레이어의 성의 사이즈
                int size = castles.get(i).size();

                for (int j = 0; j < size; j++) { //성의 개수 만큼
                    Point castle = castles.get(i).poll();
                    Queue<Point> next = new ArrayDeque<>(); //성의 개수 만큼 확장
                    next.add(castle);
                    isExpended[castle.x][castle.y] = true;

                    for (int p = 0; p < ableCnt[i] && !next.isEmpty(); p++) {
                        int nowSize = next.size();

                        for (int k = 0; k < nowSize; k++) {
                            Point poll = next.poll();
                            isExpended[poll.x][poll.y] = true;

                            for (int[] dir : dirs) {
                                int mvx = dir[0] + poll.x;
                                int mvy = dir[1] + poll.y;

                                if (mvx < 0 || n <= mvx || mvy < 0 || m <= mvy) {
                                    continue;
                                }
                                if (map[mvx][mvy] == '.' || ((map[mvx][mvy] == (char) (i + '1') && !isExpended[mvx][mvy]))) {
                                    next.add(new Point(mvx, mvy));
                                    isExpended[mvx][mvy] = true;
                                    if (map[mvx][mvy] == '.') {
                                        castles.get(i).add(new Point(mvx, mvy));
                                        ans[i]++;
                                        total++;
                                        map[mvx][mvy] = (char) (i + '1');
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (total == goal) {
                break;
            }


        }

        for (int an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb);

    }
}