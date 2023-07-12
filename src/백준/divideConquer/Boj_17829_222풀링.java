package 백준.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17829_222풀링 {
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(findPooling(n, 0, 0));

    }

    private static int findPooling(int n, int startX, int startY) {
        if (n == 1) return map[startX][startY];

        int[][] nMap = new int[2][2];

        //4등분
        nMap[0][0] = findPooling(n / 2, startX, +startY);
        nMap[0][1] = findPooling(n / 2, startX, startY + n / 2);
        nMap[1][0] = findPooling(n / 2, startX + n / 2, startY);
        nMap[1][1] = findPooling(n / 2, startX + n / 2, startY + n / 2);


        int max = Integer.MIN_VALUE;
        int secondeMax = Integer.MIN_VALUE;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int nowNum = nMap[i][j];
                if (max < nowNum) {
                    secondeMax = max;
                    max = nowNum;
                } else if (secondeMax < nowNum) {
                    secondeMax = nowNum;
                }
            }
        }

        return secondeMax;
    }
}
