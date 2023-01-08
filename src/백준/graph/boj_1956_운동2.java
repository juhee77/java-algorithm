package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1956_운동2 {
    private static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int city = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int[][] floid = new int[city][city];
        for (int i = 0; i < city; i++) {
            for (int j = 0; j < city; j++) {
                floid[i][j] = INF;
            }
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            floid[s][e] = Math.min(floid[s][e], cost);
        }

        for (int i = 0; i < city; i++) {
            for (int p = 0; p < city; p++) {
                for (int q = 0; q < city; q++) {
                    floid[p][q] = Math.min(floid[p][q], floid[p][i] + floid[i][q]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < city; i++) {
            for (int j = 0; j < city; j++) {
                if (i == j) min = Math.min(min, floid[i][j]);
                else min = Math.min(min, floid[i][j] + floid[j][i]);
            }
        }

        if (min == INF) System.out.println(-1);
        else System.out.println(min);
    }
}
