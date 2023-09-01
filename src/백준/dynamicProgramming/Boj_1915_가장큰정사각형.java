package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1915_가장큰정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][m + 1];
        int maxSize = 0;
        for (int i = 1; i <= n; i++) {
            char[] chars = br.readLine().toCharArray();

            for (int j = 1; j <= m; j++) {
                map[i][j] = chars[j - 1] - '0';
                map[i][j] += map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];

                while (true) {
                    int tempSize = maxSize + 1;
                    if (0 <= i - tempSize && 0 <= j - tempSize) {
                        int area = map[i][j] - map[i - tempSize][j] - map[i][j - tempSize] + map[i - tempSize][j - tempSize];
                        if (area == tempSize * tempSize) {
                            maxSize++;
                        }
                        break;
                    }
                    break;
                }
            }
        }

        System.out.println(maxSize * maxSize);
    }
}
