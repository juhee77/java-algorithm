package 백준.graph.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2458_키순서 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            arr[i][i] = true;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            arr[x][y] = true;
        }


        for (int i = 0; i < n; i++) {

            for (int p = 0; p < n; p++) {
                for (int q = 0; q < n; q++) {
                    arr[p][q] = arr[p][q] | (arr[p][i] && arr[i][q]);
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                flag = arr[i][j] | arr[j][i];
                if (!flag) {
                    break;
                }
            }

            if (flag) cnt++;
        }

        System.out.println(cnt);
    }
}
