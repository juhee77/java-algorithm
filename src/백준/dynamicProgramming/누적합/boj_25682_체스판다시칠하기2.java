package 백준.dynamicProgramming.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_25682_체스판다시칠하기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        int[][] dpBW = new int[row + 1][col + 1];
        int[][] dpWB = new int[row + 1][col + 1];
        int min = 2000 * 2000;

        for (int i = 1; i <= row; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 1; j <= col; j++) {
                //dpBW
                char temp = (i + j) % 2 == 0 ? 'W' : 'B';
                dpBW[i][j] = dpBW[i][j - 1] + dpBW[i - 1][j] - dpBW[i - 1][j - 1];
                if (chars[j - 1] != temp) dpBW[i][j]++;

                //dpWB
                char temp2 = (i + j) % 2 == 1 ? 'W' : 'B';
                dpWB[i][j] = dpWB[i][j - 1] + dpWB[i - 1][j] - dpWB[i - 1][j - 1];
                if (chars[j - 1] != temp2) dpWB[i][j]++;
            }
        }

        for (int i = size; i <= row; i++) {
            for (int j = size; j <= col; j++) {
                int bw = dpBW[i][j] - dpBW[i - size][j] - dpBW[i][j - size] + dpBW[i - size][j - size];
                int wb = dpWB[i][j] - dpWB[i - size][j] - dpWB[i][j - size] + dpWB[i - size][j - size];
                min = Math.min(min, Math.min(bw, wb));
                if (min == 0) break;
            }
            if (min == 0) break;
        }
        System.out.println(min);
    }
}
