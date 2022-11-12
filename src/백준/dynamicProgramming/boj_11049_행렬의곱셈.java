package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11049_행렬의곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int num = Integer.parseInt(br.readLine());
        int arr[][] = new int[num][2];

        /*입력*/
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int all[][] = new int[num][num];
        for (int i = 0; i < num; i++) {
            Arrays.fill(all[i], (int) 1e8);
            all[i][i] = 0;
        }

        for (int i = 0; i < num; i++) {
            for (int p = 0; p < num - i; p++) {
                int a = p;
                int b = p + i;
                for (int q = a; q < b; q++) {
                    System.out.println(a+" "+b+" "+q);
                    all[a][b] = Math.min(all[a][b], all[a][q] + all[q + 1][b] + arr[a][0] * arr[q][1] * arr[b][1]);
                }
                System.out.println();
                for (int k = 0; k < num; k++) {
                    for (int j = 0; j < num; j++) {
                        if (all[k][j] == (int) 1e8) System.out.print("INF ");
                        else System.out.print(all[k][j] + " ");
                    }
                    System.out.println();
                }


            }
        }


        System.out.println(all[0][num - 1]);
    }
}
/*
4
5 3
3 2
2 6
6 3

->96

5
1 10
10 1
1 10
10 1
1 10
->31
 */