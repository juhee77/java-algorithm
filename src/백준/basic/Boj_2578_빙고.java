package 백준.basic;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_2578_빙고 {
    private static int[][] arr = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Integer, Point> ans = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                ans.put(arr[i][j], new Point(i, j));
            }
        }

        int hold = 0;
        int bingoCnt = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            if (bingoCnt < 3)
                for (int j = 0; j < 5 && bingoCnt < 3; j++) {
                    hold++;
                    Point point = ans.get(Integer.parseInt(st.nextToken()));
                    arr[point.x][point.y] = -1;
                    bingoCnt += check(point.x, point.y);
                }
        }
        System.out.println(hold);
    }

    private static int check(int x, int y) {
        int cnt = 0;
        //가로
        boolean isBingo = true;
        for (int k = 0; k < 5; k++) {
            if (arr[x][k] != -1) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) cnt++;
        isBingo = true;

        //세로
        for (int k = 0; k < 5; k++) {
            if (arr[k][y] != -1) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) cnt++;
        isBingo = true;

        // 대각선 두가지
        if (x + y == 4) {
            for (int i = 0; i < 5; i++) {
                if (arr[i][4 - i] != -1) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) cnt++;
            isBingo = true;
        }

        if (x == y) {
            for (int i = 0; i < 5; i++) {
                if (arr[i][i] != -1) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) cnt++;
        }
        return cnt;
    }
}
