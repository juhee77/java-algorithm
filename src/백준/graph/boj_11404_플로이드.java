package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11404_플로이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int city = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        int arr[][] = new int[city][city];
        StringBuilder sb = new StringBuilder();
        int INF = (int) 1e9;

        //배열 초기화 (자기자신 가는 방법은 0 )
        for (int i = 0; i < city; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i]=0;
        }

        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            arr[a][b] = Math.min(w, arr[a][b]);
        }

        //플로이드 워셜
        for (int p = 0; p < city; p++) {
            for (int i = 0; i < city; i++) {
                for (int j = 0; j < city; j++) {
                    arr[i][j] = Math.min(arr[i][p] + arr[p][j], arr[i][j]);
                }
            }
        }

        for (int i = 0; i < city; i++) {
            for (int j = 0; j < city; j++)
                if (arr[i][j] == INF)  sb.append(0+" ");
                else sb.append(arr[i][j] + " ");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
