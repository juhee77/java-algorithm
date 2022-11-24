package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class boj_1865_웜홀_플로이드 {
    private static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(arr[i], INF);
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                int weight = Integer.parseInt(st.nextToken());
                arr[start][end] = Math.min(weight, arr[start][end]);
                arr[end][start] = Math.min(weight, arr[end][start]);
            }


            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                int weight = -Integer.parseInt(st.nextToken());
                arr[start][end] = Math.min(weight, arr[start][end]);
            }

            /*플로이드 워셜*/
            for (int k = 0; k < n; k++)
                for (int j = 0; j < n; j++)
                    for (int l = 0; l < n; l++)
                        if (arr[j][l] > arr[j][k] + arr[k][l])
                            arr[j][l] = arr[j][k] + arr[k][l];

            boolean f = false;
            for (int i = 0; i < n; i++) {
                if (arr[i][i] < 0) {
                    f = true;
                    break;
                }
            }
            if (f) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
//        System.out.println(INF);
        System.out.println(sb);
    }
}
