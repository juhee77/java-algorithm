package 백준.basic;

import java.io.*;
import java.util.*;

public class Boj_2740_행렬곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int aR = Integer.parseInt(st.nextToken()); // 행
        int aC = Integer.parseInt(st.nextToken()); // 열

        int[][] aArr = new int[aR][aC];
        for (int i = 0; i < aR; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < aC; j++) {
                aArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int bR = Integer.parseInt(st.nextToken());
        int bC = Integer.parseInt(st.nextToken());

        int[][] bArr = new int[bR][bC];
        for (int i = 0; i < aC; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < bC; j++) {
                bArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] ans = new int[aR][bC];
        for (int i = 0; i < aR; i++) {
            for (int j = 0; j < bC; j++) {
                for (int k = 0; k < aC; k++) {
                    ans[i][j] += aArr[i][k] * bArr[k][j];
                }
            }
        }

        for (int i = 0; i < aR; i++) {
            for (int j = 0; j < bC; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
