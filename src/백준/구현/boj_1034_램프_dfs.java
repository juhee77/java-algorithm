package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 초과
 */
public class boj_1034_램프_dfs {
    private static boolean[] on;
    private static int col, row;
    private static char[][] map;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new char[row][col];

        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int chance = Integer.parseInt(br.readLine());

        on = new boolean[col];
        for (int i = chance % 2; i < col; i += 2) {
            dfs(0, i, 0);
        }

        System.out.println(max);
    }

    private static void dfs(int nowDepth, int goal, int start) {
        if (nowDepth == goal) {
            //램프 확인

            int lineCnt = getLineCnt();
            max = Math.max(max, lineCnt);
        } else {
            for (int i = start; i < col; i++) {
                on[i] = true;
                dfs(nowDepth + 1, goal, i + 1);
                on[i] = false;
            }
        }
    }

    private static int getLineCnt() {
        int lineCnt = 0;
        for (int i = 0; i < row; i++) {
            if (checkOneLine(i)) lineCnt++;
        }
        return lineCnt;
    }

    private static boolean checkOneLine(int idx) {
        for (int i = 0; i < col; i++) {
            if ((on[i] && map[idx][i] == '1') || (!on[i] && map[idx][i] == '0')) return false;
        }
        return true;
    }
}
