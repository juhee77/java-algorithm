package 백준.backTracking;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15683_감시 {
    private static int row, col, ans = Integer.MAX_VALUE;
    private static ArrayList<Point> beam = new ArrayList<>();
    private static final int[] dirx = new int[]{-1, 1, 0, 0};
    private static final int[] diry = new int[]{0, 0, -1, 1};

    private static List<List<List<Integer>>> allCase = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int[][] map = new int[row][col];

        /*init*/
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) beam.add(new Point(i, j));
            }
        }

        allCase.add(0, null);
        allCase.add(1, List.of(List.of(0), List.of(1), List.of(2), List.of(3)));
        allCase.add(2, List.of(List.of(0, 1), List.of(2, 3)));
        allCase.add(3, List.of(List.of(0, 2), List.of(1, 3),List.of(0, 3), List.of(1, 2)));
        allCase.add(4, List.of(List.of(0, 1, 2), List.of(0, 1, 3), List.of(0, 2, 3), List.of(1, 2, 3)));
        allCase.add(5, List.of(List.of(0, 1, 2, 3)));

        backtracking(map, 0, beam.size());
        System.out.println(ans);
    }

    private static void backtracking(int[][] map, int depth, int goal) {
        if(ans==0)return;
        if (depth == goal) {
            int cnt = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] == 0) cnt++;
                }
            }
            ans = Math.min(cnt, ans);

        } else {
            Point now = beam.get(depth);
            List<List<Integer>> nowCase = allCase.get(map[now.x][now.y]);
            for (List<Integer> integers : nowCase) {
                int[][] copyMap = new int[row][col];
                //clone
                for (int k = 0; k < row; k++) {
                    copyMap[k] = map[k].clone();
                }

                //각각을 처리
                for (Integer integer : integers) {
                    checkingBeam(now, integer, copyMap);
                }
                backtracking(copyMap, depth + 1, goal);
            }
        }
    }

    private static void checkingBeam(Point now, Integer dir, int[][] copyMap) {
        int nowx = now.x + dirx[dir];
        int nowy = now.y + diry[dir];
        while (0 <= nowx && 0 <= nowy && nowx < row && nowy < col) {

            if (copyMap[nowx][nowy] == 6) {
                return;
            }

            if(0 == copyMap[nowx][nowy] ) {
                copyMap[nowx][nowy] = -1;
            }
            nowx += dirx[dir];
            nowy += diry[dir];
        }
    }


}
