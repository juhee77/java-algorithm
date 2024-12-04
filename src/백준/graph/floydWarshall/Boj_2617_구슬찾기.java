package 백준.graph.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_2617_구슬찾기 {
    public static final int MAX = (int) 1e6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int bubble = Integer.parseInt(st.nextToken());
        int pair = Integer.parseInt(st.nextToken());
        int[][] maxArr = new int[bubble][bubble];
        int[][] minArr = new int[bubble][bubble];
        for (int i = 0; i < bubble; i++) {
            Arrays.fill(minArr[i], MAX);
            Arrays.fill(maxArr[i], MAX);
            minArr[i][i] = maxArr[i][i] = 0;
        }

        for (int i = 0; i < pair; i++) {
            st = new StringTokenizer(br.readLine());
            int min = Integer.parseInt(st.nextToken()) - 1;
            int max = Integer.parseInt(st.nextToken()) - 1;

            minArr[min][max] = 1;
            maxArr[max][min] = 1;
        }

        for (int p = 0; p < bubble; p++) {
            for (int i = 0; i < bubble; i++) {
                for (int j = 0; j < bubble; j++) {
                    minArr[i][j] = Math.min(minArr[i][j], minArr[i][p] + minArr[p][j]);
                    maxArr[i][j] = Math.min(maxArr[i][j], maxArr[i][p] + maxArr[p][j]);
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < bubble; i++) {
            int minSum = 0;
            int maxSum = 0;

            for (int j = 0; j < bubble; j++) {
                if (minArr[i][j] != MAX && j != i) minSum++;
                if (maxArr[i][j] != MAX && j != i) maxSum++;
            }
            if (minSum > bubble / 2 || maxSum > bubble / 2) {
                set.add(i);
            }
        }

        System.out.println(set.size());
    }
}
