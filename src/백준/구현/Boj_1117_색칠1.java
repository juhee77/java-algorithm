package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1117_색칠1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        k = row / (k + 1);
        int startR = Integer.parseInt(st.nextToken());

        int startC = Integer.parseInt(st.nextToken());
        int endR = Integer.parseInt(st.nextToken());
        int endC = Integer.parseInt(st.nextToken());

        int[][] sum = new int[(int) (row * 1.5)][(int) (col * 1.5)];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum[i][j] = 1;
            }
        }


        //세로 접기
        for (int i = n; i < n + n; i++) {
            //한줄씩
            int next = 2 * n - i - 1;

            for (int j = 0; j < row; j++) {
                sum[j][i] += sum[j][next];
//                sum[j][next] = 0;
            }
        }

        //가로 접기
        int start = 0;
        if (k != 0) {
            for (int i = 0; i < col / k + 1; i++) { //접을수 있는 횟수
                start += k;
                for (int j = start; j < start + k; j++) {
                    for (int p = n; p < 2 * col; p++) {
                        sum[j][p] += sum[start * 2 - j - 1][p];
//                    sum[start * 2 - j - 1][p] = 0;
                    }
                }
            }
        }


        int paintSum = 0;
        for (int p = startR; p < endR; p++) {
            for (int q = startC; q < endC; q++) {
                paintSum += sum[row - q - 1][(n + p)];
//                paintSum += sum[(n + p)][row - q - 1];
//                System.out.println((row-q-1)+" "+(n+p));
            }
        }
//
//        for (int i = 0; i < row; i++) {
//            System.out.println(Arrays.toString(sum[i]));
//        }

        System.out.println((row * col) - paintSum);
    }
}