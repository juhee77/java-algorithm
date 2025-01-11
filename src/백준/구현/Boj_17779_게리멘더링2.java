package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17779_게리멘더링2 {
    private static int size;
    private static int[][] dp;
    private static int wholeSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        size = Integer.parseInt(br.readLine());
        int[][] map = new int[size][size];
        dp = new int[size + 1][size + 1];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i + 1][j + 1] = dp[i + 1][j] + map[i][j];
                wholeSum += map[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                for (int d1 = 0; d1 < size; d1++) {
                    for (int d2 = 0; d2 < size; d2++) {
                        min = Math.min(min, getMin(x, y, d1, d2));
                    }
                }


            }
        }
        System.out.println(min);
    }

    private static int getMin(int x, int y, int d1, int d2) {
        if (x < x + d1 + d2 && x + d1 + d2 < size && y - d1 < y && y < y + d2 && y + d2 < size) {
//            System.out.println(x + " " + y + " " + d1 + " " + d2);
            int[] parts = new int[5];

            int hold = y + 1;
            for (int i = 0; i < x; i++) {
                if (0 <= hold && hold <= size) parts[0] += dp[i + 1][hold]; //위사각형
            }
//            System.out.println("parts[0](1) = " + parts[0]);
            for (int i = x; i < x + d1; i++) {
                if (1 <= hold && hold <= size) parts[0] += dp[i + 1][--hold]; // 줄어드는 부분
            }
//            System.out.println("parts[0](2) = " + parts[0]);


            hold = y + 1;
            for (int i = 0; i <= x; i++) {
                if (0 <= hold && hold <= size) parts[1] += dp[i + 1][size] - dp[i + 1][hold]; //위사각형
            }
//            System.out.println("parts[1](1) = " + parts[1]);
            for (int i = x + 1; i <= x + d2; i++) {
                if (0 <= hold && hold < size) parts[1] += dp[i + 1][size] - dp[i + 1][++hold]; // 줄어드는 부분
            }
//            System.out.println("parts[1](2) = " + parts[1]);


            hold = y - d1;
            for (int i = x + d1; i < x + d1 + d2; i++) {
                if (0 <= hold && hold < size) parts[2] += dp[i + 1][hold++]; // 증가하는 부분
            }
//            System.out.println("parts[2](1) = " + parts[2]);
            for (int i = x + d1 + d2; i < size; i++) {
                if (0 <= hold && hold <= size) parts[2] += dp[i + 1][hold]; // 증가하는 부분
            }
//            System.out.println("parts[2](2) = " + parts[2]);


            hold = y + d2;
            for (int i = x + d2 + 1; i <= x + d2 + d1; i++) {
                if (0 <= hold && hold <= size) parts[3] += dp[i + 1][size] - dp[i + 1][hold--]; // 증가하는 부분
            }
//            System.out.println("parts[3](1) = " + parts[3]);
            for (int i = x + d1 + d2 + 1; i < size; i++) {
                if (0 <= hold && hold <= size) parts[3] += dp[i + 1][size] - dp[i + 1][hold]; // 증가하는 부분
            }
//            System.out.println("parts[3](2) = " + parts[3]);

            parts[4] = wholeSum - parts[1] - parts[0] - parts[2] - parts[3];
//            System.out.println("parts[4] = " + parts[4]);

            int tempMax = Integer.MIN_VALUE, tempMin = Integer.MAX_VALUE;
            for (int part : parts) {
                tempMax = Math.max(tempMax, part);
                tempMin = Math.min(tempMin, part);
            }

            return tempMax - tempMin;
        } else return Integer.MAX_VALUE;
    }

}
