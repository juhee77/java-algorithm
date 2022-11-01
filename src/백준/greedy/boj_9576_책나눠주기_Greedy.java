package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_9576_책나눠주기_Greedy {


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int book = Integer.parseInt(st.nextToken());
            int pnum = Integer.parseInt(st.nextToken());
            boolean visited[] = new boolean[book];
            int arr[][] = new int[pnum][2];

            input(br, pnum, arr);

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });

            int cnt = 0;
            for (int i = 0; i < pnum; i++) {
                int start = arr[i][0];
                int end = arr[i][1];


                for (int j = start; j <= end; j++) {
                    if (!visited[j]) {
                        visited[j] = true;
                        cnt++;
                        break;
                    }
                }
            }

            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    private static void input(BufferedReader br, int pnum, int[][] arr) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < pnum; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()) - 1;
            arr[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }
    }

}
