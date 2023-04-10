package 백준.구현.배열돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16926_배열돌리기1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] cpyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cpyMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] map = cpyMap;

        //rotation
        for (int k = 0; k < r; k++) {

            cpyMap = new int[n][m];
            for (int i = 0; i < Math.min(n, m) / 2; i++) {

                //1
                if (m - i - 1 - i >= 0) System.arraycopy(map[i], i + 1, cpyMap[i], i, m - i - 1 - i);
                cpyMap[i][m - 1 - i] = map[i + 1][m - 1 - i];
                //2
                for (int q = i; q < n - i - 1; q++) {
                    cpyMap[q][m - 1 - i] = map[q + 1][m - 1 - i];
                }
                cpyMap[n - i - 1][m - 1 - i] = map[n - i - 1][m - 2 - i];

                //3
                if (m - i - 1 - (i + 1) >= 0)
                    System.arraycopy(map[n - i - 1], i + 1 - 1, cpyMap[n - i - 1], i + 1, m - i - 1 - (i + 1));
                cpyMap[n - i - 1][i] = map[n - i - 2][i];

                //4
                for (int q = i + 1; q < n - i; q++) {
                    cpyMap[q][i] = map[q - 1][i];
                }
            }

            if ((n == m) && (n & 1) == 1) {
                cpyMap[n / 2][m / 2] = map[n / 2][m / 2];
            }

            map = cpyMap;

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}